package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionFactory;

/**
 *  Aceasta clasa opereaza pe baza de date si este folosita pentru a face operatii de tip CRUD
 *  (Create, Read, Update, Delete) pe orice tabela din baza de date.
 *
 */
public class DAOGen<T> {


    protected static final Logger LOGGER = Logger.getLogger(DAOGen.class.getName());

    private final Class<T> type;
    /**
     * Constructorul clasei DAOGen
     *
     */

    @SuppressWarnings("unchecked")
    public DAOGen() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Metoda createSelectQuery este folosita pentru a crea un query de tip select
     * @param field
     * @return String
     */

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * Metoda createObjects este folosita pentru a crea un obiect de tipul T
     * @param t
     * @return String
     */
    private String createInsertQuery(T t) {

        StringBuilder sb = new StringBuilder();
        String query = "INSERT INTO " + type.getSimpleName() + "(";
        Object object=t;
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.getName().equals(type.getSimpleName().toLowerCase()+"Id")) {
                continue;
            }
            else
                query+=field.getName()+",";
        }

        query=query.substring(0, query.length() - 1);
        query+=")";
        query+=" VALUES (";
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.getName().equals(type.getSimpleName().toLowerCase()+"Id")) {
                continue;
            }
            else
                query+="?,";
        }
        query=query.substring(0, query.length() - 1);
        query+=")";
        sb.append(query);
        return sb.toString();
    }

    /**
     * Metoda createObjects este folosita pentru a crea un obiect de tipul T
     * @return List<T>
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("1");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, 1);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda findById este folosita pentru a gasi un obiect de tipul T dupa id
     * @param id
     * @return T
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(type.getSimpleName().toLowerCase()+"Id");// in loc de id
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    /**
     * Metoda createObjects este folosita pentru a crea un obiect de tipul T
     * @param resultSet
     * @return List<T>
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Metoda insert este folosita pentru a insera un obiect de tipul T
     * @param t
     * @return T
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        int k=1;
        ResultSet resultSet = null;
        String query=createInsertQuery(t);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);

            for(Field field : t.getClass().getDeclaredFields()) {
                if(field.getName().equals(type.getSimpleName().toLowerCase()+"Id")) {
                    continue;
                }
                else {
                    field.setAccessible(true);
                    statement.setObject(k, field.get(t).toString());
                    k++;
                }
            }

            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda delete este folosita pentru a sterge un obiect de tipul T
     * @param t
     * @return T
     */
    public T update(T t)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        int k=1;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int id=0;
            for(Field field : t.getClass().getDeclaredFields()) {
                if(field.getName().equals(type.getSimpleName().toLowerCase()+"Id")) {
                    field.setAccessible(true);
                    id=Integer.parseInt(field.get(t).toString());
                }
                field.setAccessible(true);
                statement.setObject(k,field.get(t).toString());
                k++;
            }
            statement.setObject(k,id);
            System.out.println(statement);
            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Metoda delete este folosita pentru a sterge un obiect de tipul T
     * @param t
     * @return boolean
     */
    public boolean delete(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        int k=1;
        String query = createDeleteQuery(t);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            for(Field field : t.getClass().getDeclaredFields()) {
                if(field.getName().equals(type.getSimpleName().toLowerCase()+"Id")) {
                    field.setAccessible(true);
                    statement.setObject(1,field.get(t).toString());
                    k++;
                }
                else {
                    continue;

                }
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return false;
    }

    /**
     * Metoda createInsertQuery este folosita pentru a crea un query de inserare
     * @return String
     */
    private String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(type.getSimpleName());
        sb.append(" SET ");
        for (Field field : type.getDeclaredFields()) {
            if (!field.getName().equals("id")) {
                sb.append(field.getName()).append("=?,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE " + type.getSimpleName().toLowerCase() + "Id=?");
        return sb.toString();
    }

    /**
     * Metoda createInsertQuery este folosita pentru a crea un query de inserare
     * @param t
     * @return String
     */
    private String createDeleteQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE ");
        sb.append(type.getSimpleName().toLowerCase()).append("Id=?");
        return sb.toString();
    }

}


package graphical.User.Interface;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class TableAbstract<T> extends JFrame {
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public TableAbstract(List<T> list) {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        createTable(list);

        this.setVisible(true);
        setLocationRelativeTo(null);
        setTitle("View");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
    }

  public void createTable(List<T> list)
  {

      JTable table = new JTable();
      DefaultTableModel model = new DefaultTableModel();
      table.setPreferredScrollableViewportSize(new Dimension(800, 300));

      JScrollPane scrollPane = new JScrollPane(table);

      this.add(scrollPane);

      for(Field field : type.getDeclaredFields())
      {
          model.addColumn(field.getName());
      }
      table.setModel(model);
      Object[][] data = new Object[list.size()][type.getDeclaredFields().length];

      for(T t : list){
          int k=0;
          for(Field field :  type.getDeclaredFields()){
              try {
                  PropertyDescriptor pd=new PropertyDescriptor(field.getName(),type);
                  Method getter=pd.getReadMethod();
                  data[list.indexOf(t)][k]=getter.invoke(t);
                  k++;
              } catch (IntrospectionException ex) {
                  throw new RuntimeException(ex);
              } catch (InvocationTargetException ex) {
                  throw new RuntimeException(ex);
              } catch (IllegalAccessException ex) {
                  throw new RuntimeException(ex);
              }
          }
      }

      for(int i=0;i<list.size();i++) {
          model.addRow(data[i]);
      }

  }
}

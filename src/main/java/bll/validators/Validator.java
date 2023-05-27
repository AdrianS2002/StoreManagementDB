package bll.validators;
/**
 * Interfata Validator este folosita pentru a valida datele din baza de date
 * @param <T>
 */
public interface Validator<T> {

    public void validate(T t) throws IllegalArgumentException;
}

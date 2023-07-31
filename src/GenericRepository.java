import java.util.List;

public abstract class GenericRepository<T> {
    public abstract void add(T entity);
    public abstract void update(T entity);
    public abstract void delete(T entity);
    public abstract T getById(int id);
    public abstract List<T> getAll();
}
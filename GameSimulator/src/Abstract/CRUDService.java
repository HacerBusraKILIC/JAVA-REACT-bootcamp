package Abstract;

public interface CRUDService <T> {
	void add(T entity);
	void update(T entity);
	void delete(T entity);	
}

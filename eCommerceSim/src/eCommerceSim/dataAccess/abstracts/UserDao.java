package eCommerceSim.dataAccess.abstracts;

import java.util.List;

import eCommerceSim.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	List<User> getAll();
}

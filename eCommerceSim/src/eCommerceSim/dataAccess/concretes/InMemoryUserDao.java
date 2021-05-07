package eCommerceSim.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSim.dataAccess.abstracts.UserDao;
import eCommerceSim.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		users.get(user.getId()).setPassword(user.getPassword());;
		// diger alanlar.... 
	}

	@Override
	public void delete(User user) {
		users.removeIf(obj->obj.getId() == user.getId());
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}

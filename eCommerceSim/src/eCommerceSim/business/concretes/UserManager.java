package eCommerceSim.business.concretes;


import eCommerceSim.business.abstracts.UserService;
import eCommerceSim.dataAccess.abstracts.UserDao;
import eCommerceSim.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void register(User user) {
	 userDao.add(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}

	@Override
	public User getByMail(String mail) {
		return null;
	}

}

package eCommerceSim.core;

import eCommerceSim.GoogleAuth.GoogleAuthManager;
import eCommerceSim.entities.concretes.User;

public class GoogleAuthManagerAdapter implements AuthService {

	@Override
	public void register(User user) {
		GoogleAuthManager googleAuth = new GoogleAuthManager();
		googleAuth.register(user.getePosta(), user.getPassword());
		
	}

	@Override
	public void login(String email, String password) {
		GoogleAuthManager googleAuth = new GoogleAuthManager();
		googleAuth.login(email, password);
	}

}

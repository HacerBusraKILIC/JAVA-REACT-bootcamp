package eCommerceSim;

import eCommerceSim.business.abstracts.UserService;
import eCommerceSim.business.concretes.AuthManager;
import eCommerceSim.business.concretes.EmailManager;
import eCommerceSim.business.concretes.UserManager;
import eCommerceSim.business.concretes.UserValidationManager;
import eCommerceSim.core.AuthService;
import eCommerceSim.core.GoogleAuthManagerAdapter;
import eCommerceSim.core.jLoggerManagerAdapter;
import eCommerceSim.dataAccess.concretes.InMemoryUserDao;
import eCommerceSim.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager(), new jLoggerManagerAdapter());
		authService.register(new User(1, "Hacer Büşra", "KILIÇ", "hacerbusrakilic@gmail.com", "hacerbusra")); 
		authService.register(new User(2, "H", "KILIÇ", "hacerbusrakilic@gmail.com", "hacerbusra")); 
		authService.login("hacerbusrakilic@gmail.com", "hacerbusra"); 

		AuthService google_authService = new GoogleAuthManagerAdapter();
		google_authService.register(new User(1, "Hacer Büşra", "KILIÇ", "hacerbusrakilic@gmail.com", "hacerbusra")); 
		google_authService.login("hacerbusrakilic@gmail.com", "hacerbusra");

	}
}

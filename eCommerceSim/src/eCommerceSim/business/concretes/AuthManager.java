package eCommerceSim.business.concretes;

import eCommerceSim.business.abstracts.EmailService;
import eCommerceSim.business.abstracts.UserService;
import eCommerceSim.business.abstracts.UserValidationService;
import eCommerceSim.core.AuthService;
import eCommerceSim.core.LoggerService;
import eCommerceSim.entities.concretes.User;

public class AuthManager implements AuthService {

	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;
	LoggerService loggerService;
	
	public AuthManager(UserService userService, UserValidationService userValidationService,
			EmailService emailService, LoggerService loggerService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
		this.loggerService = loggerService;
	}

	@Override
	public void register(User user) {
		if(!userValidationService.validate(user)) {
			loggerService.logToSystem("Validasyon işlemi başarısız. Lütfen tüm alanları doğru girdiğinizden emin olunuz.");
			return;
		}
		loggerService.logToSystem("Kayıt işlemi başarılı!");
		emailService.send("Kayıt işlemi bu e-mail ile sağlanmiştir.", user.getePosta());
		userService.register(user);
	}

	@Override
	public void login(String email, String password) {
		if(email.isEmpty() || password.isEmpty()) {
			loggerService.logToSystem("Alanlar boş geçilemez!");
			return;
		}
		
			
		loggerService.logToSystem("Giriş başarılı. Hoşgeldiniz : " + email);
		
	}

}

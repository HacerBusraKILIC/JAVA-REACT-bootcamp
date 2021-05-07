package eCommerceSim.business.abstracts;

import eCommerceSim.entities.concretes.User;

public interface UserValidationService {
	boolean validate(User user);
}

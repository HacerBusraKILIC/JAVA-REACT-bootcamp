package eCommerceSim.business.concretes;

import java.util.regex.Pattern;

import eCommerceSim.business.abstracts.UserValidationService;
import eCommerceSim.entities.concretes.User;

public class UserValidationManager implements UserValidationService {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean validate(User user) {
		boolean result = isEmailFormatValid(user.getePosta()) &&
				isPasswordLengthValid(user.getPassword()) &&
				isFirstNameLengthValid(user.getName()) &&
				isLastNameLengthValid(user.getLastName()) &&
				isAllFieldsFilled(user.getName(), user.getLastName(), user.getePosta(), user.getPassword());
		return result;
	}
	
	private boolean isEmailFormatValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
	
	private boolean isPasswordLengthValid(String password) {
		return password.length() > 6;
	}
	private boolean isFirstNameLengthValid(String firstName) {
		return firstName.length() > 2;
	}
	private boolean isLastNameLengthValid(String lastName) {
		return lastName.length() > 2;
	}
	private boolean isAllFieldsFilled(String firstName,String lastName,String email, String password) {
		if(firstName.length() <= 0 || lastName.length() <= 0 || email.length() <= 0 || password.length() <= 0) {
			return false;
		}return true;
	}
}

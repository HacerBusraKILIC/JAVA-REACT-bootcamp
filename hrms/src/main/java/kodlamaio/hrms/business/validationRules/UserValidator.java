package kodlamaio.hrms.business.validationRules;

import java.util.regex.Pattern;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class UserValidator implements BaseValidator {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public Result isEmailValid(String email) {
        boolean isMail = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
        if (!isMail)
            return new ErrorResult("Geçersiz E-Mail");

        return new SuccessResult("Geçerli E-Mail");
    }

    public Result arePasswordsSame(String password, String passwordRepeat) {
        if (!password.equals(passwordRepeat))
            return new ErrorResult("Şifre alanları aynı olmalıdır");
        return new SuccessResult("Şifre doğrulama başarılı.");
    }
}

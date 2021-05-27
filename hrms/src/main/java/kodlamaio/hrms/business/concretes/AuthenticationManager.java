package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.AuthenticationService;
import kodlamaio.hrms.business.abstracts.PersonCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class AuthenticationManager implements AuthenticationService {

	private PersonCheckService personCheckService;
	
	@Autowired
	public AuthenticationManager(PersonCheckService personCheckService) {
		super();
		this.personCheckService = personCheckService;
	}

	@Override
	public Result checkIfRealPerson(String identityNumber, String firstName, String lastName, int birthYear) {
		if (!personCheckService.checkIfRealPerson
                (identityNumber, firstName, lastName, birthYear)
        )
            return new ErrorResult("Geçersiz kayıt!");

        return new SuccessResult();
	}

}

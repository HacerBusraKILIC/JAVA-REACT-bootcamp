package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.business.abstracts.PersonCheckService;

public class MernisServiceAdapter implements PersonCheckService {

	@Override
	public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, int birthYear) {
		System.out.println(firstName + " " + lastName + " geçerli kişi." );
		return true;
	}

}

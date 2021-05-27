package kodlamaio.hrms.business.abstracts;

public interface PersonCheckService {
	 boolean checkIfRealPerson(String identityNumber,String firstName,String lastName,int birthYear);
}

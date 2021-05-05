package Adapters;

import java.rmi.RemoteException;

import Abstract.ICustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean result = false;
		  try {
			  result = client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), customer.getFirstName().toUpperCase(), customer.getLastName().toUpperCase(), customer.getDateOfBirth().getYear());
		  } catch (NumberFormatException e) {
			   e.printStackTrace();
		  } catch (RemoteException e) {
		       e.printStackTrace();
		  }
		 return result;
	}

}

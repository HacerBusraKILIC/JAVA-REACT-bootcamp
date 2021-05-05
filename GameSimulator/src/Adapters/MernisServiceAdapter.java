package Adapters;

import java.rmi.RemoteException;

import Abstract.PlayerCheckService;
import Entities.Player;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements PlayerCheckService {

	@Override
	public boolean CheckIfRealPerson(Player player) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean result = false;
		  try {
			  result = client.TCKimlikNoDogrula(Long.parseLong(player.getNationalityId()), player.getFirstName().toUpperCase(), player.getLastName().toUpperCase(), player.getDateOfBirth().getYear());
		  } catch (NumberFormatException e) {
			   e.printStackTrace();
		  } catch (RemoteException e) {
		       e.printStackTrace();
		  }
		 return result;
	}
}

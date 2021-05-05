package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {
	private ICustomerCheckService _customerCheck;
	
	public StarbucksCustomerManager(ICustomerCheckService _customerCheck) {
		this._customerCheck = _customerCheck;
	}

	@Override
	public void Save(Customer customer) {
		if( _customerCheck.CheckIfRealPerson(customer)) {
			super.Save(customer);
		} else {
			System.out.println("Not a valid Person");
		}
		
	}

}

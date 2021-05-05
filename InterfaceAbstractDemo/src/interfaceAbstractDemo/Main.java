package interfaceAbstractDemo;

import java.util.Date;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.Save(new Customer(1, "Hacer Büşra", "KILIÇ", new Date(1995,01,20), "60694307656"));

	}

}

package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jLogger.jLoggerManager;

public class ProductManager implements ProductService {

	private ProductDao productDao;
	private LoggerService loggerService;
	
	public ProductManager(ProductDao productDao, LoggerService loggerService) {
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void add(Product product) {
		// is kodlari ekleneir
		if(product.getCategoryId() == 1) {
			System.out.println("Bu kategoride ürün kabul edilmiyor");
		} else {
			this.productDao.add(product);
			this.loggerService.logToSystem("Urun eklendi " + product.getName());
		}
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package nlu.project.cdweb.service;

import nlu.project.cdweb.custom.Config;
import nlu.project.cdweb.entity.Product;
import nlu.project.cdweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
	List<Product> list();
	long count();
	List<Product> newProducts();
	List<Product> saleProducts();
	List<Product> hotProducts();
	List<Product> otherProducts();
	Product findByID(String id);
}

@Service
class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> list() {
		return productRepository.findAll(Config.orderByIdAsc());
	}

	@Override
	public long count() { return productRepository.count(); }
	@Override
	public List<Product> newProducts() { return productRepository.homeProducts("1",Config.homeProducts(Config.orderByIdAsc())); }
	@Override
	public List<Product> saleProducts() { return productRepository.homeProducts("2",Config.homeProducts(Config.orderByIdAsc())); }
	@Override
	public List<Product> hotProducts() { return productRepository.homeProducts("3",Config.homeProducts(Config.orderByIdAsc())); }
	@Override
	public List<Product> otherProducts() { return productRepository.homeProducts("0",Config.homeProducts(Config.orderByIdAsc())); }

	@Override
	public Product findByID(String id) { return productRepository.findById(id).get(); }


}
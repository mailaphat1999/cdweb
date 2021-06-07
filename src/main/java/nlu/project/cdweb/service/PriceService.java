package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Price;
import nlu.project.cdweb.repository.PriceRepository;
import nlu.project.cdweb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PriceService {
	List<Price> list();
}

@Service
class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Price> list() {
		List<Price> list = priceRepository.findAll();
		for (Price price:list) {
			price.setItems(productRepository.priceProducts(price.getStart(),price.getEnd()!=-1?price.getEnd():Integer.MAX_VALUE));
		}
		return list;
	}
}
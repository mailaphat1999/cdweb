package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Sale;
import nlu.project.cdweb.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SaleService {
	List<Sale> list();
	long count();
}

@Service
class SaleServiceImpl implements SaleService{

	@Autowired
	private SaleRepository SaleRepository;
	
	@Override
	public List<Sale> list() {
		return SaleRepository.findAll();
	}

	@Override
	public long count() {
		return SaleRepository.count();
	}
}
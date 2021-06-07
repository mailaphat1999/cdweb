package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Brand;
import nlu.project.cdweb.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
	List<Brand> list();
}

@Service
class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public List<Brand> list() {
		return brandRepository.findAll();
	}
}
package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Description;
import nlu.project.cdweb.repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DescriptionService {
	List<Description> list();
}

@Service
class DescriptionServiceImpl implements DescriptionService{

	@Autowired
	private DescriptionRepository descriptionRepository;
	
	@Override
	public List<Description> list() {
		return descriptionRepository.findAll();
	}
}
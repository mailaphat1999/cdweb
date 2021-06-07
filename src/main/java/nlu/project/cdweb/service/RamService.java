package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Ram;
import nlu.project.cdweb.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RamService {
	List<Ram> list();
}

@Service
class RamServiceImpl implements RamService{

	@Autowired
	private RamRepository ramRepository;
	
	@Override
	public List<Ram> list() {
		return ramRepository.findAll();
	}
}
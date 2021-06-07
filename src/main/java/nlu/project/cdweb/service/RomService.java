package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Rom;
import nlu.project.cdweb.repository.RomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RomService {
	List<Rom> list();
}

@Service
class RomServiceImpl implements RomService{

	@Autowired
	private RomRepository romRepository;

	@Override
	public List<Rom> list() {
		return romRepository.findAll();
	}
}
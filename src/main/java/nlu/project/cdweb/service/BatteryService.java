package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Battery;
import nlu.project.cdweb.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BatteryService {
	List<Battery> list();
}

@Service
class BatteryServiceImpl implements BatteryService{

	@Autowired
	private BatteryRepository BatteryRepository;
	
	@Override
	public List<Battery> list() {
		return BatteryRepository.findAll();
	}
}
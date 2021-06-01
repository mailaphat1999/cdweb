package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.OrderDetail;
import nlu.project.cdweb.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderDetailService {
	List<OrderDetail> list();
}

@Service
class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository OrderDetailRepository;
	
	@Override
	public List<OrderDetail> list() {
		return OrderDetailRepository.findAll();
	}
}
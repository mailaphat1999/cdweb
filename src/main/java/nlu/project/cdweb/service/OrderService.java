package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Order;
import nlu.project.cdweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
	List<Order> list();
}

@Service
class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository OrderRepository;
	
	@Override
	public List<Order> list() {
		return OrderRepository.findAll();
	}
}
package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Order;
import nlu.project.cdweb.entity.OrderDetail;
import nlu.project.cdweb.repository.OrderDetailRepository;
import nlu.project.cdweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
	List<Order> list();
	void save(Order order);
}

@Service
class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public List<Order> list() { return orderRepository.findAll(); }
	@Override
	public void save(Order order) {
		Order rs = orderRepository.saveAndFlush(order);
		String id = rs.getId();
		for (OrderDetail detail:order.getItems()) {
			detail.setOrder(order);
			orderDetailRepository.save(detail);
		}
	}
}
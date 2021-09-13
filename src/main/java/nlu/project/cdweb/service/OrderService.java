package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.Order;
import nlu.project.cdweb.entity.OrderDetail;
import nlu.project.cdweb.repository.OrderDetailRepository;
import nlu.project.cdweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface OrderService {
	List<Order> list();
	void save(Order order);
	void cancelOrder(String id);
	List<Order> getOrder(String id);
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

		orderRepository.saveAndFlush(order);
		for (OrderDetail detail:order.getItems()) {
			detail.setOrder(order);
			orderDetailRepository.saveAndFlush(detail);
		}
	}

	@Override
	public void cancelOrder(String id) {
		orderRepository.cancelOrder(id);
	}

	@Override
	public List<Order> getOrder(String id) {
		return orderRepository.getOrder(id);
	}
}
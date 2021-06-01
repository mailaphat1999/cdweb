package nlu.project.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.repository.UserRepository;

public interface UserService {
	List<User> list();
	long count();
}
@Service
class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> list() {
		return userRepository.findAll();
	}
	@Override
	public long count() { return userRepository.count(); }
}
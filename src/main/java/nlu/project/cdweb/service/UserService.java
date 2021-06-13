package nlu.project.cdweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.repository.UserRepository;

public interface UserService {
	List<User> list();
	long count();
	Optional<User> findByID(String id);
	User login(String username,String password);
	void save(User user);
	void active(String email);
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

	@Override
	public Optional<User> findByID(String id) {
		return userRepository.findById(id);
	}
	@Override
	public User login(String username,String password) {
		User user = userRepository.login(username, password);
		return user;
	}

	@Override
	public void save(User user) { userRepository.save(user); }

	@Override
	public void active(String email) {
		userRepository.active(email);
	}
}
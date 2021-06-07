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
}
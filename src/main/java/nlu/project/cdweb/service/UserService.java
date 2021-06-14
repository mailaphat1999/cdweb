package nlu.project.cdweb.service;

import java.util.List;
import java.util.Optional;

import nlu.project.cdweb.custom.MyDateFormat;
import nlu.project.cdweb.entity.ForgetPass;
import nlu.project.cdweb.repository.ForgetPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.repository.UserRepository;

public interface UserService {
	List<User> list();
	long count();
	Optional<User> findByID(String id);
	User login(String username,String password);
	User getUserByEmail(String email);
	void save(User user);
	void active(String email);
	void addForgetPass(ForgetPass forgetPass);
	ForgetPass getForgetPass(String id);
	void resetPass(String email,String newpassword);
}
@Service
class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ForgetPassRepository forgetPassRepository;
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
	public void save(User user) { userRepository.saveAndFlush(user); }

	@Override
	public void active(String email) {
		userRepository.active(email);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

	@Override
	public void addForgetPass(ForgetPass forgetPass) { forgetPassRepository.saveAndFlush(forgetPass); }
	@Override
	public ForgetPass getForgetPass(String id) { return forgetPassRepository.findById(id).get(); }

	@Override
	public void resetPass(String email,String newpassword) {
		User user = getUserByEmail(email);
		user.setPassword(newpassword);
		user.setLastChange(MyDateFormat.getNow());
		save(user);
	}
}
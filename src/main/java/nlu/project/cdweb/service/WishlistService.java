package nlu.project.cdweb.service;

import nlu.project.cdweb.entity.User;
import nlu.project.cdweb.entity.Wishlist;
import nlu.project.cdweb.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface WishlistService {
	void save(Wishlist wishlist);
	void deleteAll(User user);
	void deleteOne(String id);
	Wishlist findByID(String id);
}

@Service
class WishlistServiceImpl implements WishlistService{
	@Autowired
	WishlistRepository wishlistRepository;
	@Override
	public void save(Wishlist wishlist) {
		wishlistRepository.save(wishlist);
	}

	@Override
	public void deleteAll(User user) {
		wishlistRepository.deleteAll(user.getWishLists());
	}

	@Override
	public void deleteOne(String id) {
		wishlistRepository.deleteById(id);
	}

	@Override
	public Wishlist findByID(String id) {
		return wishlistRepository.findById(id).get();
	}
}
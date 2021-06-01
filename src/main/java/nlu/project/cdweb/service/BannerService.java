package nlu.project.cdweb.service;

import nlu.project.cdweb.custom.Config;
import nlu.project.cdweb.entity.Banner;
import nlu.project.cdweb.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BannerService {
	List<Banner> list();
	List<Banner> carousel();
	List<Banner> bottom();
	List<Banner> foot();
}

@Service
class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerRepository BannerRepository;
	
	@Override
	public List<Banner> list() { return BannerRepository.findAll(); }

	@Override
	public List<Banner> carousel() { return BannerRepository.carousel("carousel", Config.orderByIdAsc()); }
	@Override
	public List<Banner> bottom() { return BannerRepository.carousel("bottom", Config.orderByIdAsc()); }
	@Override
	public List<Banner> foot() { return BannerRepository.carousel("foot", Config.orderByIdAsc()); }
}
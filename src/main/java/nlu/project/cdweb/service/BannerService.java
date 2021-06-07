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
	private BannerRepository bannerRepository;
	
	@Override
	public List<Banner> list() { return bannerRepository.findAll(); }

	@Override
	public List<Banner> carousel() { return bannerRepository.banner("carousel", Config.orderByIdAsc()); }
	@Override
	public List<Banner> bottom() { return bannerRepository.banner("bottom", Config.orderByIdAsc()); }
	@Override
	public List<Banner> foot() { return bannerRepository.banner("foot", Config.orderByIdAsc()); }
}
package tw.taiwanday.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelDao hDao;
	
	public HotelBean insert(HotelBean HBean) {
		return hDao.insert(HBean);
	}
	
	public List<HotelBean> getAll(){
		return hDao.getAll();
	}
	
	public HotelBean update(HotelBean HBean) {
		return hDao.update(HBean);
	}
	
	public HotelBean getHotelBeanById(int hotelId){
		return hDao.getHotelBeanById(hotelId);	
	}
	
	public boolean delete(int hotelId) {
		return hDao.delete(hotelId);
	}
	
	
}

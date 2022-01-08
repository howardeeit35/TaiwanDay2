package tw.taiwanday.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class HotelDao {
	@Autowired
	private SessionFactory sessionFactory;

	public HotelBean getHotelBeanById(int hotelId) {
		Session session = sessionFactory.openSession();
		HotelBean hotelBean = session.get(HotelBean.class, hotelId);
		session.close();
		return hotelBean;
	}

	public HotelBean insert(HotelBean hotel) {
		Session session = sessionFactory.openSession();
		System.out.println("Transaction begin");
		HotelBean hotelBean = session.get(HotelBean.class, hotel.getHotelId());

		if (hotelBean == null) {
			session.save(hotel);
		}

		session.close();

		return hotel;
	}

	public List<HotelBean> getAll() {
		Session session = sessionFactory.openSession();
		String hql = "from HotelBean";
		Query<HotelBean> query = session.createQuery(hql, HotelBean.class);
		return query.list();
	}

	public HotelBean update(HotelBean hotel) {
		Session session = sessionFactory.openSession();
		HotelBean hotelBean = null;

		System.out.println("Transaction begin");
		hotelBean = session.get(HotelBean.class, hotel.getHotelId());
		if (hotelBean != null) {
			hotelBean.setHotelName(hotel.getHotelName());
			hotelBean.setHotelPhoneNum(hotel.getHotelPhoneNum());
			hotelBean.setHotelAddress(hotel.getHotelAddress());
			hotelBean.setHotelPrice(hotel.getHotelPrice());
			hotelBean.setRoomStyle(hotel.getRoomStyle());
			hotelBean.setCheckinDate(hotel.getCheckinDate());
			hotelBean.setCheckoutDate(hotel.getCheckoutDate());
			session.flush();
		}
		System.out.println("Transaction commit");

		session.close();
		System.out.println("Transaction close");

		return hotelBean;
	}

	public boolean delete(int hotelId) {
		Session session = sessionFactory.openSession();

		System.out.println("Transaction begin");
		HotelBean hotelBean = session.get(HotelBean.class, hotelId);
		System.out.println(hotelBean);
		if (hotelBean != null) {
			session.delete(hotelBean);
			session.flush();
			session.close();
			System.out.println("Transaction commit");
			return true;

		}
		session.close();
		System.out.println("Transaction close");

		return false;

	}

	public void close() {
		sessionFactory.close();
	}

}

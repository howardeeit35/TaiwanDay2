package tw.taiwanday.model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ShowDao{

	@Autowired
	private SessionFactory factory;

	public Show getShowById(int id) {		
		 Session session = factory.openSession();
		 Show show = session.get(Show.class, id);
		 session.close();
		 return show;
	}
	
	public List<Show> getAll() {
		Session session = factory.openSession();
		String hql = "from Show";
		Query<Show> query = session.createQuery(hql, Show.class);
		return query.list();
	}

	public Show inster(Show show) {
		Session session = factory.openSession();
		Show result = session.get(Show.class, show.getId());
		if (result == null) {
			session.save(show);
		}
			session.close();
			return show;
	}
	
	public Show update(Show show) {
		Session session = factory.openSession();
		
		if (show != null) {
			session.update(show);
			session.flush();
		}
			session.close();
			return show;
	}
	
	public boolean delete(int id) {
		Session session = factory.openSession();
		Show result = session.get(Show.class, id);
	if(result != null) {		
		session.delete(result);
		session.flush();
		session.close();
		return true;
	}
		session.close();
		return false;
	}
	

}

package tw.taiwanday.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bbsDao")
public class BbsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public BbsBean insert(BbsBean bbs) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			System.out.println("Transaction begin");
			BbsBean bbsBean = session.get(BbsBean.class, bbs.getId());
			
			if (bbsBean == null) {
				session.save(bbs);
				session.getTransaction().commit();
				System.out.println("Transaction commit");
				return bbs;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction rollback");
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Transaction close");
		}
		return null;
	}
	
	public List<BbsBean> findAll(){
		Session session = sessionFactory.openSession();
		Query<BbsBean> query = session.createQuery("from BbsBean",BbsBean.class);
		return query.list();
	}
	
	public BbsBean update(BbsBean bbs) {
		Session session = sessionFactory.openSession();
		BbsBean bbsBean = null;

			System.out.println("Transaction begin");
			bbsBean = session.get(BbsBean.class,bbs.getId());
			if (bbsBean != null) {
				bbsBean.setContent(bbs.getContent());
				bbsBean.setGrades(bbs.getGrades());
				session.flush();
			}
			System.out.println("Transaction commit");

			session.close();
			System.out.println("Transaction close");

		return bbsBean;		
	}
	
	public boolean delete(int bbsid) {
		Session session = sessionFactory.openSession();

			System.out.println("Transaction begin");
			BbsBean bbsBean = session.get(BbsBean.class, bbsid);
			System.out.println(bbsBean);
			if (bbsBean != null) {
				session.delete(bbsBean);
				session.flush();
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

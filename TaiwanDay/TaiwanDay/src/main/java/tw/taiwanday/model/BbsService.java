package tw.taiwanday.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbsService {
	@Autowired
	private BbsDao bbsDao;

	public BbsBean insert(BbsBean BBean) {
		return bbsDao.insert(BBean);
	}
	
	public List<BbsBean> findAll(){
		return bbsDao.findAll();
	}
	
	public BbsBean update(BbsBean bbs) {
		return bbsDao.update(bbs);
	}
	
	public boolean delete(int no) {
		return bbsDao.delete(no);
	}

}

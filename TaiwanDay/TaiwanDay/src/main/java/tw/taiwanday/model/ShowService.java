package tw.taiwanday.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShowService {

	@Autowired
	private ShowDao dao;
	
	public List<Show> getAll(){
		return dao.getAll();
	}

	public Show inster(Show show){
		 return dao.inster(show);
	}
	
	public Show getShowById(int id){
		return dao.getShowById(id);	
	}
	
	public boolean delete(int id){
		 return dao.delete(id);
	}
	
	public Show update(Show show) {
		return dao.update(show);
	}


}
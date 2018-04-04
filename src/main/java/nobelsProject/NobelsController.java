package nobelsProject;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.rest.dao.DAOFactory;
import demo.springboot.rest.dao.NobelsDAOImpl;

@RestController
public class NobelsController {

	private static final NobelsDAOImpl GET_DB;

	static {
		GET_DB = new NobelsDAOImpl(DAOFactory.getInstance("mysql"));
	}

	@RequestMapping("/nobelPrizeWinners")
	public List<Laureates> getAllWinners() {
		List<Laureates> list = GET_DB.getWinners();
		return list;
	}
}

package demo.springboot.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nobelsProject.Laureates;

public class NobelsDAOImpl implements NobelsDAO {

	private DAOFactory daoFactory;

	public NobelsDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	private List<Laureates> findLaureates(String sql, Object... values) {
		List<Laureates> laureatesList = new ArrayList<>();

		try {
			Connection connection = daoFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			if (values.length > 0) {
				for (int i = 1; i <= values.length; i++) {
					statement.setObject(i, values[i - 1]);
				}
			}
			ResultSet rs = statement.executeQuery();
			Laureates laureates = null;
			while (rs.next()) {
				laureates = new Laureates();
				laureates.setId(rs.getLong("id"));
				laureates.setFirstname(rs.getString("firstname"));
				laureates.setLastname(rs.getString("lastname"));
				laureates.setMotivation(rs.getString("motivation"));
				laureates.setShareOfPrize(rs.getInt("share"));
				laureates.setYear(rs.getInt("year"));
				laureates.setCategory(rs.getString("category"));
				laureatesList.add(laureates);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return laureatesList;
	}

	@Override
	public List<Laureates> getWinnersByYear(int year) {
		List<Laureates> list = findLaureates(" select * from nobel_laureates where " + " year=? ", year);
		return list;
	}

	@Override
	public List<Laureates> getWinners() {
		List<Laureates> list = findLaureates("select * from nobel_laureates");
		return list;
	}

	@Override
	public List<Laureates> getWinnerByName(String name) {
		List<Laureates> list = findLaureates(" select * from nobel_laureates " + " where firstname=? or lastname=? ",
				name, name);
		return list;
	}

	@Override
	public List<Laureates> getWinnersByCategory(String category) {
		List<Laureates> list = findLaureates(" select * from nobel_laureates where " + " category=? ", category);
		return list;
	}

}

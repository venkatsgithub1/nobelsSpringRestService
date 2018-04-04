package demo.springboot.rest.dao;

import java.util.List;

import nobelsProject.Laureates;

/**
 * This interface defines methods that will be used for data retrieval and other
 * actions done by a concrete class that implements this interface.
 *
 */
public interface NobelsDAO {
	public List<Laureates> getWinnersByYear(int year);

	public List<Laureates> getWinners();

	public List<Laureates> getWinnerByName(String name);

	public List<Laureates> getWinnersByCategory(String category);
}

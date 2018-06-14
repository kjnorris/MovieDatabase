import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ActorTest {

	@Test
	void testGetName() {
		Actor seanPenn = new Actor("Sean Penn");
		assertEquals(seanPenn.getName(), "Sean Penn");
		assertNotEquals(seanPenn.getName(), "Sean Connery");
	}

	@Test
	void testSetName() {
		Actor seanPenn = new Actor("Sean Connery");
		assertEquals(seanPenn.getName(), "Sean Connery");
		seanPenn.setName("Sean Penn");
		assertEquals(seanPenn.getName(), "Sean Penn");
		assertNotEquals(seanPenn.getName(), "Sean Connery");
	}

	@Test
	void testGetMovieList() {
		// Identical to testSetMovieList()
		Actor seanPenn = new Actor("Sean Connery");
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		String[] pennMovies = new String[] {"I am Sam", "Milk", "Mystic River",
			"Fast Times at Ridgemont High"};
		for (int i = 0; i < pennMovies.length; i++) {
			movieList.add(new Movie(pennMovies[i]));
		}
		seanPenn.setMovieList(movieList);
		assertEquals(seanPenn.getMovieList(), movieList);
	}

	@Test
	void testSetMovieList() {
		// Identical to testGetMovieList()
		Actor seanPenn = new Actor("Sean Connery");
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		String[] pennMovies = new String[] {"I am Sam", "Milk", "Mystic River",
			"Fast Times at Ridgemont High"};
		for (int i = 0; i < pennMovies.length; i++) {
			movieList.add(new Movie(pennMovies[i]));
		}
		seanPenn.setMovieList(movieList);
		assertEquals(seanPenn.getMovieList(), movieList);
	}

	@Test
	void testAddMovie() {
		Actor seanPenn = new Actor("Sean Connery");
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		String[] pennMovies = new String[] {"I am Sam", "Milk", "Mystic River"};
		for (int i = 0; i < pennMovies.length; i++) {
			movieList.add(new Movie(pennMovies[i]));
		}
		seanPenn.setMovieList(movieList);
		Movie nextMovie = new Movie("Fast Times at Ridgemont High");
		movieList.add(nextMovie);
		seanPenn.addMovie(nextMovie);
		assertEquals(seanPenn.getMovieList(), movieList);
	}

	@Test
	void testEqualsString() {
		Actor seanPenn = new Actor("Sean Penn");
		assertTrue(seanPenn.equals("Sean Penn"));
	}

}

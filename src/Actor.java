import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actor {
	private String name;
	private ArrayList<Movie> movieList;

	public Actor(String name) {
		this.name = name;
		this.movieList = new ArrayList<Movie>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	public void addMovie(Movie movie) {
		if (!this.movieList.contains(movie)) {
			this.movieList.add(movie);
		}
	}
	
	public boolean equals(String name) {
		return this.name == name;
	}
}

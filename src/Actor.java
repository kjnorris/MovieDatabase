import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Actor object tracks an actor and the movies in which they appear.
 * @author kjnorris
 *
 */
public class Actor {

	private String name;
	private ArrayList<Movie> movieList;

	/**
	 * Constructor sets the actor's name and creates a blank ArrayList of type Movie
	 *  of the movies the actor appears in.
	 * @param name String containing the actor's name
	 * 
	 */
	public Actor(String name) {
		this.name = name;
		this.movieList = new ArrayList<Movie>();
	}
	
	public Actor() {
		this.movieList = new ArrayList<Movie>();
	}
	
	/**
	 * Gets the name of the actor.
	 * @return String containing the actor's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of the actor to the one provided.
	 * @param name String containing the updated name of the actor
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets a list of the movies in which the actor appears.
	 * @return ArrayList of Movie objects with the movies the actor has appeared in
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	/** 
	 * Sets the list of movies in which an actor appears.
	 * @param movieList ArrayList of Movie objects with the movies the actor has appeared in
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	/**
	 * Adds a movie to the list of movies in which an actor appears.
	 * @param movie A Movie object for the movie in which the actor appears
	 */
	public void addMovie(Movie movie) {
		if (!this.movieList.contains(movie)) {
			this.movieList.add(movie);
		}
	}
	
	/**
	 * Checks whether the name of the actor is the same as the String provided.
	 * @param name String containing the name of the actor to be checked
	 * @return Boolean True is the name provided is the actor's name, False otherwise
	 */
	public boolean equals(String name) {
		return this.name == name;
	}
}

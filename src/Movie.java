import java.util.ArrayList;

/**
 * Movie object tracks an movie, its Rotten Tomatoes rating, and the actors
 * appearing in the movie.
 * @author kjnorris
 *
 */
public class Movie {
	
	private String name;
	private double rating;
	private ArrayList<Actor> actorList;
	
	/**
	 * Constructor sets the movie's name and creates a blank ArrayList of type Actor
	 * of the actors appearing in the movie. The movie's rating is initially set to 0.
	 * @param name String containing the movie's name
	 * 
	 */
	public Movie(String name) {
		this.name = name;
		this.actorList = new ArrayList<Actor>();
	}
	
	public Movie() {
		this.actorList = new ArrayList<Actor>();
	}
	
	/**
	 * Gets the name of the movie.
	 * @return String containing the movie's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Changes the name of the movie to the one provided.
	 * @param name String containing the updated name of the movie
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the movie's Rotten Tomatoes rating.
	 * @return Double containing the movie's rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Sets the movie's Rotten Tomatoes rating.
	 * @param rating Double containing the movie's rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * Gets a list of the actors who appear in the movie.
	 * @return ArrayList of Actor objects with the actors appearing in the movie
	 */
	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
	/**
	 * Sets the list of actors who appear in the movie.
	 * @param actorList ArrayList of Actor objects with the actors appearing in the movie
	 */
	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}
	
	/**
	 * Adds an actor to the list of actors who appear in the movie.
	 * @param actor An Actor object for the actor who appears in the movie
	 */
	public void addActor(Actor actor) {
		if (!this.actorList.contains(actor)) {
			this.actorList.add(actor);
		}
	}
	
	/**
	 * Checks whether the name of the movie is the same as the String provided.
	 * @param name tring containing the name of the movie to be checked
	 * @return Boolean True is the name provided is the movie's name, False otherwise
	 */
	public boolean equals(String name) {
		return this.name == name;
	}
	
}

import java.util.ArrayList;
import java.util.Hashtable;

public class MovieDatabase {
	private ArrayList<Actor> actorList;
	private ArrayList<Movie> movieList;

	public MovieDatabase() {
		this.actorList = new ArrayList<Actor>();
		this.movieList = new ArrayList<Movie>();
	}
	
	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void addMovie(String name, String[] actors) {
		Movie movieToAdd = new Movie(name);
		this.movieList.add(movieToAdd);
		for (String actorToAdd: actors) {
			boolean newActor = true;
			for (Actor actor: actorList) {
				if (actor.getName()==actorToAdd) {
					newActor = false;
					actor.addMovie(movieToAdd);
					movieToAdd.addActor(actor);
					break;
				}
			}
			if (newActor) {
				Actor addedActor = new Actor(actorToAdd);
				addedActor.addMovie(movieToAdd);
				movieToAdd.addActor(addedActor);
				this.actorList.add(addedActor);
			}
		}
	}
	
	public void addRating(String name, double rating) {
		for (Movie currMovie: this.getMovieList()) {
			if (currMovie.getName() == name) {
				currMovie.setRating(rating);
			}
		}
	}
	
	public void updateRating(String name, double newRating) {
		this.addRating(name,  newRating);
	}
	
	public String getBestMovie() {
		double highestRating = 0;
		int highestIndex = -1;
		for (Movie currMovie: this.getMovieList()) {
			if (currMovie.getRating() > highestRating) {
				highestRating = currMovie.getRating();
				highestIndex = this.getMovieList().indexOf(currMovie);
			}
		}
		return this.getMovieList().get(highestIndex).getName();
	}
	
	public String getBestActor() {
		double highestAverage = 0;
		int highestIndex = -1;
		for (Actor currActor: this.getActorList()) {
			int numMovies = 0;
			int totalRating = 0;
			for (Movie currMovie: currActor.getMovieList()) {
				if (currMovie.getRating() > 0) {
					numMovies++;
					totalRating += currMovie.getRating();
				}
			}
			if ((numMovies > 0) && (totalRating/numMovies > highestAverage)) {
				highestAverage = totalRating/numMovies;
				highestIndex = this.getActorList().indexOf(currActor);
			}
		}
		return this.getActorList().get(highestIndex).getName();
	}

	public static void main(String[] args) {
		MovieDatabase mvdb = new MovieDatabase();
		
		Hashtable<String, String[]> movieActors = new Hashtable<String, String[]>() {
			{
				put("Sleepers", new String[]{"Brad Pitt", "Dustin Hoffman"});
				put("Troy", new String[] {"Brad Pitt", "Diane Kruger"});
				put("Meet Joe Black", new String[] {"Brad Pitt"});
				put("Oceans Eleven", new String[] {"Brad Pitt"});
				put("Seven", new String[] {"Brad Pitt"});
				put("Mr & Mrs Smith", new String[] {"Brad Pitt"});
				put("12 Years a Slave", new String[] {"Brad Pitt"});
				put("You've Got Mail", new String[] {"Tom Hanks", "Meg Ryan"});
				put("Sleepless in Seattle", new String[] {"Tom Hanks", "Meg Ryan"});
				put("Apollo 13", new String[] {"Tom Hanks"});
				put("Catch Me If You Can", new String[] {"Tom Hanks"});
				put("Philadelphia", new String[] {"Tom Hanks"});
				put("Forrest Gump", new String[] {"Tom Hanks"});
				put("Courage Under Fire", new String[] {"Meg Ryan"});
				put("National Treasure", new String[] {"Diane Kruger"});
				put("Inglorious Bastards", new String[] {"Diane Kruger"});
				put("The Lost City", new String[] {"Dustin Hoffman"});
				put("Rain Man", new String[] {"Dustin Hoffman"});
				put("The Graduate", new String[] {"Dustin Hoffman"});
				put("Kramer vs. Kramer", new String[] {"Dustin Hoffman"});
			}
		};
		
		Hashtable<String, Integer> movieRatings = new Hashtable<String, Integer>() {
			{
				put("Sleepers", 74);
				put("Troy", 54);
				put("Meet Joe Black", 51);
				put("Oceans Eleven", 82);
				put("Seven", 79);
				put("Mr & Mrs Smith", 59);
				put("You've Got Mail", 69);
				put("Sleepless in Seattle", 72);
				put("Apollo 13", 95);
				put("Catch Me If You Can", 96);
				put("Philadelphia", 77);
				put("Forrest Gump", 71);
				put("National Treasure", 35);
				put("Rain Man", 90);
				put("Kramer vs. Kramer", 88);
			}
		};
		
		for (String currentMovie: movieActors.keySet()) {
			mvdb.addMovie(currentMovie, movieActors.get(currentMovie));
		}
		
		
		for (String currentMovie: movieRatings.keySet()) {
			mvdb.addRating(currentMovie,  (double) movieRatings.get(currentMovie));
		}

		for (Movie currMovie: mvdb.getMovieList()) {
			System.out.println("Movie: \"" + currMovie.getName() + "\" ");
			if (currMovie.getRating() > 0) {
				System.out.println("Rating: " + currMovie.getRating());
			} else {
				System.out.println("This movie is not yet rated.");
			}
			System.out.println("Starring: ");
			for (Actor currActor: currMovie.getActorList()) {
				System.out.println("  " + currActor.getName());
			}
			System.out.print("\n\n");;
		}
		
		/*
		for (Actor currActor: mvdb.getActorList()) {
			System.out.println("Actor: " + currActor.getName());
			System.out.println("Starred in: ");
			for (Movie currMovie: currActor.getMovieList()) {
				System.out.println("\"" + currMovie.getName() + "\"");
				if (currMovie.getRating() == 0) {
					System.out.println(" This movie is not yet rated.");
				} else {
					System.out.println(" This rating scored " + currMovie.getRating() + " Rotten Tomatoes");
				}
			}
			System.out.println("\n");
		}
		*/
		
		System.out.println("The highest rated movie is: \"" + mvdb.getBestMovie() + "\"");
		System.out.println("The highest rated actor is: " + mvdb.getBestActor() + "");
		
		System.out.println("\nFin!");
	}

}

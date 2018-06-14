import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

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
		boolean newMovie = true;
		
		for (Movie currMovie: this.movieList) {
			if (currMovie.getName() == name) {
				newMovie = false;
			}
		}
		
		if (newMovie) {
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
		
		Hashtable<String, ArrayList<String>> movieActors = new Hashtable<String, ArrayList<String>>();
		Hashtable<String, Integer> movieRatings = new Hashtable<String, Integer>();

		try {
			File movieFile = new File("movies.txt");
			Scanner movieScan = new Scanner(movieFile);
			while (movieScan.hasNextLine()) {
				String movieLine = movieScan.nextLine();
				String[] movieActor = movieLine.split(",");
				
				for (int i = 0; i < movieActor.length; i++) {
					movieActor[i] = movieActor[i].trim();
				}
				
				for (int i = 1; i < movieActor.length; i++) {
					if (movieActors.containsKey(movieActor[i])) {
						ArrayList<String> currActors = movieActors.get(movieActor[i]);
						currActors.add(movieActor[0]);
						movieActors.replace(movieActor[i], currActors);
					} else {
						ArrayList<String> currActors = new ArrayList<String>();
						currActors.add(movieActor[0]);
						movieActors.put(movieActor[i], currActors);
					}
				}
			}
			movieScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			File ratingsFile = new File("ratings.txt");
			Scanner ratingsScan = new Scanner(ratingsFile);
			if (ratingsScan.hasNextLine()) {
				//Skip header line
				ratingsScan.nextLine();
			}
			while (ratingsScan.hasNextLine()) {
				String ratingsLine = ratingsScan.nextLine().trim();
				String[] movieRating = ratingsLine.split("\\s+");
				String movieTitle = "";
				for (int i = 0; i < movieRating.length - 1; i++) {
					movieTitle = movieTitle + movieRating[i] + " ";
				}
				movieTitle = movieTitle.trim();
				int currRating = Integer.parseInt(movieRating[movieRating.length-1]);
				movieRatings.put(movieTitle, currRating);
			}
			ratingsScan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (String currentMovie: movieActors.keySet()) {
			ArrayList<String> currActors = movieActors.get(currentMovie);
			String[] addActors = currActors.toArray(new String[currActors.size()]);
			mvdb.addMovie(currentMovie, addActors);
			if (movieRatings.containsKey(currentMovie)) {
				mvdb.addRating(currentMovie,  (double) movieRatings.get(currentMovie));
			}
		}

		/*
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

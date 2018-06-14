import java.util.ArrayList;

public class Movie {
	private String name;
	private double rating;
	private ArrayList<Actor> actorList;
	public Movie(String name) {
		this.name = name;
		this.actorList = new ArrayList<Actor>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	public void setActorList(ArrayList<Actor> actorList) {
		this.actorList = actorList;
	}
	
	public void addActor(Actor actor) {
		if (!this.actorList.contains(actor)) {
			this.actorList.add(actor);
		}
	}
	
	public boolean equals(String name) {
		return this.name == name;
	}
	
}

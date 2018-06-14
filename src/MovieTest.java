import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	void testGetName() {
		Movie pennMovie = new Movie("Milk");
		assertEquals(pennMovie.getName(), "Milk");
		assertNotEquals(pennMovie.getName(), "Mystic River");
	}

	@Test
	void testSetName() {
		Movie pennMovie = new Movie("Milk");
		assertEquals(pennMovie.getName(), "Milk");
		pennMovie.setName("Mystic River");
		assertEquals(pennMovie.getName(), "Mystic River");
		assertNotEquals(pennMovie.getName(), "Milk");
	}

	@Test
	void testGetRating() {
		Movie pennMovie = new Movie("Milk");
		pennMovie.setRating((double) 94); 
		assertEquals(pennMovie.getRating(), (double) 94);
	}

	@Test
	void testSetRating() {
		Movie pennMovie = new Movie("Milk");
		pennMovie.setRating((double) 94); 
		assertEquals(pennMovie.getRating(), (double) 94);
	}

	@Test
	void testGetActorList() {
		Movie pennMovie = new Movie("Milk");
		ArrayList<Actor> movieActors = new ArrayList<Actor>();
		String[] actorList = new String[] {"Sean Penn", "Josh Brolin"};
		for (int i = 0; i < actorList.length; i++) {
			movieActors.add(new Actor(actorList[i]));
		}
		pennMovie.setActorList(movieActors);
		assertEquals(pennMovie.getActorList(), movieActors);
	}

	@Test
	void testSetActorList() {
		Movie pennMovie = new Movie("Milk");
		ArrayList<Actor> movieActors = new ArrayList<Actor>();
		String[] actorList = new String[] {"Sean Penn", "Josh Brolin"};
		for (int i = 0; i < actorList.length; i++) {
			movieActors.add(new Actor(actorList[i]));
		}
		pennMovie.setActorList(movieActors);
		assertEquals(pennMovie.getActorList(), movieActors);
	}

	@Test
	void testAddActor() {
		Movie pennMovie = new Movie("Milk");
		ArrayList<Actor> movieActors = new ArrayList<Actor>();
		String[] actorList = new String[] {"Sean Penn"};
		for (int i = 0; i < actorList.length; i++) {
			movieActors.add(new Actor(actorList[i]));
		}
		pennMovie.setActorList(movieActors);
		assertEquals(pennMovie.getActorList(), movieActors);
		Actor missedActor = new Actor("Josh Brolin");
		movieActors.add(missedActor);
		pennMovie.addActor(missedActor);
		assertEquals(pennMovie.getActorList(), movieActors);
	}

	@Test
	void testEqualsString() {
		Movie pennMovie = new Movie("Milk");
		assertTrue(pennMovie.equals("Milk"));
	}

}

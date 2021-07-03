/* Created by Adam Jost and Neha Metlapalli on 06/25/2021 */
/* Update by Adam Jost on 06/29/2021 */

package project1.system.movies;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class MovieList {
	
	// Data fields
	private ArrayList<Movie> releasedMovies;
	private ArrayList<Movie> receivedMovies;
	private Date today;
	
	// Constructor
	public MovieList() {
		releasedMovies = new ArrayList<>();
		receivedMovies = new ArrayList<>();
		
		Calendar c = Calendar.getInstance();

		// Set the calendar to the beginning of today
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		// Create a date object using the above.
		today = c.getTime();
		
	}
	
	private Date getToday() { return this.today; }
	
	// Class-member methods
	
	public String getMovieInfo(String movieName) {
		Iterator<Movie> iter = receivedMovies.iterator();
		Movie movie = null;
		
		while(iter.hasNext()) {
			movie = iter.next();
			if (movie.getName().equalsIgnoreCase(movieName)) {
				return movie.toFileString();
			}
		}
		
		iter = releasedMovies.iterator();
		
		while(iter.hasNext()) {
			movie = iter.next();
			if (movie.getName().equalsIgnoreCase(movieName)) {
				return movie.toFileString();
			}
		}
		
		return null;	
	}
	
	/** Displays the receivedMovies list */
	public String displayReceivedMovies() {
		
		StringBuilder sb = new StringBuilder();
		
		// Add a heading 
		sb.append("================\nReceived Movies:\n================\n");
		
		// Iterator for receivedMovies list
		Iterator<Movie> iter = receivedMovies.iterator();
		
		// Until we have reached the end of the received list.
		while (iter.hasNext()) {
			sb.append(iter.next());
			
		}

		
		return sb.toString();
	}
	
	/** Displays the releasedMovies list */
	public String displayReleasedMovies() {
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Movie> iter = releasedMovies.iterator();

		// Print heading to the standard console.
		sb.append("================\nReleased Movies:\n================\n");
		
		// Iterator for releasedMovies list
		iter = releasedMovies.iterator();
		
		// Until we have reached the end of the released list.
		while (iter.hasNext()) {
			sb.append(iter.next());
		}
				
		return sb.toString();
	}
	
	/** Displays all of the movies from both movie lists by status "Received" or "Released" */
	public String displayAll() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(displayReceivedMovies());
		
		sb.append("\n");
		
		// Print a divider between the displayed movie lists
		for (int i = 0; i <= 82; i++) sb.append("=");
		
		sb.append("\n\n");
		
		sb.append(displayReleasedMovies());
		
		return sb.toString();
	}
	
	/**
	 * Adds a movie to the coming movie list.
	 * @param m: the movie to be added
	 * @return: {true} if the movie was add successfully; {false} otherwise.
	 */
	public boolean addToReceivedList(Movie m) {
		Iterator<Movie> iter = receivedMovies.iterator(); // Create iterator to iterate over the comingMovies list
		int moviePos = -1; 
		
		while (iter.hasNext()) { 
			Movie currMovie = (Movie) iter.next(); // Move the iterator to the next element and store the element that was passed over
			if (currMovie.getName().toLowerCase().equals(m.getName().toLowerCase())) { // If the input movie already exists in the list
				return false; // Then end the method here
			}
			if (currMovie.getReleaseDate().after(m.getReleaseDate()) && moviePos == -1) { // If the input movie should be inserted here because the element after it is greater than it
				moviePos = receivedMovies.indexOf(currMovie);
			}
		}
		
		iter = releasedMovies.iterator();
		while (iter.hasNext()) {
			Movie currMovie = iter.next(); // Move the iterator to the next element and store the element that was passed over
			if (currMovie.getName().toLowerCase().equals(m.getName().toLowerCase())) { // If the input movie already exists in the list
				return false; // Then end the method here
			}
		}
		
		// If an greater element was found place movie before that element.
		if (moviePos != -1) {
			receivedMovies.add(moviePos, m);
		} else { // Otherwise,
			// Add the movie to the end of the received movies list in case the movie has the latest release date
			receivedMovies.add(m);
		}
		return true;
	}
	
	/**
	 * Adds a movie to the released movies list.
	 * @param m: the movie to be added.
	 */
	public boolean addToReleasedList(Movie m) {
		Iterator<Movie> iter = releasedMovies.iterator(); 
		int moviePos = -1; 
		
		while (iter.hasNext()) { 
			Movie currMovie = iter.next(); // Move the iterator to the next element and store the element that was passed over
			if (currMovie.getName().toLowerCase().equals(m.getName().toLowerCase())) { // If the input movie already exists in the list
				return false; // Then end the method here
			}
			if (currMovie.getReleaseDate().after(m.getReleaseDate()) && moviePos == -1) { // If the input movie should be inserted here because the element after it is greater than it
				moviePos = releasedMovies.indexOf(currMovie);
			}
		}
		
		iter = receivedMovies.iterator();
		while (iter.hasNext()) {
			Movie currMovie = iter.next(); // Move the iterator to the next element and store the element that was passed over
			if (currMovie.getName().toLowerCase().equals(m.getName().toLowerCase())) { // If the input movie already exists in the list
				return false; // Then end the method here
			}
		}
		
		// If an greater element was found place movie before that element.
		if (moviePos != -1) {
			releasedMovies.add(moviePos, m);
		} else { // Otherwise,
			// Add the movie to the end of the received movies list in case the movie has the latest release date
			releasedMovies.add(m);
		}
		return true;
	}
	
	/**
	 * Counts and returns the number of received movies before a given date.
	 * @param d: the date to count up to.
	 * @return: the number of received movies before the date.
	 */
	public int countReceivedMovies(Date d) {
		int totalMoviesBeforeDate = 0; // This will store the number of movies before the input date
		Iterator<Movie> iter = receivedMovies.iterator(); // Create iterator to iterate over the receivedMovies list
		while (iter.hasNext()) { // While there are more elements to iterate over
			Movie currMovie = iter.next(); // Move the iterator to the next element and store the element that was passed over
			if (currMovie.getReleaseDate().compareTo(d) < 0) { // If the current movie's release date is before the input date
				totalMoviesBeforeDate++; // Then add one to the count of the total number of movies before the input date
			} 
		}
		return totalMoviesBeforeDate;
	}
	
	/**
	 * Deletes a movie from the movie lists.
	 * @param movieName: the name of the movie to be deleted.
	 * @return: {true} if a movie was deleted; {false} otherwise.
	 */
	public boolean deleteMovie(String movieName) {
		int removePos = -1;
		Iterator<Movie> iter = receivedMovies.iterator();
		while (iter.hasNext()) {
			Movie currMovie = iter.next();
			if (currMovie.getName().equalsIgnoreCase(movieName)) {
				removePos = receivedMovies.indexOf(currMovie);
				break;
			}
		}
		if (removePos > -1) {
			// Print the deleted movie name from here to avoid user input capitalization issues.
			receivedMovies.remove(removePos);
			return true;
		}
		// Change to the releasedMovies list.
		iter = releasedMovies.iterator();
		
		while (iter.hasNext()) {
			Movie currMovie = iter.next();
			if (currMovie.getName().equalsIgnoreCase(movieName)) {
				removePos = releasedMovies.indexOf(currMovie);
				break;
			}
		}
		if (removePos > -1) {
			// Print the deleted movie name from here to avoid user input capitalization issues.
			releasedMovies.remove(removePos);
			return true;
		}
		return false;
	}
	
	public String releaseMovie(String movieName, Date date, String releaseBy) {
		
		Iterator<Movie> iter = receivedMovies.iterator();
		String returnVal = "";
		ArrayList<Integer> removePos = new ArrayList<>();
				
		while (iter.hasNext()) {
			Movie movie = iter.next();
			
			if (releaseBy.equals("name")) {
				if (movie.getName().equalsIgnoreCase(movieName)) {
					if (movie.getReceiveDate().compareTo(getToday()) >= 0) {
						return "receive date error";
					} else {
						movie.setReleaseDate(today);
						movie.setStatus(MovieStatus.RELEASED);
						receivedMovies.remove(movie);
						addToReleasedList(movie);
						return "success";
					}
				}
			} else {
				if (movie.getReleaseDate().compareTo(date) == 0 && movie.getReceiveDate().compareTo(getToday()) < 0) {
					removePos.add(receivedMovies.indexOf(movie));
					movie.setReleaseDate(today);
					movie.setStatus(MovieStatus.RELEASED);
					
					returnVal += movie.getName() + " has been released.\n";
				}
			}
		}
		
		if (removePos.size() > 0) {
			for (int pos : removePos) {
				addToReleasedList(receivedMovies.remove(pos));
			}
		}
		
		return returnVal == "" ? "no movie error" : returnVal;
	}
	
	@Override
	public String toString() {
		// Iterator used to iterate through both movie lists.
		Iterator<Movie> iter = receivedMovies.iterator();
		
		// Used to build a String to print to the output file "movies.txt".
		StringBuilder sb = new StringBuilder();
		
		// Until the end of the receivedMovies list...
		while (iter.hasNext()) {
			// Append String representation of each movie followed by a new line. 
			sb.append(iter.next().toFileString() + "\n");
		}
		
		// Set the iterator to the releasedMovies list.
		iter = releasedMovies.iterator();
		
		// Until the end of the releasedMovies list...
		while (iter.hasNext()) {
			// Append String representation of each movie followed by a new line. 
			sb.append(iter.next().toFileString() + "\n");
		}
		
		return sb.toString();
	}

}

/* Created by Adam Jost on 07/01/2021 */

package project1.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JApplet;
import javax.swing.JFrame;

import project1.system.frame.ApplicationFrame;
import project1.system.movies.Movie;
import project1.system.movies.MovieList;
import project1.system.movies.MovieStatus;

public class SystemManager {

	public static void main(String[] args) throws IOException {
				
		// Open input streams.
		FileInputStream fin = new FileInputStream("movies.txt");
		Scanner scanner = new Scanner(fin);

		// MovieList object used for storing Movie objects within two lists: "Received"
		// and "Released"
		MovieList movieList = new MovieList();
		
		// Parse input file data.
		while (scanner.hasNext()) {
			// Read in next line from file and place in a String array.
			String[] data = scanner.nextLine().split(", ");
			// Instantiate a Movie object using data retrieved from input file.
			Movie movie = new Movie(data[0], convertDate(data[1]), data[2], convertDate(data[3]),
					convertStatus(data[4]));
			// Update the movies status if it has been released as of today's date.
			movie.updateMovieStatus();
			// If currently "Released" add the Movie to the released MovieList.
			if (movie.getStatus() == MovieStatus.RELEASED) {
				movieList.addToReleasedList(movie);
			} else {
				// If currently "Received" then add the Movie to the received MovieList.
				movieList.addToReceivedList(movie);
			}
		}

		// Close open streams
		scanner.close();
		fin.close();
		
		// Create and display the application window. 
		new ApplicationFrame(movieList);

	}

	/**
	 * Creates and returns a Date from an input String.
	 * @param date: The date to be converted.
	 * @return: The parsed Date.
	 */
	static Date convertDate(String date) {
		// Create a null Date
		Date result = null;

		// Date cannot be expected format if argument length is not 10 (e.g.
		// 01/02/2022).
		if (date.length() != 10) {
			// Notify user input String entered was not in the valid/acceptable format.
			System.out.println("Error: Date entered was invalid.");
			return null;
		}
		try {
			// Specify format
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			// Set result to the parsed argument String
			result = dateFormat.parse(date);
		} catch (ParseException e) {
			// This catch will only ever apply to user input unless input file is manually
			// edited and invalid input is added.
			// Recommendation: Do not manually edit the input file. Use this system instead.
			// Notify user input String entered was not in the valid/acceptable format.
			System.out.println("Error: Date entered was invalid.");
		}
		// Return the Date
		return result;
	}

	/**
	 * Converts argument String to MovieStatus
	 * @param status: String to be converted to MovieStatus
	 * @return MovieStatus
	 */
	static MovieStatus convertStatus(String status) {
		// Set status depending on argument String, if valid
		if (status.equalsIgnoreCase("RECEIVED")) {
			return MovieStatus.RECEIVED;
		} else if (status.equalsIgnoreCase("RELEASED")) {
			return MovieStatus.RELEASED;
		} else {
			// If input String was not valid, notify user and leave status set to null.
			System.out.println("Error: Invalid status entered");
			return null;
		}
	}

}

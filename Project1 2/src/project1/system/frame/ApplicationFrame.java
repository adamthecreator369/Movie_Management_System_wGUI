/* Created by Adam Jost on 07/02/2021 */

package project1.system.frame;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import project1.system.movies.Movie;
import project1.system.movies.MovieList;
import project1.system.movies.MovieStatus;

@SuppressWarnings("serial")
public class ApplicationFrame extends Frame {
	
	
	private final String TITLE;
	
	private String user, userType, userName;

	private static final java.awt.Color Color = null;
	
	private static String savedName = "";

	private JButton addBtn, editBtn, countBtn, releaseBtn, deleteBtn, saveBtn, cancelBtn,
		viewAllBtn, viewReceivedBtn, viewReleasedBtn, viewFileBtn, addMovieBtn, resetBtn,
		findMovieBtn, editSaveBtn, editCancelBtn, deleteDeleteBtn, releaseByNameBtn,
		releaseByDateBtn, countCountBtn, loginBtn, logoutBtn;
	
	private int frameWidth, frameHeight, mainBtnWidth, mainBtnHeight;
	
	private JLabel nameLabel, descriptionLabel, receiveLabel, releaseLabel, statusLabel, 
		addOperationLabel, editOperationLabel, countOperationLabel, releaseOperationLabel, 
		deleteOperationLabel, countReceiveLabel, loginOperationLabel, usernameLabel, passwordLabel,
		nameOfUserLabel;
		
	private JTextField nameField, receiveField, releaseField, countReceiveField, passwordField;
	
	private JCheckBox actionCheckBox, adventureCheckBox, animationCheckBox, comedyCheckBox, 
		crimeCheckBox, dramaCheckBox, experimentCheckBox,fantasyCheckBox, historicalCheckBox, 
		horrorCheckBox, otherCheckBox, romanceCheckBox, scifiCheckBox, thrillerCheckBox, 
		westernCheckBox;
	
	private ArrayList<JCheckBox> checkBoxList;
		
	private JTextArea displayArea;
	
	private JScrollPane scrollPane;
	
	private String[] statusChoices;
	
	private JComboBox<String> statusComboBox;
	
	private MovieList movieList;

	// Constructor
	public ApplicationFrame(MovieList movieList) {
		TITLE = "Movie Management System";
		this.movieList = movieList;
		prepareGUI();
	}
	
	// Prepares and creates the GUI
	private void prepareGUI() {
		
		// Stored Sizes
		frameWidth = 1250;
		frameHeight = 950;
		mainBtnWidth = 250;
		mainBtnHeight = 100;
		
		// Colors
		java.awt.Color bgColor = Color.LIGHT_GRAY;
		
		// Instances, their size, and settings
		
		// Buttons : Instances
		addBtn = new JButton("ADD");
		editBtn = new JButton("EDIT");
		countBtn = new JButton("COUNT");
		releaseBtn = new JButton("RELEASE");
		deleteBtn = new JButton("DELETE");
		saveBtn = new JButton("SAVE");
		cancelBtn = new JButton("CANCEL");
		viewAllBtn = new JButton("View All Movies");
		viewReceivedBtn = new JButton("View Received Movies");
		viewReleasedBtn = new JButton("View Released Movies");
		viewFileBtn = new JButton("View File Data");
		addMovieBtn = new JButton("Add Movie");
		resetBtn = new JButton("Reset");
		findMovieBtn = new JButton("Find Movie");
		editSaveBtn = new JButton("Edit");
		editCancelBtn = new JButton("Cancel");
		deleteDeleteBtn = new JButton("Delete");
		releaseByNameBtn = new JButton("Release Today");
		releaseByDateBtn = new JButton("Release All Today");
		countCountBtn = new JButton("Count");
		loginBtn = new JButton("Login");
		logoutBtn = new JButton("Logout");
		
		// Buttons : Bounds
		addBtn.setBounds(40, 100, mainBtnWidth, mainBtnHeight);
		editBtn.setBounds(40, 235, mainBtnWidth, mainBtnHeight);
		countBtn.setBounds(40, 370, mainBtnWidth, mainBtnHeight);
		releaseBtn.setBounds(40, 505, mainBtnWidth, mainBtnHeight);
		deleteBtn.setBounds(40, 640, mainBtnWidth, mainBtnHeight);
		saveBtn.setBounds(40, 775, mainBtnWidth, mainBtnHeight);
		viewAllBtn.setBounds(350, 450, 207, 50);
		viewReceivedBtn.setBounds(565, 450, 207, 50);
		viewReleasedBtn.setBounds(780, 450, 207, 50);
		viewFileBtn.setBounds(995, 450, 207, 50);
		
		addMovieBtn.setBounds(820, 95, 175, 50);
		editSaveBtn.setBounds(820, 95, 175, 50);
		resetBtn.setBounds(1010, 95, 175, 50);
		editCancelBtn.setBounds(1010, 95, 175, 50);
		
		loginBtn.setBounds(545, 285, 160, 40);
		logoutBtn.setBounds( 1100, 900, 160, 40);
		findMovieBtn.setBounds(545, 210, 160, 40);
		deleteDeleteBtn.setBounds(545, 210, 160, 40);
		releaseByNameBtn.setBounds(545, 210, 160, 40);
		releaseByDateBtn.setBounds(545, 340, 160, 40);
		countCountBtn.setBounds(545, 210, 160, 40);

		// Buttons : Font
		addBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		editBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		countBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		releaseBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		deleteBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		saveBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		cancelBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		viewAllBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		viewReceivedBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		viewReleasedBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		viewFileBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		addMovieBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		resetBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		findMovieBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		editSaveBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		editCancelBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		deleteBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		releaseByNameBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		releaseByDateBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		countCountBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		loginBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		logoutBtn.setFont(new Font("Serif", Font.PLAIN, 15));

		// Labels : Instances
		loginOperationLabel = new JLabel("User Login");
		addOperationLabel = new JLabel("ADD MOVIE");		
		editOperationLabel = new JLabel("EDIT MOVIE");
		countOperationLabel = new JLabel("COUNT RECEIVED MOVIES");
		releaseOperationLabel = new JLabel("RELEASE MOVIE");
		deleteOperationLabel = new JLabel("DELETE MOVIE");
		
		
		nameLabel = new JLabel("Movie Name: ");
		descriptionLabel = new JLabel("Movie Description (Select All That Apply)");
		receiveLabel = new JLabel("Receive Date: ");
		releaseLabel = new JLabel("Release Date: ");
		statusLabel = new JLabel("Movie Status: ");
		countReceiveLabel = new JLabel("Receive Date: ");
		
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		nameOfUserLabel = new JLabel("Currently not logged in.");
		
		// Label : Bounds
		loginOperationLabel.setBounds(350, 70, 300, 100);
		addOperationLabel.setBounds(350, 70, 300, 100);
		editOperationLabel.setBounds(350, 70, 300, 100);
		countOperationLabel.setBounds(350, 70, 400, 100);
		releaseOperationLabel.setBounds(350, 70, 300, 100);
		deleteOperationLabel.setBounds(350, 70, 300, 100);
		
		nameLabel.setBounds(350, 165, 110, 46);
		receiveLabel.setBounds(350, 230, 110, 46);
		releaseLabel.setBounds(350, 295, 110, 46);
		statusLabel.setBounds(350, 360, 110, 46);
		countReceiveLabel.setBounds(350, 165, 110, 46);
		descriptionLabel.setBounds(845, 155, 350, 40);
		
		usernameLabel.setBounds(350, 165, 110, 46);
		passwordLabel.setBounds(350, 230, 110, 46);
		nameOfUserLabel.setBounds(44, 900, 410, 46);
		
		// Labels : Font
		loginOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		addOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		editOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		countOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		releaseOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		deleteOperationLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		
		nameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		receiveLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		releaseLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		statusLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		countReceiveLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		usernameLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		passwordLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		nameOfUserLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 18));
		
		nameOfUserLabel.setForeground(Color.GRAY);
		
		// TextFields : Instances 
		nameField = new JTextField();
		receiveField = new JTextField();
		releaseField = new JTextField();
		countReceiveField = new JTextField();
		passwordField = new JTextField();
		
		// TextFields : Bounds
		nameField.setBounds(455, 165, 250, 40);
		receiveField.setBounds(455, 230, 250, 40);
		releaseField.setBounds(455, 295, 250, 40);	
		countReceiveField.setBounds(455, 165, 250, 40);
		passwordField.setBounds(455, 230, 250, 40);

		// CheckBoxes : Instances 
		actionCheckBox = new JCheckBox(" Action");
		adventureCheckBox = new JCheckBox(" Adventure");
		animationCheckBox = new JCheckBox(" Animation");
		comedyCheckBox = new JCheckBox(" Comedy");
		crimeCheckBox = new JCheckBox(" Crime");
		dramaCheckBox = new JCheckBox(" Drama");
		experimentCheckBox = new JCheckBox(" Expirimental");
		fantasyCheckBox = new JCheckBox(" Fantasy");
		historicalCheckBox = new JCheckBox(" Historical");
		horrorCheckBox = new JCheckBox(" Horror");
		otherCheckBox = new JCheckBox(" Other");
		romanceCheckBox = new JCheckBox(" Romance");
		scifiCheckBox = new JCheckBox(" Sci-Fi");
		thrillerCheckBox = new JCheckBox(" Thriller");
		westernCheckBox = new JCheckBox(" Western");
		
		// CheckBoxes : Bounds 
		actionCheckBox.setBounds(825, 200, 120, 20);
		adventureCheckBox.setBounds(825, 230, 120, 20);
		animationCheckBox.setBounds(825, 260, 120, 20);
		comedyCheckBox.setBounds(825, 290, 120, 20);
		crimeCheckBox.setBounds(825, 320, 120, 20);
		dramaCheckBox.setBounds(825, 350, 120, 20);
		experimentCheckBox.setBounds(945, 200, 140, 20);
		fantasyCheckBox.setBounds(945, 230, 120, 20);
		historicalCheckBox.setBounds(945, 260, 120, 20);
		horrorCheckBox.setBounds(945, 290, 120, 20);
		otherCheckBox.setBounds(945, 320, 120, 20);
		romanceCheckBox.setBounds(945, 350, 120, 20);
		scifiCheckBox.setBounds(1075, 200, 120, 20);
		thrillerCheckBox.setBounds(1075, 230, 120, 20);
		westernCheckBox.setBounds(1075, 260, 120, 20);
		
		// CheckBoxes : Font
		actionCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		adventureCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		animationCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		comedyCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		crimeCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		dramaCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		experimentCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		fantasyCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		historicalCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		horrorCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		otherCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		romanceCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		scifiCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		thrillerCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));
		westernCheckBox.setFont(new Font("Serif", Font.PLAIN, 18));		
		
		// CheckBox ArrayList
		checkBoxList = new ArrayList<>();
		checkBoxList.add(actionCheckBox);
		checkBoxList.add(adventureCheckBox);
		checkBoxList.add(animationCheckBox);
		checkBoxList.add(comedyCheckBox);
		checkBoxList.add(crimeCheckBox);
		checkBoxList.add(dramaCheckBox);
		checkBoxList.add(experimentCheckBox);
		checkBoxList.add(fantasyCheckBox);
		checkBoxList.add(historicalCheckBox);
		checkBoxList.add(horrorCheckBox);
		checkBoxList.add(otherCheckBox);
		checkBoxList.add(romanceCheckBox);
		checkBoxList.add(scifiCheckBox);
		checkBoxList.add(thrillerCheckBox);
		checkBoxList.add(westernCheckBox);
		
		// ComboBoxes : Combined
		statusChoices = new String[] { "Received", "Released" };
		statusComboBox = new JComboBox<String>(statusChoices);
		statusComboBox.setBounds(455, 360, 250, 45);

		// TextAreas : Combined
		displayArea = new JTextArea();
		displayArea.setBounds(350, 505, 850, 365);
		displayArea.setEditable(false);
		displayArea.setText("Enter login information to continue.\n");
		
		// ScrollPanes : Combined
		scrollPane = new JScrollPane(displayArea);
		scrollPane.setBounds(350, 505, 850, 365);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Adding Elements
		
		// Always Displayed
		add(addBtn);
		add(editBtn);
		add(releaseBtn);
		add(countBtn);
		add(deleteBtn);
		add(saveBtn);
		add(viewAllBtn);
		add(viewReceivedBtn);
		add(viewReleasedBtn);
		add(viewFileBtn);
		add(scrollPane);
		
		// Operation dependent displayed items
		add(loginOperationLabel);
		add(loginBtn);
		add(logoutBtn);
	    add(usernameLabel);
		add(passwordLabel);
		add(passwordField);
		add(addMovieBtn);
 		add(resetBtn);
 		add(editSaveBtn);
		add(findMovieBtn);
		add(editCancelBtn);
		add(deleteDeleteBtn);
		add(releaseByNameBtn);
		add(releaseByDateBtn);
 		add(addOperationLabel);
 		add(editOperationLabel);
 		add(releaseOperationLabel);
 		add(countOperationLabel);
 		add(deleteOperationLabel);
 		add(nameLabel);
 		add(descriptionLabel);
 		add(receiveLabel);
 		add(releaseLabel);
 		add(statusLabel);
 		add(nameField);
 		add(receiveField);
 		add(releaseField);
 		add(statusComboBox);
 		add(actionCheckBox);
 		add(adventureCheckBox);
 		add(animationCheckBox);
 		add(comedyCheckBox);
 		add(crimeCheckBox);
 		add(dramaCheckBox);
 		add(experimentCheckBox);
 		add(fantasyCheckBox);
 		add(historicalCheckBox);
 		add(horrorCheckBox);
 		add(otherCheckBox);
 		add(romanceCheckBox);
 		add(scifiCheckBox);
 		add(thrillerCheckBox);
 		add(westernCheckBox);
 		add(countReceiveField);
 		add(countReceiveLabel);
 		add(countCountBtn);
 		
 		add(nameOfUserLabel);
 		
 		
 		// Hide all operation displays at start.
 		hideAddArea();
 		hideEditArea();
 		hideReleaseArea();
 		hideCountArea();
 		hideDeleteArea();
 		
 		// Show login area at start
 		showLoginArea();
 		disableMainBtns();
		
		// Frame settings
		setLocationRelativeTo(null);
		setSize(frameWidth, frameHeight);
		setResizable(false);
		setLayout(null);
		setTitle(TITLE);
		setBackground(bgColor);
		setVisible(true);
		
		// Event listeners
		
		// Login Btn 
		loginBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		         removeMessageIfExists();
		         String loginResult = "";
				 try {
				     loginResult = attemptLogin(nameField.getText().trim(), passwordField.getText().trim());
				 } catch (IOException e1) {
					 displayArea.setText("Error: Cannot complete login at this time.\n" +
							 "Login data file cannot be found.");
				 }
				 if (!messageExists()) {
		        	 if (loginResult.equals("success")) {
		        		 hideLoginArea();
		        		 enableMainBtns();
		        		 removeMessageIfExists();
		        		 nameOfUserLabel.setText(userName);
		        	 } else {
		        		 displayArea.setText("Error: Login Failed.\n");
		        		 if (loginResult.equals("invalid username")) {
		        			 displayArea.setText(displayArea.getText() + "Invalid Username: User not found.");
		        		 } else {
		        			 displayArea.setText(displayArea.getText() + "Invalid Password: Password does not match our records.");
		        		 }
		        		 
		        	 }
				 }
	          }
	     });
		
		logoutBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		         removeMessageIfExists();
	        	 showLoginArea();
	          }
	     });
		
		// Add Operation Btn (On Left)
		addBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		         removeMessageIfExists();
	        	 showAddArea();
	          }
	     });
		
		// Edit Operation Btn (On Left)
		editBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		        removeMessageIfExists();
	        	 showEditArea();
	          }
	     });
		
		// Release Operation Btn (On Left)
		releaseBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		        removeMessageIfExists();
	        	 showReleaseArea();
	          }
	     });
		
		// Count Operation Btn (On Left)
		countBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		        removeMessageIfExists();
	        	 showCountArea();
	          }
	     });
		
		// Delete Operation Btn (On Left)
		deleteBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		        removeMessageIfExists();
	        	 showDeleteArea();
	          }
	     });
		
		// Save Operation Btn (On Left)
		saveBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	try {
					saveChangesToFile(movieList);
					displayArea.setText("System has been updated successfully.");
				} catch (IOException e1) {
					displayArea.setText("Error: Save unsuccessful. Non-existent data file.");
					e1.printStackTrace();
				}
	          }
	     });
		
		viewAllBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayArea.setText(movieList.displayAll());
	          }
	     });
		
		viewReceivedBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayArea.setText(movieList.displayReceivedMovies());
	          }
	     });
		
		viewReleasedBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayArea.setText(movieList.displayReleasedMovies());
	          }
	     });
		
		viewFileBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayArea.setText(movieList.toString());
	          }
	     });
		
		addMovieBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	removeMessageIfExists();
	        	String movieName = getMovieName();
	        	Date releaseDate = getDate(releaseField, null);
	        	String description = formatDescription(getDescription());
	        	Date receiveDate = getDate(receiveField, releaseDate);
	        	MovieStatus status = convertStatus((String) statusComboBox.getSelectedItem());
	        	
	        	if (!messageExists()) {
	        		if (status == MovieStatus.RECEIVED) {
	        			if (movieList.addToReceivedList(new Movie(movieName,releaseDate,description,receiveDate,status))) {
	        				displayArea.setText("Success: " + movieName + " added successfully.");
	        			} else {
	        				displayArea.setText("Error: " + movieName + " already exists in the system.");
	        			}
	        		} else {
	        			if (movieList.addToReleasedList(new Movie(movieName,releaseDate,description,receiveDate,status))) {
	        				displayArea.setText("Success: " + movieName + " has been successfully added to the system.");
	        			} else {
	        				displayArea.setText("Error: " + movieName + " already exists in the system.");
	        			}
	        		}
	        		
	        		resetAddOperationElements();
	        	}
	         }
	     });
		
		resetBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	resetAddOperationElements();
	        	removeMessageIfExists();
	          }
	     });
		
		findMovieBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	removeMessageIfExists();
	        	savedName = getMovieName();
	        	
        		if (!messageExists()) {
        			getMovieInfo(savedName);
        		}

	        	if (!messageExists()) {
	        		findMovieBtn.setVisible(false);
	        		showAllEditableAreas();
	        		editSaveBtn.setVisible(true);
	        		editCancelBtn.setVisible(true);
	        	}
	        	
	          }
	     });
		
		editSaveBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	removeMessageIfExists();
	        	String movieName = getMovieName();
	        	Date releaseDate = getDate(releaseField, null);
	        	String description = formatDescription(getDescription());
	        	Date receiveDate = getDate(receiveField, releaseDate);
	        	MovieStatus status = convertStatus((String) statusComboBox.getSelectedItem());
	        	
	        	if (!messageExists()) {
	        		movieList.deleteMovie(savedName);
	        		if (status == MovieStatus.RECEIVED) {
	        			movieList.addToReceivedList(new Movie(movieName,releaseDate,description,receiveDate,status));
	        		} else {
	        			movieList.addToReleasedList(new Movie(movieName,releaseDate,description,receiveDate,status));
	        		}
	        		displayArea.setText("Success: " + movieName + " edited successfully.\n\n* To permenantely save changes click the save button on the left.");
	        		hideEditArea();
	        		showEditArea();
	        	}
	         }
	     });
		
		
		editCancelBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 removeMessageIfExists();
	        	 hideEditArea();
	        	 showEditArea();	        	 
	          }
	     });
		
		releaseByNameBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 removeMessageIfExists();
	        	 savedName = getMovieName();
	        	 
	        	 if (!messageExists()) {
		        	 String result = movieList.releaseMovie(savedName, null, "name");
		        	 
		        	 if (result.equals("no movie error")) {
		        		 displayArea.setText("Error: " + savedName + " does not exist in the system's received movies list.");
		        	 } else if (result.equals("receive date error")){
		        		 displayArea.setText("Error: " + savedName + " has not been received yet and therefore cannot be released");
		        	 } else if (result.equals("success")){
		        		 displayArea.setText("Success: " + savedName + " started showing successfully.");
		        	 }
	        	 }
	        	 
	        	 nameField.setText(null);
	        	 releaseField.setText(null);        	 
	          }
	     });
		
		releaseByDateBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 removeMessageIfExists();
	        	 Date date = getDate(releaseField, null);
	        	 
	        	 if (!messageExists()) {
	        		 displayArea.setText(null);
		        	 String result = movieList.releaseMovie(null, date, "date");
		        	 
		        	 if (result.equals("no movie error")) {
		        		 displayArea.setText("Error: No movies with that date exists in the system's received movies list.");
		        	 } else {
		        		 displayArea.setText("Success: \n" + result + "\nAll movies with that release date have been successfully released" 
		        				 + " on today's date.");
		        	 }
	        	 }
	        	 
	        	 nameField.setText(null);
	        	 releaseField.setText(null); 	 
	          }
	     });
		
		countCountBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 removeMessageIfExists();
	        	 Date date = getDate(countReceiveField, null);
	        	 int count = -1;
	        	 
	        	 if (!messageExists()) {
	        		 count = movieList.countReceivedMovies(date);
	        		 displayArea.setText("Success: " + count + " movies have been received before " + countReceiveField.getText() + " that are still yet to be released.");
	        	 }
	        
	        	 countReceiveField.setText(null);
	          }
	     });
		
		
		deleteDeleteBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 removeMessageIfExists();
	        	 String movieName = getMovieName();
	        	 if (!messageExists()) {
	        		 if (movieList.deleteMovie(movieName)) {
	        			 displayArea.setText("Success: " + movieName + " was successfully deleted from the system.");
	        		 } else {
	        			 displayArea.setText("Error: " + movieName + " cannot be deleted because it does not exist in the system.");
	        		 }
	        	 }
	          }
	     });
				
		// Window closed
		addWindowListener(
	            new WindowAdapter() {
	                public void windowClosing(
	                    WindowEvent we)
	                {
	                    System.exit(0);
	                }
	    });
				
	}
	
	private void showAllEditableAreas() {
		actionCheckBox.setVisible(true);
		adventureCheckBox.setVisible(true);
		animationCheckBox.setVisible(true);
		comedyCheckBox.setVisible(true);
		crimeCheckBox.setVisible(true);
		dramaCheckBox.setVisible(true);
		experimentCheckBox.setVisible(true);
		fantasyCheckBox.setVisible(true);
		historicalCheckBox.setVisible(true);
		horrorCheckBox.setVisible(true);
		otherCheckBox.setVisible(true);
		romanceCheckBox.setVisible(true);
		scifiCheckBox.setVisible(true);
		thrillerCheckBox.setVisible(true);
		westernCheckBox.setVisible(true);
		
		nameField.setVisible(true);
		receiveField.setVisible(true);
		releaseField.setVisible(true);	
		
		nameLabel.setVisible(true);
		descriptionLabel.setVisible(true);
		receiveLabel.setVisible(true);
		releaseLabel.setVisible(true);
		statusLabel.setVisible(true);
		
		statusComboBox.setVisible(true);
	}
	
	private void hideAllEditableAreas() {
		actionCheckBox.setVisible(false);
		adventureCheckBox.setVisible(false);
		animationCheckBox.setVisible(false);
		comedyCheckBox.setVisible(false);
		crimeCheckBox.setVisible(false);
		dramaCheckBox.setVisible(false);
		experimentCheckBox.setVisible(false);
		fantasyCheckBox.setVisible(false);
		historicalCheckBox.setVisible(false);
		horrorCheckBox.setVisible(false);
		otherCheckBox.setVisible(false);
		romanceCheckBox.setVisible(false);
		scifiCheckBox.setVisible(false);
		thrillerCheckBox.setVisible(false);
		westernCheckBox.setVisible(false);
		statusComboBox.setVisible(false);
		nameField.setVisible(false);
		receiveField.setVisible(false);
		releaseField.setVisible(false);	
		nameLabel.setVisible(false);
		descriptionLabel.setVisible(false);
		receiveLabel.setVisible(false);
		releaseLabel.setVisible(false);
		statusLabel.setVisible(false);
		statusComboBox.setVisible(false);
		nameField.setText(null);
		receiveField.setText(null);
		releaseField.setText(null);
		
		statusComboBox.setSelectedIndex(0);
	}
	
	private void disableMainBtns() {
		addBtn.setEnabled(false);
		editBtn.setEnabled(false);
		countBtn.setEnabled(false);
		releaseBtn.setEnabled(false);
		deleteBtn.setEnabled(false);
		saveBtn.setEnabled(false);
	}
	
	private void enableMainBtns() {
		addBtn.setEnabled(true);
		editBtn.setEnabled(true);
		countBtn.setEnabled(true);
		releaseBtn.setEnabled(true);
		deleteBtn.setEnabled(true);
		saveBtn.setEnabled(true);
	}
	
	private void resetLoginArea() {
		nameField.setText(null);
		passwordField.setText(null);
	}
	
	private void showLoginArea() {
		
		hideAddArea();
		hideEditArea();
		hideCountArea();
		hideReleaseArea();
		hideDeleteArea();
		
		resetLoginArea();
		disableMainBtns();
		
		usernameLabel.setVisible(true);
		nameField.setVisible(true);
		passwordLabel.setVisible(true);
		passwordField.setVisible(true);
		loginBtn.setVisible(true);
		loginOperationLabel.setVisible(true);
		
		logoutBtn.setVisible(false);
		
		nameOfUserLabel.setText("Currently not logged in.");
		
	}
	
	private void showAddArea() {
		resetAddOperationElements();
		hideEditArea();
		hideCountArea();
		hideReleaseArea();
		hideDeleteArea();
		
		addBtn.setEnabled(false);
		
		addOperationLabel.setVisible(true);
		
		showAllEditableAreas();
		
		addMovieBtn.setVisible(true);
		resetBtn.setVisible(true);
	}
	
	private void showEditArea() {
		editBtn.setEnabled(false);
		editOperationLabel.setVisible(true);

		hideAddArea();
		hideCountArea();
		hideReleaseArea();
		hideDeleteArea();
		
		nameLabel.setVisible(true);
		nameField.setVisible(true);
		
		findMovieBtn.setVisible(true);
	}
	
	private void showCountArea() {
		countBtn.setEnabled(false);
		
		hideAddArea();
		hideEditArea();
		hideReleaseArea();
		hideDeleteArea();
		
		countOperationLabel.setVisible(true);

		countReceiveLabel.setVisible(true);
		countReceiveField.setVisible(true);
		countCountBtn.setVisible(true);
		
	}
	
	private void showReleaseArea() {
		releaseBtn.setEnabled(false);
		
		releaseOperationLabel.setVisible(true);
		
		hideAddArea();
		hideEditArea();
		hideCountArea();
		hideDeleteArea();
		
		nameLabel.setVisible(true);
		releaseLabel.setVisible(true);
		
		nameField.setVisible(true);
		releaseField.setVisible(true);
		
		releaseByNameBtn.setVisible(true);
		releaseByDateBtn.setVisible(true);
	}
	
	private void showDeleteArea() {
		deleteBtn.setEnabled(false);
		
		hideAddArea();
		hideEditArea();
		hideCountArea();
		hideReleaseArea();
		
		deleteOperationLabel.setVisible(true);
		nameLabel.setVisible(true);
		nameField.setVisible(true);
		
		deleteDeleteBtn.setVisible(true);
	}
	
	private void hideLoginArea() {
		loginOperationLabel.setVisible(false);
		usernameLabel.setVisible(false);
		nameField.setVisible(false);
		passwordLabel.setVisible(false);
		passwordField.setVisible(false);
		loginBtn.setVisible(false);
		logoutBtn.setVisible(true);
	}
	
	private void hideAddArea() {
		addBtn.setEnabled(true);
		addOperationLabel.setVisible(false);
		
		
		addMovieBtn.setVisible(false);
		resetBtn.setVisible(false);
		
		actionCheckBox.setSelected(false);
		adventureCheckBox.setSelected(false);
		animationCheckBox.setSelected(false);
		comedyCheckBox.setSelected(false);
		crimeCheckBox.setSelected(false);
		dramaCheckBox.setSelected(false);
		experimentCheckBox.setSelected(false);
		fantasyCheckBox.setSelected(false);
		historicalCheckBox.setSelected(false);
		horrorCheckBox.setSelected(false);
		otherCheckBox.setSelected(false);
		romanceCheckBox.setSelected(false);
		scifiCheckBox.setSelected(false);
		thrillerCheckBox.setSelected(false);
		westernCheckBox.setSelected(false);
		
		hideAllEditableAreas();
	}
	
	private void hideEditArea() {
		editBtn.setEnabled(true);
		
		editOperationLabel.setVisible(false);
		findMovieBtn.setVisible(false);
		editSaveBtn.setVisible(false);
		editCancelBtn.setVisible(false);

		hideAllEditableAreas();
	}
	
	private void hideCountArea() {
		countBtn.setEnabled(true);
		
		countOperationLabel.setVisible(false);
		
		countReceiveLabel.setVisible(false);
		countReceiveField.setVisible(false);
		
		countCountBtn.setVisible(false);
	}
	
	private void hideReleaseArea() {
		releaseBtn.setEnabled(true);
		
		releaseOperationLabel.setVisible(false);
		
		nameLabel.setVisible(false);
		releaseLabel.setVisible(false);
		
		nameField.setVisible(false);
		releaseField.setVisible(false);
		
		releaseByNameBtn.setVisible(false);
		releaseByDateBtn.setVisible(false);
	}

	private void hideDeleteArea() {
		deleteBtn.setEnabled(true);
		deleteOperationLabel.setVisible(false);
		deleteDeleteBtn.setVisible(false);
	}
	
	private String getMovieName() {
		String movieName = "";
		
		String input = nameField.getText().trim();
		if (input.length() > 0) {
			// Capitalize the first letter of each word in the movie name and lower all subsequent letters.
			String[] inputArr = input.split(" ");
			for (int i = 0; i < inputArr.length; i++) {
				inputArr[i] = inputArr[i].substring(0, 1).toUpperCase() + inputArr[i].substring(1).toLowerCase();
			}
			movieName = String.join(" ", inputArr);
		} else {
			displayArea.setText("Error: You must enter a movie name to continue.");
		}
		
		return movieName;
	}
	
	private Date convertDate(String date) {
		// Create a null Date
		Date result = null;

		// Date cannot be expected format if argument length is not 10 (e.g.
		// 01/02/2022).
		if (date.length() != 10) {
			if (messageExists()) {
				String message = displayArea.getText();
				displayArea.setText(message + "\nError: Date entered was invalid or non-existent.");
			} else {
				displayArea.setText("Error: Date entered was invalid or non-existent.");
			}
			// Notify user input String entered was not in the valid/acceptable format.
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
			if (messageExists()) {
				String message = displayArea.getText();
				displayArea.setText(message + "\nError: Date entered was invalid.");
			} else {
				displayArea.setText("Error: Date entered was invalid.");
			}
		}
		// Return the Date
		return result;
	}
	
	
	private Date getDate(JTextField field, Date releaseDate) {
		Date date = null;
		String input = "";
		
		input = field.getText().trim();
		
		// Convert to Date from user input String.
		date = convertDate(input);
		
		if (date != null && releaseDate != null) {
			if (date.compareTo(releaseDate) >= 0) {
				if (messageExists()) {
					String message = displayArea.getText();
					displayArea.setText(message + "\nError: Receive date must be before release date.");
				} else {
					displayArea.setText("Error: Receive date must be before release date.");
				}
				date = null;
			}
		}
		return date;
	}
	
	/**
	 * Checks selected description options and returns options as a String. Displays an error message
	 * if no options have been checked.
	 * @return: the selected description options checked as a single string value. 
	 */
	private String getDescription() {
		
		StringBuilder sb = new StringBuilder();
		boolean selected = false;
		for (JCheckBox box : checkBoxList) {
			if (box.isSelected()) {
				// Remove from space and add a back space needed for formatting
				// later.
				sb.append(box.getText().trim() + " ");
				if (selected == false) selected = true;
			}
		}
		if (selected == false) {
			if (messageExists()) {
				String message = displayArea.getText();
				displayArea.setText(message + "\nError: No description has been selected.");
			} else {
				displayArea.setText("Error: No description has been selected.");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * Converts argument String to MovieStatus
	 * @param status: String to be converted to MovieStatus
	 * @return MovieStatus
	 */
	private MovieStatus convertStatus(String status) {
		// Set status depending on argument String
		if (status.equalsIgnoreCase("RECEIVED")) {
			return MovieStatus.RECEIVED;
		} else {
			return MovieStatus.RELEASED;
		}
	}
	
	/**
	 * Formats and returns the selected description in the desired format.
	 * @param description: the description option as an unformatted String.
	 * @return: the formated description String.
	 */
	private String formatDescription(String description) {
		
		if (description.equals("")) {
			return "";
		}
		
		String[] arr = description.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			result.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase());
			if (i != arr.length - 1) {
				result.append("/");
			}
		}
		return result.toString();
	}
	
	/** If the parameter movie exists in one of the movie lists, all of the edit fields will be
	 * set to the movie's values currently stored, otherwise an error message will be shown in 
	 * the display area.
	 * @param movieName: the name of the movie whose value are to be retrieved.
	 */
	private void getMovieInfo(String movieName) {
		String info = movieList.getMovieInfo(movieName);
		
		if (info == null) {
			displayArea.setText("Error: The requested movie does not exist in the system");
			return;
		} 
		
		String[] infoList = info.split(", ");
		
		nameField.setText(infoList[0]);
		releaseField.setText(infoList[1]);
		receiveField.setText(infoList[3]);
		statusComboBox.setSelectedItem(infoList[4]);
		
		String[] descriptionList = infoList[2].split("/");
		
		for (String genre : descriptionList) {
			for (JCheckBox box : checkBoxList) {
				if (box.getText().trim().equals(genre)) {
					box.setSelected(true);
				}
			}
		}
		
	}
	
	/** Resets all fields and checkboxes for the add movie operation display */
	private void resetAddOperationElements() {
		nameField.setText(null);
		receiveField.setText(null);
		releaseField.setText(null);
		
		statusComboBox.setSelectedIndex(0);
		
		actionCheckBox.setSelected(false);
		adventureCheckBox.setSelected(false);
		animationCheckBox.setSelected(false);
		comedyCheckBox.setSelected(false);
		crimeCheckBox.setSelected(false);
		dramaCheckBox.setSelected(false);
		experimentCheckBox.setSelected(false);
		fantasyCheckBox.setSelected(false);
		historicalCheckBox.setSelected(false);
		horrorCheckBox.setSelected(false);
		otherCheckBox.setSelected(false);
		romanceCheckBox.setSelected(false);
		scifiCheckBox.setSelected(false);
		thrillerCheckBox.setSelected(false);
		westernCheckBox.setSelected(false);
				
	}
	
	/**
	 * Checks if an error or success message exists in the display area.
	 * @return: {true} if a message exists; {false} otherwise.
	 */
	private boolean messageExists() {
		if (displayArea.getText().equals("")) {
			return false;
		}
		char c = displayArea.getText().charAt(0);
		if (c == 'E' || c == 'S') {
			return true;
		} else {
			return false;
		}
	}
	
	/** Removes an error or success message from the display area if one exist. */
	private void removeMessageIfExists() {
		if (messageExists()) {
			displayArea.setText(null);
		}
	}
	
	/**
	 * Saves all changes made by user to the movies.txt file.
	 * @throws IOException
	 */
	private void saveChangesToFile(MovieList list) throws IOException {
		// Open output streams.
		FileOutputStream fout = new FileOutputStream("movies.txt");
		PrintWriter writer = new PrintWriter(fout);

		// Print the movie lists in their current state to the output file.
		writer.write(list.toString());

		// Close open streams.
		writer.close();
		fout.close();
	}
	
	private String attemptLogin(String username, String password) throws IOException {
		FileInputStream fin = new FileInputStream("users.txt");
		Scanner scanner = new Scanner(fin);
		String result = "";
		
		while (scanner.hasNext()) {
			String[] userInfo = scanner.nextLine().split("/");
			
			if (username.equals(userInfo[0].trim()) && password.equals(userInfo[1].trim())) {
				result = "success";
				user = username;
				userType = userInfo[2];
				userName = "Currently logged in as " + userInfo[3];
				return result;
			} else if (username.equals(userInfo[0])) {
				result = "invalid password"; 
				return result;
			} else {
				result = "invalid username";
			}
		}
		
		scanner.close();
		fin.close();
		
		return result;
	}
	
	
}

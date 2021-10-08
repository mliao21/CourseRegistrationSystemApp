package courseRegView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CourseRegGUI extends JFrame {
	
	private String studentName;
	private int studentId;
	private JButton searchCourse = new JButton ("Search catalogue courses");
	private JButton addCourse = new JButton ("Add course to student courses");
	private JButton removeCourse = new JButton ("Remove course from student courses");
	private JButton viewCourseCat = new JButton ("View all courses in catalogue");
	private JButton viewRegCourse = new JButton ("View all courses taken by student");
	private JButton quit = new JButton ("Quit");
	
	public CourseRegGUI() {
		
		// Prompts user to enter their student name and id
		JFrame studentInput = new JFrame(); 
	    studentName = JOptionPane.showInputDialog(studentInput,"Enter Student Name");
	    studentId = Integer.parseInt(JOptionPane.showInputDialog(studentInput,"Enter Student ID"));
		
	    // A menu screen is created and prompts user to choose an option
		JPanel prompt = new JPanel();
		prompt.add(new JLabel("Please choose any of the following options:"));
		
		// Add options to the panel
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(0, 2));
		menu.add(searchCourse);
		menu.add(addCourse);
		menu.add(viewRegCourse);
		menu.add(removeCourse);
		menu.add(viewCourseCat);
		menu.add(quit);
		
		// Layout of each panel in the screen
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add("North", prompt);
		contentPane.add("Center", menu);
		
		setTitle("Registration System");
		setSize(600, 300);
		setResizable(false); //can't change the size of the screen
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	// Executes function of the option accordingly
	public void addActionListener(ActionListener listenForButton) {		
		searchCourse.addActionListener(listenForButton);
		addCourse.addActionListener(listenForButton);
		viewRegCourse.addActionListener(listenForButton);
		removeCourse.addActionListener(listenForButton);
		viewCourseCat.addActionListener(listenForButton);
		quit.addActionListener(listenForButton);
	}
	
	// Displays information in new window
	public void displayInfoWindow(String title, String show) {
		// Sets layout of the new window
		JFrame displayInfo = new JFrame();
		displayInfo.setTitle(title);
		displayInfo.setSize(400, 400);
		displayInfo.setVisible(true);
		displayInfo.setLocationRelativeTo(null); 
		
		// Adds information to the screen
		JTextArea display = new JTextArea(21, 40);
		display.append(show);
		
		JPanel info = new JPanel();
		info.setLayout(new GridLayout(0, 1));
		info.add(display);
		displayInfo.add(info);
	}
	
	public String getStudentName() {
		return studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public JButton getSearchCourse() {
		return searchCourse;
	}

	public JButton getAddCourse() {
		return addCourse;
	}

	public JButton getRemoveCourse() {
		return removeCourse;
	}

	public JButton getViewCourseCat() {
		return viewCourseCat;
	}

	public JButton getViewRegCourse() {
		return viewRegCourse;
	}

	public JButton getQuit() {
		return quit;
	}

}

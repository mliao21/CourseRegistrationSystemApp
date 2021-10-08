package courseRegModel;

import java.util.ArrayList;

public class CourseCatalogue {
	
	private ArrayList<Course> courseList;
	
	public CourseCatalogue() {
		courseList = loadFromDB();
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	@Override
	public String toString() {
		String list = "";
		for (Course c: courseList) {
			list += c + "\n";
		}
		return list;
	}
	
	// Just search if course is in catalogue database (no details included)
	public Course searchCat(String courseName, int courseNum) {
		for (Course c: courseList) {
			if (c.getCourseName().compareToIgnoreCase(courseName) == 0 && c.getCourseNum() == courseNum) {
				return c;
			}
		}
		return null;
	}
	
	// Search for course information detail in catalogue database.
	public String searchCatDetail(String courseName, int courseNum) {
		Course myCourse = null;
		for (Course c: courseList) {
			if (c.getCourseName().compareToIgnoreCase(courseName) == 0 && c.getCourseNum() == courseNum) {
				myCourse = c;
			}
		}
		String temp = "";
		if (myCourse != null) {
			temp += "\n" + myCourse + myCourse.listPreq() + " " + myCourse.listOffering() + "\n";
		}
		else {
			temp += "\nCourse not found in catalogue.";
		}
		return temp;
	}
	
	private static ArrayList<Course> loadFromDB() {
		// Since code is not tied into a database, an imaginary database is created
		// in the back end to fulfill the requirements of the lab exercise.
		
		ArrayList<Course> imaginaryDB = new ArrayList<Course>();
		
		imaginaryDB.add(new Course("ENGG", 687));
		imaginaryDB.add(new Course("ENSF", 607));
		imaginaryDB.add(new Course("ENSF", 608));
		imaginaryDB.add(new Course("ENSF", 611));
		imaginaryDB.add(new Course("ENSF", 612));
		imaginaryDB.add(new Course("ENSF", 614));
		
		for (Course c: imaginaryDB) {
			c.addPreq(new Course("ENSF", 592));
			c.addPreq(new Course("ENSF", 593));
			c.addPreq(new Course("ENSF", 594));
		}
				
		for (Course c: imaginaryDB) {
			c.addOffering(new CourseOffering(c, 1, 90));
			c.addOffering(new CourseOffering(c, 2, 50));
			c.addOffering(new CourseOffering(c, 3, 20));
		}
		
		return imaginaryDB;
	}

}

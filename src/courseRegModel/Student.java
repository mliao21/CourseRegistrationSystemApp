package courseRegModel;

import java.util.ArrayList;

public class Student {
	
	private String studentName;
	private int studentId;
	private ArrayList<Registration> courseList;
	
	public Student(String studentName, int studentId) {
		this.setStudentName(studentName);
		this.setStudentId(studentId);
		courseList = new ArrayList<Registration>();
	}
	
	public String registerCourse(CourseCatalogue cat, String courseName, int courseNum, int section) {
		// When student registers a course, it needs to verify if it is available
		// in the catalogue and matches with any offering
		String message = "";
		Course myCourse = cat.searchCat(courseName, courseNum);
		if (myCourse == null) {
			message += "\nInvalid course number. Please try again!";
		}
		else if (myCourse != null && myCourse.searchOffering(section) == null) {
			message += "\nInvalid section number. Please try again!";
		}
		// If course offering is available, then it needs to verify if there are any
		// already registered in the student's course list to prevent duplicates
		else {
			if (verifyDuplicateReg(courseName, courseNum, section) == true) {
				// Students cannot register more than 6 courses at a time (per semester)
				if (courseList.size() < 6) {
					CourseOffering myOffering = myCourse.searchOffering(section);
					Registration reg = new Registration();
					reg.register(this, myOffering);
					message += "\nYou have successfully added course " + myCourse + " Section " + section;
					// Course offering can only run if at least has 8 students are registered in it. Here needs 
					// to elaborate more functions to allow offering to run but it is out of scope for this lab
					if (myOffering.getStudentList().size() < 8) {
						message += "\nBut it still needs more students to run the course...";
					}
				}
				else {
					message += "\nYou have exceeded the limit to register courses! You can only register maximum 6 courses.";
				}
			}
			else {
				message += "\nCourse offering is already in your course list!";
			}
		}
		return message;
	}
	
	// Verifies for any duplicate course offering registration
	public boolean verifyDuplicateReg(String courseName, int courseNum, int section) {
		boolean unique = true;
		for (Registration u: courseList) {
			if (u.getTheCourseName().compareToIgnoreCase(courseName) == 0 && 
				u.getTheCourseNum() == courseNum && u.getTheSectionNum() == section) {
				unique = false;
				break;
			}
			else {
				unique = true;
			}
		}
		return unique;
	}
	
	public String removeCourse(String courseName, int courseNum, int section) {
		// When student wants to remove a course from its registered list, it
		// needs to verify if course entered contains in the list
		String message = "";
		ArrayList<Registration> removedCourseList = new ArrayList<>();
		for (Registration reg: courseList) {
			if (reg.getTheCourseName().compareToIgnoreCase(courseName) == 0 && 
				reg.getTheCourseNum() == courseNum && reg.getTheSectionNum() == section) {				
				removedCourseList.add(reg);
			}
		}
		if (removedCourseList.size() == 0) {
			message += "\nCourse is not registered in your course list.";
		}
		else {
			for (Registration del: removedCourseList) {
				message += 	"\nYou have successfully removed course " + del.getTheCourse() + 
							" Section " + del.getTheSectionNum() + " from your course list!";
				del.unregister(del.getTheStudent(), del.getTheOffering());
			}
		}
		return message;
	}
	
	public void addRegistration(Registration reg) {
		courseList.add(reg);
	}
	
	public void removeRegistration(Registration reg) {
		courseList.remove(reg);
	}
	
	// Prints out all courses registered by student	
	public String courseListStatus() {
		String temp = "Number of courses registered: " + courseList.size() + "\n\n";
		if (courseList.size() != 0) {
			temp += listCourses();
		}
		else {
			temp += "There are no courses registered.";
		}
		return temp;
	}
	
	public String listCourses() {
		String temp = "";
		for (Registration reg: courseList) {
			temp += reg.getTheCourse() + " " +
					reg.getTheOffering().toString() + 
					reg.getTheCourse().listPreq() + "\n\n";
		}
		return temp;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList<String> getCourseList() {
		ArrayList<String> courses = new ArrayList<String>();
		for (Registration reg: courseList) {
			courses.add(reg.getTheCourse() + " " + reg.getTheOffering().toString());
		}
		return courses;
	}

	public void setCourseList(ArrayList<Registration> courseList) {
		this.courseList = courseList;
	}
	
}

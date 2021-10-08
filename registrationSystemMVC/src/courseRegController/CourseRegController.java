package courseRegController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import courseRegModel.*;
import courseRegView.CourseRegGUI;

public class CourseRegController {
	
	Course theCourse;
	CourseCatalogue theCourseCat;
	CourseOffering theOffering;
	Registration theReg;
	Student theStudent;
	CourseRegGUI theView;
	
	public CourseRegController(CourseRegGUI theView, CourseCatalogue theCourseCat) {
		this.theView = theView;
		this.theCourseCat = theCourseCat;
		this.theStudent = new Student(theView.getStudentName(), theView.getStudentId());
		theView.addActionListener(new RegistrationListener());
	}
	
	class RegistrationListener implements ActionListener {

		@Override		
		public void actionPerformed(ActionEvent e) {
			
			// Prompts user to choose a course from dropdown list to search for details of the course
			if (e.getSource() == theView.getSearchCourse()) {
				
				// List of courses to populate in dropdown function
				Object[] courses = theCourseCat.getCourseList().toArray();
				Object o = 	JOptionPane.showInputDialog(null, "Select a course from dropdown list:", 
							"Search Course Catalogue", JOptionPane.QUESTION_MESSAGE, null, courses, null);
				String myCourse = o.toString();
			    String courseName = myCourse.substring(0, 4);
				int courseNum = Integer.parseInt(myCourse.substring(5, 8));
				
				// Chosen course is then searched in catalogue and displayed in new window
				theView.displayInfoWindow("Course Catalogue", theCourseCat.searchCatDetail(courseName, courseNum));
			}
			
			// Prompts user to choose a course from catalogue in dropdown
			if (e.getSource() == theView.getAddCourse()) {
				
				// List of courses to populate in dropdown function
				Object[] courses = theCourseCat.getCourseList().toArray();
				Object o1 = JOptionPane.showInputDialog(null, "Select a course from dropdown list:", 
							"Add course registration", JOptionPane.QUESTION_MESSAGE, null, courses, null);
				String myCourse = o1.toString();
			    String courseName = myCourse.substring(0, 4);
			    int courseNum = Integer.parseInt(myCourse.substring(5, 8));
			    
			    // Student have to choose a section from the course they want to enroll in
			    Object[] sections = theCourseCat.searchCat(courseName, courseNum).getSections().toArray();
				Object o2 = JOptionPane.showInputDialog(null, "Select an offering from course:", 
							"Add course registration", JOptionPane.QUESTION_MESSAGE, null, sections, null);
				int sectionNum = (int) o2;
				
				// Chosen course is added to student's course list
				String result = theStudent.registerCourse(theCourseCat, courseName, courseNum, sectionNum);
				JOptionPane.showMessageDialog(null, result);
			}
			
			// Prompts user to choose a course from their student's course list in dropdown
			if (e.getSource() == theView.getRemoveCourse()) {
				
				// Student's course list is populated in dropdown function
				Object[] studentCourses = theStudent.getCourseList().toArray();
				Object o1 = JOptionPane.showInputDialog(null, "Select a course from dropdown list:", 
							"Remove course registration", JOptionPane.QUESTION_MESSAGE, null, studentCourses, null);
				
				// Breaks down chosen information into course name, course number and section number
				String myCourse = o1.toString();
			    String courseName = myCourse.substring(0, 4);
			    int courseNum = Integer.parseInt(myCourse.substring(5, 8));
				int sectionNum = Integer.parseInt(myCourse.substring(17, 18));
				
				// Chosen course is removed from student's course list
				String result = theStudent.removeCourse(courseName, courseNum, sectionNum);
				JOptionPane.showMessageDialog(null, result);
			}
			
			if (e.getSource() == theView.getViewRegCourse()) {
				theView.displayInfoWindow("Student Registered Course List", theStudent.courseListStatus());
			}
			
			if (e.getSource() == theView.getViewCourseCat()) {
				theView.displayInfoWindow("Course Catalogue", theCourseCat.toString());
			}
			
			if (e.getSource() == theView.getQuit()) {
				theView.dispose();
				System.exit(0);
			}
		}
	}

}

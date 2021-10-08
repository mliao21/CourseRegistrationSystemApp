package courseRegModel;

import java.util.ArrayList;

public class CourseOffering {
	
	private int sectionNum;
	private int sectionCap;
	private Course theCourse;
	private ArrayList<Registration> studentList;
	
	public CourseOffering(Course theCourse, int sectionNum, int sectionCap) {
		this.setTheCourse(theCourse);
		this.setSectionNum(sectionNum);
		this.setSectionCap(sectionCap);
		studentList = new ArrayList<Registration>();
	}
	
	// Adds students who are registered to the course offering
	public void addRegistration(Registration reg) {
		studentList.add(reg);
	}
	
	// Removes students who unregistered from the course offering
	public void removeRegistration(Registration reg) {
		studentList.remove(reg);
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public Course getTheCourse() {
		return theCourse;
	}

	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	
	public String getTheCourseName() {
		return theCourse.getCourseName();
	}
	
	public int getTheCourseNum() {
		return theCourse.getCourseNum();
	}

	public ArrayList<Registration> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Registration> studentList) {
		this.studentList = studentList;
	}
	
	@Override
	public String toString() {
		return "Section " + sectionNum + ", Capacity: "+ sectionCap;
	}
	

}

package courseRegModel;

import java.util.ArrayList;

public class Course {
	
	private String courseName;
	private int courseNum;
	private ArrayList<Course> coursePreq;
	private ArrayList<CourseOffering> offeringList;
	
	public Course(String courseName, int courseNum) {
		this.setCourseName(courseName);
		this.setCourseNum(courseNum);
		coursePreq = new ArrayList<Course>();
		offeringList = new ArrayList<CourseOffering>();
	}
	
	// adds list of prerequisite in relation to the course
	public void addPreq(Course preq) {
		coursePreq.add(preq);
	}
	
	// adds offering that are available in relation to the course
	public void addOffering(CourseOffering offering) {
		offeringList.add(offering);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}

	public ArrayList<Course> getCoursePreq() {
		return coursePreq;
	}

	public void setCoursePreq(ArrayList<Course> coursePreq) {
		this.coursePreq = coursePreq;
	}
	
	public ArrayList<CourseOffering> getOfferingList() {
		return offeringList;
	}

	public void setOfferingList(ArrayList<CourseOffering> offeringList) {
		this.offeringList = offeringList;
	}
	
	// Retrieves the list of all section numbers available from CourseOffering class
	public ArrayList<Integer> getSections() {
		ArrayList<Integer> listSectionNums = new ArrayList<>(); 
		for (CourseOffering o: offeringList) {
			listSectionNums.add(o.getSectionNum());
		}
		return listSectionNums;
	}
	
	// Searches for the offering information in relation to the section number you are looking for
	public CourseOffering searchOffering(int sectionNum) {
		for (CourseOffering o: offeringList) {
			if (o.getSectionNum() == sectionNum) {
				return o;
			}
		}
		return null;
	}
	
	public String listPreq() {
		String temp = "\nPrerequisites: ";
		for (Course preq: coursePreq) {
			temp += preq + ", ";
		}
		return temp;
	}
	
	public String listOffering() {
		String temp = "";
		for (CourseOffering sec: offeringList) {
			temp += "\n" + sec;
		}
		return temp + "\n";
	}
	
	@Override
	public String toString() {
		return courseName + " " + courseNum;
	}

}

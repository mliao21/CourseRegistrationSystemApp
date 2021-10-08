package courseRegModel;

public class Registration {
	
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	public Registration () {
	}
	
	// Every time a registration is instantiated,
	// the registered course is added to the student's course list and
	// the student is added to the offering's student list
	public void register(Student theStudent, CourseOffering theOffering) {
		this.theStudent = theStudent;
		this.theOffering = theOffering;
		addRegistration();
	}
	
	// To undo registration applies a similar function. Every time a student removes 
	// a course from registration, it removes from its course list and removes the 
	// student from the offering
	public void unregister(Student theStudent, CourseOffering theOffering) {
		this.theStudent = theStudent;
		this.theOffering = theOffering;
		removeRegistration();
	}
	
	public void addRegistration() {
		theStudent.addRegistration(this);
		theOffering.addRegistration(this);
	}
	
	public void removeRegistration() {
		theStudent.removeRegistration(this);
		theOffering.removeRegistration(this);
	}

	public Student getTheStudent() {
		return theStudent;
	}
	
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	
	public Course getTheCourse() {
		return theOffering.getTheCourse();
	}
	
	public String getTheCourseName() {
		return theOffering.getTheCourseName();
	}
	
	public int getTheCourseNum() {
		return theOffering.getTheCourseNum();
	}
	
	public int getTheSectionNum() {
		return theOffering.getSectionNum();
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	
}

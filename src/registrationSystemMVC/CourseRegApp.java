package registrationSystemMVC;

import courseRegModel.CourseCatalogue;
import courseRegView.CourseRegGUI;
import courseRegController.*;

public class CourseRegApp {

	public static void main(String[] args) {
		
		CourseCatalogue theCourseCat = new CourseCatalogue();
		CourseRegGUI theView = new CourseRegGUI();
		CourseRegController theController = new CourseRegController(theView, theCourseCat);
		theView.setVisible(true);
	}

}

package org.testscripts.regression;
import org.pageobjects.ContentCreationLessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ReviewerRequestChangesTheBook  extends BaseTest
{
	//Files yet to update from Richa
	@Test
	public void verifyReviewerRequestChnagesTheBook() throws Exception
	{
		//List <TestDataForSunbird> objListOFTestDataForSunbird=null;
		SignUpPageObj userLogin = new SignUpPageObj();
		ContentCreationLessonPlanPageObj contentCreationLessonPlanobj= new ContentCreationLessonPlanPageObj();
		
		//1.Login as  reviewer
		userLogin.userLogin(REVIEWER);
		
		//2.Navigate to workspace-
		contentCreationLessonPlanobj.navigateToWorkspace();
		
		//3.Go to up for Review
		contentCreationLessonPlanobj.rejectTheContent();
		contentCreationLessonPlanobj.verifyReviewerIsRedirectedPage();
	}
}

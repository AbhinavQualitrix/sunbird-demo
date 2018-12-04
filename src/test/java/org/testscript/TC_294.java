package org.testscript;

import org.pageobjects.BatchUserPageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_294 extends BaseTest{
	@Test
	public void TC_294_rootOrg() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
		//CreateMentorPageObj CreateMentorPageObj = new CreateMentorPageObj();
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.createInviteBatch();
		
		// Logout
	      BatchUserPageObj.userLogout();
	      
	    // Login back as invited mentor
	}
}

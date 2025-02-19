/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/27/2018

* Purpose: As a Creator Upload PDF,as a Reviewer Publish it and as a User Consume it.

*/
package org.testscripts2;

import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentTypePdfAndVerify extends BaseTest
{
	@Test
	public void uploadContentPdfAndVerify() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1:Login as content creator
		
		signupObj.userLogin(CREATOR);
		
		//Step2:Navigate to workspace and uplaod content-PDF
		
		creatorUserPageObj.uploadContentMp4(PDF);
		
		//Step3:Logout as creator
		
		signupObj.userLogout();
		
		//Step4:Login as Reviewer
		
		signupObj.userLogin(REVIEWER);
		
		//Step5:Go to workspace and publish content PDF
		
		creatorUserPageObj.goToWorkspace("pdf");
		
		//Step6:Logout as reviewer
		
		signupObj.userLogout();
		
		//Step7:Login as Public user
		
		signupObj.userLogin(PUBLICUSER1);	
				
		//Step8:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchContent("content");
		
		//Step9:Logout as Public user
		
		signupObj.userLogout();
		
	}
}


/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/18/2018
 * Purpose:  Upload the Content type - Mp4 and validate it
 */

package org.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentTypeMp4 extends BaseTest
{
	@Test(priority=4, groups={"Creator Group"})
	public void uploadContentTypeMp4() throws Exception
	{
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2,3 and 4:Navigate to workspace and upload content-MP4 and send the content for review
		creatorUserPageObj.uploadContentMp4(MP4);

		creatorUserPageObj.uploadContentMp4(MP4);

		//Logout as creator
		signupObj.userLogout();

		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6, 7:Go to workspace and publish content Mp4
		creatorUserPageObj.goToWorkspace("mp4");
		
		//Step 8 :Reject the upload type-MP4 which is already existing in the list
		creatorUserPageObj.rejectTheUploads("mp4");

		//Step 9 :Logout as Reviewer
		signupObj.userLogout();

		//Step10: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step11: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step12: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator
		signupObj.userLogout();
	}
}

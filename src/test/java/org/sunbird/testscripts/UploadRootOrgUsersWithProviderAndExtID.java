/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/14/2018
* Purpose: Upload user for root org with provider and external id
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.pageobjects.UploadOrgObj;
import org.sunbird.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadRootOrgUsersWithProviderAndExtID extends BaseTest
{
	@Test(priority=5)
	public void rootUsersProviderAndExtID() throws Exception
	{
		//Step1: Admin Login
		SignUpPageObj adminLogin = new SignUpPageObj();
		adminLogin.userLogin(ADMIN);
		
		//Step 2,3,4 and 5: Go to profile
		//and Upload user for roor org with provider and external ID
		UploadOrgObj adminUpload= new UploadOrgObj();
		adminUpload.rootAndSubOrgUserExternalAndProvider(UPLOAD_USERS_ROOT_ORG);
		
		//Logout as Admin
		adminLogin.userLogout();
	}

}

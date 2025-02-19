package org.testscripts.regression;

import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CopyContentFromLibraryAndVerify extends BaseTest 
{
	//TC74
	@Test
	public void verifyCopyContent_Library() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Step 1.Login as content creator
		userLogin.userLogin(CREATOR);
		
		//Step 2.Navigate to library and search the content
		contentReourcePageObj.navigateToLibraryAndSearchContent(RESOURCE);
		
		//Step 3.Copy the content and validate it in drafts
		contentReourcePageObj.copyContentAndValidate(RESOURCE);
		
		//Step 4.Logout as content creator
		userLogin.userLogout();
	}

}

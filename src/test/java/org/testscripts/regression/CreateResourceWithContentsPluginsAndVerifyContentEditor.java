package org.testscripts.regression;

import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateResourceWithContentsPluginsAndVerifyContentEditor extends BaseTest 
{
	//TC75
	@Test
	public void createResourceWithContentsPlugins_VerifyContentEditor() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);
		
		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Validate content editor
		contentReourcePageObj.valdiateContentEditor();
			
		
		//validate all the plugins and content for creating resource
		contentReourcePageObj.verifyResourcePluginsAndContents();
		
		
		//Logout as content creator
		userLogin.userLogout();
		
		
		
	}

}

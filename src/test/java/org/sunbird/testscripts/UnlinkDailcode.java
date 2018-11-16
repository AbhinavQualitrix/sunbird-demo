/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/27/2018
* Purpose: Dial code unlinking to book unit
*/

package org.sunbird.testscripts;

import org.testng.annotations.Test;
import java.util.List;

import org.sunbird.generic.ReadTestDataFromExcel;
import org.sunbird.pageobjects.CreatorUserPageObj;
import org.sunbird.pageobjects.SignUpPageObj;
import org.sunbird.startup.BaseTest;
import org.sunbird.testdata.TestDataForSunbird;
import org.testng.annotations.Test;

public class UnlinkDailcode extends BaseTest
{
	@Test(priority=18, groups={"Creator Group"})
	public void unlinkDailcode() throws Exception
	{
		List <TestDataForSunbird> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(BOOKCREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);

		//Step 3:Create a Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);

		//Step 4:Save the book and the message
		creatorUserPageObj.removeDailCodeAndCheckMessage();
		
		//Step 5: Logout as Creator
		signupObj.userLogout();
		
		//Step 6: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 7: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 8: Logout as Creator
		signupObj.userLogout();

	}

}

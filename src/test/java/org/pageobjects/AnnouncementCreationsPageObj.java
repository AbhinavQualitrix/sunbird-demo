package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.page.AnnouncementCreationsPage;
import org.page.ContentCreationResourcePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.startup.BaseTest;
import org.testdata.TestDataForSunbird;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class AnnouncementCreationsPageObj extends BaseTest
{


	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	ContentCreationResourcePage contentResourcePage =PageFactory.initElements(driver,ContentCreationResourcePage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForSunbird> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();	
	AnnouncementCreationsPage announcementcreationspage=PageFactory.initElements(driver,AnnouncementCreationsPage.class);
	CreatorUserPageObj  createUserPageObj = new CreatorUserPageObj();



	public void NavigateToAnnouncementDashboard()
	{
		try
		{
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Profile Icon Page");
			GenericFunctions.waitForElementToAppear(announcementcreationspage.profileIcon);
			announcementcreationspage.profileIcon.click();



			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on AnnouncementDashboardMenu In ProfileIcone");
			GenericFunctions.waitForElementToAppear(announcementcreationspage.announcementDashboardMenu);
			announcementcreationspage.announcementDashboardMenu.click();

			GenericFunctions.waitWebDriver(3000);



			try
			{
				if(announcementcreationspage.verifyMyAnnouncementPageIsDisplayed.isDisplayed())
				{

					ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement Dashboard Page Displayed Succesfully");
					//Assert.assertTrue(true);
					//ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement Dashboard Page Displayed Succesfully");
				}

			}
			catch(Exception e3)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Announcement Page Not Displayed");
				
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e3.getLocalizedMessage());
				Assert.fail();
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			//ExtentTestManager.getTest().log(LogStatus.FAIL, "Announcement Dashboard Page Not Displayed");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Clicking AnnouncementDashboardMenu in ProfileIcon");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on Clicking AnnouncementDashboardMenu in ProfileIcon");
			Assert.fail("Failed on Clicking AnnouncementDashboardMenu in ProfileIcon");
		}


	}

	public void verifyAnnouncementMessage()
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Announcement Page");
			GenericFunctions.waitForElementToAppear(announcementcreationspage.verifyNoAnnouncementMessage);
			if(announcementcreationspage.verifyNoAnnouncementMessage.isDisplayed())
			{

				String ActualMsg=announcementcreationspage.verifyNoAnnouncementMessage.getText();
				System.out.println(ActualMsg);
				String ExpectedMsg="No announcement found!p";

				Assert.assertEquals(ExpectedMsg,ActualMsg);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Validating NoAnnouncement Message In Announcement DashBoard Completed Succesfully");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Validating NoAnnouncement Msg In Announcement DashBoard");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());

			Assert.fail("Failed on Validating NoAnnouncement Msg In Announcement DashBoard");

		}

	}


	public void ValidateViewAnnouncementSection()
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is in Announcement Page");
			GenericFunctions.waitForElementToAppear(announcementcreationspage.fetchAnnouncementHeader);	

			String Value=announcementcreationspage.fetchAnnouncementHeader.getText();
			String Expected="Name Published Sent Received Seen Actions";

			System.out.println(Value);
			System.out.println(Expected);
			//Assert.assertEquals(Value,Expected);

			if(Value.equals(Expected))
			{
				Assert.assertEquals(Value,Expected);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Header Column in Announcement Section Verified Succesfully");

				if(announcementcreationspage.checkAnnouncementData.isDisplayed())
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Announcement Details Verified Succesfully");
				}


			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Header Column and Announcement Details in Announcement DashBoard  Verification is failed");


				Assert.fail("Failed on Asserting Header Column and Announcement Details in Announcement DashBoard");

			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println(e);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Validating ViewAnnouncemnt Section in Announcement DashBoard");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());

			Assert.fail("Failed on Validating ViewAnnouncemnt Section in Announcement DashBoard");

		}
	}
	
	public void navigateToCoursePage() throws InterruptedException
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Course page");	
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourseTitles);
			String actualUrl="https://staging.open-sunbird.org/learn";
			String expectedUrl=driver.getCurrentUrl();
			if(createUserPage.headerCourseTitles.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Course Page");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can access the Course Page sucessfully");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to course page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to course page"+e.getLocalizedMessage());
		}
	}
	
	
	public void navigateToLibraryPage() throws InterruptedException
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library page");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(announcementcreationspage.headerLibraryTitles);
			System.out.println(announcementcreationspage.headerLibraryTitles.getText());
			String actualUrl="https://staging.open-sunbird.org/resources";
			String expectedUrl=driver.getCurrentUrl();
			if(announcementcreationspage.headerLibraryTitles.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Library Page");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can access Library Page sucessfully ");
			}	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to library page"+e.getLocalizedMessage());
		}
	}
	
	public void navigateToProfilePage() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Profile page");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);

			String actualUrl="https://staging.open-sunbird.org/profile";
			String expectedUrl=driver.getCurrentUrl();
			if(createUserPage.workSpace.isDisplayed())
			{
				Assert.assertEquals(actualUrl, expectedUrl,"Failed on Asserting the URLs of Profile Page");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can access Profile page sucessfully");
			}					

			//GenericFunctions.assertIfElementExists(driver, XPATH, createUserPage.workSpace.toString());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to profile page"+e.getLocalizedMessage());
		}
	}

}

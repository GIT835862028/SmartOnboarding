package appModules.ManageUserAccounts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import appModules.Setup_ChallengeQuestions;
import appModules.Verification2Factor_Authentication;
import pageObjects.BaseClass;
import pageObjects.TestScenarios.TS_ChangeUserRoles_Page;
import utility.Constant;
import utility.OnboardingConstants;
import utility.psUtility;

public class UnlockUserAccounts extends psUtility {
	/**
	 * Test Name      : How to UnLock a User account
	 * Developer      : Srinivas
	 * Description    : Login with TA and select user in manage user page and Unlock the account .
	 *                  
	 * Dependency     : 1) Organization ID, Tenant Admin, Tenent user (User must me unlock) is required To execute the script
	 *                  2) Set the connection.Property file  in the folder Files>EnvironemntDetails>Connection.properties
	 *                   
	 */
	@Test
	public static void Execute() throws Exception {
		///Login to external site 
		if(!isElementExists("driver.findElement(By.id(\"configMenu\"))")) {
			BaseClass.driver.quit();
			setEnvironment(Constant.ExternalURL);
			psUtility.ExternalLogin(OnboardingConstants.TAUser, OnboardingConstants.ONBPassword);
			Verification2Factor_Authentication.Execute();
			Setup_ChallengeQuestions.Execute();
		}
		//Select user from Manage user content to lock 
		TS_ChangeUserRoles_Page.Lnk_ConfigMenu().click();
		TS_ChangeUserRoles_Page.Lnk_ManageUsersContacts().click();
		TS_ChangeUserRoles_Page.Lnk_Actions().click();
		TS_ChangeUserRoles_Page.Lnk_AccountUnLock().click();
		TS_ChangeUserRoles_Page.btn_Yes().click();
		TS_ChangeUserRoles_Page.btn_Close().click();
		
		Reporter.log("UnLock User Accounts Performed Successfully<br>");    
	}
}

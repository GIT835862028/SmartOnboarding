package appModules;

import java.util.Set;

import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.Constant;
import utility.psUtility;

public class SetEnvironment extends psUtility {

	@Test
	public static void Execute() throws Exception {
		setEnvironment(Constant.InternalURL);
		System.out.println("Testing git");
	}
}

package Tests;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testComponents.BaseTests;

public class PoModel extends BaseTests{

	
	@Test
	public void test() {
		homePage.typeTheWords();
		homePage.displayWPM();
	}

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class = 'highlight']")
	WebElement txt;

	@FindBy(xpath = "//input[@id = 'inputfield']")
	WebElement inputField;
	
	@FindBy(xpath = "//td[@id = 'wpm']/strong")
	WebElement wpm;
	
	@FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
	WebElement acceptAll;
	
	public void goTo() throws InterruptedException {
		driver.get("https://10fastfingers.com/typing-test/english");
		
//		driver.findElement(By.xpath("//button[@ id = 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))
//		.click();
		acceptAll.click();
		Thread.sleep(3000);
	}

	public void typeTheWords() {
		long startTime = System.currentTimeMillis(); // Get the start time
		long timeLimit = 60000; // 1 minute in milliseconds

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			// Check if the time limit (1 minute) has been reached
			if (System.currentTimeMillis() - startTime >= timeLimit ) {
				System.out.println("Time's up! Exiting the loop.");
				break; // Exit the loop after 1 minute
			}

			if(txt.isDisplayed() == true) {
				System.out.println(txt.getText());
				String x = txt.getText();
				inputField.sendKeys(x);
				inputField.sendKeys(" ");
			}

		}
	}
	
	public void displayWPM() {
		String wordsPerMinute =  wpm.getText();
		System.out.println("Words Per minite is " + wordsPerMinute);
	}
}

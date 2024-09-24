package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class withoutPOModel {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://10fastfingers.com/typing-test/english");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@ id = 'CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']"))
				.click();
		Thread.sleep(3000);

		long startTime = System.currentTimeMillis(); // Get the start time
		long timeLimit = 60000; // 1 minute in milliseconds

		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			// Check if the time limit (1 minute) has been reached
			if (System.currentTimeMillis() - startTime >= timeLimit) {
				System.out.println("Time's up! Exiting the loop.");
				break; // Exit the loop after 1 minute
			}

			System.out.println(driver.findElement(By.xpath("//span[@class = 'highlight']")).getText());
			String x = driver.findElement(By.xpath("//span[@class = 'highlight']")).getText();

			driver.findElement(By.xpath("//input[@id = 'inputfield']")).sendKeys(x);
			driver.findElement(By.xpath("//input[@id = 'inputfield']")).sendKeys(" ");

		}

		System.out.println("The WPM is " + driver.findElement(By.xpath("//td[@id = 'wpm']/strong")).getText());

		driver.quit();

	}
}

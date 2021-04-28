package weatherReporting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class websiteUIAutomation extends APITesting {

	public static int uiTesting(String city) throws Exception {
		
		//Initialize driver
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\himjunej\\eclipse-workspace\\AssessmentWebAutomation\\src\\driver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				//Triggering game.tv
				driver.get("https://weather.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(10000);
				//waitForElement(driver, 20, driver.findElement(By.xpath("//input[@id='LocationSearch_input']")));
				//System.out.println(driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).isEnabled());
				
					
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).click();
				driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).sendKeys(city);
				driver.findElement(By.xpath("//div[@id='LocationSearch_listbox']/button[1]")).click();
				
				WebElement tempElement = driver.findElement(By.xpath("//h1[contains(text(),'"+city+"')]//following::div[3]/span[1]"));
				waitForElement(driver, 5, tempElement);
				String temp = tempElement.getText();
				temp = temp.replace("°", "");
				int temperatureUI= Integer.parseInt(temp);

							
				/*
				 * driver.findElement(By.xpath("//input[@id='LocationSearch_input']")).click();
				 * driver.findElement(By.xpath("//div[@id='LocationSearch_listbox']/button[1]"))
				 * .click();
				 */
				
				
				driver.close();
				return temperatureUI;
	}
	
	public static void waitForElement(WebDriver driver,int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	

}

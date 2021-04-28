package gameTV;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GameTV {

	public static void main(String[] args) {

		
		//Initialize driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\himjunej\\eclipse-workspace\\AssessmentWebAutomation\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Triggering game.tv
		driver.get("https://www.game.tv/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("(//a[text()='Launch App'])[2]")).isDisplayed()) {
			System.out.println("Verify that the user is able to launch the application - Passed");
		}else {
			System.out.println("Verify that the user is able to launch the application - Failed");
		}
		//Navigating to Login Page Web Element Launch App =(//a[text()='Launch App'])[2]
		driver.findElement(By.xpath("(//a[text()='Launch App'])[2]")).click();
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
			driver.switchTo().window(child_window);
			}
		}
		
		if(driver.findElement(By.xpath("(//*[local-name()='svg']/*[local-name()='path'])[6]")).isDisplayed()) {
			System.out.println("Verify that the user is able see Login Screen & Twitter is visible - Passed");
		}else {
			System.out.println("Verify that the user is able see Login Screen & Twitter is visible  - Failed");
		}
		
		driver.findElement(By.xpath("(//*[local-name()='svg']/*[local-name()='path'])[6]")).click();
		

		if(driver.findElement(By.xpath("//a[text()='Twitter']")).isDisplayed()) {
		System.out.println("Verify that the user is able navigate to Twitter For login - Passed");
		}else {
		System.out.println("Verify that the user is able navigate to Twitter For login  - Failed");
		}
		
		driver.findElement(By.id("username_or_email")).sendKeys("tes1.auto1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("game@twitter");
		
		driver.findElement(By.xpath("//input[@id='allow']")).click();
		
		

	}

}

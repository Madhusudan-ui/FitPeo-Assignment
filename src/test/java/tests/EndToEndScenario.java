package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.Home;
import pages.RevenueCalculator;

public class EndToEndScenario {
	
	
	WebDriver driver;
	Home home;
	RevenueCalculator revenueCal;
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		home = new Home(driver);
		revenueCal = new RevenueCalculator(driver);
	}
	
	
	@Test
	public void endToEndScenario() {
		try {
			home.lauchFitPeoSite();
			home.navigateToRevenueCalculator();
			Thread.sleep(3000);
			revenueCal.scrollToSlider();
//			revenueCal.slideToNthValue("860");
//			Thread.sleep(5000);
			revenueCal.sendDataToInputField("820");
//			Thread.sleep(3000);
			revenueCal.checkSliderData("820");
//			Thread.sleep(3000);
			
			revenueCal.checkAllCPTCheckboxes();
			revenueCal.checkTotalRecurring();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally {
			
			driver.close();
		}
	}

}

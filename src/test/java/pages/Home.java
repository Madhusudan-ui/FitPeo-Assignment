package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver;
	
	public Home(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
		
	}
	
	//div[text()='Revenue Calculator']
	
	@FindBy(how = How.XPATH, using="//div[text()='Revenue Calculator']")
	WebElement revenueCalculator;
	
	
	
	public void lauchFitPeoSite() {
		driver.get("https://www.fitpeo.com/home");
	}
	
	public void navigateToRevenueCalculator() {
		revenueCalculator.click();
	}
	
	
	
	

}

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RevenueCalculator {
	
WebDriver driver;
Actions action;
JavascriptExecutor js;
	
	public RevenueCalculator(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		js = (JavascriptExecutor)driver;
		
	}

	
	@FindBy(how = How.XPATH, using="//input[@type='range']/parent::span")
	WebElement sliderPointer;
	
	
	@FindBy(how = How.XPATH, using="//span[contains(@class, 'MuiSlider-root')]")
	WebElement slider;
	
	//input[@type='number']
	
	@FindBy(how = How.XPATH, using="//input[@id=':r0:']")
	WebElement sliderInputField;
	
	@FindBy(how = How.XPATH, using="(//p[text()='CPT-99453']/following::input)[1]")
	WebElement CPT99453Checkbox;
	
	@FindBy(how = How.XPATH, using="(//p[text()='CPT-99091']/following::input)[1]")
	WebElement CPT99091Checkbox;
	
	@FindBy(how = How.XPATH, using="(//p[text()='CPT-99454']/following::input)[1]")
	WebElement CPT99454Checkbox;
	
	@FindBy(how = How.XPATH, using="(//p[text()='CPT-99474']/following::input)[1]")
	WebElement CPT99474Checkbox;
	
	
	
	@FindBy(how = How.XPATH, using="//p[contains(text(), 'Total Recurring')]/p")
	WebElement totalRecurring;
	
	public void checkAllCPTCheckboxes() {
		CPT99091Checkbox.click();
		CPT99453Checkbox.click();
		CPT99454Checkbox.click();
		CPT99474Checkbox.click();
	}
	
	public void checkTotalRecurring() {
		Assert.assertEquals(totalRecurring.getText().trim().replace("$", ""), "110700");
	}
	
	public void scrollToSlider() {
		action.scrollToElement(sliderPointer).perform();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		
//		js.executeScript("arguments[0].scrollIntoView()", sliderPointer);
	}
	
	
	public void slideToNthValue(String data) {
		

        // Move the handle to the calculated target position (taking into account the float value)
        action.clickAndHold(sliderPointer) // Hold the handle
               .moveByOffset(300, 0) // Move horizontally to the target position
               .release() // Release the handle
               .perform(); // Execute the action
		
		action.clickAndHold(sliderPointer) // Hold the handle
        .moveByOffset(-177, 0) // Move horizontally to the target position
        .release() // Release the handle
        .perform(); // Execute the action
	

	}
	
	public void sendDataToInputField(String data) throws InterruptedException {
		
		// Focus on the input field
        sliderInputField.click();

        // Use JavascriptExecutor to clear the value

        js.executeScript("arguments[0].value = '';", sliderInputField);

        // Now, set the new value one character at a time
        sliderInputField.sendKeys(data);


	}
	
	public void checkSliderData(String data) {
		System.out.println(sliderPointer.getAttribute("value"));
		Assert.assertTrue(sliderPointer.getAttribute("value").equals(data));
	}

}

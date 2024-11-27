package Admin;

//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Project {
	static WebDriver driver;
    
    @BeforeMethod
    public void Setup() {
    	System.setProperty("webdriver.ie.driver", "C://Users//Sarath//Downloads//edgedriver_win64 (4)//msedgedriver.exe");
    	driver = new EdgeDriver();
    	driver.manage().window().maximize();
    	PageFactory.initElements(driver, this);
    	
    }
    
    @FindBy(how=How.XPATH, using="//*[text()='Images']")
    WebElement ele;
    
    
    @Test
    public void test1() throws InterruptedException {
    	//driver.navigate().to("https://www.google.com");
    	Actions action = new Actions(driver);
    	action.keyDown(Keys.CONTROL+"t").keyUp(Keys.CONTROL+"t").build().perform();
    	//driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t"); // Opens a new tab
    	driver.findElement(By.tagName("body")).sendKeys("https://www.google.com"); // Types the URL in the new tab
    	driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
    	driver.findElement(By.id("APjFqb")).sendKeys("Google",Keys.ENTER);
    	//WebElement ele = driver.findElement(By.xpath(""));
    	ele.click();
    	Thread.sleep(5000);
    	// driver.navigate().refresh();
    	ele.click();
    	//driver.findElement(By.xpath("//*[text()='Images']")).click();
    	
    }
}

// To automate registration and order placement in a demo E-Commerce website :

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class SeleniumECommerceAutomation {

	static WebDriver driver; // Creating WebDriver

	@BeforeMethod
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\sowmya\\eclipse-workspace\\Selenium_Basic\\chromedriver.exe");

		driver = new ChromeDriver(); // Initializing the WebDriver

		driver.get("http://automationpractice.com/index.php");
		
		// To maximize the window :
		driver.manage().window().maximize(); 
		
		// To click Sign in :
		driver.findElement(By.linkText("Sign in")).click(); 
		Thread.sleep(2000);

		// To enter mail id :
		driver.findElement(By.id("email_create")).sendKeys("sowmya.geddam2@gmail.com");
		Thread.sleep(1000);

		// To click Submit :
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(1000);

		// To select 'Female' as gender :
		driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		Thread.sleep(1000);

		// To enter First name :
		driver.findElement(By.id("customer_firstname")).sendKeys("Sowmya");
		Thread.sleep(1000);

		// To enter Last name :
		driver.findElement(By.id("customer_lastname")).sendKeys("Geddam");
		Thread.sleep(1000);

		// To enter Password :
		driver.findElement(By.id("passwd")).sendKeys("Sowmya@123");
		Thread.sleep(1000);

		// To enter Address :
		driver.findElement(By.id("address1")).sendKeys("328/A,Steel Plant");
		Thread.sleep(1000);

		// To enter City :
		driver.findElement(By.id("city")).sendKeys("Visakhapatnam");
		Thread.sleep(1000);

		// To select State :
		WebElement state = driver.findElement(By.id("id_state"));
		Thread.sleep(1000);
		Select states = new Select(state);
		Thread.sleep(1000);
		states.selectByVisibleText("Indiana");
		Thread.sleep(1000);

		// To enter Zip code :
		driver.findElement(By.id("postcode")).sendKeys("530032");
		Thread.sleep(1000);

		// To enter Mobile phone number :
		driver.findElement(By.id("phone_mobile")).sendKeys("6304542647");
		Thread.sleep(1000);

		// To enter address alias :
		driver.findElement(By.id("alias")).sendKeys("8,fgt");
		Thread.sleep(1000);

		//To click 'REGISTER' button :
		driver.findElement(By.id("submitAccount")).click();

		Actions act = new Actions(driver);
		Thread.sleep(2000);
		
		// To click on 'Women' :
		WebElement women = driver.findElement(By.xpath("//ul//li//a[contains(text(),'Women')]"));
		act.moveToElement(women).build().perform();
		Thread.sleep(1000);

		// To select 'T-shirts' from drop down :
		WebElement tshirt = driver.findElement(By.xpath("//li//a[contains(text(),'T-shirts')]"));
		Thread.sleep(1000);
		act.moveToElement(tshirt).click().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);

		// To scroll until 'More' is viewed :
		js.executeScript("window.scrollTo(0,700)");
		Thread.sleep(1000);

		// To mouse over on the first product :
		WebElement dress = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		act.moveToElement(dress).build().perform();
		Thread.sleep(1000);

		// To click on 'More' :
		driver.findElement(By.linkText("More")).click();
		Thread.sleep(1000);

		// To increase the 'Quantity' to '2' :
		driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
		Thread.sleep(1000);

		// To select 'Size' as 'L' :
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByVisibleText("L");
		Thread.sleep(1000);

		// To change the Color :
		driver.findElement(By.id("color_14")).click();
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(1000);

		// To click 'Add to cart' :
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		Thread.sleep(3000);

		// To click 'Proceed to checkout' :
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		Thread.sleep(1000);

		// To scroll until 'Proceed to checkout' is viewed :
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(2000);

		// To click 'Proceed to checkout' :
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
		Thread.sleep(1000);

		// To scroll until 'Proceed to checkout' is viewed :
		js.executeScript("window.scrollTo(0,400)");
		Thread.sleep(1000);

		// To click 'Proceed to checkout' :
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		Thread.sleep(1000);

		// To click the 'Check-box' :
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		Thread.sleep(1000);

		// To click 'Proceed to checkout' :
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();
		Thread.sleep(1000);

		// To select 'Pay by check' :
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
		Thread.sleep(1000);

		// To click 'I confirm my order' :
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		Thread.sleep(1000);

		// To get the confirmation text :
		String confirmationText = driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();

		if (confirmationText.contains("complete")) {
			System.out.println("Order is placed - Execution successfull");
		} else {
			System.out.println("Order is not placed - Execution failed");
		}
	}

	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

}
package flipkart.com;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class mobile {
	 static WebDriver driver;
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajap\\eclipse-workspace\\Junit\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	
	    
	}

	@Given("user login into flipkart")
	public void user_login_into_flipkart() {
		WebElement close=driver.findElement(By.xpath("//button[text()='✕']"));
		close.click();
		System.out.println("login");
	   
	}

	@When("user search mobile")
	public void user_search_mobile() throws InterruptedException {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("redmi mobiles", Keys.ENTER);
		Thread.sleep(4000);
	   
	}

	@When("user choose the mobile and doing payments")
	public void user_choose_the_mobile_and_doing_payments() {
		WebElement w1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		w1.click();
		
	
		String parentID = driver.getWindowHandle();
		System.out.println("Parent Window ID:"+parentID);
		Set<String> childID = driver.getWindowHandles();
		for(String x : childID)
			if(!parentID.equals(x)) {
				System.out.println("Child Window ID:"+childID);
				driver.switchTo().window(x);
				
	}
	}
	@When("user search mobile by using one dim list")
	public void user_search_mobile_by_using_one_dim_list(DataTable dataTable) throws Throwable {
		List<String> aslist = dataTable.asList();
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(aslist.get(0), Keys.ENTER);
		driver.findElement(By.xpath("//div[contains(text(),"+aslist.get(0)+")]"));
		Thread.sleep(4000);
		
	   
	}

@When("user search mobile by using one dim map")
public void user_search_mobile_by_using_one_dim_map(DataTable dataTable) throws InterruptedException {
	  Map<String, String> map = dataTable.asMap(String.class, String.class);
	   WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(map.get("phone2"), Keys.ENTER);
		driver.findElement(By.xpath("//div[contains(text(),"+map.get("phone2")+")]"));
		Thread.sleep(4000);
}

@When("user search mobile {string}")
public void user_search_mobile(String string, DataTable dataTable) throws InterruptedException {
	
	   WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(string, Keys.ENTER);
		driver.findElement(By.xpath("//div[contains(text(),"+string+")]"));
		Thread.sleep(4000);
}
	    
	

	@Then("user receive order confirmation message")
	public void user_receive_order_confirmation_message() {
		driver.quit();
		System.out.println("Browserquite");
	
	    
	}

}

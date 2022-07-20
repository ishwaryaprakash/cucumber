package flipkart.com;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class tv {
	
	@When("user search tv")
	public void user_search_tv() throws InterruptedException {

		WebElement search = mobile.driver.findElement(By.name("q"));
		search.sendKeys("redmi tv", Keys.ENTER);
		Thread.sleep(4000);
	}

	@When("user choose the tv and doing payments")
	public void user_choose_the_tv_and_doing_payments() throws Throwable {
		WebElement a = mobile.driver.findElement(By.xpath("(//div[contains(@class,'_4rR01T')])[1]"));
		a.click();
		Thread.sleep(4000);
		String textt = a.getText();
		System.out.println("Tv name : " + textt);
		String parentID = mobile.driver.getWindowHandle();
		System.out.println("Parent Window ID:" + parentID);
		Set<String> childID = mobile.driver.getWindowHandles();
		for (String y : childID)
			mobile.driver.switchTo().window(y);
		Thread.sleep(3000);
		WebElement q = mobile.driver.findElement(By.xpath("//span[contains(@class,'B_NuCI')]"));
		String text2 = q.getText();
	}

@When("user search tv by using one dim list")
public void user_search_tv_by_using_one_dim_list(io.cucumber.datatable.DataTable dataTable) throws Throwable {
	List<String> asList = dataTable.asList();
	WebElement search = mobile.driver.findElement(By.name("q"));
	search.sendKeys(asList.get(0), Keys.ENTER);
	Thread.sleep(4000);
}

@When("user search tv by using one dim map")
public void user_search_tv_by_using_one_dim_map(DataTable dataTable) throws Throwable {
	Map<String, String> asMap = dataTable.asMap(String.class, String.class);
	WebElement search = mobile.driver.findElement(By.name("q"));
	search.sendKeys(asMap.get("phone2"),Keys.ENTER);
	Thread.sleep(4000);
}



	

}

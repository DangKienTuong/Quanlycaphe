package poly.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Category {
	public String BaseUrl = "http://localhost:8080/PS09298ASM/";
	String driverPath = "D:\\Document\\Advanced Testing\\TaiNguyen\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();

		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("tnt");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("0710");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();

		driver.get("http://localhost:8080/PS09298ASM/manage/category.htm");
	}

	@Test
	public void CAT05() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count);
	}

	@Test(priority = 1)
	public void CAT06() {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("new cat");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[3]/button")).click();
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/input"))
				.getAttribute("value");
		String expected = driver.findElement(By.xpath("//*[@id=\"name\"]")).getAttribute("value");
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void CAT07() {
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[3]/button")).click();
		String actual = driver.findElement(By.id("name.errors")).getText();
		String expected = "Không được để trống tên danh mục !";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void CAT08() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/input"))
				.sendKeys(" 1");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[3]/button"))
				.click();

		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/input"))
				.getAttribute("value");
		String expected = "new cat 1";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void CAT09() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[3]/form/button"))
				.click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count - 1);
	}

	@Test(priority = 4)
	public void CAT04() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys("c");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[2]/input"))
				.getAttribute("value");
		Assert.assertTrue(actual.startsWith("c"));
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}

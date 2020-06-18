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

public class Account {
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

		driver.get("http://localhost:8080/PS09298ASM/manage/user.htm");
	}

	@Test
	public void ACC05() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[4]/button")).click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count);
	}

	@Test(priority = 1)
	public void ACC07() {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("new1");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[4]/button")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys("new1");
		;

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[4]/button")).click();

		String actualUser = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[1]/input"))
				.getAttribute("value");
		String actualPass = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[2]/input"))
				.getAttribute("value");
		String expectedUser = "new1";
		String expectedPass = "123";
		Assert.assertTrue(actualUser.equals(expectedUser) && actualPass.equals(expectedPass));
		;
	}

	@Test
	public void ACC06() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[4]/button")).click();
		Assert.assertEquals(driver.findElement(By.id("username.errors")).getText(), "Không được để trống username !");
	}

	@Test(priority = 2)
	public void ACC08() {
		driver.get("http://localhost:8080/PS09298ASM/manage/user.htm");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[4]/td[3]/input")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[4]/td[4]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[4]/td[3]/input"))
				.getAttribute("value");
		String expected = "test";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void ACC09() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[4]/td[4]/form/button")).click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count - 1);
	}

	@Test(priority = 4)
	public void ACC04() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys("t");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[4]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[1]/input"))
				.getAttribute("value");
		Assert.assertTrue(actual.startsWith("t"));
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}

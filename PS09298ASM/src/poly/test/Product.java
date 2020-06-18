package poly.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;

public class Product {
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

		driver.get("http://localhost:8080/PS09298ASM/manage/product.htm");
	}

	@Test
	public void PRO06() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[7]/button")).click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count);
	}

	@Test(priority = 1)
	public void PRO12() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[4]/input"))
				.sendKeys("D:\\anh_the.jpg");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[7]/button")).click();

		driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("tuong");
		driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys("16000");
		Select sel = new Select(driver.findElement(By.xpath("/html/body/form/select")));
		sel.selectByIndex(2);
		driver.findElement(By.xpath("/html/body/form/button")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[5]")).getText(), "");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[7]/button")).click();
	}

	@Test
	public void PRO10() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[4]/input"))
				.sendKeys("D:\\anh_the.jpg");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[7]/button")).click();

		driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys("tuong");
		driver.findElement(By.xpath("/html/body/form/input[3]")).sendKeys("1");
		Select sel = new Select(driver.findElement(By.xpath("/html/body/form/select")));
		sel.selectByIndex(2);
		driver.findElement(By.xpath("/html/body/form/button")).click();
		Assert.assertEquals(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[5]")).getText(),
				"Giá không hợp lệ!");
	}

	@Test(priority = 2)
	public void PRO14() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/input"))
				.sendKeys("1");

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[7]/button"))
				.click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[7]/button")).click();
		String actual = driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/input"))
				.getAttribute("value");
		String expected = "tuong1";
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void SALE08() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[7]/form/button"))
				.click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count - 1);
	}

	@Test(priority = 4)
	public void PRO05() {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[2]/input")).sendKeys("a");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[7]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[2]/input"))
				.getAttribute("value");
		Assert.assertTrue(actual.startsWith("a"));
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}

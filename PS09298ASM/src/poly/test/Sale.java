package poly.test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.mail.search.StringTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sale {
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

		driver.get("http://localhost:8080/PS09298ASM/manage/sale.htm");
	}

	@Test
	public void ACC05() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
		List<WebElement> rowsAfter = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int countAfter = rowsAfter.size();
		Assert.assertEquals(countAfter, count);
	}

	@Test(priority = 1)
	public void SALE06() {
		Select sel = new Select(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[2]/select")));
		sel.selectByIndex(3);

		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[3]/button")).click();
		Select selAc = new Select(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[2]/select")));
		String actual = selAc.getFirstSelectedOption().getText();
		Assert.assertEquals(actual, "bac xiu");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
	}

	@Test(priority = 2)
	public void SALE07() {
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr"));
		int count = rows.size();

		Select sel = new Select(driver
				.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[2]/select")));
		sel.selectByIndex(4);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[" + count + "]/td[3]/button"))
				.click();
		Select selAc = new Select(
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[2]/td[2]/select")));
		String actual = selAc.getFirstSelectedOption().getText();
		Assert.assertEquals(actual, "capuchino");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
	}

	@Test(priority = 3)
	public void SALE08() {
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
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[1]/input")).sendKeys("3");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[1]/td[3]/button")).click();
		String actual = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/table/tbody/tr[3]/td[1]")).getText();
		Assert.assertEquals(actual, "3");
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}

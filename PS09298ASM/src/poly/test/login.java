package poly.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class login {

	public String BaseUrl = "http://localhost:8080/PS09298ASM/";
	String driverPath = "D:\\Document\\Advanced Testing\\TaiNguyen\\chromedriver_win32\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@Test(priority = 2)
	public void LOG01() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("tnt");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("' or 1 = 1 --");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "404 HTML Template by Colorlib");
	}

	@Test(priority = 3)
	public void LOG02() {
		driver.get("http://localhost:8080/PS09298ASM/index.jsp/manage/product.htm");
		assertEquals(driver.getCurrentUrl(), "http://localhost:8080/PS09298ASM/login.htm");
	}

	@Test(priority = 1)
	public void LOG05() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("abc");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("0710");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "404 HTML Template by Colorlib");
	}

	@Test(priority = 1)
	public void LOG06() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("tnt");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "404 HTML Template by Colorlib");
	}

	@Test(priority = 1)
	public void LOG07() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("abc");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "404 HTML Template by Colorlib");
	}

	@Test(priority = 1)
	public void LOG08() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "Login V5");
	}

	@Test(priority = 1)
	public void LOG09() {
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[2]/input")).sendKeys("tnt");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/input")).sendKeys("0710");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button")).click();
		assertEquals(driver.getTitle(), "Coffee - Free Bootstrap 4 Template by Colorlib");
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}

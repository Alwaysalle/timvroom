package assignmentTimvroom;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Timvrrom {
	private static WebDriver driver;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://timvroom.com/selenium/playground/");
	}
	
	@Test
	public void task01() {
		String title = driver.getTitle();
		driver.findElement(By.id("answer1")).sendKeys(title);
	}
	@Test
	public void task02() {
		String name ="Kilgore Trout";
		driver.findElement(By.id("name")).sendKeys(name);
	}

	@Test
	public void task03() {
		WebElement dropDownList = driver.findElement(By.id("occupation"));
		new Select(dropDownList).selectByValue("scifiauthor");
	}
	@Test
	public void task04() {
		int i = driver.findElements(By.className("bluebox")).size();
		String count  = String.valueOf(i);
		driver.findElement(By.id("answer4")).sendKeys(count);
	}
	@Test
	public void task05() {
		driver.findElement(By.linkText("click me")).click();
		
	}
	@Test
	public void task06() {
		String redBoxClassName = driver.findElement(By.id("redbox")).getAttribute("class");
		driver.findElement(By.id("answer6")).sendKeys(redBoxClassName);
	}
	@Test
	public void task07() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("ran_this_js_function()");
	}
	@Test
	public void task08() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Long returnValue = (Long)executor.executeScript("return got_return_from_js_function()");
		String value = String.valueOf(returnValue);
		driver.findElement(By.id("answer8")).sendKeys(value);
	}
	@Test
	public void task09() {
		driver.findElement(By.xpath("//input[@value='wrotebook']")).click();
	}
	@Test
	public void task10() {
		String text = driver.findElement(By.id("redbox")).getText();
		driver.findElement(By.id("answer10")).sendKeys(text);
	}
	@Test
	public void task11() {
		Point green = driver.findElement(By.id("greenbox")).getLocation();
		Point orange = driver.findElement(By.id("orangebox")).getLocation();

		if (green.y < orange.y){
			driver.findElement(By.id("answer11")).sendKeys("green");
		} else {
			driver.findElement(By.id("answer11")).sendKeys("orange");
		}
	}
	@Test
	public void task12() {
		Dimension d = new Dimension(850,650);
		driver.manage().window().setSize(d);
	}
	@Test
	public void task13() {
		if (driver.findElements(By.id("ishere")).size() == 0){
			driver.findElement(By.id("answer13")).sendKeys("no");;
		} else {
			driver.findElement(By.id("answer13")).sendKeys("yes");;
		}
	}
	@Test
	public void task14() {
		if (driver.findElement(By.id("purplebox")).isDisplayed()){
			driver.findElement(By.id("answer14")).sendKeys("yes");;
		} else {
			driver.findElement(By.id("answer14")).sendKeys("no");;
		}
	}
	@Test
	public void task15() throws InterruptedException {
		driver.findElement(By.xpath("//a[@onclick='show_new_link_after_wait();return false;']")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("click after wait")));
		wait.pollingEvery(100,TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("click after wait")).click();
	}
	@Test
	public void task16() {
		Alert alertWindow = driver.switchTo().alert();
		alertWindow.accept();
	}
	@Test
	public void task17() {
		driver.findElement(By.name("submit")).click();
	}
	@AfterClass
	public static void afterClass() {
		driver.findElement(By.id("checkresults")).click();
		
	}
}


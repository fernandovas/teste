package testeLogin;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02ValidateLoginFailEmptyTest {
	String url;
	WebDriver driver;

	@Before
	public void iniciar() { 
		url = "https://mantis-prova.base2.com.br/login_page.php?return=%2Fmy_view_page.php";
	    System.setProperty("webdriver.chrome.driver", 
	    "C:\\Users\\User\\Base2\\TesteBase2\\driver\\Chrome\\86\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	  }

	@After
	public void finalizar() {
		driver.quit();
	}

	@Test
	public void tC02ValidateLoginFailEmpty() {
		driver.get(url);
		driver.findElement(By.cssSelector(".button")).click();
		driver.findElement(By.cssSelector("div:nth-child(3)")).click();
		assertThat(driver.findElement(By.cssSelector("font")).getText(),
				is("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
}

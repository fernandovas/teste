package testeLogin;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04ValidateCorrectLoginTest {
	String url;
	WebDriver driver;

	@Before
	public void Iniciar() {
		url = "https://mantis-prova.base2.com.br/login_page.php?return=%2Fmy_view_page.php";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Base2\\TesteBase2\\driver\\Chrome\\86\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	}

	@After
	public void Finalizar() {
		driver.quit();
	}

	@Test
	public void tC04ValidateCorrectLogin() {
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("fernando.vitor");
		driver.findElement(By.name("password")).sendKeys("fernandogh");
		driver.findElement(By.cssSelector(".button")).click();
	}
}

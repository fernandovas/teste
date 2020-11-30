package HappyFlow;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01HappyFlow {
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
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void tC04ValidateCorrectLogin() {
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys("fernando.vitor");
		driver.findElement(By.name("password")).sendKeys("fernandogh");
		driver.findElement(By.cssSelector(".button")).click();
		driver.findElement(By.linkText("Relatar Caso")).click();
		driver.findElement(By.name("category_id")).click();
		{
			WebElement dropdown = driver.findElement(By.name("category_id"));
			dropdown.findElement(By.xpath("//option[. = '[Todos os Projetos] 7EI2PODHPN']")).click();
		}
		driver.findElement(By.name("category_id")).click();
		driver.findElement(By.name("reproducibility")).click();
		{
			WebElement dropdown = driver.findElement(By.name("reproducibility"));
			dropdown.findElement(By.xpath("//option[. = 'aleatório']")).click();
		}
		driver.findElement(By.name("reproducibility")).click();
		driver.findElement(By.name("severity")).click();
		{
			WebElement dropdown = driver.findElement(By.name("severity"));
			dropdown.findElement(By.xpath("//option[. = 'grande']")).click();
		}
		driver.findElement(By.name("severity")).click();
		driver.findElement(By.name("priority")).click();
		{
			WebElement dropdown = driver.findElement(By.name("priority"));
			dropdown.findElement(By.xpath("//option[. = 'urgente']")).click();
		}
		driver.findElement(By.name("priority")).click();
		driver.findElement(By.name("profile_id")).click();
		{
			WebElement dropdown = driver.findElement(By.name("profile_id"));
			dropdown.findElement(By.xpath("//option[. = 'Desktop  Windows 10']")).click();
		}
		driver.findElement(By.name("profile_id")).click();
		driver.findElement(By.name("summary")).click();
		driver.findElement(By.name("summary")).sendKeys("Esse Ã© um teste de fluxo feliz");
		driver.findElement(By.name("description")).click();
		driver.findElement(By.name("description")).sendKeys("teste de fluxo feliz");
		driver.findElement(By.name("additional_info")).click();
		driver.findElement(By.name("additional_info")).sendKeys("teste");
		driver.findElement(By.cssSelector(".button")).click();
	}
}

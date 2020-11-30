package testeLogin;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01AssertValidateEnvironmentLoginTest {
	String url;
	WebDriver driver;
	//testesss
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
  public void tC01AssertValidateEnvironmentLogin() {
    driver.get(url);
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".row-1:nth-child(2) > .category"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.name("password"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.name("perm_login"));
      assert(elements.size() > 0);
    }
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".button"));
      assert(elements.size() > 0);
    }
  }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bgtest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\Chrome135\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://pushing-it.vercel.app/");
    }

    @Test
    public void testTitle() {
        String expectedTitle = "Pushing-it";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "El título no coincide");
    }

    @Test
    public void testLanguage() {
        String lang = driver.findElement(org.openqa.selenium.By.tagName("html")).getAttribute("lang");
        Assert.assertEquals(lang, "en", "El idioma no es español");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

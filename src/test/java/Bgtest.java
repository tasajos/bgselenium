import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Bgtest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("🚀 Iniciando el navegador...");
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\Chrome135\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pushing-it.vercel.app/");
    }

    @Test
    public void testTitle() {
        System.out.println("🔍 Validando el título de la página...");
        String expectedTitle = "Pushing-it";
        String actualTitle = driver.getTitle();
        System.out.println("📄 Título obtenido: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "❌ El título no coincide");
        System.out.println("✅ Test de título PASÓ");
    }

    @Test
    public void testLanguage() {
        System.out.println("🌐 Verificando el idioma de la página...");
        String lang = driver.findElement(By.tagName("html")).getAttribute("lang");
        System.out.println("🈯 Idioma detectado: " + lang);
        Assert.assertEquals(lang, "en", "❌ El idioma no es inglés");
        System.out.println("✅ Test de idioma PASÓ");
    }

    @Test
    public void testRegisterForm() {
        System.out.println("📝 Completando el formulario de registro...");

        // Hacer clic en el botón Register
       // WebElement registerBtn = driver.findElement(By.xpath("//button[contains(text(), 'Register')]"));
       // registerBtn.click();

        // Esperar que aparezca el formulario
       // try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Completar campos
        driver.findElement(By.name("user")).sendKeys("usuarioTest1");
        driver.findElement(By.name("pass")).sendKeys("password123@");
        //driver.findElement(By.name("confirmPass")).sendKeys("password123");

        // Hacer clic en el radio button "Male"
        WebElement genderMale = driver.findElement(By.cssSelector("span[data-cy='Male']"));
        genderMale.click();
        System.out.println("✅ Seleccionado género: Male");

        // Seleccionar día en dropdown
        Select selectDay = new Select(driver.findElement(By.cssSelector("select[data-cy='day']")));
        selectDay.selectByVisibleText("10");
        System.out.println("✅ Día seleccionado: 10");

        // Seleccionar Mes en dropdown
        Select selectmonth = new Select(driver.findElement(By.cssSelector("select[data-cy='month']")));
        selectmonth.selectByVisibleText("April");
        System.out.println("✅ Mes seleccionado: Abril");

        // Seleccionar Año en dropdown
        Select selectYear = new Select(driver.findElement(By.cssSelector("select[data-cy='year']")));
        selectYear.selectByVisibleText("2000");
        System.out.println("✅ Año seleccionado: 2000");

        // Hacer clic en el botón "Register"
        WebElement registerButton = driver.findElement(By.cssSelector("button[data-cy='submitForm']"));
        registerButton.click();
        System.out.println("✅ Se hizo clic en el botón 'Register'");

        System.out.println("🎉 Formulario enviado (esperando confirmación si aplica)");

        // Validación simple: verificar que aparezca mensaje de éxito
        try { Thread.sleep(15500); } catch (InterruptedException e) {}


    }

    @AfterClass
    public void teardown() {
        System.out.println("🧹 Cerrando el navegador...");
        if (driver != null) {
            driver.quit();
        }
    }
}

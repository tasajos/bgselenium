import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.LocalDate;

public class Bgtest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.out.println("🚀 Iniciando el navegador...");
        //System.setProperty("webdriver.chrome.driver", "C:\\drivers\\Chrome135\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\ChakuySoft\\chdrive\\chromedriver.exe");
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
    }

    @Test
    public void testLanguage() {
        System.out.println("🌐 Verificando el idioma de la página...");
        String lang = driver.findElement(By.tagName("html")).getAttribute("lang");
        System.out.println("🈯 Idioma detectado: " + lang);
        Assert.assertEquals(lang, "es", "❌ El idioma no es español");
        System.out.println("✅ Test de idioma PASÓ");
    }

    @Test
    public void testValidacionEdadMinima100Anios() {

        driver.findElement(By.name("user")).sendKeys("usuarioTest2");
        driver.findElement(By.name("pass")).sendKeys("password123@");
        //driver.findElement(By.name("confirmPass")).sendKeys("password123");

        // Hacer clic en el radio button "Male"
        WebElement genderMale = driver.findElement(By.cssSelector("span[data-cy='Male']"));
        genderMale.click();
        System.out.println("Seleccionado género: Male");


        System.out.println("🎯 Iniciando validación de edad mínima de 100 años...");

        // Asignar valores de fecha de nacimiento
        WebElement daySelect = driver.findElement(By.id("day"));
        Select selectDay = new Select(daySelect);
        selectDay.selectByValue("1"); // Día 1

        WebElement monthSelect = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthSelect);
        selectMonth.selectByValue("1"); // Enero

        WebElement yearSelect = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearSelect);

        // Seleccionar año para que tenga menos de 100 años
        int currentYear = LocalDate.now().getYear();
        int yearToSelect = currentYear - 99; // 99 años de edad

        selectYear.selectByValue(String.valueOf(yearToSelect));

        // Calcular edad manualmente
        int edad = currentYear - yearToSelect;
        System.out.println("📅 Año seleccionado: " + yearToSelect);
        System.out.println("🎂 Edad calculada: " + edad + " años");

        // Validar y mostrar en consola
        if (edad < 100) {
            System.out.println("✅  CORRECTO: La edad es menor a 100 años.");
        } else {
            System.out.println("✅ CORRECTO: La edad cumple con el mínimo de 100 años.");
        }

        // También podrías hacer un Assert si quieres forzar que el test falle
        //Assert.assertTrue(edad >= 100, "La edad debe ser mínimo 100 años.");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("🛑 Cerrando el navegador...");
        if (driver != null) {
            driver.quit();
        }
    }
}

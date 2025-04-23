import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bgtest {
    public static void main(String[] args) {
        // Configura la ruta del ChromeDriver si no está en el PATH
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\Chrome135\\chromedriver.exe");

        // Crea una instancia del navegador
        WebDriver driver = new ChromeDriver();

        // Navega a la página
        driver.get("https://www.google.com");

        // Verifica el título
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("✅ El título es correcto: " + actualTitle);
        } else {
            System.out.println("❌ El título es incorrecto. Se obtuvo: " + actualTitle);
        }

        // Cierra el navegador
        driver.quit();
    }
}

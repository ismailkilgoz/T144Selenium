package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getTitle());  // Test Otomasyonu - Test Otomasyonu

        System.out.println(driver.getCurrentUrl()); // https://www.testotomasyonu.com/

        // System.out.println(driver.getPageSource()); // HTML sayfasinin tum kaynak kodlarini getirir

        System.out.println(driver.getWindowHandle());
        // F1AD93C52523129786B35C86A33EA31F
        // Selenium WebDriver actigi her browser icin benzersiz bir handle degeri uretir
        // EGER testimiz calisirken driver objesi ile birden fazla window acildi ise
        // bu window'lar arasinda gecisi windowHandle degerleri ile yapabiliriz

        System.out.println(driver.getWindowHandles());  // [0BE9D015A0B273B0188CB7B4844A568F]
        // Eger driver birden fazla window acti ise acik olan tum window'larin windowHandle degerlerini bize verir.

        Thread.sleep(3000);
        driver.quit();



    }
}

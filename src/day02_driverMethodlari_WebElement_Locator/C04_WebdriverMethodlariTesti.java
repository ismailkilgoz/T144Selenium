package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebdriverMethodlariTesti {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. Yeni bir class olusturun (TekrarTesti)
        // 2. Youtube web sayfasına gidin
        driver.get("https://www.youtube.com");
        // ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.

        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Youtube title testi PASSED");
        }else {
            System.out.println("Youtube title testi FAILED");
            System.out.println("Actuak title : " + actualTitle);
        }

        // 3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Youtube URL testi PASSED");
        }else System.out.println("Youtube URL testi FAILED");
        Thread.sleep(3000);

        // 4. Daha sonra testotomasyonu sayfasina gidin https://www.testotomasyonu.com/
        driver.navigate().to("https://www.testotomasyonu.com/");
        Thread.sleep(3000);

        // 5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);

        // 6. Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);

        // 7. Testotomasyonu sayfasina donun
        driver.navigate().forward();
        Thread.sleep(3000);

        // 8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        // 9. Ardından sayfa başlığının "Test" içerip içermediğini (contains) test edin, Yoksa doğru başlığı(Actual Title) yazdırın.
        String expectedHead = "Test";
        String actualHead = driver.getTitle();

        if (actualHead.contains(expectedHead)){
            System.out.println("Testotomasyonu title testi PASSED");
        }else {
            System.out.println("Testotomasyonu title testi FAILED");
            System.out.println("Actual title : "+ actualHead);
        }


        // 10.Sayfa URL'sinin https://www.testotomasyonu.com/ olup olmadığını test edin, degilse doğru URL'yi yazdırın
        String expectedUrl1 = "https://www.testotomasyonu.com/";
        String actualUrl2 = driver.getCurrentUrl();

        if (expectedUrl1.equals(actualUrl2)){
            System.out.println("Testotomasyonu url testi PASSED");
        }else {
            System.out.println("Testotomasyonu url testi FAILED");
            System.out.println("Actual Url : "+actualUrl2);
        }



        // 11.Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}

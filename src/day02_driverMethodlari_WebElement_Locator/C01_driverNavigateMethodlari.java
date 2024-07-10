package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        // System.setProperty("Webdriver.chrome.driver","Kurulum Dosyalari/chromedriver");
        /*
             9. satirin gorevi
             bilgisayarimizda fiziki olarak kullandigimiz chrome versiyonuna uygun
             selenium.dev sitesinden indirdigimiz ve kopya browser olusturmamizi saglayan
             chromedriver.exe dosyasini classimiza tanitmak

             Selenium 4.0.0 versiyonu ile kutuphanelerine tum guncel browserlara ait
             driver'lari yukledi
             Boylece bir class olusturdugumuzda

             BIZ ISTERSEK, kendi driver'imizi 9. satiri kullanarak tanitabilir
             veya ISTERSEK 9. satiri atlayip Selenium'un kendi driver'larini kullanabiliriz
         */

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        driver.navigate().to("https://www.wisequarter.com");

        // 28.satir ile 26.satir islev acisindan aynidir.
        Thread.sleep(2000);

        // tekrar testomasyona donun
        driver.navigate().back();

        Thread.sleep(2000);
        // bir daha wisequarter'a gidelim
        driver.navigate().forward();

        Thread.sleep(2000);

        driver.navigate().refresh();



        Thread.sleep(3000);
        driver.quit();
    }
}

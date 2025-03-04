package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class C03_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","KurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();


        // 1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        // 2. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        // 3. Sayfa basliginin “Test Otomasyonu” icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else System.out.println("Title testi FAILED");

        // 4. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        // 5. Sayfa url’inin https://testotomasyonu.com/ oldugunu test edin.
        String exceptedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(exceptedUrl)){
            System.out.println("Url testi PASSED");
        }else System.out.println("Url testi FAILED");

        // 6. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        // 7. Sayfa HTML kodlarinda “otomasyon” kelimesi gectigini test edin
        String exceptedCode = "otomasyon";
        String actualCode = driver.getPageSource();

        if (actualCode.contains(exceptedCode)){
            System.out.println("Sayfa kaynagi testi PASSED");
        }else System.out.println("Sayfa kaynagi testi FAILED");

        // 8. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.quit();


    }
}

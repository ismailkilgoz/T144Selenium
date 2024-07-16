package day04_xpath_CssSelector_relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_XPath {

    public static void main(String[] args) throws InterruptedException {

        // 1- bir class olusturun
        System.setProperty("webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        // 3- Browseri tam sayfa yapin
        // driver.manage().window().fullscreen();

        // 4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        // 5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Sayfa basligi testi PASSED");
        }else System.out.println("Sayfa basligi testi FAILED");

        // 6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();

        // 7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minkutusu = driver.findElement(By.xpath("//*[@name='min']"));
        minkutusu.clear();
        minkutusu.sendKeys("40");
        WebElement maxKutusu = driver.findElement(By.xpath("//*[@name='max']"));
        maxKutusu.clear();
        maxKutusu.sendKeys("200");
        driver.findElement(By.xpath("//*[@name='button']")).click();

        // 8- filtreleme sonucunda urun bulunabildigini test edin
        List <WebElement> urunlerList = driver.findElements(By.xpath("//*[@class='prod-title mb-3 ']"));

        if (urunlerList.size()>0){
            System.out.println("Urun bulma testi PASSED ");
        }else System.out.println("Urun bulma testi FAILED ");

        // 10-Ilk urunu tiklayin
        // driver.findElement(By.xpath("//*[text()='Product Tax']")).click();
        urunlerList.get(0).click();

        // 11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement fiyatElementi = driver.findElement(By.xpath("//span[@id='priceproduct']"));

        String fiyatStr = fiyatElementi.getText();
        fiyatStr = fiyatStr.replaceAll("\\D","");

        double fiyatDouble = Double.parseDouble(fiyatStr);  // int 5000
        fiyatDouble /= 100; // double 50.00

        if (fiyatDouble>=40 && fiyatDouble<=200){
            System.out.println("ilk urun fiyat testi PASSED");
        }else System.out.println("ilk urun fiyat testi FAILED");

        // 12-Sayfayi kapatin
        Thread.sleep(1000);
        driver.quit();
    }
}

package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_findElements {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone", Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        /*
            By.className kullanildiginda
            EGER class attribute'unun value'su space iceriyorsa
            By.className CALISMAYABILIR
         */
        List <WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        if (bulunanUrunElementleriList.size()>0){
            System.out.println("Urun sayisi testi PASSED");
        } else {
            System.out.println("Urun sayisi testi FAILED");
        }

        // bulunan tum urunlerin isimlerini yazdirin
        // System.out.println(bulunanUrunElementleriList);
        /*
            findElements() bize WebElement'lerden olusan bir liste getirir
            bu listeyi yazdirmak istedigimizde
            direk yazdirirsak, liste WebElementlerden olustugundan referanslarini yazdirir

            eger her bir webelement'in uzerindeki text'i almak istersek
            her elemani tek tek ele alip
            getText() ile uzerindeki yaziyi kullanabiliriz
         */

        for (WebElement eachElement : bulunanUrunElementleriList){
            System.out.println(eachElement.getText());
        }
        /*
            Her WebElement yazi icermeyebilir
            urun ismini iceren webelement'lerin class attribute degerleri space icerdiginden
            bu maddeyi xPath ile yapmak uzere pass geciyoruz
         */

        System.out.println(bulunanUrunElementleriList.get(0).getText());
        System.out.println(bulunanUrunElementleriList.get(1).getText());
        System.out.println(bulunanUrunElementleriList.get(2).getText());
        System.out.println(bulunanUrunElementleriList.get(3).getText());

        // ilk urunu tiklayin
        // tum urunleri liste olarak kaydettigimiz icin
        // listedeki ilk urune tiklamamiz yeterli olacaktir
        bulunanUrunElementleriList.get(0).click();

        // ilk urun sayfasinda, urun isminde case sensitive olmadan "phone" bulundugunu test edin
        WebElement urunDetaylariElementi = driver.findElement(By.className("prod-detail"));

        String expectedUrunIsimIcerigi = "phone";
        String actualUrunDetaylari = urunDetaylariElementi.getText().toLowerCase();
        if (actualUrunDetaylari.contains(expectedUrunIsimIcerigi)){
            System.out.println("Ilk urun icerik testi PASSED");
        }else {
            System.out.println("Ilk urun icerik testi FAILED");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}

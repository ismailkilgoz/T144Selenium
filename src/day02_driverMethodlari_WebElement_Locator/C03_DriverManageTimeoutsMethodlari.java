package day02_driverMethodlari_WebElement_Locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageTimeoutsMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        /*
            Thread.sleep() Java'dan gelir
            ve kodlarin calismasini bizim belirledigimiz surece durdurur.

            testi ilk defa yazarken test adimlarini gormemiz
            veya bir sunum yaptigimizda
            sunum yaptigimiz kisilere adimlari gostermemiz acisindan
            kullanimi UYGUNDUR

            Bazen de bilgisayarimizin veya internetin hizindan dolayi
            kodlar hizli ilerlediginde istedigimiz adimlari gerceklestiremeyebilir
            bu durumda MECBUR KALIRSAK Thread.sleep() kullanilabilir.

            Eger testi hazirlamayi bitirdik
            ve hiz acisindan da beklemeyi mecbur kilan bir durum yoksa
            Thread.sleep()'leri silmekte fayda vardir.

         */

        driver.quit();
    }
}

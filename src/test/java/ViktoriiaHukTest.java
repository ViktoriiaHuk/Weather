import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViktoriiaHukTest {

    // TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverChrom\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(5000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class='search-dropdown-menu']//li//span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );

        Thread.sleep(5000);

        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    // TC_11_01
    // 1.  Открыть базовую ссылку
    // 2.  Нажать на пункт меню Guide
    // 3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой
    // страницы OpenWeatherMap API guide - OpenWeatherMap.

    @Test

    public void testWenTitlePageIsOpenWeatherMapGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverChrom\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchClickGuide = driver.findElement(

                By.xpath("//div[@id = 'desktop-menu']/ul/li[1]/a")
        );
        searchClickGuide.click();

        Thread.sleep(5000);

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }


    // TC_11_02
    // 1.  Открыть базовую ссылку
    // 2.  Нажать на единицы измерения Imperial: °F, mph
    // 3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test

    public void testWenTemperatureIsF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverChrom\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "°F";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchTempF = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[2]//div[3]")
        );
        searchTempF.click();

        Thread.sleep(5000);

        WebElement searchSpanDataInPageF = driver.findElement(
                By.xpath("//div[@class ='grid-container grid-4-5']//div[2]//div[1]//span[1]")
        );

        String actualResult = searchSpanDataInPageF.getText().substring(2);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    // TC_11_03
    // 1.  Открыть базовую ссылку
    // 2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site
    // to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
    // You can allow all cookies or manage them individually.”
    // 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test

    public void testCookiesInFooterPanel() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverChrom\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. We also use non-essential " +
                "cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies " +
                "or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchPanelWithTextCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p")
        );

        String actualResult1 = searchPanelWithTextCookies.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement searchButtonInFooterPanelAllowAll = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//div/div/div/div/div/button")
        );
        String actualResult2 = searchButtonInFooterPanelAllowAll.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        WebElement searchButtonInFooterPanelManageCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//div/div/div/div/div/a")
        );

        String actualResult3 = searchButtonInFooterPanelManageCookies.getText();

        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();

    }

    //   TC_11_04
    //   1.  Открыть базовую ссылку
    //   2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test

    public void testMenuSupportHas3Menu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\DriverChrom\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

        driver.get(url);

        Thread.sleep(5000);

        WebElement searchMenuSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        searchMenuSupport.click();


        WebElement searchSupportDropDownMenuFAQ = driver.findElement(
                By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[1]/a")
        );
        WebElement searchSupportDropDownMenuHowToStart = driver.findElement(
                By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[2]/a")
        );
        WebElement searchSupportDropDownMenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@class = 'dropdown-menu dropdown-visible']/li[3]/a")
        );

        String actualResult1 = searchSupportDropDownMenuFAQ.getText();
        String actualResult2 = searchSupportDropDownMenuHowToStart.getText();
        String actualResult3 = searchSupportDropDownMenuAskAQuestion.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

    }





}






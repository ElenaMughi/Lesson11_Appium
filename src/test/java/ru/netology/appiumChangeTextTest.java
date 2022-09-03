package ru.netology;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class appiumChangeTextTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Pixel");
        desiredCapabilities.setCapability("appium:app", "C:\\Mobile\\Lesson11_Appium\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testChangeActivityText() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el1.sendKeys("Netology");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el2.click();
        MobileElement els1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");

        Assertions.assertEquals("Netology", els1.getText());
    }

    @Test
    public void testChangeEmptyText() {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el1.sendKeys(" ");
        MobileElement el2 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el2.click();
        MobileElement els1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");

        Assertions.assertEquals("Hello UiAutomator!", els1.getText());
    }

    @Test
    public void testChangeText() {
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el3.sendKeys(" Netology student");
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el4.click();
        MobileElement els1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");

        Assertions.assertEquals(" Netology student", els1.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}

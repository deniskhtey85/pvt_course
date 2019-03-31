package webdriverDecorator;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDec {
	
	@Test
	    public void testCustomDriver(){
	  
	        WebDriver cromeDriver = new ChromeDriver();
	        WebDriver decoratedDriver = new ChromeDriverDecorator(cromeDriver);
	        decoratedDriver.get("http://www.mail.ru");
	        decoratedDriver.findElement(By.xpath("//h3[contains(text(),'ТВ-программа')]")).click();
	        decoratedDriver.quit();
	    }

}

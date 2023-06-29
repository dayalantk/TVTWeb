package TVT.TVT;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import java.util.*;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

public class Title {
    public String baseUrl = "https://web.tvt-test.com/";
    String driverPath = "/usr/bin/geckodriver";
    public WebDriver driver ;

       @Test
		public void login() throws IOException
		{
		System.setProperty("webdriver.gecko.driver","/usr/bin/geckodriver"); // Setting system properties of FirefoxDriver
		driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		
        driver.findElement(By.id("username")).sendKeys("john.doe@shtvtwebtest.onmicrosoft.com"); //name locator for text box
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("Laca@8328");
		driver.findElement(By.xpath("//input[contains(@value,'Sign in')]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Yes')]")).click();
        
			
		}
       @Test(priority=1)
       public void CreateProject() throws InterruptedException
		{   
		driver.findElement(By.xpath("//h2[contains(text(),'Create New')]")).click();
		Thread.sleep(2000);
    	}
       @Test(priority=2)
       public void OriginalUpload() throws InterruptedException,JavascriptException
		{   
		WebElement drop = driver.findElement(By.id("OriginalFiles"));
		drop.sendKeys("/home/dayalan/Documents/instagramscreenshot.docx");
    	}
       @Test(priority=3)
       public void CopyUpload() throws InterruptedException
		{   
		  WebElement drop = driver.findElement(By.id("CopyFiles"));
   		  drop.sendKeys("/home/dayalan/Documents/arithmetic.docx");
       	
		}
       
       @Test(priority=4)
       public void cartonsClicked() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Cartons";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Cartons clicked");
    			   break;
    		   }
    	   }
       }
       @Test(priority=5)
       public void cartonswithclonesClicked() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Cartons with Clones";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Cartons with Clones is clicked");
    			   break;
    		   }
    	   }
       }
       
       @Test(priority=6)
       public void cartonsqrdhuman() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Cartons QRD Human";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Cartons QRD is clicked");
    			   break;
    		   }
    	   }
       }
       
       @Test(priority=7)
       public void cartonsqrdveterinary() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Cartons QRD Veterinary";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Cartons QRD Veterinary is clicked");
    			   break;
    		   }
    	   }
       } 
       
       @Test(priority=8)
       public void Documents() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Documents";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Documents is clicked");
    			   break;
    		   }
    		   
    	   }
       }
       
       @Test(priority=9)
       public void Documents_Complex_Languages() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Documents (Complex Languages)";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Documents (Complex Languages) is clicked");
    			   break;
    		   }
    	   }
       }
       
       
       @Test(priority=10)
       public void Documents_without_hyphenation_check() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Documents (without hyphenation check)";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Documents (without hyphenation check) is clicked");
    			   break;
    		   }
    	   }
       }
       @Test(priority=11)
       public void Leaflets_Complex_Languages() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Leaflets (Complex Languages)";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Leaflets (Complex Languages) is clicked");
    			   break;
    		   }
    		   
    	   }
       }
       @Test(priority=12)
       public void Leaflets() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Leaflets";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Leaflets is clicked");
    			   break;
    		   }
    		   
    	   }
       } 
       
       @Test(priority=13)
       public void LeafletswithspecialPDFs() throws InterruptedException
       {
    	   WebElement select  = driver.findElement(By.xpath("//select"));
    	   select.click();
    	   List<WebElement> allOptions = driver.findElements(By.cssSelector("select option"));
    	   String option = "Leaflets with special PDFs";
    	   for(int i=0; i<allOptions.size(); i++)
    	   {
    		   if(allOptions.get(i).getText().contains(option))
    		   {
    			   allOptions.get(i).click();
    			   System.out.println("Leaflets with special PDFs is clicked");
    			   break;
    		   }
  
    	   }
       }
       	   
    	
    	
    	   @Test(priority=14)
    	   	public void addfile() throws InterruptedException
    	   	{
    	        WebElement drop = driver.findElement(By.id("OriginalFiles"));
    			drop.sendKeys("/home/dayalan/Downloads/RENTAL AGREEMENT.docx");
    	   	}
        
    	 
         
       @Test(priority=15)
       public void tick() throws InterruptedException
		{ 
		  
		  WebElement tick = driver.findElement(By.xpath("//img[@src='/icons/tick.svg']"));
		  By tick1 = By.xpath("//img[@src='/icons/tick.svg']");
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(tick1)); 
		  tick.click();
       	
		}
       
       
       @Test(priority=16)
       public void compare() throws InterruptedException
		{ 
    	   
    	   By tick1 = By.xpath("//img[starts-with(@src,'/icons/compare.svg')]");
		   WebDriverWait wait = new WebDriverWait(driver,300);
		   wait.until(ExpectedConditions.elementToBeClickable(tick1)); 
		   driver.manage().window().maximize();
		   WebElement compare=driver.findElement(By.xpath("//img[starts-with(@src,'/icons/mouseover/compare.svg')]"));
		   ((JavascriptExecutor)driver).executeScript("arguments[0].click();",compare);
		  		
		  
          WebElement imagesFirst = driver.findElement(By.xpath("//div[contains(text(),'Images')]/span[1]"));
          String imgFirst = imagesFirst.getText();
          System.out.println("lEFT IMAGE"+imgFirst);
          WebElement imagesSecond = driver.findElement(By.xpath("//div[contains(text(),'Images')]/span[2]"));
          String imgSecond = imagesSecond.getText();
          System.out.println("RIGHT IMAGE"+imgSecond);
          SoftAssert soft_assert1 = new SoftAssert();
          soft_assert1.assertEquals(imgFirst,imgSecond,"Images count have difference");
          soft_assert1.assertAll();
          WebElement barFirst = driver.findElement(By.xpath("//div[contains(text(),'Barcodes')]/span[1]"));
          String barcodeFirst = barFirst.getText();
          System.out.println("lEFT BARCODE"+barcodeFirst);
          WebElement barSecond = driver.findElement(By.xpath("//div[contains(text(),'Barcodes')]/span[2]"));
          String barcodeSecond= barSecond.getText();
          System.out.println("RIGHT BARCODE"+barcodeSecond);
          SoftAssert soft_assert3 = new SoftAssert();
          soft_assert3.assertEquals(barcodeFirst,barcodeSecond,"Barcode count have differences");
          soft_assert3.assertAll();
      	
          WebElement firstword = driver.findElement(By.xpath("//div[contains(text(),'Words')]/span[1]"));
          String first = firstword.getText();
          System.out.println("LEFT WORD:"+first);
          WebElement secondword = driver.findElement(By.xpath("//div[contains(text(),'Words')]/span[2]"));
          String second = secondword.getText();
          System.out.println("RIGHT WORD:"+second);
          SoftAssert soft_assert = new SoftAssert();
          soft_assert.assertEquals(first,second,"Words count have difference");
          soft_assert.assertAll();
          
		}
        
       @Test(priority=17)
       public void check() throws InterruptedException
		{   
		  By tick1 = By.xpath("//img[contains(@src,'/icons/check.svg')]");
		  WebDriverWait wait = new WebDriverWait(driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(tick1));
		  WebElement check=driver.findElement(By.xpath("//img[starts-with(@src,'/icons/mouseover/check.svg')]"));
		  ((JavascriptExecutor)driver).executeScript("arguments[0].click();",check);                                                                                                 
		}
       @Test(priority=18)
       public void Compare_Results() throws InterruptedException
		{   
		  
  		  WebElement Readingorder= driver.findElement(By.xpath("//span[contains(text(),'Reading order')]"));
		  String actual2 = Readingorder.getText();
   		  System.out.println(actual2);
   		  String expected2 = "Reading order: 0";
   		  SoftAssert soft_assert2 = new SoftAssert();
          soft_assert2.assertEquals(actual2,expected2,"Reading Order Difference is shown");
          soft_assert2.assertAll();
		  
   		  WebElement Hyphenation= driver.findElement(By.xpath("//span[contains(text(),'Hyphenation')]"));
   		  String actual3 = Hyphenation.getText();
 		  System.out.println(actual3);
 		  String expected3 = "Hyphenation: 0";
 		  SoftAssert soft_assert3 = new SoftAssert();
          soft_assert3.assertEquals(actual3,expected3,"Hyphenation found");
          soft_assert3.assertAll();
		 
   		  WebElement Criticalwords= driver.findElement(By.xpath("//span[contains(text(),'Critical words')]"));
   		  String actual4 = Criticalwords.getText();
 		  System.out.println(actual4);
 		  String expected4 = "Critical words: 0";
 		  SoftAssert soft_assert4 = new SoftAssert();
          soft_assert4.assertEquals(actual4,expected4,"Critical words difference is shown");
          soft_assert4.assertAll();
		 
 		 
 		  
   		  WebElement Spelling= driver.findElement(By.xpath("//span[contains(text(),'Spelling')]"));
   		  String actual5 = Spelling.getText();
 		  System.out.println(actual5);
 		  String expected5 = "Spelling: 0";
 		  SoftAssert soft_assert5 = new SoftAssert();
          soft_assert5.assertEquals(actual5,expected5,"Spelling difference is found");
          soft_assert5.assertAll();
		 
   		  WebElement Images= driver.findElement(By.xpath("//span[contains(text(),'Images')]"));
   		  String actual6 = Images.getText();
 		  System.out.println(actual6);
 		  String expected6 = "Images: 0";
 		  SoftAssert soft_assert6 = new SoftAssert();
          soft_assert6.assertEquals(actual6,expected6,"Image difference found");
          soft_assert6.assertAll();
		 
 		  
   		  WebElement Barcodes= driver.findElement(By.xpath("//span[contains(text(),'Barcodes')]"));
   		  String actual7 = Barcodes.getText();
 		  System.out.println(actual7);
 		  String expected7 = "Barcodes: 0";
 		  SoftAssert soft_assert7 = new SoftAssert();
          soft_assert7.assertEquals(actual7,expected7,"Barcode difference is found");
          soft_assert7.assertAll();
		
   		  WebElement styles= driver.findElement(By.xpath("//span[contains(text(),'Styles')]"));
   		  String actual8 = styles.getText();
 		  System.out.println(actual8);
 		  String expected8 = "Styles: 0";
 		  SoftAssert soft_assert8 = new SoftAssert();
          soft_assert8.assertEquals(actual8,expected8,"Style difference is found");
          soft_assert8.assertAll();  
		
          WebElement deviation= driver.findElement(By.xpath("//span[contains(text(),'Text deviation')]"));
   		  String actual = deviation.getText();
   		  System.out.println(actual);
   		  String expected = "Text deviation: 0";
   		  SoftAssert soft_assert = new SoftAssert();
          soft_assert.assertEquals(actual,expected,"Deviation found");
          soft_assert.assertAll();
   		  
          WebElement Warning= driver.findElement(By.xpath("//span[contains(text(),'Warning')]"));
   		  String actual1 = Warning.getText();
   		  System.out.println(actual1);
 		  String expected1 = "Warning: 0";
 		  SoftAssert soft_assert1 = new SoftAssert();
          soft_assert1.assertEquals(actual1,expected1,"Warning is shown");
          soft_assert1.assertAll();
		}       
       
     
}	
















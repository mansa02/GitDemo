package LearnFramework.SeleniumFrameworkETE;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LearnFramework.BaseTest.baseTest;

public class StanaloneTestupdated extends baseTest{

	
	@Test(dataProvider="getData")
	public void placeAnOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		//String ProductName="ADIDAS ORIGINAL";
		String ToastMsgExp="Product Added To Cart";
		String ConfirmationMsgExp="Thankyou for the order.";
		
	 Product p=loginP.login(input.get("Email"),input.get("Pwd"));
		List<WebElement> listOfElement=p.getProductList();
		p.getProductName(input.get("ProductName"));
		 p.verifyToastMsg(ToastMsgExp);
		CartPage cartP= p.goToCart();
		Boolean match= cartP.verifyCart(input.get("ProductName"));
Assert.assertTrue(match);
FinalPage finalp=cartP.checkOut();

    finalp.selectCountry1("india");
   String ConfirmationMsgAct=finalp.confirmation();
   Assert.assertTrue(ConfirmationMsgAct.equalsIgnoreCase(ConfirmationMsgExp));

	}
//   @DataProvider
//   public Object[][] getData()
//   {
//	  
//	 return new Object[][] {{"mansa123@gmail.com","Mansa123","ADIDAS ORIGINAL"},{"Rinki456@gmail.com" , "Rinki@123","ZARA COAT 3"}};
//   }
//   
	
	
	//Reading data from json file
	@DataProvider
   public Object[][] getData() throws IOException
   {
	List<HashMap<String,String>> data= getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumFrameworkETE\\data\\testData.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
	//Sending data via hashmap
	
//	HashMap<String,String> hm=new HashMap<String,String>();
//	   hm.put("Email","mansa123@gmail.com");
//	   hm.put("Pwd","Mansa123");
//	   hm.put("ProductName","ADIDAS ORIGINAL");
//	   
//	   HashMap<String,String> hm1=new HashMap<String,String>();
//	   hm.put("Email","Rinki456@gmail.com");
//       hm.put("Pwd","Rinki@123");
//	   hm.put("ProductName","ZARA COAT 3");
//	   return new Object[][] {{hm},{hm1}};
	   
   }
	
	//Screenshot utility
	
 

   






//List<WebElement> suggestionsDropDown=driver.findElements(By.cssSelector(".ta-results .ta-item"));
//eSystem.out.println(suggestionsDropDown);
//suggestionsDropDown.stream().filter(search->search.equals("India")).

	//driver.close();
        
       // driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();

//		for(int i=0;i<addToCart.size();i++)
//		{
//			addToCart.get(i).click();
//			String successmsg=driver.findElement(By.xpath("//div[@class=\"ng-tns-c4-9 toast-message ng-star-inserted\"]")).getText();
//			Assert.assertEquals(successmsg, "Product Added To Cart");
//		}
//		
//		Thread.sleep(5000);
		

	}

// define groups in testNG after suit name 

//<groups>
//<run>
//<include name="smoke"></include>
//</run>
//</groups>


//<test thread-count="5" name="ErrorValidation">
//<classes>
//  <class name="LearnFramework.SeleniumFrameworkETE.ErrorValidation"/>
//</classes>
//</test> 

//<listeners>
//<listener class-name="LearnFramework.BaseTest.Listeners"></listener>
//</listeners>


//|Username          |  |Pwd      |   | Product   |
//|Rinki456@gmail.com|  |Rinki@123|   |ZARA COAT 3|

//Testing ci/cd pipleline
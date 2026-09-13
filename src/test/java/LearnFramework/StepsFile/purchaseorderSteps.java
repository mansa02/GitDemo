package LearnFramework.StepsFile;

import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.gherkin.model.When;

import LearnFramework.BaseTest.baseTest;
import LearnFramework.SeleniumFrameworkETE.CartPage;
import LearnFramework.SeleniumFrameworkETE.FinalPage;
import LearnFramework.SeleniumFrameworkETE.Product;
import LearnFramework.SeleniumFrameworkETE.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class purchaseorderSteps extends baseTest{

	public loginPage loginP;
	public Product product;
	public CartPage cartP;
	public FinalPage finalp;
	
	@Given("Launch URL")
	public void LaunchURL() throws IOException
	{
		loginP=	launchApplication();
	}
	
	@Given("^Enter login details with username (.+) and pwd (.+)$")
	public void Enter_login_Details(String Username, String Pwd)
	{
		product=loginP.login(Username, Pwd);
	}
	
	@And("^I add a (.+) in Cart$")
	public void add_Product_In_Cart(String Product)
	{
		product.getProductList();
		product.getProductName(Product);
		product.verifyToastMsg("Product Added To Cart");
	}
	@Then("^CheckOut (.+) and submit the order$")
	public void CheckOut_Product_And_Submit_Order(String Product) throws InterruptedException
	{
		cartP= product.goToCart();
		Boolean match= cartP.verifyCart(Product);
		Assert.assertTrue(match);
		finalp=cartP.checkOut();
		finalp.selectCountry1("india");
	
		
	}
	@And ("Verify the confirmation message {string}")
	public void Verify_Order_Confirmation_Msg(String string) throws InterruptedException
	{
		 String ConfirmationMsgAct=finalp.confirmation();
		   Assert.assertTrue(ConfirmationMsgAct.equalsIgnoreCase(string));
	}
	//Im adding purchase
}


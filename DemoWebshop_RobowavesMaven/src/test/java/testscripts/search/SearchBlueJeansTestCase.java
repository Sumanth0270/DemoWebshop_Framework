package testscripts.search;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import pomrepository.BlueJeansPage;
import pomrepository.DigitalDownloadsPage;
import pomrepository.ShoppingCartPage;

public class SearchBlueJeansTestCase extends BaseTest
{
	
		@Test
	public void verify_User_Is_Able_To_Add_BlueJeans_Product_To_Cart()
	{
		//Searching blue jeans
		home_Page.getSearchStoreTF().sendKeys("Blue Jeans");
		home_Page.getSearchButton().click();
		
		//Validation:Result page
		BlueJeansPage bjp=new BlueJeansPage(driver);
		Assert.assertEquals(bjp.getBlueJeans().isDisplayed(), true);
		Reporter.log("Blue Jeans result is displayed", true);
		
		//Adding blue jeans to cart
		String expProdText=bjp.getBlueJeans().getText();
		bjp.getAddToCart().click();
		
		DigitalDownloadsPage dp=new DigitalDownloadsPage(driver);
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(dp.getAddedToCartSuccessMessage()));
		
		home_Page.getShoppingCart().click();
		
		//Validation:Adding to cart
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		String actProdtext=scp.getBlueJeans().getText();
		
		Assert.assertEquals(expProdText, actProdtext);
		Reporter.log("Blue Jeans is added to Cart", true);
		
		//Increasing Quantity
		scp.getQtyTF().clear();
		scp.getQtyTF().sendKeys("5",Keys.ENTER);
		
		//Validation: Increasing quantity
		String priceText=scp.getPrice().getText();
		String qtyText=scp.getQtyTF().getAttribute("value");
		String totalText=scp.getTotal().getText();
		

		double priceNumText=Double.valueOf(priceText);
		double qtyNumText=Double.valueOf(qtyText);
		double totalNumText=Double.valueOf(totalText);
		
		double total=priceNumText*qtyNumText;
		
		Assert.assertEquals(totalNumText, total);
		Reporter.log("Quantity increased successfully",true);
		
		//Removing from cart
		for(WebElement checkbox:scp.getRemoveCheckbox())
		{
			checkbox.click();
		}
		scp.getUpdateShoppingCart().click();
		
		//Validation:Removing from Cart
		Assert.assertEquals(scp.getCartEmptySuccessMessage().isDisplayed(), true);
		Reporter.log("Removed from cart successfully", true);
	}
		
	}



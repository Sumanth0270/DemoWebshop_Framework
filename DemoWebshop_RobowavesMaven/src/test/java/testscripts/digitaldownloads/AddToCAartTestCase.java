package testscripts.digitaldownloads;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import pomrepository.DigitalDownloadsPage;
import pomrepository.ShoppingCartPage;

@Listeners(genericlibrary.ListenersImplementation.class)

public class AddToCAartTestCase 
{
	
	public class AddToCartTestCase extends BaseTest
	{
		@Test
	public void verify_User_Is_Able_To_Add_Product_To_Cart() throws InterruptedException
	{
			home_Page.getDigitalDownloads().click();
			
			//Validation	
			Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Digital downloads");
			Reporter.log("Navigated to Digital Downloads page pass",true);
			
			DigitalDownloadsPage dp=new DigitalDownloadsPage(driver);
		
			//Performing add to cart
			for(WebElement atc:dp.getAddToCart())
			{
				atc.click();
				Thread.sleep(1000);
			}
			int atcSize = dp.getAddToCart().size();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.invisibilityOf(dp.getAddedToCartSuccessMessage()));
			home_Page.getShoppingCart().click();


			
			//Verify Cart page
				ShoppingCartPage scp=new ShoppingCartPage(driver);
				
				Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Shopping Cart");
				Reporter.log("Navigated to Cart Page Successfully",true);
				
			//Verify Product added to cart
				int chkbxSize=scp.getRemoveCheckbox().size();

				Assert.assertEquals(atcSize, chkbxSize);
				Reporter.log("Products are added to Cart Successfully",true);
			//Remove from cart
				for(WebElement checkbox:scp.getRemoveCheckbox())
				{
					checkbox.click();
				}
				scp.getUpdateShoppingCart().click();
			
				Assert.assertEquals(scp.getCartEmptySuccessMessage().isDisplayed(), true);
				Reporter.log("Products are removed from Cart pass",true);
	}
	}

}

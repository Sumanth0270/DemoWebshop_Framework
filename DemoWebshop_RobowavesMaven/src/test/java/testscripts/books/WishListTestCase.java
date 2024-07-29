package testscripts.books;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import pomrepository.BooksPage;
import pomrepository.FictionExPage;
import pomrepository.WishListPage;

public class WishListTestCase extends BaseTest
{
	@Test
	public void verify_User_Is_Able_To_WishList()
	{
		home_Page.getBooks().click();
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books");
		Reporter.log("Navigated to Books page successfull",true);
		
		BooksPage books_page=new BooksPage(driver);
		String expProdName=books_page.getFictionEXName().getText();
		books_page.getFictionEXName().click();
		
		//Validate
		
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Fiction EX");
		Reporter.log("Navigated to FictionEX page successfull",true);
		
		FictionExPage product_Page=new FictionExPage(driver);
		product_Page.getAddToWishList().click();
		
		home_Page.getWishList().click();
		
		//Validate
		
		driver.navigate().refresh();
		
		WishListPage wishlist_Page=new WishListPage(driver);
		String actProdName=wishlist_Page.getFindExWishlist().getText();
		

		Assert.assertEquals(expProdName, actProdName);
		Reporter.log("verify_User_Is_Ablle_To_WishList is Pass",true);
		
		//Remove from wishlist
		List<WebElement> allRemoveCheckBox=wishlist_Page.getRemoveCheckbox();
		for(WebElement checkbox:allRemoveCheckBox)
		{
			checkbox.click();
		}
		wishlist_Page.getUpdateWishlist().click();
		
		//Validation
		Assert.assertEquals(wishlist_Page.getEmptyWishListMessage().isDisplayed(),true);
		Reporter.log("Product are removed from Wishlist",true);
		
	}
}

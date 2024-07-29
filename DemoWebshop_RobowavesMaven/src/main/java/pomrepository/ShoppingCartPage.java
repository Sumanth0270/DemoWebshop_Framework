package pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage 
{
	@FindBy(xpath = "//td[@class='remove-from-cart']/input")
	private List<WebElement> removeCheckbox;
	
	@FindBy(xpath = "//table[@class='cart']//a")
	private List<WebElement> expectedProduct;
	
	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateShoppingCart;
	
	@FindBy(xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")
	private WebElement cartEmptySuccessMessage;
	
	@FindBy(xpath = "//td[@class='product']/a")
	private WebElement blueJeans;
	
	@FindBy(xpath = "//td[@class='qty nobr']/input")
	private WebElement qtyTF;
	
	@FindBy(xpath = "//td[@class='subtotal nobr end']/span[@class='product-subtotal']")
	private WebElement total;
	
	@FindBy(xpath = "//td[@class='unit-price nobr']/span[@class='product-unit-price']")
	private WebElement price;
	

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public List<WebElement> getRemoveCheckbox() {
		return removeCheckbox;
	}

	public List<WebElement> getExpectedProduct() {
		return expectedProduct;
	}

	public WebElement getUpdateShoppingCart() {
		return updateShoppingCart;
	}

	public WebElement getCartEmptySuccessMessage() {
		return cartEmptySuccessMessage;
	}
	
	public WebElement getBlueJeans() {
		return blueJeans;
	}
	
	public WebElement getQtyTF() {
		return qtyTF;
	}
	
	public WebElement getTotal() {
		return total;
	}

	public WebElement getPrice() {
		return price;
	}

}

package pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage 
{
	@FindBy(xpath = "//input[@value='Add to cart']")
private List<WebElement> addToCart;
	
	@FindBy(xpath = "//h2[@class='product-title']/a")
	private List<WebElement> actualProduct;
	
	@FindBy(xpath = "//a[text()='shopping cart']")
	private WebElement addedToCartSuccessMessage;

	
	public DigitalDownloadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getAddedToCartSuccessMessage() {
		return addedToCartSuccessMessage;
	}

	public List<WebElement> getAddToCart() {
		return addToCart;
	}
	public List<WebElement> getActualProduct() {
		return actualProduct;
	}
}

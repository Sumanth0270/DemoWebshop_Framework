package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueJeansPage 
{
	@FindBy(xpath = "//h2[@class='product-title']/a[text()='Blue Jeans']")
private WebElement blueJeans;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCart;
	
	public BlueJeansPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getBlueJeans() {
		return blueJeans;
	}
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	
}

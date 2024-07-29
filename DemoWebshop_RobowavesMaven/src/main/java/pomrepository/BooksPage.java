package pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksPage
{
	@FindBy(id="products-orderby")
private WebElement sortBy;
	
	@FindBy(id="products-pagesize")
private WebElement display;
	
	@FindBy(id="products-viewmode")
private WebElement grid;
	
	@FindBy(xpath ="//h2[@class='product-title']/a")
private List<WebElement> fictionEX;
	
	@FindBy(xpath ="//a[text()='Fiction EX']")
	private WebElement fictionEXName;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement>addToCart;

public List<WebElement> getAddToCart() {
		return addToCart;
	}

public WebElement getFictionEXName() {
		return fictionEXName;
	}

public BooksPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getSortBy() {
	return sortBy;
}

public WebElement getDisplay() {
	return display;
}

public WebElement getGrid() {
	return grid;
}

public List<WebElement> getFictionEX() {
	return fictionEX;
}
}

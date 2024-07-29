package testscripts.register;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;
import pomrepository.RegisterPage;

public class RegiisterTestCase extends BaseTest
{
	
		@Test(dataProvider = "RegisterData")
	 public  void verify_User_Is_able_To_Register(String firstName,String lastName,String email,String password,String confirmPassword) throws EncryptedDocumentException, IOException 
		{
			home_Page.getLogOut().click();
			home_Page.getRegister().click();
			
			//Validation
		
			Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Register");
			Reporter.log("Navigated to Register page successfull",true);
			
			//Performing Register
			RegisterPage rp=new RegisterPage(driver);
			String modEmail=new Random().nextInt(3000)+email;
			rp.getMaleRadio().click();
			rp.getFirstnameTF().sendKeys(firstName);
			rp.getLastNameTF().sendKeys(lastName);
			rp.getEmailTF().sendKeys(modEmail);
			rp.getPasswordTF().sendKeys(password);
			rp.getConfirnPasswordTF().sendKeys(confirmPassword);
			rp.getRegistrButton().click();
			
			//Validation
			Assert.assertEquals(rp.getSuccessfullMessage().isDisplayed(), true);
			Reporter.log("Register Successfull",true);
			
	}
		@DataProvider(name="RegisterData")
		public Object[][] dataSupply() throws EncryptedDocumentException, IOException
		{
			return data_utility.getMultipleDataFromExcel("RegisterData");
		}
	}




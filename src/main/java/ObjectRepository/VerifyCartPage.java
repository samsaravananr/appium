package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VerifyCartPage 
{
	public VerifyCartPage(AndroidDriver<MobileElement> myD) 
	{
	
		PageFactory.initElements(new AppiumFieldDecorator(myD), this);
	}
	@AndroidFindBy(id ="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> ProductPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement TotalAmount;

}

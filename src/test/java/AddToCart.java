import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AddToCart 
{

	public AddToCart(AndroidDriver<MobileElement> myD)
	{
	myD.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\").instance(0))"));
	int vTotalItem=myD.findElementsById("com.androidsample.generalstore:id/productName").size();
	//System.out.println(vTotalItem);
	
	for (int i=0;i<vTotalItem;i++)
	{
	String vProd=myD.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
	//System.out.println(vProd +"     "+vProduct);
	if(vProd.contains("Converse All Star"))
	{
		myD.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
		myD.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i+1).click();
		break;
		
	}
	}
	myD.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
	}
}

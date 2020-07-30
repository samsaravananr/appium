import org.testng.annotations.DataProvider;

public class TestData 
{

		@DataProvider(name="InputData")
		public Object[][] getDataforEditField()
		{
			
			String[][] obj=new String[][]
					
			{ {"sam"}, {"saravanan"} };
					
					return obj;
					
		}

	

}

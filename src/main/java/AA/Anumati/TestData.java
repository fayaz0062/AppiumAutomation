package AA.Anumati;

import org.testng.annotations.DataProvider;

public class TestData {
	

	@DataProvider(name="InputDataName")
	public Object[][] getDataForPINField()
	{
		Object [][] obj= new Object[][]
				{
			{"7760305049","7760305049","0082"}
			
				};
			return obj;
				
				
	}

}

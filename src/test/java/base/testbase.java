package base;

import java.util.List;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.path.xml.element.Node;

public class testbase {
	
	@BeforeClass
	public void setup() {
		
		RestAssured.baseURI="http://www.colourlovers.com/api";
		RestAssured.basePath ="/patterns";
	}
	
	public boolean areViewsGreaterThan (List<Node> list,int number)
	{
		int NumsViewValue=0;
		for (Node NumsViewNode : list) {
			NumsViewValue = Integer.parseInt(NumsViewNode.value());			
		}
		if (NumsViewValue>number)
		return true;
		else return false;			
	}
}

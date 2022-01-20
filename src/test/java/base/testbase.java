package base;

import java.util.List;

import io.restassured.path.xml.element.Node;

public class testbase {
	
	public boolean areNodesValueGreaterThan (List<Node> list,int number)
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

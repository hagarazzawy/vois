package base;

import java.util.List;

import io.restassured.path.xml.element.Node;

public class testbase {
	
	public boolean areNodesValueGreaterThan (List<Node> list,int number)
	{
		int NodeValue=0;
		for (Node NumsViewNode : list) {
			NodeValue = Integer.parseInt(NumsViewNode.value());			
		}
		if (NodeValue>number)
		return true;
		else return false;			
	}
}

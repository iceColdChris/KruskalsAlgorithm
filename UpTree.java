import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;




public class UpTree {
	Map<Object, UpTreeNode> forest = new HashMap<Object, UpTreeNode>();

	public UpTree(LinkedList<Vertex> list){
		for(Vertex v : list){
			makeUpTreeNode(v.getName());
		}
	}
	
	
	public Object find(Object o){
		UpTree.UpTreeNode node = (UpTree.UpTreeNode)forest.get(o);
		if(node == null)
			return null;
		if(o != node.parent)
			return node.parent = find(node.parent);
		
		
		return node.parent;
		
	}
	
	public void union(Object a, Object b){
		Object set1 = find(a);
		Object set2 = find(b);
		
		if (set1 == null || set2 == null || set1 == set2)
			return;
		
		UpTree.UpTreeNode node1 = (UpTree.UpTreeNode) forest.get(set1);
		UpTree.UpTreeNode node2 = (UpTree.UpTreeNode) forest.get(set2);
		
		if(node1.numOfChildren < node2.numOfChildren){
			node2.parent = node1;
			node2.numOfChildren += node1.numOfChildren;
		} else {
			node1.parent = node2;
			node1.numOfChildren += node2.numOfChildren;
		}
		
		
	}
	
	private void makeUpTreeNode(Object o) {
		forest.put(o, new UpTreeNode(o, 0));
	}

	
	private class UpTreeNode{
		Object parent;
		int numOfChildren;
		
		UpTreeNode(Object parent, int numOfChildren){
			this.parent = parent;
			this.numOfChildren = numOfChildren;
		}
	}
}

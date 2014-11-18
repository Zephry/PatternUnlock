import java.util.ArrayList;
import java.util.List;


public class Node {
	int x;
	int y;
	int nodeType;
	boolean viewed;
	List<Integer> neigh;
	List<Integer> newLeftRowNeigh;
	List<Integer> newRightRowNeigh;
	List<Integer> newCenterNeigh;
	List<Integer> shouldChangeNode;	
	List<Integer> shouldChangeLeftCornNode;	
	List<Integer> shouldChangeRightCornNode;	
	Node(int x, int y, int type) {
		this.x = x;
		this.y = y;
		nodeType = type;
		neigh = new ArrayList<Integer>();
		newLeftRowNeigh = new ArrayList<Integer>();
		newRightRowNeigh = new ArrayList<Integer>();
		newCenterNeigh = new ArrayList<Integer>();
		shouldChangeNode = new ArrayList<Integer>();
		shouldChangeLeftCornNode = new ArrayList<Integer>();
		shouldChangeRightCornNode = new ArrayList<Integer>();
	}
	Node(int x, int y, int type, boolean viewed) {
		this.x = x;
		this.y = y;
		this.viewed = viewed;
		nodeType = type;
		neigh = new ArrayList<Integer>();
		newLeftRowNeigh = new ArrayList<Integer>();
		newRightRowNeigh = new ArrayList<Integer>();
		newCenterNeigh = new ArrayList<Integer>();
		shouldChangeNode = new ArrayList<Integer>();
		shouldChangeLeftCornNode = new ArrayList<Integer>();
		shouldChangeRightCornNode = new ArrayList<Integer>();
	}
	public Node copy() {
		Node newNode = new Node(this.x, this.y, this.nodeType, this.viewed);
		newNode.neigh = new ArrayList<Integer>(neigh);
		newNode.newLeftRowNeigh = new ArrayList<Integer>(newLeftRowNeigh);
		newNode.newRightRowNeigh = new ArrayList<Integer>(newRightRowNeigh);
		newNode.newCenterNeigh = new ArrayList<Integer>(newCenterNeigh);
		newNode.shouldChangeNode = new ArrayList<Integer>(shouldChangeNode);
		newNode.shouldChangeLeftCornNode = new ArrayList<Integer>(shouldChangeLeftCornNode);
		newNode.shouldChangeRightCornNode = new ArrayList<Integer>(shouldChangeRightCornNode);
		return newNode;
	}
}

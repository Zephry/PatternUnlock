
public class Solution {
	final static int CENTERNODE = 0;
	final static int ROWNODE = 1;
	final static int CORNERNODE = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLongestDis());
	}
	
	
	public static double findLongestDis() {
		
		
		Node[] nodes = new Node[9];
		nodes[0] = new Node(-1,1,CORNERNODE);	nodes[1] = new Node(0,1,ROWNODE);	nodes[2] = new Node(1,1,CORNERNODE);
		nodes[3] = new Node(-1,0,ROWNODE);		nodes[4] = new Node(0,0,CENTERNODE);nodes[5] = new Node(1,0,ROWNODE);
		nodes[6] = new Node(-1,-1,CORNERNODE);	nodes[7] = new Node(0,-1,ROWNODE);	nodes[8] = new Node(1,-1,CORNERNODE);	
		//Corner
		nodes[0].neigh.add(1);
		nodes[0].neigh.add(3);
		nodes[0].neigh.add(4);
		nodes[0].neigh.add(7);
		nodes[0].neigh.add(5);
		nodes[0].newRightRowNeigh.add(6);
		nodes[0].newLeftRowNeigh.add(2);
		nodes[0].newCenterNeigh.add(8);
		
		nodes[2].neigh.add(1);
		nodes[2].neigh.add(5);
		nodes[2].neigh.add(4);
		nodes[2].neigh.add(7);
		nodes[2].neigh.add(3);
		nodes[2].newRightRowNeigh.add(0);
		nodes[2].newCenterNeigh.add(6);
		nodes[2].newLeftRowNeigh.add(8);
		
		nodes[6].neigh.add(1);
		nodes[6].neigh.add(5);
		nodes[6].neigh.add(4);
		nodes[6].neigh.add(7);
		nodes[6].neigh.add(3);
		nodes[6].newLeftRowNeigh.add(0);
		nodes[6].newCenterNeigh.add(2);
		nodes[6].newRightRowNeigh.add(8);
		
		nodes[8].neigh.add(1);
		nodes[8].neigh.add(5);
		nodes[8].neigh.add(4);
		nodes[8].neigh.add(7);
		nodes[8].neigh.add(3);
		nodes[8].newCenterNeigh.add(0);
		nodes[8].newRightRowNeigh.add(2);
		nodes[8].newLeftRowNeigh.add(6);
		
		
		//Row
		nodes[1].neigh.add(0);
		nodes[1].neigh.add(3);
		nodes[1].neigh.add(6);
		nodes[1].neigh.add(4);
		nodes[1].neigh.add(8);
		nodes[1].neigh.add(5);
		nodes[1].neigh.add(2);
		nodes[1].newCenterNeigh.add(7);
		nodes[1].shouldChangeLeftCornNode.add(0);
		nodes[1].shouldChangeRightCornNode.add(2);
		
		nodes[3].neigh.add(0);
		nodes[3].neigh.add(1);
		nodes[3].neigh.add(3);
		nodes[3].neigh.add(4);
		nodes[3].neigh.add(8);
		nodes[3].neigh.add(7);
		nodes[3].neigh.add(2);
		nodes[3].newCenterNeigh.add(5);
		nodes[3].shouldChangeRightCornNode.add(0);
		nodes[3].shouldChangeLeftCornNode.add(6);
		
		nodes[7].neigh.add(0);
		nodes[7].neigh.add(5);
		nodes[7].neigh.add(6);
		nodes[7].neigh.add(4);
		nodes[7].neigh.add(8);
		nodes[7].neigh.add(3);
		nodes[7].neigh.add(2);
		nodes[7].newCenterNeigh.add(1);
		nodes[7].shouldChangeLeftCornNode.add(8);
		nodes[7].shouldChangeRightCornNode.add(6);
		
		nodes[5].neigh.add(0);
		nodes[5].neigh.add(1);
		nodes[5].neigh.add(6);
		nodes[5].neigh.add(4);
		nodes[5].neigh.add(8);
		nodes[5].neigh.add(7);
		nodes[5].neigh.add(2);
		nodes[5].newCenterNeigh.add(3);
		nodes[5].shouldChangeLeftCornNode.add(2);
		nodes[5].shouldChangeRightCornNode.add(8);
		
		//Center
		nodes[4].neigh.add(0);
		nodes[4].neigh.add(1);
		nodes[4].neigh.add(2);
		nodes[4].neigh.add(3);
		nodes[4].neigh.add(5);
		nodes[4].neigh.add(6);
		nodes[4].neigh.add(7);
		nodes[4].neigh.add(8);
		nodes[4].shouldChangeNode.add(0);
		nodes[4].shouldChangeNode.add(1);
		nodes[4].shouldChangeNode.add(2);
		nodes[4].shouldChangeNode.add(3);
		nodes[4].shouldChangeNode.add(5);
		nodes[4].shouldChangeNode.add(6);
		nodes[4].shouldChangeNode.add(7);
		nodes[4].shouldChangeNode.add(8);
		

		double max = 0;
		Node[] tmpNodes = new Node[9];
		for(int m=0;m<9;m++) {
			tmpNodes[m] = nodes[m].copy();
		}
		
		tmpNodes = viewNode(tmpNodes, tmpNodes[0]);			//Start from Corner Node
		max = findDis(0, tmpNodes[0], tmpNodes, 0, max);
		
		for(int m=0;m<9;m++) {
			tmpNodes[m] = nodes[m].copy();
		}
		tmpNodes = viewNode(tmpNodes, tmpNodes[1]);			//Start from Row Node
		double tmp = findDis(0, tmpNodes[1], tmpNodes, 0, max);
		if(tmp > max) {
			max = tmp;
		}
		
		for(int m=0;m<9;m++) {
			tmpNodes[m] = nodes[m].copy();
		}
		tmpNodes = viewNode(tmpNodes, tmpNodes[4]);			//Start from Center Node
		tmp = findDis(0, tmpNodes[4], tmpNodes, 0, max);
		if(tmp > max) {
			max = tmp;
		}
		return max;
	}
	
	public static double findDis(double current, Node lastNode, Node[] nodes, int count, double max) {
		if(count == 8) {
			return current;
		}
		for(int i=0;i<lastNode.neigh.size();i++) {
			Node currentNode = nodes[lastNode.neigh.get(i)];
			if(!currentNode.viewed) {
				Node[] tmp = new Node[9];
				for(int m=0;m<9;m++) {
					tmp[m] = nodes[m].copy();
				}
				
				nodes = viewNode(nodes, currentNode);
				double result = findDis(current + calculateDis(lastNode, currentNode), currentNode, nodes, count+1, max);
				
				if(result > max) {
					max = result;
					
				}
				nodes = tmp;
				
			}
		}
		return max;
	}
	
	private static Node[] viewNode(Node[] nodes, Node currentNode) {
		boolean center = false;
		if(currentNode.nodeType == CENTERNODE) {
			center = true;
		}
		currentNode.viewed = true;
		if(center) {
			for(int i=0;i<currentNode.shouldChangeNode.size();i++) {
				nodes[currentNode.shouldChangeNode.get(i)].neigh.addAll(nodes[currentNode.shouldChangeNode.get(i)].newCenterNeigh);
			}
		}else {
			for(int i=0;i<currentNode.shouldChangeLeftCornNode.size();i++) {
				nodes[currentNode.shouldChangeLeftCornNode.get(i)].neigh.addAll(nodes[currentNode.shouldChangeLeftCornNode.get(i)].newLeftRowNeigh);
			}
			for(int i=0;i<currentNode.shouldChangeRightCornNode.size();i++) {
				nodes[currentNode.shouldChangeRightCornNode.get(i)].neigh.addAll(nodes[currentNode.shouldChangeRightCornNode.get(i)].newRightRowNeigh);
			}
		}
		return nodes;
	}
	
	private static double calculateDis(Node last, Node current) {
		int x = last.x - current.x;
		int y = last.y - current.y;
		double dis = Math.sqrt((x*x)+(y*y));
		return dis;
	}
}

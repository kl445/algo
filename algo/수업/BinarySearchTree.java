package algo_day7;


public class BinarySearchTree {
	
	private static Node root;
	
	static class Node{
		int v;
		Node l, r, p;
		
		@Override
		//자식 객체를 그대로 쓰는경우 자식의 스트링 무한 호출 및 널포인터 조심
		public String toString() {
			StringBuilder sb= new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(l==null?"n":l.v).append(",")
			.append(r==null?"n":r.v).append(",")
			.append(p==null?"n":p.v).append(")");
			return sb.toString();
		}

		public Node(int v) {
			this.v = v;
		}
		
		
	}
	//v에 해당하는 노드를 추가하고 결과 반환.
	public static boolean addNode(int v) {
		
		Node newNode=new Node(v);
		
		
		//root가 없는경우  
		if(root==null) {
			root=newNode;
			return true;
		}
		
		Node current= root;
		
		while(true) {
			
			//이미 동일한 노드가 있는경우
			if(current.v==v) {
				return false;
			}
			//현재 노드가 더 커서 왼쪽으로 이동
			else if(current.v>v) {
				//왼쪽으로 가는데
				if(current.l==null) {
					current.l=newNode;
					newNode.p=current;
					return true;
				}else {
					current=current.l;
				}
			}
			else {
				if(current.r==null) {
					current.r=newNode;
					newNode.p=current;
					return true;
				}
				else {
					current=current.r;
				}
				
			}
		}
		
		
	}
	public static Node search(int v) {
		if(root==null) {
			return null;
		}
		else {
			Node current= root;
			
			
			while(true) {
				if(current.v==v) {
					return current;
				}
				else if (current.v>v) {
					current=current.l;
				}
				else{
					current=current.r;
				}
			}
		}
	}
	
	public static boolean deleteNode(int v) {
		Node target= search(v);
		if(target==null) {
			return false;
		}
		else if(target.l==null && target.r==null) {
			if(target.p.l==target) {
				target.p.l=null;
			}else {
				target.p.r=null;
			}
		}
		else if(target.l==null || target.r==null) {
			Node child= target.l==null? target.r: target.l;
			
			if(target.p.l==target) {
				target.p.l=child;
				child.p=target.p;
			}
			else  {
				target.p.r=child;
				child.p=target.p;
			}
		}
		else {
			//왼쪽의 서브 트리에서 가장 큰 오른쪽 자식이 null인것 찾기

		Node max= target.l;
		
		while(max.r!=null) {
			max=max.r;
		}
		int newV=max.v;
		deleteNode(max.v);
		target.v=newV;
		}
		
		return true;
	}
	public static void main(String[] args) {
		
		int[]nums= {9,4,3,6,12,15,13,17};
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("삽입 연산: %d %b %n",nums[i],addNode(nums[i]));
			
		}
		
		System.out.printf("%d노드: %s%n",9,search(9));
		
		System.out.println();
		
		System.out.printf("%d 노드 삭제: %b: %s%n",13,deleteNode(13),search(15));
		System.out.printf("%d 노드 삭제: %b: %s%n",12,deleteNode(12),search(9));
		System.out.printf("%d 노드 삭제: %b: %s%n",9,deleteNode(9),search(6));
		
		

	}

}

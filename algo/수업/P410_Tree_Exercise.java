package algo_day7;

import java.util.Arrays;

public class P410_Tree_Exercise {

	private static int V=13;
	
	private static String src="1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13";
	
	private static Node[] tree=null;
	
	private static void makeTre() {
		//tree는 1번부터 시작
		
		tree=new Node[V+1];
		
		String[] splited=src.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int parent=Integer.parseInt(splited[i]);
			int child=Integer.parseInt(splited[i+1]);
//			System.out.println(parent+" : "+child);
			Node pNode=getNode(parent);
			Node cNode= getNode(child);
			
			//노드 관계 설정
			
			if(pNode.l==null) {
				pNode.l=cNode;
			}
			else {
				pNode.r=cNode;
			}
		}
		System.out.println(Arrays.toString(tree));
	}
	
	public static Node getNode(int v) {
		if(tree[v]==null) {
			tree[v]= new Node(v);
		}
		return tree[v];
	}
	
	
	static class Node{
		int v;
		Node l, r;
		
		@Override
		//자식 객체를 그대로 쓰는경우 자식의 스트링 무한 호출 및 널포인터 조심
		public String toString() {
			StringBuilder sb= new StringBuilder();
			sb.append("(").append(v).append(",")
			.append(l==null?"n":l.v).append(",")
			.append(r==null?"n":r.v).append(")");
			return sb.toString();
		}

		public Node(int v) {
			this.v = v;
		}
		
		
	}
	
	
	public static void preorder(Node tree) {
		
		if(tree!=null) {
			System.out.print(tree+", ");
			preorder(tree.l);
			preorder(tree.r);
		}
	}
	public static void inorder(Node tree) {
		
		if(tree!=null) {
			
			inorder(tree.l);
			System.out.print(tree+", ");
			inorder(tree.r);
		}
	}
	public static void postorder(Node tree) {
		
		if(tree!=null) {
			postorder(tree.l);
			postorder(tree.r);
			System.out.print(tree+", ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		makeTre();
		
		
		System.out.println("전위");
		preorder(tree[1]);
		System.out.println();
		System.out.println("중위");
		inorder(tree[1]);
		System.out.println();
		System.out.println("후위");
		postorder(tree[1]);
		
	}
	
}

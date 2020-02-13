package swea_0213;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;



public class SWEA_1231_D4_중위순회 {

	static class Node{
		
		char c;
		int v;
		int r_node;
		int l_node;
		Node r;
		Node l;
		public Node(int v,char c) {
			this.v = v;
			this.c =c;
		}
		@Override
		public String toString() {
			return "Node [c=" + c + ", r=" + r + ", l=" + l + "]";
		}
	}
	
	private static Node tree;
	
	public static void makeNode(String str[] ) {
		
		int v=0;
		char c;
		int l_num=0;
		int r_num=0;
		
		if(str.length==2) {
			v=Integer.parseInt(str[0]);
			c=str[1].charAt(0);
		}
		else if(str.length==3){
			v=Integer.parseInt(str[0]);
			c=str[1].charAt(0);
			l_num=Integer.parseInt(str[2]);
		}
		else {
			v=Integer.parseInt(str[0]);
			c=str[1].charAt(0);
			l_num=Integer.parseInt(str[2]);
			r_num=Integer.parseInt(str[3]);
		}
		
		
		Node newNode=new Node(v,c);
		
		newNode.l_node=l_num;
		newNode.r_node=r_num;
		
		if(tree==null) {
			tree=newNode;
			return;
		}
		
		Node current= tree;
		inadd(current,newNode);
		}
	
	public static void inadd(Node current,Node newNode) {
		
			
			if(current==null) {
				return;
			}
			
			if(current.v==newNode.v) {
				return ;
			}
			
			if(current.l_node==newNode.v) {
				current.l=newNode;
				return;
			}
			else if(current.r_node==newNode.v){
				current.r=newNode;
				return;
			}
			else {
				inadd(current.l,newNode);
				inadd(current.r,newNode);
			}
		
		
			
		
		
		
	}
	
public static void inorder(Node tree) {
		
		if(tree!=null) {
			
			inorder(tree.l);
			System.out.print(tree.c);
			inorder(tree.r);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Scanner sc =new Scanner(System.in);
		
		for (int i =1; i <=10; i++) {
			
			
			int n=sc.nextInt();
			sc.nextLine();
			
			for (int j = 0; j < n; j++) {
				String str= sc.nextLine();
				
				str=str.split("\n")[0];
				
				String[] spli=str.split(" ");
				
//				System.out.println(Arrays.toString(spli));
				
				makeNode(spli);
				
				
				
			}
			
			
			System.out.print("#"+i+" ");
			inorder(tree);
			System.out.println();
			
		}
		
		
		
		
	
	}

}

package algo_day5;

import java.awt.GradientPaint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.w3c.dom.stylesheets.LinkStyle;

public class MakeGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeGraph();
		System.out.println();
		makeGraph2();
		System.out.println();
		makeGraph3();
		System.out.println();
		makeGrap4();
		System.out.println();
		makeGrap5();
		System.out.println();
		makeGrap6();
	}

	public static void makeGraph() {
		int v = 6;

		String src = "1 2 1 5 2 5 5 4 2 4 4 3 4 6 2 3";

//		위 정보를 이용해 그래프 만들기

		int[][] graph = new int[6 + 1][6 + 1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);

			graph[a][b] = 1;
			graph[b][a] = 1;

		}

		for (int[] row : graph) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void makeGraph2() {
		int v = 6;

		String src = "1 2 1 5 2 5 5 4 2 4 4 3 4 6 2 3";

//		위 정보를 이용해 그래프 만들기

		int[][] graph = new int[6 + 1][6 + 1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);

			graph[a][b] = 1;

		}

		for (int[] row : graph) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void makeGraph3() {
		int v = 7;

		String src = "1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";

//	위 정보를 이용해 그래프 만들기

		int[][] graph = new int[6 + 1][6 + 1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);
			int w = Integer.parseInt(splited[i + 2]);

			graph[a][b] = w;

		}
		int[] temp = new int[10];
		Arrays.fill(temp, -1);

		for (int[] row : graph) {
			System.out.println(Arrays.toString(row));
		}

//		for (int[] row : graph) {
//			Arrays.fill(temp, -1);
//		}
	}

	public static void makeGrap4() {
		int v = 7;

		String src = "1 2 1 3 1 6 1 7 6 4 6 5 5 4 7 5";

//		위 정보를 이용해 그래프 만들기

		List<Integer>[] graph = new List[v + 1];

		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

//			int[][] graph= new int[6+1][6+1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);
			graph[a].add(b);
			graph[b].add(a);

		}

		for (int j = 0; j < graph.length; j++) {
			System.out.println(j + " > " + graph[j]);
		}

	}

	public static void makeGrap5() {
		int v = 7;

		String src = "1 2 1 3 1 6 1 7 6 4 6 5 5 4 7 5";

//		위 정보를 이용해 그래프 만들기

		List<Integer>[] graph = new List[v + 1];

		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

//			int[][] graph= new int[6+1][6+1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);
			graph[a].add(b);
//			graph[b].add(a);

		}

		for (int j = 0; j < graph.length; j++) {
			System.out.println(j + " > " + graph[j]);
		}

	}

	public static void makeGrap6() {
		int v = 7;

		String src = "1 2 2 1 3 4 1 6 1 1 7 3 6 4 6 6 5 1 5 4 2 7 5 4";

//		위 정보를 이용해 그래프 만들기

		List<Pair>[] graph = new List[v + 1];

		for (int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

//			int[][] graph= new int[6+1][6+1];

		String[] splited = src.split(" ");

		for (int i = 0; i < splited.length; i += 3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i + 1]);
			int w = Integer.parseInt(splited[i + 2]);
			graph[a].add(new Pair(b,w));
//			graph[b].add(a);

		}

		for (int j = 0; j < graph.length; j++) {
			System.out.println(j + " > " + graph[j]);
		}

	}
	static class Pair{
		// 관리가 필요한 정보들을 변수로 선언
		
		int n;
		int w;
		public Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
		@Override
		public String toString() {
			return "[n=" + n + ", w=" + w + "]";
		}
		
		
	}
	

}

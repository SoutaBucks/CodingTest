package baekjoon;
//https://www.acmicpc.net/problem/10828
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;

class Stack {
	LinkedList<Integer> list = new LinkedList<>();
	
	public void push(int x) {
		list.add(x);
	}
	
	public void pop() {
		if(list.isEmpty())
			System.out.println(-1);
		else
			System.out.println(list.removeLast());
	}
	
	public void size() {
		System.out.println(list.size());
	}
	
	public void empty() {
		if(list.isEmpty())
			System.out.println(1);
		else
			System.out.println(0);
	}
	
	public void top() {
		if(list.isEmpty())
			System.out.println(-1);
		else
			System.out.println(list.peekLast());
	}
}

public class Main {
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		Stack mys = new Stack();
		String[] ipt = null;
		
		for(int i = 0; i < n; i++) {
			ipt = bf.readLine().split(" ");
			if(ipt[0].equals("push")) 
				mys.push(Integer.parseInt(ipt[1]));
			else if(ipt[0].equals("pop")) 
				mys.pop();
			else if(ipt[0].equals("size")) 
				mys.size();
			else if(ipt[0].equals("empty")) 
				mys.empty();
			else
				mys.top();
		}
		
		bw.flush();
		bw.close();
	} 
}   
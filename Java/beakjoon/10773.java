package baekjoon;
//https://www.acmicpc.net/problem/10773
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Deque;
import java.io.IOException;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static Deque<Integer> makestack(int N) throws IOException	 {
		Deque<Integer> stack = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(bf.readLine());

			if (num == 0) {								// 0이 입력되면
				if (stack.isEmpty())				// 스택이 비어있따면
					stack.add(0);							// 0을 넣는다
				else												// 숫자가 들어있다면
					stack.removeLast();			  // 제일 위 숫자를 제거한다
			}
			else
				stack.add(num);
		}

		return stack;
	}
	
	public static int sum(Deque<Integer> st) {
		int ans = 0;
		if (st.isEmpty())
			ans = 0;
		else {
			for(Integer e : st) 
				ans += e;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException	{	
		int N = Integer.parseInt(bf.readLine());
		int answer = sum(makestack(N));
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		
	} 
}   
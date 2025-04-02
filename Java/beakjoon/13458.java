package baekjoon;
//https://www.acmicpc.net/problem/13458
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	/* 1. 총 시험장 개수
	 * 2. 각 시험장 당 총 감독관을 넣는다
	 * 3. 부족하면 부감독관을 채워 넣는다
	 * */
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());					// 시험장 갯수
		String[] s_test_p = bf.readLine().split(" ");			// 시험장 당 인원   (string
		String[] s_n_test_p = bf.readLine().split(" ");		// 감독관 당 인원   (string
		long[] test_p = new long[n];												// 시험장 당 인원		(int
		long first_see  = Integer.parseInt(s_n_test_p[0]);	// 총 감독관 최대 인원
		long second_see = Integer.parseInt(s_n_test_p[1]);	// 부 감독관 최대 인원
		
		for(int i = 0; i < n; i++)												// 시험장 당 인원
			test_p[i] = Integer.parseInt(s_test_p[i]);			// string -> int
		
		long ans = n;																			// 각 시험장 당 총 감독관 꼭
		
		// 먼저 총 감독관을 각각 넣는다
		for(int here = 0; here < n; here++) 
			test_p[here] -= first_see;
		
		// 봐야할 인원이 더 있다면 부감독관 투입
		for(int here = 0; here < n; here++) {
			long more_see = 0;																// 추가 투입 해야할 부 감독관
			
			if(test_p[here] > 0) {													// 인원이 남아 있으면 투입
				more_see = test_p[here] / second_see;
				ans += more_see;
				test_p[here] -= more_see * second_see;
				
				if(test_p[here] % second_see != 0) {					// 어정쩡하게 남으면 1명 더 
					ans += 1;
					test_p[here] -= second_see;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		
	} 
}   
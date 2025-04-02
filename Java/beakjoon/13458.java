package baekjoon;
//https://www.acmicpc.net/problem/13458
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	/* 1. �� ������ ����
	 * 2. �� ������ �� �� �������� �ִ´�
	 * 3. �����ϸ� �ΰ������� ä�� �ִ´�
	 * */
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());					// ������ ����
		String[] s_test_p = bf.readLine().split(" ");			// ������ �� �ο�   (string
		String[] s_n_test_p = bf.readLine().split(" ");		// ������ �� �ο�   (string
		long[] test_p = new long[n];												// ������ �� �ο�		(int
		long first_see  = Integer.parseInt(s_n_test_p[0]);	// �� ������ �ִ� �ο�
		long second_see = Integer.parseInt(s_n_test_p[1]);	// �� ������ �ִ� �ο�
		
		for(int i = 0; i < n; i++)												// ������ �� �ο�
			test_p[i] = Integer.parseInt(s_test_p[i]);			// string -> int
		
		long ans = n;																			// �� ������ �� �� ������ ��
		
		// ���� �� �������� ���� �ִ´�
		for(int here = 0; here < n; here++) 
			test_p[here] -= first_see;
		
		// ������ �ο��� �� �ִٸ� �ΰ����� ����
		for(int here = 0; here < n; here++) {
			long more_see = 0;																// �߰� ���� �ؾ��� �� ������
			
			if(test_p[here] > 0) {													// �ο��� ���� ������ ����
				more_see = test_p[here] / second_see;
				ans += more_see;
				test_p[here] -= more_see * second_see;
				
				if(test_p[here] % second_see != 0) {					// �������ϰ� ������ 1�� �� 
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
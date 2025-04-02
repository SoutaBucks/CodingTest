package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
//https://acmicpc.net/problem/1152
public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* �Է��� ���� */
		String[] str = bf.readLine().split(" ");
		
		int ans = 0;
		
		for (String e : str)
			if (e != "")
				ans += 1;

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
} 
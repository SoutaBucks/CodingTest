package baekjoon;
//https://acmicpc.net/problem/2675
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < T; i++) {
			// �ݺ�Ƚ���� ���ڿ��� int�� / ex) ["A", "B", "C"] �� ��ȯ
			String[] input = bf.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			String[] S = input[1].split("");
			
			String ans = "";
			for (String e : S) {
				for (int j = 0; j < R; j++) 
					ans += e;
			}
			bw.write(ans);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	} 
} 
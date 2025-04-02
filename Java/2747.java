package baekjoon;
//https://www.acmicpc.net/problem/2747
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static int fibo(int num) {
		int[] fibo_num = new int[num];
		fibo_num[0] = 0;
		fibo_num[1] = 1;
		for(int i = 2; i < num; i++) 
			fibo_num[i] = fibo_num[i - 1] + fibo_num[i - 2];
		
		return fibo_num[num - 1];
	}
	
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		bw.write(String.valueOf(fibo(n + 1)));
	
		bw.flush();
		bw.close();
		
	} 
}   
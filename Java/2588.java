package baekjoon;
//https://acmicpc.net/problem/2588
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int num1 = Integer.parseInt(bf.readLine());
		String[] strn2 = bf.readLine().split("");
		int[] num2 = new int[3];
		
		for(int i = 0; i < 3; i++) 
			num2[i] = Integer.parseInt(strn2[i]);
		
		int[] nums = new int[3];
		
		for(int i = 0; i < 3; i++) 
			nums[i] = num1 * num2[i];

		int num6 = nums[0] * 100 + nums[1] * 10 + nums[2];
		
		for(int i = 2; i >= 0; i--) 
			bw.write(String.valueOf(nums[i]) + "\n");
		bw.write(String.valueOf(num6));
		bw.flush();
		bw.close();
	} 
} 
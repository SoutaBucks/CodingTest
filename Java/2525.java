package baekjoon;
//https://acmicpc.net/problem/2525
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		int[] time = new int[2];
		int need_time = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < 2; i++)
			time[i] = Integer.parseInt(str[i]);
		
		time[1] += need_time;
	
		while(time[1] >= 60) {
			time[1] -= 60;
			time[0] += 1;
		}
		
		if(time[0] >= 24)
			time[0] -= 24;
		
		bw.write(time[0] + " " + time[1]);
		bw.flush();
		bw.close();
	} 
} 
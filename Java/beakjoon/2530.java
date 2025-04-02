package baekjoon;
//https://acmicpc.net/problem/2530
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
		int[] now = new int[3];
		int more = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < 3; i++)
			now[i] = Integer.parseInt(str[i]);
		
		now[2] += more;
		
		while(now[2] >= 60) {
			now[2] -= 60;
			now[1] += 1;
		}
		
		while(now[1] >= 60) {
			now[1] -= 60;
			now[0] += 1;
		}
		
		while(now[0] >= 24) 
			now[0] -= 24;
		
		bw.write(now[0] + " " + now[1] + " " + now[2]);
		bw.flush();
		bw.close();
	} 
} 
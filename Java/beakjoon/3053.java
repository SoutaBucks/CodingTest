package baekjoon;
//https://www.acmicpc.net/problem/3053
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static String uclid(double r) {
		return String.valueOf(r * r * Math.PI);
	}
	public static String taxi(double r) {
		return String.valueOf(2 * r * r);
	}
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double n = Double.parseDouble(bf.readLine());
		bw.write(String.valueOf(uclid(n)) + "\n");
		bw.write(String.valueOf(taxi(n)));
		bw.flush();
		bw.close();
		
	} 
} 
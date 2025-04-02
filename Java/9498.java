package baekjoon;
//https://www.acmicpc.net/problem/9498
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
	public static char result(int grade) {
		if ((90 <= grade) && (grade <= 100))
			return 'A';
		else if ((80 <= grade) && (grade < 90))
			return 'B';
		else if ((70 <= grade) && (grade < 80))
			return 'C';
		else if ((60 <= grade) && (grade < 70))
			return 'D';
		else
			return 'F';
	}
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bf.readLine());
		bw.write(result(num));
		bw.flush();
		bw.close();
		
	} 
}   
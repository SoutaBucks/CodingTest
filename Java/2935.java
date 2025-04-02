package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;	

//https://www.acmicpc.net/problem/2935

public class Main {
	/* "�л����� ������ ������ �����"
	 * "�־����� ���� 10�� ���� ���´�"
	 */
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		BigInteger n1 = new BigInteger(bf.readLine());
		String op = bf.readLine();
		BigInteger n2 = new BigInteger(bf.readLine());

		
		if (op.equals("+")) 
			bw.write(String.valueOf(n1.add(n2)));
		else
			bw.write(String.valueOf(n1.multiply(n2)));
		
		bw.flush();
		bw.close();
	} 
} 
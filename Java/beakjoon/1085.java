package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
//https://acmicpc.net/problem/1085
public class Main {	
	/*
	 * ��輱���� �ּ� �Ÿ�  
	 * ��� ��輱������ �Ÿ� �� ���� ���� �� ��ȯ */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* �Է��� �޾ƿ� */
		String[] arr = bf.readLine().split(" ");
		/* �Է°��� ������ �ٲ� */
		int[] point = new int[4];
		for (int i = 0; i < 4; i++) 
			point[i] = Integer.parseInt(arr[i]);
		/* ��� ��輱������ �Ÿ� */
		int[] dist = {
				point[0] - 0, point[1] - 0, point[2] - point[0], point[3] - point[1]
		};
		Arrays.sort(dist);
		
		bw.write(String.valueOf(dist[0]));
		bw.flush();
		bw.close();
	}
} 
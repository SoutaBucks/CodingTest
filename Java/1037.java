package baekjoon;

//https://acmicpc.net/problem/1037

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* �Է� ���� �޾ƿ� */
		int N = Integer.parseInt(bf.readLine());
		String[] ali_str = bf.readLine().split(" ");
		/* �Է� ���� ���� ������ ��ȯ */
		int[] ali_int = new int[N];
		for (int i = 0; i < N; i++)
			ali_int[i] = Integer.parseInt(ali_str[i]);
		/* ũ�� ������ ���� */
		Arrays.sort(ali_int);
		/* ���� ���� �� * ���� ū ���� ���̴� */
		int ans = ali_int[0] * ali_int[N - 1];
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
} 
package baekjoon;

//https://acmicpc.net/problem/1065

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {	
	public static int solve(int num) {
		/* 1 ~ 99������ �Ѽ��̴� */
		int ans = 99; 
		
		if (num <= 99)
			return num;
		else {
			/* 100���� 
			 * �����ڸ� - �����ڸ� = ����
			 * �����ڸ� + ���� = �����ڸ� => �Ѽ�
			 * 1000�� �Ѽ��� �ƴϹǷ� 999������ �����ϸ� �ȴ� */
			int[] arr = {1, 0, 0};
			for (int i = 100; i <= num; i++) { 
				int d = arr[1] - arr[0];
				if (arr[1] + d == arr[2])
					ans += 1;
				/* arr ���� ���� 1�� ������Ų��
				 * �� �ڸ� ���� 10�� ������
				 * �ø� ������ ���ش�
				 * */
				arr[2] += 1;
				if (arr[2] == 10) {
					arr[2] = 0;
					arr[1] += 1;
					if(arr[1] == 10) {
						arr[1] = 0;
						arr[0] += 1;
					}
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* �Է��� ���� */
		int X = Integer.parseInt(bf.readLine());	
		/* ����� ��� */
		bw.write(String.valueOf(solve(X)));
		bw.flush();
		bw.close();
	}
} 
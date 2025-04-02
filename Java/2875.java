package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

//https://www.acmicpc.net/problem/2875

public class Main {
	/* 1. �ִ��� ���� ���� �����
	 * 2. ���� �ο��� K���� ������ ��� ���ڶ��� Ȯ���Ѵ�
	 * 3. 1���� 3���̹Ƿ� 3�� �����ŭ���� ���� Ȯ���Ѵ�
	 */
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] ipt = bf.readLine().split(" ");
		int woman = Integer.parseInt(ipt[0]);
		int man = Integer.parseInt(ipt[1]);
		int internship = Integer.parseInt(ipt[2]);
		
		int teams = 0;	// �ִ�� ������� �� �ִ� ���� ��
		// ���� 2��, ���� 1�� ���� �̷��
		while ((woman - 2 >= 0) && (man - 1 >= 0)) {
			woman -= 2;
			man -= 1;
			teams++;
		}
		
		// �����ִ� ����� ���Ͻ��� �����ؾ��ϴ� �ο����� ���ٸ�
		if (woman + man >= internship) 
			bw.write(String.valueOf(teams));
		// �ƴ϶��
		else {
			while (woman + man < internship) {
				woman += 2;
				man += 1;
				teams--;
			}
			bw.write(String.valueOf(teams));
		}
		
		bw.flush();
		bw.close();
	} 
} 
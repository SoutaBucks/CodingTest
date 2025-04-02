package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://acmicpc.net/problem/1004

public class Main {	
	
	//�迭 �� ���ڿ��� ���� ���·� ��ȯ�ϴ� �Լ�
	public static int[] str_to_int(String[] st, int len) {
		int[] arr = new int[len];
		for(int i = 0; i < len; i++) 
			arr[i] = Integer.parseInt(st[i]);
		return arr;
	}
	
	public static double distance(int[] from, int[] to) {
		double ans = Math.sqrt(Math.pow(from[0] - to[0], 2) + Math.pow(from[1] - to[1], 2));
		return ans;
	}
	
	/* �༺���� ��谡 �´�ų� ���� �����ϴ� ���� ����. 
	 * ������� ���ΰ� �ִ� �� + �������� ���ΰ� �ִ� �� - �� �� ���ΰ� �ִ� ��
	 * */ 
	
	public static int sol(int[] point, int[][] planet) {
		
		int[] start_point = {point[0], point[1]};	// ������
		int[] end_point = {point[2], point[3]};		// ������
		int count = 0;	// ��� ������ �ϴ���
		
		// ���� �Ÿ� ���� �������
		for (int i = 0; i < planet.length; i++) {
			int[] planet_point = {planet[i][0], planet[i][1]}; //�༺ ����
			double dist_s = distance(start_point, planet_point); // ��������� �Ÿ�
			double dist_e = distance(end_point, planet_point);   // ���������� �Ÿ�
			double planet_r = (double)planet[i][2]; //�༺�� ������ double �񱳸� ����
			
			/* �� �������� �Ÿ� < �༺ ������
			 * �̹� �� ���� �����ϰ� �ִ� �༺���̹Ƿ� 
			 * ������ �ʿ� ���� */
			if (dist_s < planet_r && dist_e < planet_r)
				continue;
			
			/* �� �� �ϳ��� �����Ѵٸ� ���������Ѵ� */
			else if (dist_s < planet_r || dist_e < planet_r)
				count += 1;
			
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ����
		
		for(int i = 0; i < T; i++) {
			int[] point = str_to_int(br.readLine().split(" "), 4);	//��� ��ǥ			
			int n = Integer.parseInt(br.readLine()); // �༺�� ����
			int[][] planet = new int[n][3];			 // �༺�� ��ǥ �����

			// �༺ ������ �迭�� �ֱ�
			for(int j = 0; j < n; j++) 
				planet[j] = str_to_int(br.readLine().split(" "), 3);
			
			System.out.println(sol(point, planet)); 
		}
	}
} 
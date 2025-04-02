package baekjoon;

import java.util.Scanner;

//https://acmicpc.net/problem/1002

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* �������� ��ǥ������ ���� 
		   ���ȯ�� ��ǥ������ ���� ������ ������? */
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			System.out.println(sol());
		}
	}
	
	public static int sol() {
		int[] arr = new int[6];
		
		//���� �Է� ����
		for (int i = 0; i < 6; i++)
			arr[i] = sc.nextInt();

		//������ ���� ��ǥ�� �������� �и�
		int[] jo_po = {arr[0], arr[1]};
		int jo_r = arr[2];
		int[] baek_po = {arr[3], arr[4]};
		int baek_r = arr[5];
		
		//�� ���� ��ǥ�� �Ÿ��� �������� ���� ����
		double dist_po = Math.sqrt(Math.pow(jo_po[0] - baek_po[0], 2) + Math.pow(jo_po[1] - baek_po[1], 2));
		double sum_r = jo_r + baek_r;
		
		if ((dist_po == 0) && (jo_r == baek_r)) //������ �������� ���ٸ�
			return -1;  						//�յ��̴�
		//1.���� �Ÿ��� ������ �պ��� ũ�� (�ܺ�) 2. ���� �Ÿ� + ������ < �ٸ� ������ (����)
		else if ((dist_po > sum_r) || (dist_po + jo_r < baek_r) || (dist_po + baek_r < jo_r))
			return 0;							//������ �ʴ´�
		//1. ���� �Ÿ� == ������ ��(�ܺ�) 2. ���� �Ÿ� + �ƹ� ������ == �ٸ� ������ (����)
		else if ((dist_po == sum_r) || (dist_po + jo_r == baek_r) || (dist_po + baek_r == jo_r))
			return 1;							//���Ѵ�
		else									//�װ� �ƴϸ�
			return 2;							//2������ ������
	}
}

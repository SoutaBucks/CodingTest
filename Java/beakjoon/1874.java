package baekjoon;
//https://acmicpc.net/problem/1874
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> stack = new ArrayDeque<>();				//����
		List<Integer> list_arr = new ArrayList<>();				//������ ���
		List<String> list_push_pop = new ArrayList<>();		//+, - �迭
		List<Integer> list_want = new ArrayList<>();			//���ϴ� ���
		
		int n = Integer.parseInt(bf.readLine());
		int num = 1;
		
		for(int i = 0; i < n; i++) {											// ���ڸ� n�� �޴´�
			
			int arr_num = Integer.parseInt(bf.readLine());	// ���� ���ڸ� �Է¹޴´�
			list_want.add(arr_num);													// ������ �ִ´�
			
			while (num <= arr_num) {
				stack.addFirst(num);													// ���ÿ� ���ڸ� 1���� �ִ´�
				num++;																				// ���� �� ���ڸ� 1 ������Ų��
				list_push_pop.add("+");												// push �����Ƿ� + �ִ´�
			}
			
			list_arr.add(stack.removeFirst());							// num�� �迭 ���ں��� ũ�ٸ� �̹� ���þȿ� ���ڰ� �����Ƿ� ����
			list_push_pop.add("-");													// pop �����Ƿ� - �ִ´�
		}
		
		if (list_arr.equals(list_want))	{									// ���ϴ� ������ ������ ����� ���ٸ�
			for (String s : list_push_pop)
				System.out.println(s);
		}
		else 
			System.out.println("NO");
	}
} 
package baekjoon;
//https://acmicpc.net/problem/1712
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {	
	public static int solve(int[] price) {
		if (price[2] <= price[1])
			return -1;
		else {
			return price[0]/(price[2]  - price[1]) + 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// �Է°��� �޾� �迭�� ������ ��
		String[] str = bf.readLine().split(" ");
		// ������ ������ �ٲپ� �ش�
		int[] nums = new int[3];
		for (int i = 0; i < 3; i++) 
			nums[i] = Integer.valueOf(str[i]);
		
		int ans = 0;
		ans = solve(nums);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}
	
} 
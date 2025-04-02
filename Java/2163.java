package baekjoon;
//https://acmicpc.net/problem/2163
import java.util.Scanner;

public class Main {
	public static void main(String[] args)	{	
		Scanner sc = new Scanner(System.in);
		String str[] = sc.nextLine().split(" ");
		int num[] = new int[2];
		for(int i = 0; i < 2; i++)
			num[i] = Integer.parseInt(str[i]);
		System.out.println(num[0] * num[1] - 1);
	} 
} 
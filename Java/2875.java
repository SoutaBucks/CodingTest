package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

//https://www.acmicpc.net/problem/2875

public class Main {
	/* 1. 최대한 많은 팀을 만든다
	 * 2. 남은 인원이 K보다 작으면 몇명 모자란지 확인한다
	 * 3. 1팀당 3명씩이므로 3의 배수만큼씩을 빼서 확인한다
	 */
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		String[] ipt = bf.readLine().split(" ");
		int woman = Integer.parseInt(ipt[0]);
		int man = Integer.parseInt(ipt[1]);
		int internship = Integer.parseInt(ipt[2]);
		
		int teams = 0;	// 최대로 만들어질 수 있는 팀의 수
		// 여자 2명, 남자 1명씩 팀을 이룬다
		while ((woman - 2 >= 0) && (man - 1 >= 0)) {
			woman -= 2;
			man -= 1;
			teams++;
		}
		
		// 남아있는 사람이 인턴쉽에 참가해야하는 인원보다 많다면
		if (woman + man >= internship) 
			bw.write(String.valueOf(teams));
		// 아니라면
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
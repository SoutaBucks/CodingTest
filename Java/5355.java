package baekjoon;
//https://www.acmicpc.net/problem/5355
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

/* @ => °öÇÏ±â 3
 * % => ´õÇÏ±â 5
 * # => »©±â 7
 */
public class Main {
	public static double mars(String[] ipt) {
		double num = Double.parseDouble(ipt[0]);
		for(int i = 1; i < ipt.length; i++) {
			if(ipt[i].equals("@"))
				num *= 3;
			else if(ipt[i].equals("%"))
				num += 5;
			else
				num -= 7;
		}
		return num;
	}
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(bf.readLine());
		for(int i = 0; i < T; i++)
			bw.write(String.format("%.2f",mars(bf.readLine().split(" "))) + "\n");
		bw.flush();
		bw.close();
		
	} 
}   
package baekjoon;
//https://www.acmicpc.net/problem/10799
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Deque;
import java.io.IOException;

/* �������� ���� ��ȣ�� �ݴ� ��ȣ�� ������ �� ��( ) �� ���� ǥ���ȴ�. 
 * ����, ��� ��( ) ���� �ݵ�� �������� ǥ���Ѵ�.
 * �踷����� ���� ���� ���� ��ȣ �� ( �� ��, ������ ���� ���� ��ȣ ��) �� �� ǥ���ȴ�. 
 */

public class Main {
	public static void main(String[] args) throws IOException	{	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* 1. �������� x�� ġȯ�Ѵ�
		 * 2. �� ���·� ���ÿ� �ִ´� (x�� ����)
		 * 3. ��ȣ�� �ϼ��� �Ǹ� x������ ���ϰ� �ٽ� x�� �ִ´�
		 * 4. �̸� �ݺ��ϸ� ���ÿ��� x�� ���� �ȴ�
		 * */
		
		/* �ڷ� �ֱ� add()
		 * �ڷ� ���� pollLast()
		 * �� �ڿ� �ִ� �� Ȯ���ϱ� peekLast()
		 * */
		
		Deque<String> stack = new LinkedList<>();
		String[] ipt = bf.readLine().replace("()", "1").split("");
		int razer = 0;
		int ans   = 0;
		
		for(String e : ipt) {
			razer = 0;
			if(e.equals("(") || e.equals("1")) {		// (, 1 -> �׳� �ִ´�
				stack.add(e);
			}
			else if(e.equals(")")) {								
				while(!stack.peekLast().equals("("))	{	// ( �� ���ö����� x ���� Ȯ�� 
					razer += Integer.parseInt(stack.pollLast()); // ������ ���� ��ŭ ���ϱ�
				}
				stack.pollLast();											// ( �� ���ش�
				ans += (razer + 1);										// �� ����� ���� = ������ + 1
				stack.add(String.valueOf(razer));	  	// �� ������ ä���ֱ�
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		
	} 
}   
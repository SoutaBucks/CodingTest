//https://school.programmers.co.kr/learn/courses/30/lessons/258711
/* 정점...간선....
 * 도넛 그래프 - 시작 정점에서 출발하면 시작 정점으로 되돌아온다
 * 막대 그래프 - 끝이 존재한다 (나가는 간선이 0인 정점이 존재한다)
 * 8자 그래프 - 특정 정점에서 2개의 나가는 간선이 존재한다
 * 시작 정점 - 들어오는 간선이 없다
 * */

class Solution {
  public int[] solution(int[][] edges) {
    int[] answer = new int[4];
    int maxIndex = -1;

    //나가는 간선과 들어오는 간선을 정리하자 0 - in 1 - out
    int[][] edgeInOut = new int[2][1000001];

    for(int[] e : edges) {
      int out = e[0], in = e[1];
      //System.out.printf("in %d out %d\n", in, out);
      edgeInOut[0][in]++;	// 들어오는 간선 수 더하기
      edgeInOut[1][out]++;	// 나가는 간선 수 더하기
      maxIndex = Math.max(Math.max(in, out), maxIndex);
    }

      /*
      for(int j = 0; j < 2; j++) {
      	for(int i = 1; i <= maxIndex; i++)
      		System.out.printf("%d ", edgeInOut[j][i]);
      	System.out.println();
      }
        */

    for(int i = 1; i <= maxIndex; i++) {
      int in = edgeInOut[0][i], out = edgeInOut[1][i];
      if(in == 0 && out >= 2)
        answer[0] = i;
      else if(out == 0 && in > 0)
        answer[2]++;
      else if(out == 2 && in >= 2)
        answer[3]++;
    }
    answer[1] = edgeInOut[1][answer[0]] - (answer[2] + answer[3]);

    //System.out.printf("%d %d %d %d", answer[0], answer[1], answer[2], answer[3]);

    return answer;
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}}));
  }
}
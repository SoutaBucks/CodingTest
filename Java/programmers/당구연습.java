//https://school.programmers.co.kr/learn/courses/30/lessons/169198
class Solution {

  public double getLengthPow(int startX, int startY, int ballX, int ballY) {
    double result = 0;

    double distance = Math.pow(ballX - startX, 2) + Math.pow(ballY - startY, 2);

    // System.out.printf("start (%d, %d) ball (%d, %d) distance = %f\n", startX,
    // startY, ballX, ballY, distance);

    return distance;
  }

  public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    int[] answer = new int[balls.length];

    // 왼쪽, 위, 오른쪽, 아래 대칭
    int[] dx = {-startX, startX, 2 * m - startX, startX};
    int[] dy = {startY, 2 * n - startY, startY, -startY};

    for (int i = 0; i < balls.length; i++) {

      int ballX = balls[i][0];
      int ballY = balls[i][1];

      int result = Integer.MAX_VALUE;
      for (int j = 0; j < 4; j++) {

        if (startX == ballX) {
          if ((j == 1 && ballY > startY) || (j == 3 && ballY < startY))
            continue;
        }

        if (startY == ballY) {
          if ((j == 0 && ballX < startX) || (j == 2 && ballX > startX))
            continue;
        }

        result = Math.min(result, (int) getLengthPow(dx[j], dy[j], ballX, ballY));
      }
      answer[i] = result;
    }

    return answer;
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7}, {7, 3}}));
  }
}
//https://school.programmers.co.kr/learn/courses/30/lessons/258712

import java.util.HashMap;

class Solution {

  // 주고 받은 경과를 보기위한 배열
  public int[][] board = new int[50][50];

  public void showBoard() {
    for (int[] r : board) {
      for (int c : r)
        System.out.print(c + " ");
      System.out.println();
    }
  }

  public int solution(String[] friends, String[] gifts) {
    int answer = 0;

    // 답 배열
    int[] answerArray = new int[friends.length];

    // 캐릭터를 숫자로 변경
    HashMap<String, Integer> characterMap = new HashMap<String, Integer>();
    for (int i = 0; i < friends.length; i++)
      characterMap.put(friends[i], i);

    // 각 캐릭터 당 [준 선물, 받은 선물, 선물 지수]
    int[][] presentStatic = new int[50][3];

    // 위의 배열에 주고 받은 내역을 저장한다.
    for (String e : gifts) {
      String[] str = e.split(" ");
      int from = characterMap.get(str[0]), to = characterMap.get(str[1]);
      board[from][to] += 1;
      presentStatic[from][0] += 1;
      presentStatic[to][1] += 1;
    }

    // 선물 지수 계산
    for (int i = 0; i < friends.length; i++)
      presentStatic[i][2] = presentStatic[i][0] - presentStatic[i][1];

    // 하나씩 돌면서 누구한테 선물을 많이 줬는지 확인하자
    for (int from = 0; from < friends.length; from++) {
      for (int to = 0; to < friends.length; to++) {
        // 자신이 자신에게 주고받는 경우는 슬프니까 없다
        if (from == to) continue;

        // 주고받은 수가 같다면
        if (board[from][to] == board[to][from]) {
          // 선물 지수까지 같다면 넘어가자
          if (presentStatic[from][2] == presentStatic[to][2])
            continue;
            // 중복 방지를 위해서 주는 쪽만 계산하자
          else if (presentStatic[from][2] > presentStatic[to][2])
            answerArray[from] += 1;
        }
        // 더 많이 줬다면
        else if (board[from][to] > board[to][from]) {
          answerArray[from] += 1;
        }

      }
    }

    for (int c : answerArray) {
      if (answer < c)
        answer = c;
    }

    return answer;
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new String[] {"muzi", "ryan", "frodo", "neo"}, new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
  }
}
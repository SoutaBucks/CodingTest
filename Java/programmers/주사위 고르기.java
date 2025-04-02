//https://school.programmers.co.kr/learn/courses/30/lessons/258709

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* A가 반을 가져가면 나머지는 B가 가져간다
 * 모든 경우 중 승리의 개수만 구하면 된다
 *
 *
 * */
class Solution {
  public int diceNumber = 0;      // 주사위 개수
  public boolean[] visited;      // 주사위를 골랐는지 확인

  public List<List<Integer>> diceAList = new ArrayList<>(), diceBList = new ArrayList<>();

  //A와 B의 주사위 수 합을 저장하는 배열
  public List<Integer> diceSumListA, diceSumListB;

  // 주사위를 고르자
  public void chooseDice(List<Integer> list, int index) {

    // A(list)가 주사위의 반을 가져갔으면 B는 남은 거 가져가자!!
    // sublist는 참조값만을 전달하기 때문에 새로 선언한 List에 저장해야합니다!!!!!!
    if (list.size() == diceNumber / 2) {
      List<Integer> listA = new ArrayList<Integer>(list);
      diceAList.add(listA);
      List<Integer> listB = new ArrayList<>();
      for (int i = 0; i < diceNumber; i++) {
        if (!visited[i])
          listB.add(i);
      }
      diceBList.add(listB);
      return;
    }

    for (int i = index; i < diceNumber; i++) {
      if (!visited[i]) {
        list.add(i);
        visited[i] = true;
        chooseDice(list, i + 1);
        list.remove(list.size() - 1);
        visited[i] = false;
      }
    }

  }

  // 어떤 주사위 골랐는지 보여주는 함수
  public void showDiceChoose() {

    for (int i = 0; i < diceAList.size(); i++)
      System.out.println("A - " + diceAList.get(i) + "| B - " + diceBList.get(i));

  }

  // 각 경우를 가지고 승패를 계산하자
  public List<Integer> getWinorLose(int[][] dice) {
    List<Integer> result = new ArrayList<>();  // 최대 승률일 때 A경우
    long maxWin = -1, nowWin = 0;  // 최대 승률, 현재 승률

    for (int i = 0; i < diceAList.size(); i++) {
      // A와 B의 주사위 수 합을 저장하는 배열 초기화
      diceSumListA = new ArrayList<>();
      diceSumListB = new ArrayList<>();

      // 주사위 A의 합들을 저장하자
      sumChosenDice(diceAList.get(i), 0, 0, 1, dice);
      Collections.sort(diceSumListA);
      // 주사위 B의 합들을 저장하자
      sumChosenDice(diceBList.get(i), 0, 0, 2, dice);
      Collections.sort(diceSumListB);

      //System.out.print("A가 " + diceAList.get(i) + "를 골랐을 때\n" + diceSumListA + "\n");
      //System.out.print("B가 " + diceBList.get(i) + "를 골랐을 때\n" + diceSumListB + "\n");

      // A의 합에 따라서 몇번 이기는 지 확인해보자
      for (int a : diceSumListA)
        nowWin += howManyWin(a);

      //System.out.printf("maxwin : %d, nowWin = %d\n", maxWin, nowWin);
      if (maxWin < nowWin) {
        maxWin = nowWin;
        result = diceAList.get(i);
      }
      nowWin = 0;
    }

    return result;
  }

  // 총 몇번 이겼는지 확인해보자
  public int howManyWin(int numA) {
    int low = 0, high = diceSumListA.size() - 1, middle = (low + high) / 2;
    int here, winCount = 0;

		/*
		// 어느 지점까지 A가 이기는가?
		while(true) {
			System.out.printf("low = %d middle = %d high = %d, A = %d B = %d\n", low, middle, high, numA, diceSumListB.get(middle));
			if(numA <= diceSumListB.get(middle))
				high = middle;
			else
				low = middle + 1;
			if(low == high) {
				here = low;
				break;
			}
			middle = (low + high) / 2;
		}

		//System.out.printf("%d까지 A의 %d가 이기기 시작합니다\n", here, numA);
		if(here == 0)
			winCount = here;
		else winCount = here + 1;
		*/

    for (int i = 0; i < diceSumListB.size(); i++) {
      if (numA <= diceSumListB.get(i))
        break;
      winCount++;
    }
    return winCount;
  }

  // 주사위 눈을 시뮬레이션하고 합을 반환하는 함수
  // sumChosenDice(주사위조합, 조합 속 몇번째 주사위, 주사위 눈의 합, A/B, dice배열)
  public void sumChosenDice(List<Integer> list, int diceIndex, int sum, int whichDice, int[][] dice) {

    if (diceIndex == list.size()) {
      if (whichDice == 1)
        diceSumListA.add(sum);
      else
        diceSumListB.add(sum);
      return;
    }

    // 뽑은 주사위 중 x번째 주사위를 던질거야
    int nowDice = list.get(diceIndex);

    for (int i = 0; i < 6; i++)
      sumChosenDice(list, diceIndex + 1, sum + dice[nowDice][i], whichDice, dice);
  }

  // solution 함수
  public int[] solution(int[][] dice) {
    List<Integer> answer = new ArrayList<Integer>();

    diceNumber = dice.length;
    visited = new boolean[dice.length];

    chooseDice(new ArrayList<Integer>(), 0);
    //showDiceChoose();
    answer = getWinorLose(dice);

    for (int i = 0; i < answer.size(); i++)
      answer.set(i, answer.get(i) + 1);

    //System.out.println(answer);

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}}));
  }
}
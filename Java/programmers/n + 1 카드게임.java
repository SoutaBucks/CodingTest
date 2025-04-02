//https://school.programmers.co.kr/learn/courses/30/lessons/258707
import java.util.HashMap;
import java.util.PriorityQueue;

class PairCard implements Comparable<PairCard> {
  int cost, first, second;

  public PairCard(int cost, int first, int second) {
    this.cost = cost;
    this.first = first;
    this.second = second;
  }

  @Override
  public int compareTo(PairCard p) {
    return this.cost - p.cost;
  }

  @Override
  public String toString() {
    return "[" + first + "," + second + "] = " + cost + "\n";
  }

}

class Solution {

  int n = 0;
  public boolean[] nowIHave;
  public int[] coinToPlayThisCard;
  HashMap<Integer, Integer> cardIndex = new HashMap<Integer, Integer>();
  PriorityQueue<PairCard> pQueue = new PriorityQueue<PairCard>();

  public void initCards(int[] cards) {
    n = cards.length;
    nowIHave = new boolean[n];
    coinToPlayThisCard = new int[n];

    // 카드 인덱스와 숫자 매칭
    for (int i = 0; i < n; i++)
      cardIndex.put(cards[i], i);

    int pair = -1;

    for (int i = 0; i < n / 3; i++) {
      nowIHave[i] = true;

      pair = (n + 1) - cards[i];
      if (nowIHave[cardIndex.get(pair)]) {
        PairCard temp = new PairCard(coinToPlayThisCard[i], cards[i], pair);
        pQueue.add(temp);
      }
    }
  }


  public int solution(int coin, int[] cards) {
    int answer = 1, pair = -1;

    initCards(cards);

    for (int i = (n / 3); i < n; i++) {
      nowIHave[i] = true;
      coinToPlayThisCard[i]++;

      pair = (n + 1) - cards[i];
      // 낼 수 있는 카드를 찾았다면 등록 하자
      if (nowIHave[cardIndex.get(pair)]) {
        PairCard temp = new PairCard(coinToPlayThisCard[i] + coinToPlayThisCard[cardIndex.get(pair)], cards[i], pair);
        //System.out.print(temp);
        pQueue.add(temp);
      }

      // 카드를 2장 뽑았다면 이제 내야 됨
      if (i % 2 == 1) {
        if (!pQueue.isEmpty()) {
          PairCard temp = pQueue.poll();

          // 코인을 가장 적게 낼 수 있는 경우의 수보다 내가 가지고 있는 코인이 적으면 못냄
          if (temp.cost > coin)
            break;

          coin -= temp.cost;
          answer++;
        }
        // 낼 수 있는 카드가 없으면 끝냄
        else
          break;
      }
    }

    return answer;
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(4, new int[] {3,6,7,2,1,10,5,9,8,12,11,4}));
  }
}
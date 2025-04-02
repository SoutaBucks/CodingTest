//https://school.programmers.co.kr/learn/courses/30/lessons/250135

class Solution {
  static int cnt = 0;

  double hourAngle;
  double minuteAngle;
  double secondAngle;

  int totalTime = 0;

  // 총 시간을 구하는 함수
  public void setTotalTime(int h1, int m1, int s1, int h2, int m2, int s2) {
    int start = h1*3600 + m1*60 + s1;
    int end = h2*3600 + m2*60 + s2;

    totalTime = end - start;
  }

  // 해당 위치 각도를 구하는 함수
  public void setAngle(int hour, int minute, int second) {
    hourAngle = (hour % 12) * 30 + minute * 0.5 + second * (1/120d);
    minuteAngle = minute * 6 + second * 0.1;
    secondAngle = second * 6;
  }


  public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
    int answer = 0;

    setTotalTime(h1, m1, s1, h2, m2, s2);
    setAngle(h1,m1,s1);

    for(int i = 0; i < totalTime; i++)
      answer += goSecond();

    // 시작 할 때 시침과 분침이 같게 되면
    setAngle(h1,m1,s1);
    if(Double.compare(hourAngle, minuteAngle) == 0 || Double.compare(minuteAngle, secondAngle) == 0) answer++;

    setAngle(h2,m2,s2);
    if(Double.compare(hourAngle, minuteAngle) == 0 || Double.compare(minuteAngle, secondAngle) == 0) answer++;

    return answer;
  }

  // 다음 초로 넘어갈 때 겹치는지 확인하는 함수
  public int goSecond() {
    int result = 0;

    double beforeHourAngle = hourAngle;
    double beforeMinuteAngle = minuteAngle;
    double beforeSecondAngle = secondAngle;

    hourAngle += (1/120d);
    minuteAngle += 0.1;
    secondAngle += 6;

    // 시침과 초침이 만나면 1 더하기
    if(Double.compare(beforeHourAngle, beforeSecondAngle) > 0 && Double.compare(hourAngle, secondAngle) <= 0) result++;
    // 분침과 초침이 만나면 1 더하기
    if(Double.compare(beforeMinuteAngle, beforeSecondAngle) > 0 && Double.compare(minuteAngle, secondAngle) <= 0) result++;

    if(Double.compare(beforeHourAngle, beforeMinuteAngle) == 0) result--;

    if(hourAngle >= 360) hourAngle %= 360;
    if(minuteAngle >= 360) minuteAngle %= 360;
    if(secondAngle >= 360) secondAngle %= 360;

    return result;
  }
}

class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(0,5,30,0,7,0));
  }
}
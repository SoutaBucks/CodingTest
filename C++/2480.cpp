#include <iostream>

//https://www.acmicpc.net/problem/2480
// 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
// 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
// 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.

int main() {
  using namespace std;
  int n1, n2, n3, ans;
  cin >> n1 >> n2 >> n3;


  if(n1 == n2 && n2 == n3)                      // 1번 경우
    ans = 10000 + n1 * 1000;
  else if(n1 != n2 && n2 != n3 && n1 != n3)     // 3번 경우
    ans = max(max(n1, n2), max(n2, n3)) * 100;
  else {                                        // 2번 경우
    if (n1 == n2 || n1 == n3)
      ans = 1000 + n1 * 100;
    else if(n2 == n3)
      ans = 1000 + n2 * 100;
  }
  cout << ans << endl;
  return 0;
}

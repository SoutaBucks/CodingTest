#include <iostream>
//https://www.acmicpc.net/submit/11022

int main() {
  using namespace std;
  int T, n1, n2;
  cin >> T;
  for(int i = 1; i < T + 1; i++) {
    cin >> n1 >> n2;
    printf("Case #%d: %d + %d = %d \n", i, n1, n2, n1 + n2);
  }
  return 0;
}
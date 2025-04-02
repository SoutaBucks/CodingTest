#include <iostream>
//https://www.acmicpc.net/submit/14681

int main() {
  using namespace std;
  int n1, n2;
  cin >> n1 >> n2;
  if((n1 >= 0) && (n2 >= 0))
    cout << 1;
  else if((n1 < 0) && (n2 >= 0))
    cout << 2;
  else if((n1 < 0) && (n2 < 0))
    cout << 3;
  else
    cout << 4;
  return 0;
}
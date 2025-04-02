#include <iostream>
//https://www.acmicpc.net/problem/2753
int main() {
  using namespace std;

  int year;
  cin >> year;

  if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
    cout << 1;
  else
    cout << 0;

  return 0;
}

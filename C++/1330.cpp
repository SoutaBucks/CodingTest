#include <iostream>

//https://www.acmicpc.net/problem/1330

int main() {
  using namespace std;

  int a, b;
  cin >> a >> b;
  if(a > b)
    cout << ">";
  else if(a == b)
    cout << "==";
  else
    cout << "<";

  return 0;
}

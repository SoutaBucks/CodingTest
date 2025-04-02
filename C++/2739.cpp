#include <iostream>
//https://www.acmicpc.net/problem/2739
int main() {
  using namespace std;

  int n;
  cin >> n;

  for(int i = 1; i < 10; i++)
    cout << n << " * " << i << " = " << n * i << endl;

  return 0;
}

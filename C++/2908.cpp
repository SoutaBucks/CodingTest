#include <iostream>
#include <string>
#include <algorithm>
//https://www.acmicpc.net/problem/2908
int main()
{
  using namespace std;
  string a, b;
  cin >> a >> b;
  reverse(a.begin(), a.end());
  reverse(b.begin(), b.end());

  int na, nb;
  na = stoi(a);
  nb = stoi(b);
  cout << max(na, nb);
  return 0;
}
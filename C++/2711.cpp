#include <iostream>
#include <string>
//https://www.acmicpc.net/problem/2711
using namespace std;

void sol();

int main()
{
  int n;
  cin >> n;
  for(int i = 0; i < n; i++)
    sol();
  return 0;
}

void sol()
{
  int where;
  string ipt;
  cin >> where >> ipt;
  for(int i = 0; i < ipt.length(); i++)
  {
    if(i == where - 1)
      continue;
    cout << ipt[i];
  }
  cout << endl;
}
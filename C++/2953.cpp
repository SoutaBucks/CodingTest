#include <iostream>
//https://www.acmicpc.net/problem/2953
using namespace std;

void sol();

int main()
{
  sol();
  return 0;
}

void sol()
{
  int sum[5] = {0};
  int ipt;
  int num = 0, score = 0;
  for(int i = 0; i < 5; i++)  {
    for(int j = 0; j < 4; j++) {
      cin >> ipt;
      sum[i] += ipt;
    }
    if(score < sum[i]) {
      score = sum[i];
      num = (i + 1);
    }
  }
  cout << num << " " << score;
}
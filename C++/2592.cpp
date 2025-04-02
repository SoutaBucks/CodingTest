#include <iostream>
//https://www.acmicpc.net/problem/2592
int avg(int[]);
int most(int[]);
const int SIZE = 10;
using namespace std;

int main()
{
  int arr[10] = {0};

  for(int i = 0; i < SIZE; i++)
    cin >> arr[i];

  cout << avg(arr) << endl;
  cout << most(arr) << endl;

  return 0;
}

int avg(int num[]) {
  int sum = 0;
  // for(int e : num)은 왜 안되는거지?
  for (int i = 0; i < SIZE; i++)
    sum += num[i];
  sum /= SIZE;
  return sum;
}

int most(int num[])
{
  int where[100] = {0};
  int ans = 0, ans_index = 0;
  for(int i = 0; i < SIZE; i++)
    where[num[i]/10]++;
  for(int i = 1; i < 100; i++) {
    if (ans < where[i])
    {
      ans = where[i];
      ans_index = i;
    }
  }
  return ans_index * 10;
}
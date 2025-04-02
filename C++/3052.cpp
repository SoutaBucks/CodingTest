#include <iostream>
//https://www.acmicpc.net/problem/3052
using namespace std;
/*  1. 모든 수를 입력받는다
 *  2. 나눈 나머지를 배열에 저장한다
 *  @ 여기서 나머지가 나올 수 있는 개수는 42개다 (나누어 떨어지는 경우도 포함)
 */
int sol(int []);

int main()
{
  int nums[10] = {0};
  for(int i = 0; i < 10; i++) {
    cin >> nums[i];
  }
  cout << sol(nums);

  return 0;
}

int sol(int ar[])
{
  bool remainder[42] = {false};   // remainder[0]은 '나누어 떨어짐' 을 의미
  int ans = 0;
  for(int i = 0; i < 10; i++)
    remainder[ar[i] % 42] = true;

  for(bool i : remainder) {
    if(i)
      ans++;
  }
  return ans;
}
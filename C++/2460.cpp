#include <iostream>
//https://www.acmicpc.net/problem/2460
int main()
{
  using namespace std;
  int in, out;
  // 변수 여러개를 초기화 할 때는 각각 초기화를 해주어야 쓰레기 값이 안들어간다
  int ans = 0, now = 0;
  for(int i = 0; i < 10; i++)
  {
    cin >> out >> in;
    now += (in - out);
    if(ans < now)
      ans = now;
  }
  cout << ans << endl;
  return 0;
}
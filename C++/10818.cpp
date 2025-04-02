#include <iostream>
//https://www.acmicpc.net/problem/10818
int main() {
  using namespace std;

  int n;
  cin >> n;
  int * arr = new int[n];
  for(int i = 0; i < n; i++)
    cin >> arr[i];
  int Mans = arr[0];
  int mans = arr[0];
  for(int i = 0; i < n; i++) {
    if(Mans < arr[i])
      Mans = arr[i];
    if(mans > arr[i])
      mans = arr[i];
  }
  cout << mans << " " << Mans << endl;
  return 0;
}

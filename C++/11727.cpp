#include <iostream>
//https://www.acmicpc.net/problem/11727
using namespace std;

int n;
int cache[1001];
const int MOD = 10007;

int sol(int);

int main() {
    for(int i = 0; i < 1001; i++)
        cache[i] = -1;
    cin >> n;
    cout << sol(n) << endl;
    return 0;
}

int sol(int x) {
    if(x == 0)  return 1;
    int & ret = cache[x];
    if(ret != -1)   return ret;
    ret = 0;
    ret += (sol(x - 2) * 2 + sol(x - 1)) % MOD;
    return ret;
}
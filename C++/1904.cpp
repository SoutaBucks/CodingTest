#include <iostream>

using namespace std;

//https://www.acmicpc.net/problem/1904

int sol(int);

const int MAX_N = 1000000;
const int MOD = 15746;
int cache[MAX_N + 1];
int n;

int main() {
    cin >> n;
    for(int i = 0; i < MAX_N + 1; i++)  cache[i] = -1;
    cout << sol(0) << endl;
    return 0;
}

/* 가지고 있는 타일은 '1', '00' 2가지
 * 길이가 n인 카드 조합 개수를 구해라
 * */

int sol(int x) {
    if(n - x <= 1)  return 1;
    int & ret = cache[x];
    if(ret != -1)   return ret;
    ret = 0;
    ret += (sol(x + 1) + sol(x + 2)) % MOD;
    return ret;
}
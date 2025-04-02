
#include <iostream>

using namespace std;
//https://www.acmicpc.net/problem/11052
const int MAX_N = 1000;
const int MAX_PRICE = 10000;
int prices[MAX_PRICE + 1];
int cache[MAX_N + 1][MAX_N + 1];
int n;

int sol(int, int);

int main() {
    cin >> n;
    prices[0] = 0; cache[0][0] = -1;
    for(int i = 0; i <= n; i++) {
        for(int j = 1; j <= n; j++)
            cache[i][j] = -1;
        if(i == 0) continue;
        cin >> prices[i];
    }
    cout << sol(0, 1) << endl;
    return 0;
}

int sol(int card, int idxcd) {
    if(card == n) return 0;
    if(idxcd > n)  return -987654321;
    int & ret = cache[card][idxcd];
    if(ret != -1)   return ret;
    ret = 0;
    for(int i = 0; i <= n; i++) {
        if(card + idxcd * i <= n)
            ret = max(ret, sol(card + idxcd * i, idxcd + 1) + prices[idxcd] * i);
    }
    return ret;
}
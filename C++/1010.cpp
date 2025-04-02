#include <iostream>
//https://www.acmicpc.net/problem/1010
using namespace std;

int n, m;
int cache[31][31][31];

int sol(int, int, int);

int main() {
    int t;
    cin >> t;
    while(t--) {
        for(int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                for (int z = 0; z < 31; z++)
                    cache[i][j][z] = -1;
            }
        }
        cin >> n >> m;
        cout << sol(0, 0, 0) << endl;
    }
    return 0;
}

/*
 * N개만큼 오른쪽 다리가 매칭이 되었다면 ok
 * 다리를 연결시킬 수 있는 경우의 수
 * 1. 가장 빠른 순으로 연결하기
 * 2. 동쪽 사이트 하나를 건너뛰고 연결하기
 * 이때 남은 동쪽 사이트가 서쪽 사이트보다 작다면 x
 * */

int sol(int w_site, int e_site, int connect) {
    if(n - w_site > m - e_site) return 0;   // N개를 다 못 짓는 경우
    if(connect == n)            return 1;   // N개를 다 지은 경우
    int & ret = cache[w_site][e_site][connect];
    if(ret != -1)   return ret;
    ret = 0;
    ret += sol(w_site + 1, e_site + 1, connect + 1) + sol(w_site, e_site + 1, connect);
    return ret;
}
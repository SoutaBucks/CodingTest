
//https://www.acmicpc.net/problem/11053
#include <iostream>
#include <vector>

using namespace std;

vector<int> seq(1000, 0);
vector<int> cache(1000, -1);
int n;


int sol(int);

int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        seq[i] = temp;
    }

    for(int i = 0; i < n; i++)
        sol(i);
    int ans = cache[0];
    for(int i = 1; i < n; i++)
        ans = max(ans, cache[i]);
    cout << ans << endl;
    return 0;
}

/* 맨끝부터 순열을 하나씩 세간다
 * 그 지점에서 시작되는 순 증가 순열 중 가장 긴 순열을 cache[x]에 저장한다
 * cache[x]에 저장된 순열이 있다면 바로 그 순열을 사용한다
 * */

int sol(int x) {
    //cout << "x = " << x << endl;
    if(x == n - 1) return cache[x] = 1;   // 마지막 숫자는 1개의 순열로 간주한다
    int & ret = cache[x];
    if(ret != -1)   return cache[x];    // 이미 순열을 찾았다면 그것을 사용한다

    ret = 1;
    for(int i = x; i < n; i++) {
        if(seq[x] < seq[i]) {
            ret = max(ret, 1 + sol(i));
        }
        //cout << "cache[" << x << "] = " << ret << endl;
    }
    return ret;
}
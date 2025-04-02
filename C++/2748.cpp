//https://www.acmicpc.net/problem/2748

#include <iostream>

using namespace std;

int n;
int64_t cache[91];

int64_t sol(int);

int main() {
    cache[0] = 0;
    cache[1] = 1;
    for(int i = 2; i < 91; i++)
        cache[i] = -1;
    cin >> n;
    cout << sol(n) << endl;
    return 0;
}

int64_t sol(int index) {
    if(index <= 1)  return (index == 1 ? 1 : 0);
    int64_t & ret = cache[index];
    if(ret != -1)   return ret;
    ret = 0;
    ret = sol(index - 1) + sol(index - 2);
    return ret;
}
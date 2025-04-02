#include <iostream>
#include <unordered_map>
#define MAX_CARD 500000
//https://www.acmicpc.net/problem/10816
using namespace std;

int N, M;
int cards[MAX_CARD + 1] = {0,};        // 가지고 있는 카드
int want_to_know[MAX_CARD + 1] = {0,}; // 알고 싶은 카드
unordered_map<int, int> m;

void solve() {
    for(int i = 0; i < N; i++) {
        if(m.find(cards[i]) == m.end())  // 해당 카드가 처음 발견 되었다면
            m.insert({cards[i], 1});      // map에 추가한다
        else
            m[cards[i]] += 1;
    }
}

int main()
{
    scanf("%d", &N);
    for(int i = 0; i < N; i++)
        scanf("%d", &cards[i]);
    scanf("%d", &M);
    for(int i = 0; i < M; i++)
        scanf("%d", &want_to_know[i]);
    solve();
    for(int i = 0; i < M; i++)
        printf("%d ", m[want_to_know[i]]);
    return 0;
}

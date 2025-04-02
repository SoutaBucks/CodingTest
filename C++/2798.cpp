//https://www.acmicpc.net/problem/2798
#include <iostream>
#include <vector>

/* 각 카드에는 양의 정수가 쓰여져 있따
 * N장의 카드 중 3장을 골라야한다
 * M보다는 작으면서 최대한 가깝게 만들어야 한다
 * 최대한 가까운 카드 3장의 합을 구해 출력하라
 * */

using std::vector;

int n, m;
int sol(vector<int>, int, int, int);

int main() {
    using std::cin;
    using std::cout;
    using std::endl;

    cin >> n >> m;
    vector<int> cards;
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        cards.push_back(temp);
    }

    cout << sol(cards, 0, 0, 0) << endl;
    return 0;
}

int sol(vector<int> card, int which, int sum, int cnt) {

    using std::cout;
    using std::endl;

    if(cnt == 3) {          // 카드를 3장을 뽑고
        if(sum > m)         // 3장 합이 m보다 크다면
            return -1;      // 안된다
        else                // 아니라면
            return sum;     // 값 반환
    }

    if(cnt > 3 || which >= n)  // 3장이상 뽑고, 고르는 카드 수가 넘어가면
        return -1;              // 안돼요

    int ans = -1;
    ans = std::max(sol(card, which + 1, sum + card[which], cnt + 1),
                   sol(card, which + 1, sum, cnt));
    return ans;
}
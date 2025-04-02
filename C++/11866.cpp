#include <iostream>
#include <queue>
#include <vector>
//https://www.acmicpc.net/problem/11866
using namespace std;

int n, k;
vector<int> sol();

int main() {
    cin >> n >> k;
    vector<int> ans = sol();
    cout << "<";
    for(int i = 0; i < n; i++) {
        cout << ans[i];
        if(i != n - 1)
            cout << ", ";
    }
    cout << ">";
    return 0;
}

vector<int> sol() {
    vector<int> ret;
    queue<int> queue;
    for(int i = 1; i <= n; i++) queue.push(i);
    while (!queue.empty()) {
        for(int i = 0; i < k - 1; i++) {
            int temp = queue.front();
            queue.pop();
            queue.push(temp);
        }
        ret.push_back(queue.front());
        queue.pop();
    }
    return ret;
}
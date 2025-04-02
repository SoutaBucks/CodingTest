#include <iostream>
#include <queue>
#include <vector>
//https://www.acmicpc.net/problem/13335
using namespace std;

int sol();
bool bridgeempty();
void showbridge();

int n, w, l;
/*
 * n개의 트럭
 * w M 다리 길이
 * L kg 다리가 견딜 수 있는 최대 하중
 * */
vector<int> truck;
int nowbridge[100];

int main() {
    cin >> n >> w >> l;
    for(int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        truck.push_back(temp);
    }
    cout << sol() << endl;
    return 0;
}

bool bridgeempty() {
    int flag = true;
    for(int i = 0; i < w; i++) {
        if (nowbridge[i] != 0) {
            flag = false;
            break;
        }
    }
    return flag;
}

void showbridge() {
    for(int i = 0; i < w; i++)
        cout << nowbridge[i] << ' ';
    cout << endl;
}

int sol() {
    queue<int> queue;
    for(int & t : truck)
        queue.push(t);

    int ans = 0;
    int nowkg = 0;
    while(!queue.empty()) {
        // 다리 왼쪽 끝에 있는 트럭을 먼저 처리해준다
        if (nowbridge[0] != 0) {
            nowkg -= nowbridge[0];
            nowbridge[0] = 0;
        }
        // 트럭을 1칸씩 앞으로 전진시킨다
        for (int i = 1; i < w; i++) {
            nowbridge[i - 1] = nowbridge[i];
            nowbridge[i] = 0;
        }
        if((nowkg + queue.front()) <= l && nowbridge[w - 1] == 0) {    // 트럭이 지나갈 수 있다면
            nowkg += queue.front(); // 현재 다리 중량에 더한다
            nowbridge[w - 1] = queue.front();   // 현재 다리 오른쪽에 둔다
            queue.pop();
        }
        ans += 1;
    }
    // 큐는 끝났는데 다리에 트럭이 남아있다면
    if (!bridgeempty()) {
        while(!bridgeempty()) {
            if (nowbridge[0] != 0) {
                nowkg -= nowbridge[0];
                nowbridge[0] = 0;
            }
            // 트럭을 1칸씩 앞으로 전진시킨다
            for (int i = 1; i < w; i++) {
                nowbridge[i - 1] = nowbridge[i];
                nowbridge[i] = 0;
            }
            ans += 1;
        }
    }
    return ans;
}
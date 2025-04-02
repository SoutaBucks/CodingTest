//https://www.acmicpc.net/problem/17298
#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int n;
int nums[1000000];
int ans[1000000];

void sol();

int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> nums[i];
        ans[i] = -1;
    }
    sol();
    for(int i = 0; i < n; i++)
        cout << ans[i] << ' ';
    cout << endl;
    return 0;
}

void sol() {
    stack<int> stack;
    for(int i = n - 1; i >= 0; i--) {
        int nowN = nums[i];
        while(!stack.empty() && nowN >= stack.top())
            stack.pop();
        if(stack.empty()) {
            stack.push(nowN);
            ans[i] = -1;
        }
        else {
            ans[i] = stack.top();
            stack.push(nowN);
        }
    }
}

/* 답
 * */


/*
 * 새롭게 떠오른 생각
 * 스택에는 값이 아닌 인덱스 번호를 삽입하자
 * 1. 기준이 되는 수를 앞에서 부터 고른다
 * 2. 그 수보다 작으면 스택에 넣는다 단 (내림차순이어야 한다)
 * 2 - 1. 스택 top수가 비교수보다 작으면 꺼내고 비교수를 스택에 넣는다.
 * 3. 기준이 되는 수의 오큰수를 찾으면 답을 배열에 넣는다
 * 4. 스택에 있는
 * */
//
//void sol() {
//    stack<int> stack;
//    for(int i = 0; i < n; i++) {
//        while(!stack.empty()) stack.pop();
//        int nown = nums[i]; // 기준이 되는 수
//        if(ans[i] != -1) continue;
//        for(int j = i + 1; j < n; j++) {    // nums[j] 비교 수
//            if(nown >= nums[j]) {
//                if (stack.empty() || nums[stack.top()] >= nums[j])
//                    stack.push(j);
//                else {
//                    while(!stack.empty() && nums[stack.top()] < nums[j]) {
//                        ans[stack.top()] = nums[j];
//                        stack.pop();
//                    }
//                    stack.push(j);
//                }
//            }
//            else {
//                ans[i] = nums[j];
//                while(!stack.empty()) {
//                    ans[stack.top()] = nums[j];
//                    stack.pop();
//                }
//                break;
//            }
//        }
//    }
//}

//
//void sol() {
//    stack<int> stack1;
//    stack<int> stack2;
//
//    for(int i = n - 1; i >= 0; i--)
//        stack1.push(nums[i]);
//
//    int nowN = stack1.size();
//    while(n > 0) {
//        int num = stack1.top();
//        bool flag = true; // 더 큰 값이 없다면
//        stack1.pop();
//        nowN = stack1.size();
//
//        for(int i = 0; i < nowN; i++) {
//            if(num < stack1.top()) {
//                ans.push_back(stack1.top());
//                nowN = stack2.size();
//                flag = false;
//                break;
//            }
//            stack2.push(stack1.top());
//            stack1.pop();
//        }
//        if(flag)
//            ans.push_back(-1);
//        for(int i = 0; i < nowN; i++) {
//            stack1.push(stack2.top());
//            stack2.pop();
//        }
//        n--;
//    }
//}

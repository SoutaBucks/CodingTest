//https://www.acmicpc.net/problem/17413

#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

void sol();
string str;
char ans[100000];

int main() {
    getline(cin, str);
    sol();
    return 0;
}

/* 태그가 나오면 그대로 ans에 넣는다
 * 태그가 아닌 일반 단어가 나오면
 * 시작 인덱스를 알아야 한다
 * 그래야 stack에서 빼내서 넣을 수 있다
 * 공백이 나오면 stack에서 pop실행
 * */

void sol() {
    stack<char> s;
    bool tag = false;
    int index = 0;
    for(int i = 0; i < str.length(); i++) {
        if(str[i] == '<') {
            ans[i] = '<';
            while(!s.empty()) {
                ans[index] = s.top();
                s.pop();
                index += 1;
            }
            tag = true;
        }
        else if(str[i] == '>') {
            ans[i] = '>';
            tag = false;
            index = i + 1;
        }
        else if(tag) {
            ans[i] = str[i];
            continue;
        }
        else if (str[i] == ' ') {
            while(!s.empty()) {
                ans[index] = s.top();
                s.pop();
                index += 1;
            }
            ans[index] = ' ';
            index += 1;
        }
        else
            s.push(str[i]);
    }
    while(!s.empty()) {
        ans[index] = s.top();
        s.pop();
        index += 1;
    }
    for(int i = 0; i < str.length(); i++)
        cout << ans[i];
    cout << endl;
}
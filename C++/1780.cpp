
//https://www.acmicpc.net/problem/1780
#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> paper;
vector<int> answer(3, 0);
void sol(int, int, int, int);
bool allsame(int, int, int, int);

int main() {
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) {
        vector<int> templine;
        for(int j = 0; j < n; j++) {
            int temp;
            cin >> temp;
            if(temp == -1)
                temp = 2;
            templine.push_back(temp);
        }
        paper.push_back(templine);
    }

    sol(0, n, 0, n);
    cout << answer[2] << endl;
    cout << answer[0] << endl;
    cout << answer[1];
    return 0;
}

bool allsame(int xfrom, int xto, int yfrom, int yto) {
    int flag = paper[yfrom][xfrom];
//    cout << "flag = " << flag << endl;
    for(int i = xfrom; i < xto; i++) {
        for(int j = yfrom; j < yto; j++) {
            if(paper[j][i] != flag)
                return false;
        }
    }
//    cout << "hi" << endl;
    return true;
}

void sol(int xfrom, int xto, int yfrom, int yto) {
//    cout << xfrom << " ~ " << xto << " " << yfrom << " ~ " << yto << endl;
    if(xto - xfrom == 1 || allsame(xfrom, xto, yfrom, yto))  {      // 종이가 자를곳이 없다면
//        cout << "paper[yfrom][xfrom]" << paper[yfrom][xfrom] << endl;
        answer[paper[yfrom][xfrom]] += 1;                           // 종이가 다 똑같다면
        return;
    }

    int divide = (xto - xfrom) / 3;
    sol(xfrom, xfrom + divide, yfrom, yfrom + divide);
    sol(xfrom, xfrom + divide, yfrom + divide, yfrom + divide * 2);
    sol(xfrom, xfrom + divide, yfrom + divide * 2, yto);
    sol(xfrom + divide, xfrom + divide * 2, yfrom, yfrom + divide);
    sol(xfrom + divide, xfrom + divide * 2, yfrom + divide, yfrom + divide * 2);
    sol(xfrom + divide, xfrom + divide * 2, yfrom + divide * 2, yto);
    sol(xfrom + divide * 2, xto, yfrom, yfrom + divide);
    sol(xfrom + divide * 2, xto, yfrom + divide, yfrom + divide * 2);
    sol(xfrom + divide * 2, xto, yfrom + divide * 2, yto);
    return;
}

#include <iostream>
#include <vector>
#include <stdio.h>
//https://www.acmicpc.net/problem/2447

using namespace std;

void sol(int, int, int, int, bool);
vector<vector<int>> board(6561, vector<int>(6561, 0));

int main() {
    int n;
    cin >> n;
    sol(0, n, 0, n, 0);
    for(int y = 0; y < n; y++) {
        for(int x = 0; x < n; x++) {
            if (board[y][x] == 1)
                printf("*");
            else
                printf(" ");
        }
        printf("\n");
    }
    return 0;
}
// * => 1 , 빈칸 -> 0
void sol(int xfrom, int xto, int yfrom, int yto, bool blank) {
    // 별조각을 1개만 놓을 수 있을 때
    // 빈칸, 별을 구별해서 하자
    if(xto - xfrom == 1) {
        if(blank) {
            board[yfrom][xfrom] = 0;
            return;
        }
        else {
            board[yfrom][xfrom] = 1;
            return;
        }
    }
    int divide = (xto - xfrom) / 3;
    sol(xfrom, xfrom + divide, yfrom, yfrom + divide, blank);
    sol(xfrom, xfrom + divide, yfrom + divide, yfrom + divide * 2, blank);
    sol(xfrom, xfrom + divide, yfrom + divide * 2, yto, blank);
    sol(xfrom + divide, xfrom + divide * 2, yfrom, yfrom + divide, blank);
    sol(xfrom + divide, xfrom + divide * 2, yfrom + divide, yfrom + divide * 2, 1);
    sol(xfrom + divide, xfrom + divide * 2, yfrom + divide * 2, yto, blank);
    sol(xfrom + divide * 2, xto, yfrom, yfrom + divide, blank);
    sol(xfrom + divide * 2, xto, yfrom + divide, yfrom + divide * 2, blank);
    sol(xfrom + divide * 2, xto, yfrom + divide * 2, yto, blank);
}
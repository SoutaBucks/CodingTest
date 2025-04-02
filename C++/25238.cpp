#include <iostream>
//https://www.acmicpc.net/problem/25238
bool okayAttack(double, double);

int main(void)
{
    using namespace std;

    int a, b;
    cin >> a >> b;
    cout << okayAttack(a, b) ? 1 : 2;
    return 0;
}

bool okayAttack(double md, double ud)
{
    double real_ud;
    real_ud = md - md * (ud / 100);
    return (real_ud >= 100) ? false : true;
}
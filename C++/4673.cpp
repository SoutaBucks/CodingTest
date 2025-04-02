//https://www.acmicpc.net/problem/4673
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

/* 각 자리수를 더하는 것을 한 조각으로 한다
 * 10으로 나누어가면서 첫번째 자리수를 더해간다!
 * 배열을 오름차순으로 정렬한 후 재로르 하여 없는 것을 출력한다
 * */
using std::vector;

int all_add(int); // 각 자리수의 합 + 주어진 수 을 반환하는 함수

int main() {
    using std::cin;
    using std::cout;
    using std::endl;

    vector<int> ar;
    vector<int> num;
    for(int n = 1; n <= 10000; n++) {
        ar.push_back(n + all_add(n));   // d(n) 수열
        num.push_back(n);               // 자연수
    }
    num.push_back(10001);

    std::sort(ar.begin(), ar.end());
    ar.erase(std::unique(ar.begin(), ar.end()), ar.end());

    int i = 0; int j = 0;
    while(j <= 10000) {
//        cout << "ar[" << i << "] = " << ar[i] << endl;
//        cout << "num[" << j << "] = " << num[j] << endl;
//        cout << "-----------------------------------------" << endl;
        if(ar[i] != num[j]) {
            cout << num[j] << endl;
            j++;
        }
        else if(ar[i] == num[j]) {
            i++;
            j++;
        }
    }

    return 0;
}

int all_add(int num) {
    if(num < 10)        // 1의 자리만 남았따면
        return num;
    return (num % 10) + all_add(num/10);
}
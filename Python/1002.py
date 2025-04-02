from sys import stdin
from math import *
//https://www.acmicpc.net/problem/1002
def sol(jo_p, jo_r, baek_po, baek_r):
    # 각 중점 사이 거리 계산
    dist_po = sqrt((jo_p[0] - baek_po[0]) ** 2 + (jo_p[1] - baek_po[1]) ** 2)
    # 중점이 같고 반지름도 같다면
    if dist_po == 0 and jo_r == baek_r:
        return -1   # 합동
    # 1. 중점 거리 = 반지름 합(외부) 2. 중점 거리 + 반지름 = 다른 반지름 (내부)
    elif dist_po == jo_r + baek_r or dist_po + jo_r == baek_r or dist_po + baek_r == jo_r:
        return 1    # 접한다
    # 1. 중점 거리 > 반지름 합(외부) 2. 중점 거리 + 반지름 < 다른 반지름 (내부)
    elif dist_po > jo_r + baek_r or dist_po + jo_r < baek_r or dist_po + baek_r < jo_r:
        return 0    # 안 만난다
    else:           # 다 아니라면
        return 2    # 서로 다른 두 점에서 만난다

def main():
    T = int(stdin.readline())
    for _ in range(T):
        x1, y1, r1, x2, y2, r2 = map(int, stdin.readline().split())
        print(sol([x1, y1], r1, [x2, y2], r2))

if __name__ == '__main__':
    main()

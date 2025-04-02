from sys import stdin
//https://www.acmicpc.net/problem/1085
def solution(there, here):
    return min(there[0] - here[0], here[0], there[1] - here[1], here[1])

x, y, w, h = map(int, stdin.readline().split())
print(solution([w, h], [x, y]))
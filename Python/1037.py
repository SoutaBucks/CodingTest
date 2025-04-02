from sys import stdin
//https://www.acmicpc.net/problem/1037
def solution(lst):
    lst.sort()
    return lst[0] * lst[-1]

def main():
    n   = int(stdin.readline())
    lst = list(map(int, stdin.readline().split()))
    print(solution(lst))

if __name__ == '__main__':
    main()
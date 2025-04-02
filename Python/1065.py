//https://www.acmicpc.net/problem/1065
def hansu(x):
    n = 0; num_list = []
    if x < 100:
        return x
    else:
        n = 99
        for i in range(100, x+1):
            num_list = list(map(int, list(str(i))))
            if (num_list[0] - num_list[1]) == (num_list[1] - num_list[2]):
                n += 1
        return n
num = int(input())
ans = hansu(num)
print(ans)
from sys import stdin
//https://www.acmicpc.net/problem/2460
def main():
  ans, now = 0, 0
  for i in range(10):
    off, on = map(int, stdin.readline().split(" "))
    now += (on - off)
    if(ans < now):
      ans = now
  print(ans)

if __name__ == "__main__":
  main()
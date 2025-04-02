from sys import stdin
import re
//https://www.acmicpc.net/problem/1152

def main():
  str = stdin.readline()
  print(len(re.findall("\w+", str)))

if __name__ == "__main__":
  main()
from typing import TextIO


num = int(input())

for _ in range(num):
    word = input()
    total=0
    for letter in word:
        total+=ord(letter)-96
    print(total)
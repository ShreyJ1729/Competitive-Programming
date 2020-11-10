inputs = input().split()

a, b, k = map(int, inputs)

def isPalindrome(n):
    if list(reversed(n)) == n:
        return True
    return False


def numberToBase(n, b):
    if n == 0:
        return [0]
    digits = []
    while n:
        digits.append(int(n % b))
        n //= b
    return digits[::-1]


def checkBases(number, top_bound):
    status = True
    for base in range(2, top_bound+1):
        if not isPalindrome(numberToBase(number, base)):
            status = False
            break
    if status:
        return True
    return False

count = 0
for num in range(a, b+1):
    if checkBases(num, k):
        count += 1

print(count)
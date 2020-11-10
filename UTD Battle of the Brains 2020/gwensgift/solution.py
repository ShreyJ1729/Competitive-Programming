import math


def gwensGift(n, k):
    ways = math.factorial(n - 1)
    if k < 1 or k > ways:
        return

    seq = []
    ways = ways // (n - 1)
    num = math.ceil(k / ways)

    if num == 0: num = 1
    seq.append(num)

    for i in range(1, n - 1):
        if i > 1:
            ways = ways // (n - i)

        bucket = list(range(1, n))
        posB = ((k - 1) % ways) // (ways // (n - 1 - i))
        total = 0

        for j in range(i - 1, -1, -1):
            total += seq[j]
            appnum = ((1000 * n) - total) % n
            bucket[appnum - 1] = 0

        for j in range(len(bucket)):
            if bucket[j] != 0:
                if posB == 0:
                    break
                posB -= 1

        seq.append(bucket[j])
    return seq


ab = input().split()
n = int(ab[0])
k = int(ab[1])
gwenList = gwensGift(n, k)
outString = ""
if gwenList is not None:
    for i in range(len(gwenList)):
        if i != len(gwenList) - 1:
            outString += str(gwenList[i]) + " "
        else:
            outString += str(gwenList[i])
    print(outString)
else:
    print("None")
def formatHeight(X, Y):
    print(f"{X}'{Y}\"")

def formatDate(X, Y, Z):
    if len(Z)==1:
        Z="0"+Z
    if len(Y)==1:
        Y="0"+Y
    print(f"{X}{Y}{Z}")

def concatenate(arr):
    print(",".join(arr))

num = int(input())
for _ in range(num):
    line = input().split(" ")
    if line[0]=="formatHeight":
        formatHeight(line[1], line[2])
    elif line[0]=="formatDate":
        formatDate(line[1], line[2], line[3])
    else:
        line.remove("concatenate")
        concatenate(line)

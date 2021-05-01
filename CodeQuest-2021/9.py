num = int(input())

arr = [100, 50, 20, 10, 5, 2, 1, 0.25, 0.10, 0.05, 0.01]

for _ in range(num):
    money = float(input())
    text = ""
    added=False
    for el in arr:
        curr=0
        while (el-money<=0.001):
            money-=el
            curr+=1
        else:
            text+=str(curr)
    # print(money)
    print(text)
# # yn=y_n-1 + h*f'(x_n-1)
import math

num = int(input())

def fp(x):
    if x==0:
        return 1
    else:
        return math.sin(x)/x

for _ in range(num):
    x0, y0, h, n = [float(i) for i in input().split()]
    yn = y0
    xn = x0


    for i in range(int(n)):
        # print(i, yn, xn)
        yn = yn + h*fp(xn)
        xn = h+xn
    print(round(yn, 3))
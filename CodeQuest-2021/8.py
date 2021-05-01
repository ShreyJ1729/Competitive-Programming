num = int(input())

def norm(matrix):
    total=0
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            total+=abs(matrix[i][j])**2
    return round(total**0.5 * 100)/100

for _ in range(num):
    r, c = [int(i) for i in input().split(" ")]
    # print(r, c)
    matrix = []
    for row in range(r):
        matrix.append([int(i) for i in input().split(" ")])
    print(f"{norm(matrix):.2f}")


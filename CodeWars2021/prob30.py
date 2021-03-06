# with open("student_datasets/prob17-6-out.txt") as f:
#     answer = f.read()
#     print(answer)
import numpy as np

def index_2d(myList, v):
    return [[x, y] for x, li in enumerate(myList) for y, val in enumerate(li) if val=="<>"]


with open("student_datasets/prob30-1-in.txt") as f:
    data = f.readlines()[1:]
data = [i.rstrip("\n") for i in data]

arr = []
for i in data:
    ar = i.split(" ")
    arr.append(ar) 

arr = np.array(arr)

garbs = index_2d(arr, "<>")

print(arr)


for startpos in garbs:
    print(startpos)
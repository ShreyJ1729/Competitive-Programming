# with open("student_datasets/prob17-6-out.txt") as f:
#     answer = f.read()
#     print(answer)
def get_sec(time_str):
    """Get Seconds from time."""
    h, m, s = time_str.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)
import math
with open("input.txt") as f:
    data = f.read().split(" ")
data[-1]=data[-1].rstrip("\n")
start = get_sec(data[0])
end = get_sec(data[1])+40

time = end-start

dist = 5 - 0.01 * time
dist = max(0, dist)

dist = round(dist,2)
def show():
    num_periods = math.floor(dist/0.2)
    for i in range(5):
        print(f"|{' '*num_periods}|")
    print(f"|{'.'*num_periods}|")
if (dist<0.20):
    for i in range(6):
        print("||")
    print("CURSE MY METAL BODY, I WASN'T FAST ENOUGH!")
elif (dist==0.20):
    show()
    print("THIS IS SOME RESCUE!")
else:
    show()
    print("THE FORCE WAS WITH YOU")

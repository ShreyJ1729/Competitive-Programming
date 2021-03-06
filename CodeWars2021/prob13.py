# with open("student_datasets/prob13-6-out.txt") as f:
#     answer = f.read()
#     print(answer)

with open("input.txt") as f:
    data = f.readlines()

data = [i.rstrip("\n") for i in data]
import math
name = data[0]
length = int(data[1])
accel = float(data[2])
width = float(data[3])

time = math.sqrt(2*length/accel)
speed=time*accel

distance = speed*speed/9.805

if (distance<width-5):
    ans="SPLASH!"
elif (distance>=width-5 and distance <= width):
    ans="BARELY MADE IT!"
else:
    ans="LIKE A BOSS!"

final = f"{name} will reach a speed of {round(speed, 2)} m/s on a {length} meter ramp, crossing {round(distance, 1)} of {width} meters, {ans}"
print(final)
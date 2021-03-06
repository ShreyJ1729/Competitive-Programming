# with open("student_datasets/prob12-4-out.txt") as f:
#     print(f.read())

with open("input.txt") as f:
    data = f.read().split(" ")
    
data[-1] = data[-1].rstrip("\n")

name = data[0]
speed = float(data[1])
lenunit = data[2]
timeunit = data[-1]

if lenunit=="MILES":
    speed*=1609.34
elif lenunit=="KILOMETERS":
    speed*=1000
elif lenunit=="YARDS":
    speed*=0.9144
elif lenunit=="FEET":
    speed*=0.30487804878
elif lenunit=="INCHES":
    speed*=0.0254
elif lenunit=="CENTIMETERS":
    speed*=0.01

if timeunit=="HOUR":
    speed*=0.000277778
elif timeunit=="MINUTE":
    speed*=0.0166667

height = speed*speed / (2*9.805)
height = round(height, 2)

if (height<25.00):
    ans = "SPLAT!"
elif (height>=25.00 and height<50):
    ans="SUCCESS!"
else:
    ans="OUCH!"
print(f"{name} will launch the messenger {height} meters high. {ans}")
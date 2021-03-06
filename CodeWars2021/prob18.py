# with open("student_datasets/prob18-5-out.txt") as f:
#     answer = f.read()
#     print(answer)

with open("input.txt") as f:
    data = f.readlines()
data = [i.rstrip("\n") for i in data]

name = data[0]
pplreq = int(data[1])
timecanrun = int(data[2])*60
startup = int(data[3])
output = float(data[4])/3600
pplhave = int(data[5])

if (timecanrun-startup<=0):
    output=0

if pplhave<pplreq:
    print(f"{name} can generate 0.00 watts/second")
    print("WHOAH, HEAVY!")
    exit()
if ((timecanrun-startup)*output >= 1210000000):
    print(f"{name} can generate {round(output, 2):.2f} watts/second")
    print("MARTY CAN MAKE IT!")
else:
    print(f"{name} can generate {round(output, 2):.2f} watts/second")
    print("WHOAH, HEAVY!")
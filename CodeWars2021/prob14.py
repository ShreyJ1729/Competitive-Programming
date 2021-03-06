# with open("student_datasets/prob14-5-out.txt") as f:
#     answer = f.read()
#     print(answer)

with open("input.txt") as f:
    data = f.read().split(' ')

nums = int(data[0])


try:
    size=int(data[1])
except:
    frac = data[1].split("/")
    num=int(frac[0])
    dnum=int(frac[1])
    size=num/dnum

cap=float(data[2].rstrip("\n"))

kg = nums*size*0.45
power = 7.5*kg

if (power<=cap):
    ans="the Mask can eat it!"
else:
    ans="the Mask should not eat it!"

print(f"{round(power,2):.2f} {ans}")
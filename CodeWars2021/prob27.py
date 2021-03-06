# with open("student_datasets/prob17-6-out.txt") as f:
#     answer = f.read()
#     print(answer)

with open("student_datasets/prob27-5-in.txt") as f:
    data = f.read().rstrip("\n")

steps=[]

for i in data:
    if (i=="T"):
        steps.append("4 E")
    elif (i=="&"):
        steps.append("2 W")
    elif (i=="F"):
        steps.append("JUMP")
    elif (i=="!"):
        steps.append("1 N")
    elif (i=="|"):
        steps.append("3 S")

data = data.replace("!", " not ")
data = data.replace("|", " or ")
data = data.replace("&", " and ")

data = data.replace("T", "True")
data = data.replace("F", "False")

if (eval(data)):
    for i in steps:
        print(i)
else:
    print("I am disinclined to acquiesce to your request")
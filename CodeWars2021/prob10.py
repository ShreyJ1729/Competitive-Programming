with open("input.txt") as f:
    data = f.readlines()

data = [i[:-1] for i in data]

tasty = []

for i in data:
    if (i=="END"):
        break
    time = i.split(" ")[1].split(":")
    vpf = int(i.split(" ")[-1])
    endtime = vpf*10 + int(time[0])*60+int(time[1])
    if endtime < 17*60:
        tasty.append(i.split(" ")[0].split("-")[1])

tasty = tuple(tasty)

if (len(tasty)==0):
    print("Blah, blah, blah, time to order delivery")
else:
    print("Villagers " + str(tasty).replace("'","") + " look tasty")
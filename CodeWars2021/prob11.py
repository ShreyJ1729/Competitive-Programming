with open("input.txt") as f:
    data = f.readlines()

data = [i[:-1] for i in data]
findf = "?" in data[0]
findk = "?" in data[1]
findx = "?" in data[2]
if not findf:
    f = float(data[0].split(" ")[1])
if not findk:
    k = float(data[1].split(" ")[1])
if not findx:
    x = float(data[2].split(" ")[1])

if (findf):
    print(f"F {round(-k*x, 2):.2f}", )
elif (findk):
    print(f"K {round(-f/x, 2):.2f}", )
else:
    print(f"X {round(-f/k, 2):.2f}", )

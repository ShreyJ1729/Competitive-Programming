# with open("student_datasets/prob14-5-out.txt") as f:
#     answer = f.read()
#     print(answer)


with open("student_datasets/prob15-1-in.txt") as f:
    data = [i.rstrip("\n") for i in f.readlines()]
    data.remove("END")


gemrank = ['Lapis',
'Topaz',
'Tourmaline',
'Sapphire',
'Peridot',
'Ruby',
'Pearl',
'Emerald',
'Diamond',
'Aquamarine',
'Amethyst',
'Garnet',]

data = sorted(data)
gemnames=[]
for name in data:
    if any(gemname in name for gemname in gemrank):
        data.remove(name)
        gemnames.append(name)



gemnames = sorted(gemnames)

print(data)
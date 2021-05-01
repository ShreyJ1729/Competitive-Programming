
alphas = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]

num = int(input())

for _ in range(num):
    cases = int(input())
    text = ""

    for i in range(cases):
        text+=input()

    # print(text)

    text2=""
    for letter in text:
        if letter.isalpha():
            text2+=letter.capitalize()

    # print(text2)

    for alpha in alphas:
        instances = text2.count(alpha)
        freq = instances/len(text2)*100
        freq=round(freq*100)/100
        print(f"{alpha}: {freq:.2f}%")

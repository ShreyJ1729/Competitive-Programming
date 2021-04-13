def findSeat(capacity, carriages):
    share = capacity/len(carriages)
    for i in range(len(carriages)):
        if (carriages[i]<=share/2):
            return i
    return -1

def minutesPassed(start, end):
    stimearr= [int(i) for i in start.split(" ")[1].split(":")]
    etimearr= [int(i) for i in end.split(" ")[1].split(":")]
    times = 60*(etimearr[0] - stimearr[0]) + (etimearr[1] - stimearr[1])
    dates = 1440*(int(end.split("/")[1].split(" ")[0]) - int(start.split("/")[1].split(" ")[0]))
    return times + dates
    

def removeWord(sentence, word):
    return sentence.replace(word, "").replace("  ", " ").strip(" ")

def persistence(n, type):
    count = 0
    if type=="a":
        while n>=10:
            dig = 0
            for i in str(n):
                dig+=int(i)
            n = dig
            count+=1
    elif type=="m":
        while n>=10:
            prod = 1
            for i in str(n):
                prod*=int(i)
            count+=1
            n = prod
    return count

def bucketize(phrase, n):
    arr = phrase.split(" ")
    if (max(list(map(len, arr)))>n): return []
    ans=[]
    accum=""
    for i, word in enumerate(arr):
        if (len(accum)+len(word)+1<=n):
            if (len(accum)==0): accum=word
            else: accum=accum+" "+word
        else:
            ans.append(accum)
            accum=word
        if i==len(arr)-1: ans.append(accum)
    return ans

def reverseHalf(array):
    odds = []
    evens = []
    for i in range(1, len(array), 2):
        odds.append(array[i])
    for i in range(0, len(array), 2):
        evens.append(array[i])
    evens = list(reversed(evens))
    for i in range(len(array)):
        if i%2==0:
            array[i] = evens.pop()
        else:
            array[i] = odds.pop()
    return array

def josephus(n, interval):
    # and just a touch of recursive magic
    return 1 if n == 1 else (josephus(n-1, interval)+interval-1)%n+1

def ascending(numbers):
    for i in range(int(len(numbers)/2)):
        str2 = numbers[0:i+1]
        num = int(str2)
        while (len(str2) < len(numbers)):
            num += 1
            str2 = str2 + str(num)
        if (str2 == numbers):
            return True
    return False

def nextNumber(n):
    ans = 0
    numarr = [int(i) for i in str(n)]
    n = len(str(n))
    for i in range(n-1,0,-1):
        if numarr[i] > numarr[i-1]: break
    if i == 1 and numarr[i] <= numarr[i-1]: return n
    x = numarr[i-1]
    least = i
    for j in range(i+1,n):
        if numarr[j] > x and numarr[j] < numarr[least]: least = j
    numarr[least],numarr[i-1] = numarr[i-1], numarr[least]
    for j in range(i): ans = ans * 10 + numarr[j]
    numarr = sorted(numarr[i:])
    for j in range(n-i): ans = ans * 10 + numarr[j]
    return ans
       
def waysToClimb(numOfStairs):
    if numOfStairs==1:
        return 1
    elif numOfStairs==2:
        return 2
    else:
        return waysToClimb(numOfStairs-1)+waysToClimb(numOfStairs-2)
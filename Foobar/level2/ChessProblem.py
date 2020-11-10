def genPossibles(x, y):
  arr = [[x+1, y+2], [x+1, y-2], [x+2, y+1], [x-2, y+1], [x-1, y+2], [x-1, y-2], [x+2, y-1], [x-2, y-1]]
    
  arr2 = list(arr)
  for idx, (i, j) in enumerate(arr):
    if i<0 or j<0 or i>7 or j>7:
      arr2[idx] = None
    
  return [k for k in arr2 if k != None]

def genNext(pos):
    x = pos[0]
    y = pos[1]
    possibles = genPossibles(x, y)
    return possibles

def numToCoord(num):
  return [num%8, num//8]

def coordToNum(coord):
  return 8*coord[1]+coord[0]

def solution(src, dest):
  flatten = lambda l: [item for sublist in l for item in sublist]
  if src == dest:
    return 0
  pathFound = False
  count = 0
  src = [numToCoord(src)]
  while not pathFound:
    src = flatten([genNext(i) for i in src])
    count += 1
    for coord in src:
      if coordToNum(coord) == dest:
        return count


print(solution(int(input("Enter src: ")), int(input("Enter dest:"))))
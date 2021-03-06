
def humanbytes(B):
   'Return the given bytes as a human friendly KB, MB, GB, or TB string'
   B = float(B)
   KB = float(1024)
   MB = float(KB ** 2) # 1,048,576
   GB = float(KB ** 3) # 1,073,741,824
   TB = float(KB ** 4) # 1,099,511,627,776
   PB = float(KB ** 5) # 1,099,511,627,776
   EB = float(KB ** 6) # 1,099,511,627,776
   ZB = float(KB ** 7) # 1,099,511,627,776

   if B < KB:
      return '{0} {1}'.format(B,'B')
   elif KB <= B < MB:
      return '{0:.2f} KiB'.format(B/KB)
   elif MB <= B < GB:
      return '{0:.2f} MiB'.format(B/MB)
   elif GB <= B < TB:
      return '{0:.2f} GiB'.format(B/GB)
   elif TB <= B < PB:
      return '{0:.2f} TiB'.format(B/TB)
   elif PB <= B < EB:
      return '{0:.2f} PiB'.format(B/PB)
   elif EB <= B < ZB:
      return '{0:.2f} EiB'.format(B/EB)
   elif ZB <= B:
      return '{0:.2f} ZiB'.format(B/ZB)

# with open("student_datasets/prob16-5-out.txt") as f:
#     answer = f.read()
#     print(answer)
with open("input.txt") as f:
    data = f.read()

num=int(data.split(" ")[0])
unit=data.split(" ")[1].rstrip("\n")

conv = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB']

num = num * 10**(3*conv.index(unit))
print(humanbytes(num))
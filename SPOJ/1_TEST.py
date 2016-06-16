import sys

for line in sys.stdin:
    if int(line)==42:
        break
    else:
        print(line)
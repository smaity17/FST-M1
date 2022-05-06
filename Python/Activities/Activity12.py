def calcSum(num):
    if num >= 0:
        return num + calcSum(num-1)
    else:
        return 0

result = calcSum(10)

print(result)
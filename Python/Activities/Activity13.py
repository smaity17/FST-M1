def calcSum(numbers):
    sum = 0
    for i in numbers:
        sum = sum + i
    return sum

numList = [1,2,3,4,5,6,7,8,9]

print(calcSum(numList))
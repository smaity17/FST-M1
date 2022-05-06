inputList = list(input("Enter CSV: ").split(","))
sum = 0
for i in inputList:
    sum += int(i)
print(f"Sum of list is {sum}") 
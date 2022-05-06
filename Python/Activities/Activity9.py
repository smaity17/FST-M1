# firstList = [1,2,3,4,5,6]
# secondList = [1,2,3,4,5,6]
firstList = list(input("Enter CSV: ").split(","))
secondList = list(input("Enter CSV: ").split(","))

newList =[]
i = 0

for i in firstList:
    if(i % 2 == 0):
        newList.append(i)
for i in secondList:
    if(i % 2 != 0):
        newList.append(i)
print(newList)
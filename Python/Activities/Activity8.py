inputList = list(input("Enter CSV: ").split(","))

firstElement = inputList[0]
lastElement = inputList[-1]

if(firstElement == lastElement):
    print("True")
else:
    print("False")
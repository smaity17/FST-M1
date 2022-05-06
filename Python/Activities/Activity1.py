from unicodedata import name


name = input("Enter Name: ")
age = input("Enter age: ")
remainingAge = 100 - int(age)
outPutMsg = "Hello {}, you are {} years close to turn 100 years old"
print(outPutMsg.format(name, int(remainingAge)))
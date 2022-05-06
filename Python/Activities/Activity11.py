fruit_dict = {
    "apple": 40,
    "banana": 12,
    "guava": 40,
    "mango": 80
}

f = input("Enter fruit to find: ").lower()

for fruit in fruit_dict.keys():
    if fruit == f:
        print("Fruit found")
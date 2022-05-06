import pandas as pd

data = pd.read_csv("Credentials.csv")

print("Usernames:")
print(data["Usernames"])

print("====================")
print("Printing username and password of second row seperated by | in below")
print(data["Usernames"][1], "|", data["Passwords"][1])

print("====================")
print("Printing Usernames in assending order")
print(data.sort_values("Usernames"))

print("====================")
print("Printing Passwords in descending order")
print(data.sort_values("Passwords", ascending=False))

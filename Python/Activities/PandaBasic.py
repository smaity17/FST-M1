import pandas as pd

#--------------Data Frame Hands on Started-------------------
# data = {
#     "X" : [1,2,3,4],
#     "Y" : [5,6,7,8],
#     "Z" : [9,0,1,2]
# }

# dataTable = pd.DataFrame(data)
# print("---------Converting the Data into Table------------")
# print(dataTable)
#--------------Data Frame Hands on Ended-------------------

dataframe = pd.read_csv("employees.csv")
print(dataframe)
print(dataframe["Name"][1])
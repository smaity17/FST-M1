import pandas as pd

dataframe = pd.read_excel("BioData.xlsx")
print(f"Total Rows: {dataframe.shape[0]}")
print(f"Total Column: {dataframe.shape[1]}")
print("==============")
print(dataframe["Email"])
print("==============")
print(dataframe.sort_values("FirstName"))
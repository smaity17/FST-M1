import pandas as pd

data = {
    "Usernames" : ["admin", "Charles", "Deku"],
    "Passwords" : ["password", "Charl13", "AllMight"]
}

pd.DataFrame(data).to_csv("Credentials.csv",index=False)
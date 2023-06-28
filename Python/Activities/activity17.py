import pandas
data={
    "Usernames" : ["admins","Charles","Deku"],
    "Passwords" : ["password","Charl13","AllMight"]
}
dataframe=pandas.DataFrame(data)
print(dataframe)
dataframe.to_csv("../resources/activity17_userlogin.csv",index=False)
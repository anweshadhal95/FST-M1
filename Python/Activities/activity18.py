import pandas
dataframe = pandas.read_csv('../resources/activity17_userlogin.csv')
print(dataframe)
print("==============")
print("Print the usernames")
print(dataframe["Usernames"])
print("==============")
print(dataframe["Usernames"][1],dataframe["Passwords"][1])
print("==============")
print("Printing Usernames column in ascending order")
print(dataframe.sort_values("Usernames"))
print("==============")
print("Printing Password column in descending order")
print(dataframe.sort_values("Passwords",ascending=False))
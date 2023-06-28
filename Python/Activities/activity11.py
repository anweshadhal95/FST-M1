Fruit_Shop={
    "apple": 100,
    "banana": 20,
    "kiwi": 200,
    "cherry": 50,
    "orange": 60
}
print(Fruit_Shop)
n=input("enter the fruit you want to check availability of: ")
if(n in Fruit_Shop):
    print(n+" Fruit is available")
else:
    print(n+" Fruit is not available")
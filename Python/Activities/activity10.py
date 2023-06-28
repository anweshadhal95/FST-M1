list1=[]
tuple1=()
n=int(input("The length of tuple"))
print(n)
for i in range(n):
    k=int(input("Enter the tuple element"))
    list1.append(k)
tuple1=tuple(list1)
print(tuple1)
list2=[]
tuple2=()
for l in range(n):
    if(tuple1[l]%5==0):
        list2.append(tuple1[l])
tuple2=tuple(list2)
print(tuple2)
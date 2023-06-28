list1=[]
n=int(input("enter the length of list1: "))
for i in range(n):
    k=int(input("enter the element: "))
    list1.append(k)
#print(list1)

list2=[]
m=int(input("enter the length of list1: "))
for j in range(m):
    l=int(input("enter the element: "))
    list2.append(l)
#print(list2)
list3=[]
for x in range(n):
    if(not(list1[x]%2==0)):
        list3.append((list1[x]))
#print(list3)
for x in range(n):
    if(list2[x]%2==0):
        list3.append((list2[x]))
print(list1)
print(list2)
print(list3)
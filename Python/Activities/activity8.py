list1=[]
n=int(input("enter the length of list1: "))
for i in range(n):
    k=int(input("enter the element: "))
    list1.append(k)
print(list1)

list2=[]
m=int(input("enter the length of list1: "))
for j in range(m):
    l=int(input("enter the element: "))
    list2.append(l)
print(list2)

if((list1[0] == list2[0]) and (list1[-1] == list2[-1])):
    print(True)
else:
    print(False)
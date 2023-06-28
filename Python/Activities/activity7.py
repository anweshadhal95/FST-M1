list1=[]
sum=0
n=int(input("enter the length of list: "))
print(n)
for i in range(n):
    k=int(input("enter the element: "))
    list1.append(k)
print(list1)
for i in range(n):
    sum=sum+list1[i]
print(sum)
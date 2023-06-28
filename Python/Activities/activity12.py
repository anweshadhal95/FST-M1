def add_function(n):
    if(n<1):
        return n
    else:
        return n+add_function(n-1)
num = int(input("Enter a number: "))
print("The sum is: ", add_function(num))
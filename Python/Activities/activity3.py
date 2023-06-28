#Get the user's names
user1=input("enter the user1's name: ")
user2=input("enter the user2's name: ")
#Get user's choice
user1_answer=input("enter the user1's choice from Rock,Paper,Scissors: ").lower()
user2_answer=input("enter the user2's choice from Rock,Paper,Scissors: ").lower()

if(user1_answer==user2_answer):
    print("It is a tie!!!")
elif(user1_answer=="rock"):
    if(user2_answer=="scissors"):
        print("Rock wins!!!")
    else:
        print("Paper wins!!!")
elif(user1_answer=="paper"):
    if(user2_answer=="rock"):
        print("Paper wins!!!")
    else:
        print("Scissors wins!!!")
elif(user1_answer=="scissors"):
    if(user2_answer=="rock"):
        print("Rock wins!!!")
    else:
        print("Scissors win!!!")
else:
    print("Invalid inputs! please enter value from values rock,paper and scissors. Try again!!!")

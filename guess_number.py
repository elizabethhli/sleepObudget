import random
def guess_number():
    myst_num=random.randint(0,100)
    
    guess=0
    user_guess=input("Guess the mystery number between 0-100:")
    while True:
        
        if not user_guess.isdigit() or not 0<=int(user_guess)<=100:
            user_guess=input("Please input a number between 0 and 100:")
        guess+=1
        elif myst_num>int(user_guess):
            print("Number is too small")
            user_guess=input("Guess the mystery number between 0-100:")
        elif myst_num<int(user_guess):
            print("Number is too big")
            user_guess=input("Guess the mystery number between 0-100:")
        elif int(user_guess)==myst_num:
            break
       
    print("The number was indeed "+ str(myst_num)+ ". You took "+str(guess)+ " guesses to find the mystery number")
    print("Your discount for food is")

# guess_number()

def roll_dice():
    
    print("Let's start rolling the dice!")
    
    take=0
    while take<2:
        take+=1
        dice_num=random.randint(1,6)
        enter=input(("Press enter to roll the dice:"))
        if dice_num==1:
            
            print("""
     ____________
    |            |
    |            |
    |      O     |
    |            |
    |____________|     
                                """)
        elif dice_num==2:
            print("""
     ____________
    |            |
    |   O        |
    |            |
    |        O   |
    |____________|     
                                """)
            
        
        elif dice_num==3:
            print("""
     ____________
    |            |
    |   O        |
    |      O     |
    |         O  |
    |____________|     
                                """)
            
        elif dice_num==4:
            print("""
     ____________
    |            |
    |  O       O |
    |            |
    |  O       O |
    |____________|     
                                """)        

        elif dice_num==5:
            print("""
     ____________
    |            |
    |  O       O |
    |      O     |
    |  O       O |
    |____________|     
                                """)
            
            
        elif dice_num==6:
            print("""
     ____________
    |            |
    |  O       O |
    |  O       O |
    |  O       O |
    |____________|     
                                """)
    
        if take==1:
            first_num=dice_num
        else:
            sec_num=dice_num
            
    discount=abs(first_num-sec_num)*10
    print("You have a "+str(discount)+"% discount on entertainment.")
roll_dice()

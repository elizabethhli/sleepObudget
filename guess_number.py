import random

def guess_number():
    myst_num=random.randint(0,100)
    
    guess=0
    
    user_guess = input("Guess the mystery number between 0-100: ")
    
    # check if guess is a valid input
    while not user_guess.isdigit() or not 0 <= int(user_guess) <= 100:
        user_guess = input("Please input a number between 0 and 100: ")
        
    # check if guess is correct
    while guess < 5 and (int(user_guess) != myst_num):
        guess += 1
        many_guesses_left = "You have " + str(5-guess) + " guesses left."
        one_guess_left = "You have " + str(5-guess) + " guess left."        
        
        if myst_num > int(user_guess):
            print("Number is too small!")
            # decide if printing 'guesses' or 'guess'
            if guess == 5:
                print(one_guess_left)
            else:
                print(many_guesses_left)
        elif myst_num < int(user_guess):
            print("Number is too big!")
            # decide if printing 'guesses' or 'guess'
            if guess == 5:
                print(one_guess_left)
            else:
                print(many_guesses_left)
        
        if guess < 5:
            user_guess = input("Guess the mystery number between 0-100: ")
        
    # check if they ran out of guesses or guessed correctly
    if guess == 5:
        print("Sorry, you took up all your guesses. \nThe mystery number was: " + str(myst_num)\
              + "! \nBetter luck next time!")
    else:
        print("The number was indeed "+ str(myst_num)+ ". You took "+str(guess)+ \
              " guesses to find the mystery number!")

        print("Your discount for food is " + str(int(check_discount(guess)*100)) + "%! Good job!")
       
       
def check_discount(guesses: int) -> float:
    """ Helper function for guess_number(). Return discount earned based on
    number of guesses used.
    """
    if guesses <=2:
        discount = 0.05
    elif guesses <= 3:
        discount = 0.1
    elif guesses <=4:
        discount = 0.15
    elif guesses <= 5:
        discount = 0.2
    
    return discount

# guess_number()


def roll_dice():
    
    print("Let's start rolling the dice!")
    
    take = 0
    while take < 2:
        take += 1
        dice_num = random.randint(1,6)
        enter = input(("Press enter to roll the dice:"))
        
        if dice_num == 1:
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
    
        if take == 1:
            first_num = dice_num
        else:
            sec_num = dice_num
            
    discount = abs(first_num-sec_num)*10
    print("You have a " + str(discount) + "% discount on entertainment.")
#roll_dice()

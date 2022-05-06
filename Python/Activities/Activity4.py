player1 = input("Enter Player1 name: ")
player2 = input("Enter Player2 name: ")

print("Enter either rock, paper or scissor")
while True:
    player1_input = input(f'{player1}, choose your option: ').lower() 
    player2_input = input(f'{player2}, choose your option: ').lower()
    if(player1_input == player2_input):
        print("It's a tie")
    elif(player1_input=="rock" and player2_input=="scissors"):
        print(f"{player1} wins")
    elif(player1_input=="scissors" and player2_input=="rock"):
        print(f"{player2} wins")
    elif(player1_input=="scissors" and player2_input=="paper"):
        print(f"{player1} wins")
    elif(player2_input=="scissors" and player1_input=="paper"):
        print(f"{player2} wins")
    elif(player2_input=="rock" and player1_input=="paper"):
        print(f"{player1} wins")
    elif(player2_input=="paper" and player1_input=="rock"):
        print(f"{player2} wins")
    else:
        print("❌Invalid input❗❗ Please choose from Rock, Paper or Scissors")
    
    repeat= input("Do you want another match? enter Y/N: ")
    if repeat == "Y":
        pass
    elif repeat == "N":
        raise SystemExit
    else:
        print("❌Invalid Entry❗❗Please enter Y/N")
        raise SystemExit
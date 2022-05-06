print("Enter either Rock, Paper or Scissors")
player1 = input("Player1 entered: ")
player2 = input("Player2 entered: ")

if(player1 == player2):
    print("It's a tie")
elif(player1=="Rock" and player2=="Scissors"):
    print("player1 wins")
elif(player1=="Scissors" and player2=="Rock"):
    print("player2 wins")
elif(player1=="Scissors" and player2=="Paper"):
    print("player1 wins")
elif(player2=="Scissors" and player1=="Paper"):
    print("player2 wins")
elif(player2=="Rock" and player1=="Paper"):
    print("player1 wins")
elif(player2=="Paper" and player1=="Rock"):
    print("player2 wins")
else:
    print("Invalid input!! Please choose from Rock, Paper or Scissors")


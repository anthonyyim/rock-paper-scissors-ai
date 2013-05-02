public class RPSScoreKeeper {
  int playerAScore = 0;
  int playerBScore = 0;
  
  public RPSScoreKeeper (int playerAScore, int playerBScore) {
    this.playerAScore = playerAScore;
    this.playerBScore = playerBScore;
  }

  public void determineWinner(String playerAMove, String playerBMove) {
    if (playerAMove.equals("R")) {
      if (playerBMove.equals("R")) {
        System.out.println("Human: " + playerAMove + " | Computer: " + playerBMove);
      } else if (playerBMove.equals("P")) {
        System.out.println("Human: " + playerAMove + " | Computer*: " + playerBMove);
        playerBScore++;
      } else if (playerBMove.equals("S")) {
        System.out.println("Human*: " + playerAMove + " | Computer: " + playerBMove);
        playerAScore++;
      }
    } else if (playerAMove.equals("P")) {
      if (playerBMove.equals("R")) {
        System.out.println("Human*: " + playerAMove + " | Computer: " + playerBMove);
        playerAScore++;
      } else if (playerBMove.equals("P")) {
        System.out.println("Human: " + playerAMove + " | Computer: " + playerBMove);
      } else if (playerBMove.equals("S")) {
        System.out.println("Human: " + playerAMove + " | Computer*: " + playerBMove);
        playerBScore++;
      }
    } else if (playerAMove.equals("S")) {
      if (playerBMove.equals("R")) {
        System.out.println("Human: " + playerAMove + " | Computer*: " + playerBMove);
        playerBScore++;
      } else if (playerBMove.equals("P")) {
        System.out.println("Human*: " + playerAMove + " | Computer: " + playerBMove);
        playerAScore++;
      } else if (playerBMove.equals("S")) {
        System.out.println("Human: " + playerAMove + " | Computer: " + playerBMove);
      }
    }
  }

  public void printScores() {
    System.out.println(playerAScore + " : " + playerBScore + "\n");
  }
}

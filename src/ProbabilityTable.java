import java.util.HashMap;
import java.util.Set;

// TODO (anthonyyim@gmail.com): Refactor variable and method names.
public class ProbabilityTable {
  HashMap<String, HashMap> moveCount;
  int difficulty;

  public ProbabilityTable(int difficulty) {
    this.difficulty = difficulty;
    moveCount = new HashMap<String, HashMap>();
    initializeMoveCount(moveCount, difficulty);
  }

  // Update probability table with true outcome in order to make future predictions as close
  // to the true human player move as possible (assuming human player uses a pattern).
  public void incrementProbabilityTable(String lookback, String mostRecentHumanMove) {
    HashMap possibleNextMoves = moveCount.get(lookback);
    int count = (Integer) possibleNextMoves.get(mostRecentHumanMove);
    possibleNextMoves.put(mostRecentHumanMove, count + 1);
    moveCount.put(lookback, possibleNextMoves);
  }

  public String getOptimalNextMove(String lookback) {
    // Find out human's most likely next move.
    String mostLikelyMoveByHuman = mostLikelyNextMove(lookback);

    // Calculate what the computer move should be for computer to win.
    return calculateWinMove(mostLikelyMoveByHuman);
  }

  private void initializeMoveCount(HashMap moveCount, int difficulty) {
    String possibleMoves = "RPS";
    permutateMoves(moveCount, difficulty, possibleMoves, "");
  }

  private void permutateMoves(HashMap moveCounts, int difficulty, String possibleMoves, String permutation) {
    // Base case.
    if (permutation.length() == difficulty) {
      HashMap possibleNextMoves = new HashMap<String, Integer>();
      initializeNextMoves(possibleNextMoves, possibleMoves);
      
      moveCounts.put(permutation, possibleNextMoves);
    } else {
      for(int i = 0; i < possibleMoves.length(); i++) {
        String nextPermutation = permutation.concat(possibleMoves.substring(i, i+1));

        permutateMoves(moveCounts, difficulty, possibleMoves, nextPermutation);
      }
    }
  }

  private void initializeNextMoves(HashMap possibleNextMoves, String possibleMoves) {
    for(int i = 0; i < possibleMoves.length(); i++) {
      possibleNextMoves.put(possibleMoves.substring(i, i+1), 1);
    }
  }

  private String mostLikelyNextMove(String lookback) {
    String result = "";
    
    if (lookback.length() >= difficulty) {
      HashMap possibleMoves = moveCount.get(lookback.substring(lookback.length() - difficulty));
      int maxCount = 0;
      Set<String> keys = possibleMoves.keySet();
      
      for(String key : keys) {
        int count = (Integer) possibleMoves.get(key);
        if (count > maxCount) {
          result = key;
          maxCount = count;
        }
      } 
    } else {
      // Assume human will go for rock if lookback window not long enough.
      // TODO (anthonyyim@gmail.com): Update to return a random move.
      result = "R";
    }
    
    return result;
  }

  private String calculateWinMove(String mostLikelyMoveByHuman) {
    String result = "";

    if (mostLikelyMoveByHuman.equals("R")) {
      result = "P";
    } else if (mostLikelyMoveByHuman.equals("P")) {
      result = "S";
    } else {
      result = "R";
    }
    
    return result;
  }
}

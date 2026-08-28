import java.util.Random;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] validMoves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        
        // Predefined list for the 5-round live demo 
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int totalRounds = 5;
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        
        // Arrays to store history for the summary table
        String[] computerMovesHistory = new String[totalRounds];
        String[] resultsHistory = new String[totalRounds];

        for (int i = 0; i < totalRounds; i++) {
            String playerMove = playerMoves[i];
            String computerMove = validMoves[random.nextInt(3)];
            
            computerMovesHistory[i] = computerMove;
            String result = playRound(playerMove, computerMove);
            resultsHistory[i] = result;
            
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            
            System.out.printf("Round %d\nPlayer: %s, Computer: %s\n%s\n\n", 
                              i + 1, playerMove, computerMove, result);
        }
        
        System.out.println("Final Summary (after 5 rounds)");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < totalRounds; i++) {
            System.out.printf("%-5d | %-11s | %-13s | %s\n", 
                              i + 1, playerMoves[i], computerMovesHistory[i], resultsHistory[i]);
        }
        
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          wins, losses, draws, winPercentage);
    }
}
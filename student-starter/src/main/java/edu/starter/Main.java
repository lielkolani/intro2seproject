package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
    public static void main() {
        Player player = new Player(20, 100, 5, 0, 10);
        Enemy enemy1 = new Enemy(30, 100);
        boolean firstWin = Battle.playBattle(player, enemy1);
        boolean rewardChosen = false; // guarantees a single reward choice.

        // @pre: A reward can be selected only after a vectory in Encounter 1.
        if (!firstWin) {
            System.out.println("Player Defeated! Game Over.");
        } else {
            System.out.println("You've defeated the 1st enemy! Choose a reward (POW, REC)");
            // safety: invalid input and repeated reward attempts leave all state unchanged.
            while (!rewardChosen) {
                Reward chosenReward = Reward.chooseReward();
                if (chosenReward != null) {
                    switch(chosenReward) {
                        case REC ->  { 
                            System.out.println("Applied Recovery.");
                            player.recover(); 
                        }
                        case POW ->  {
                            System.out.println("Applid Power."); 
                            player.power(); 
                        }
                    }
                    rewardChosen = true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }

            Enemy enemy2 = new Enemy(45, 45); // new enemy, same resources and max damage.
            boolean secondWin = Battle.playBattle(player, enemy2);
            
            if (secondWin) {
                System.out.println("You won the adventure!");
            } else {
                System.out.println("Player Defeated! Game over.");
            }
        }
    }
}

package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
    public static void main(String[] args) {
        Player player = new Player(100, 100, 5, 0, 10);
        Enemy enemy1 = new Enemy(30, 100);
        boolean firstWin = Battle.playBattle(player, enemy1);

        if (!firstWin) {
            System.out.println("Player Defeated! Game Over.");
        } else {
            System.out.println("You've defeated the 1st enemy! Choose a reward (POW, REC)");
            
            Enemy enemy2 = new Enemy(45, 45);
            boolean secondWin = Battle.playBattle(player, enemy2);
            
            if (secondWin) {
                System.out.println("You won the adventure!");
            } else {
                System.out.println("Player Defeated! Game over.");
            }
        }
    }
}

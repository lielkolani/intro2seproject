package edu.starter;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
    public static void main(String[] args) {
        Combatant player = new Combatant(100, 100, 5, 0);
        Combatant enemy1 = new Combatant(30, 100, 0, 0);
        boolean firstWin = Battle.playBattle(player, enemy1);

        if (!firstWin) {
            System.out.println("Player Defeated! Game Over.");
        } else {
            System.out.println("You've defeated the 1st enemy! Next enemy incoming");
            Combatant enemy2 = new Combatant(45, 45, 0, 0);
            boolean secondWin = Battle.playBattle(player, enemy2);
            
            if (secondWin) {
                System.out.println("You won the adventure!");
            } else {
                System.out.println("Player Defeated! Game over.");
            }
        }
    }
}

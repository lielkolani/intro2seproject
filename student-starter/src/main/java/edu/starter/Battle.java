package edu.starter;
import java.util.Scanner;

public class Battle {

    public static boolean isDefeated(Combatant combatant) {
        return combatant.getHealth() <= 0;
    }

    public static boolean playBattle(Combatant player, Combatant enemy) {
        Scanner scan = new Scanner(System.in);
        player.clearDefense();
        while (!isDefeated(player) && !isDefeated(enemy)) {
            System.out.println("Player's Health: " + player.getHealth() + ", Resources: " + player.getResources() + ", Pending Defense: " + player.getDefense());
            System.out.println("Enemy's Health: " + enemy.getHealth());
            System.out.println("Choose an action: (ATK, DEF, RES, SPC)");
            String action = scan.nextLine();
            boolean validAction = true;
            switch (action) {
                case "ATK" -> player.attack(enemy);
                case "DEF" -> player.defense();
                case "RES" -> {
                    if (!player.recoverResources()) {
                        System.out.println("Max resources!");
                        validAction = false;
                    }
                }
                case "SPC" -> {
                    if (!player.specialAttack(enemy)) {
                        System.out.println("Not enough resources!");
                        validAction = false;
                    }
                }
                default -> {
                    System.out.println("Not a valid action!");
                    validAction = false;
                }
            }

            if (validAction && enemy.getHealth() > 0) {
                enemy.attack(player);
            }
        }
        return (player.getHealth() > 0 && enemy.getHealth() == 0);
    }
}

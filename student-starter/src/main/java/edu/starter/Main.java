package edu.starter;
import java.util.Scanner;
/** Student-owned game entry point; replace this message with your own implementation. */
public final class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int playerHP = 100;
        int resources = 5;
        int enemyHP = 30;
        int pendingDefense = 0;

        /* Initial Test
        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");

        int [] specialAttackResult = specialAttack(enemyHP, resources);
        enemyHP = specialAttackResult[0];
        resources = specialAttackResult[1];

        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");

        playerHP = attack(playerHP, pendingDefense);

        System.out.println(playerHP + "," + resources + "," + enemyHP + ",");
        */

        while(playerHP > 0 && enemyHP > 0) {
            System.out.println("--- Player's Turn ---");
            System.out.println("Player HP: " + playerHP + " | Resources: " + resources + " | Defense: " + pendingDefense + " | Enemy HP: " + enemyHP);
            System.out.println("Choose an Action (ATK, DEF, SPC, RES): ");
            boolean validInput = false;
            String input = scan.nextLine();
            if (input.equals("ATK")) {
                enemyHP = attack(enemyHP);
                validInput = true;
            } else if (input.equals("DEF")) {
                pendingDefense = defend(pendingDefense);
                validInput = true;
            } else if (input.equals("SPC")) {
                if (resources >= 3) {
                    int [] specialAttackResult = specialAttack(enemyHP, resources);
                    enemyHP = specialAttackResult[0];
                    resources = specialAttackResult[1];
                    validInput = true;
                } else {
                    System.out.println("Not enough resources! ");
                }
            } else if (input.equals("RES")) {
                resources = recover(resources);
                validInput = true;
            } else {
                System.out.println("Invalid Input! ");
            }
            
            if (validInput && enemyHP > 0) {
                    System.out.println("Enemy Counterattacks! ");
                    playerHP = counterAttack(playerHP, pendingDefense);
                    if (pendingDefense > 0 && pendingDefense <= 10) {
                        pendingDefense = 0;
                    } else if (pendingDefense > 10) {
                        pendingDefense -= 10;
                    } 
                }
            }

            System.out.println("Game Over! ");
            if (playerHP > enemyHP) {
                System.out.println("Player won With: " + playerHP + " HP left! ");
            } else {
                System.out.println("Enemy won With: " + enemyHP + " HP left! ");
        }
    }

    public static int attack(int health) {
        if (health >= 10) {
            return health - 10;
        } else {
            return 0;
        }
    }

        public static int counterAttack(int health, int defense) {
            if (health >= 10) {
                return health - (10 - defense);
            } else {
                return 0;
        }
    }

    public static int recover(int resources) {
        if (resources <= 7) {
            return resources + 3;
        } else {
            return 10;
        }
    }

    public static int defend(int defense) {
        return defense + 5;
    }

    public static int[] specialAttack(int enemyHealth, int resources) {
        int [] stats = {enemyHealth, resources};
        if (resources < 3) {
            System.out.println("Not enough resources!");
            return null;
        } else {
            if (stats[0] >= 15) {
                stats[0] -= 15;
            } else {
                stats[0] = 0;
            }
            stats[1] -= 3;
            return stats;
        }
    }
}
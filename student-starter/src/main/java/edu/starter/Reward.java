package edu.starter;

import java.util.Scanner;

public enum Reward {
    POW, REC;

    public static Reward chooseReward() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your reward:");
        System.out.println("RECOVERY (+25HP) - REC");
        System.out.println("POWER (+2 Attack Damage) - POW");
        String input = scan.next();
        Reward chosenReward = null;
        if (input.equals("REC")) {
            chosenReward = Reward.REC;
        } else if (input.equals("POW")) {
            chosenReward = Reward.POW;
        }

        return chosenReward;
    }
}


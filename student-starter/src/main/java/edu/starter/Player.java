package edu.starter;

public class Player implements Combatant {
    private int health;
    private int maxHealth;
    private int resources;
    private int pendingDefense;
    private int baseDamage;

    // @inv: 0<=HP<=maximumHealth; 0<=resources<=10; Attack never decreases.
    public Player(int health, int maxHealth, int resources, int pendingDefense, int baseDamage) {
        this.health = health;
        this.maxHealth = maxHealth;
        this.resources = resources;
        this.pendingDefense = pendingDefense;
        this.baseDamage = baseDamage;
    }
    // @inv: takeDamage always leaves the player on >=0 HP.
    public void takeDamage(int damage) {
        if ((health - (damage - pendingDefense)) < 0) {
            health = 0;
        } else {
            health -= (damage - pendingDefense);
        }
        pendingDefense = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getResources() {
        return resources;
    }

    public int getDefense() {
        return pendingDefense;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void clearDefense() {
        pendingDefense = 0;
    }

    public void attack(Combatant enemy) {
        enemy.takeDamage(baseDamage);
    }

    public void defense() {
        pendingDefense += 5;
    }
    // @inv: always does 15 damage.
    public boolean specialAttack(Combatant enemy) {
        if (resources >= 3) {
            resources -= 3;
            enemy.takeDamage(15);
            return true;
        } else {
            return false;
        }
    }
    // @inv: always leaves player on <=10 HP.
    public boolean recoverResources() {
        if (resources <= 7) {
            resources += 3;
            return true;
        } else if (7 < resources && resources < 10) {
            resources = 10;
            return true;
        } else {
            return false;
        }
    }
    // @post: RECOVERY makes HP = min(maxHP, oldHP + 25), withouth changing resources or Attack.
    public void recover() {
        // HP cap enforcement.
        if (health <= maxHealth - 25) {
            health += 25;
        } else {
            health = maxHealth;
        }
    }
    // @post: POWER makes Attack = oldAttack + 2, without changing HP or resources.
    public void power() {
        baseDamage += 2;
    }
}
# Java & OOP Adventure — Student Starter

**Start with your own design.** The files here deliberately do not contain a game engine, combatant hierarchy, future rules, or an instructor solution.

Prerequisites: JDK 25, Maven, Git, terminal/IDE.

```bash
java -version
mvn test
mvn exec:java -Dexec.mainClass=edu.starter.Main
```

If the Maven exec plugin is unavailable, compile the starter directly:

```bash
mkdir -p build
javac -d build src/main/java/edu/starter/*.java
java -cp build edu.starter.Main
```

Choose one theme: Fantasy Dungeon, Space Skirmish, Robot Arena or Creature Tournament.
Read the workshop PDF for the current week and maintain one evolving Git repository all semester.

Utilities: `ConsoleChoice.read()` for safe numeric input, `Checks.that()` and `Checks.within()` for early tests. There are no hidden future requirements in this kit.

**WEEK 01**

This week we've added the base combat methods and the game loop.
The syntax is different than python, but the general idea of using classes and methods was about the same.

**WEEK 02**

**WEEK 03**

1. a Trace showing both reward options:

Player starts: HP=100, resource=5, Attack=10
Encounter 1: Special -> enemy 15HP; player 90HP / res 2
             Restore -> enemy 15HP; player 80HP / res 5
             Special -> enemy 0HP; player 80HP / res 2
POWER chosen: Encounter 2 begins HP=80 / res=2 / baseDamage = 12
RECOVERY chosen: Encounter 2 begins HP=100 / res =2 / baseDamage = 10

2. a Trace showing a loss and invalid reward choice:

Player starts: HP=20 (for checking purposes) , resource=5, Attack=10
Encounter 1: Special -> enemy 15HP; player 10HP / res 2
             Attack -> enemy 5HP; player 0HP / res 2
Player Defeated, Game over. No reward offered.

Player starts: HP=100, resource=5, Attack=10
Encounter 1: Special -> enemy 15HP; player 90HP / res 2
             Restore -> enemy 15HP; player 80HP / res 5
             Special -> enemy 0HP; player 80HP / res 2
Input "ABC": Invalid input, Please try again.
No stats were changed and the user was prompted to input a valid reward.

3. Design note:

This week we were assigned to implement a reward system after the 1st encounter, and to point out the
different invariants, preconditions and postconditions in the code.
The main invariants are the HP and resources not going above the max value set or below 0,
Damage not decreasing and special always dealing 15HP.
The main reward precondition is winning the 1st encounter. The RECOVERY reward cannot get you to
more than the maxHP set and the POWER reward cannot decrease your baseDamage. 

The AI suggested adding the chooseReward() method in the Reward enum, which was useful. but suggested
ideas on implementation of the reward system which i found harder and less readable, such as taking
console inputs in the main rather than in a new method which is now the chooseReward method.
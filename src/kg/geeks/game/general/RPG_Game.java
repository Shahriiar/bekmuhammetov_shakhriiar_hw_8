package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void startGame(){
        Boss boss = new Boss(3000, 50, "Abraham");
        Warrior warrior = new Warrior(270, 10, "Hercules");
        Medic doc = new Medic(250, 5, 15, "Nebolit");
        Magic magic = new Magic(280, 20, "Potter");
        Berserk berserk = new Berserk(290,15, "Gatz");
        Medic assistant = new Medic(300, 5, 5, "House");
        Witcher witcher = new Witcher(450, "Estes");
        Golem golem = new Golem(700, 10);
        Thor thor = new Thor(200, 20);
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, witcher, golem, thor};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("ROUND " + roundNumber + " ______________");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++){
            System.out.println(heroes[i]);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes){
        roundNumber++;
        boss.chooseDefence(heroes);
        if(!boss.isCheckThor()){
            boss.attack(heroes);
        }

        for (int i = 0; i < heroes.length; i++) {
            if(boss.getDefence() != heroes[i].getAbility() &&
            heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++){
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }
}

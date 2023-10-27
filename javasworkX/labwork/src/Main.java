package org.example;

import java.util.Scanner;

public class Main {
    static Dragon dragon;
    static Hero hero;

    static boolean endOfBattle = false;
    public static void main(String[] args) throws InterruptedException {
//        int choice = (int)
//        if(choice > 1){
//            //выбираешь одного
//        }else{
//            //выбираешь второго
//        }
        dragon = new Dragon(2000, 120, 150,0, true);
        hero = new Hero(1000, 100, 120, 250, 150,  true, false);
        mainGameLoop();
    }

    static int randomInt(int i){
        return (int) (Math.random() * i) + 1;
    }



    static void mainGameLoop() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int choice;
        while(!endOfBattle){
            System.out.println("Choose you act:\n1 - Attack\n2 - Shield\n3 - Flask of life");
            choice = scan.nextInt();
            heroTurn(choice);
            Thread.sleep(500);
            enemyTurn();
            Thread.sleep(500);
            turnInfo();
            Thread.sleep(1000);
            if(hero.shield){
                hero.shield = false;
            }
        }
        if(dragon.health < 0){
            System.out.println("Hero is winner.");
        }else{
            System.out.println("Dragon is winner.");
        }
    }

    static void heroTurn(int choice){
        switch (choice) {
            case 1 -> hero.attack(dragon);
            case 2 -> {
                hero.shield = true;
                System.out.println("Hero raise a shield.");
            }
            case 3 -> hero.drinkPotion();
        }
    }

    static void enemyTurn(){
        if(randomInt(2) > 1){
            dragon.attack(hero);
        }else{
            dragon.castFireBolt(hero);
        }

    }

    static void turnInfo(){
        System.out.println("Results of turn:\nHero health: " + hero.health + "\nDragon health: " + dragon.health);
    }
}
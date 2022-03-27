package main;

import citizens.Virologist;
import effects.*;
import items.Bag;
import items.Cape;
import items.Gloves;
import items.Virus;
import map.*;

import java.util.Scanner;

/**
 * @since 2022-03-27
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Vilagtalan virologusok vilaga - Skeleton");
        System.out.println("Csapat: alma");
        System.out.println("-------------------------------");

        Scanner sc = new Scanner(System.in);
        int caseNo;
        do {
            System.out.println("1 - Game starts");
            System.out.println("2 - Next round");
            System.out.println("3 - Virologist moves");
            System.out.println("4 - Virologist steps");
            System.out.println("5 - Virologist picks up an Equipment");
            System.out.println("6 - Virologist drops an Equipment");
            System.out.println("7 - Virologist equips a Cape");
            System.out.println("8 - Virologist equips a Bag");
            System.out.println("9 - Virologist equips Gloves");
            System.out.println("10 - Virologist unequips Equipment");
            System.out.println("11 - Virologist steals an equipment");
            System.out.println("12 - Virologist picks up material");
            System.out.println("13 - Virologist crafts agent from material");
            System.out.println("14 - Virologist learns a code");
            System.out.println("15 - Virologist touch each other");
            System.out.println("16 - Virologist uses immunity vaccine");
            System.out.println("17 - Virologist uses Forget virus");
            System.out.println("18 - Virologist uses Dance virus");
            System.out.println("19 - Virologist uses Stun Virus");
            System.out.println("20 - Virologist reflects agent");
            System.out.println("21 - Game ends");
            System.out.println("0 - Kilepes");
            System.out.println("-------------------------------");
            System.out.println("A futtatando use-case szama: ");
            caseNo = sc.nextInt();

            switch (caseNo) {
                case 1:
                    gameStarts();
                    break;
                case 2:
                    nextRound();
                    break;
                case 3:
                    virologistMoves();
                    break;
                case 4:
                    virologistSteps();
                    break;
                case 5:
                    virologistPicksUpAnEquipment();
                    break;
                case 6:
                    virologistDropsAnEquipment();
                    break;
                case 7:
                    virologistEquipsACape();
                    break;
                case 8:
                    virologistEquipsABag();
                    break;
                case 9:
                    virologistEquipsGloves();
                    break;
                case 10:
                    virologistUnequipsEquipment();
                    break;
                case 11:
                    virologistStealsAnEquipment();
                    break;
                case 12:
                    virologistPicksUpMaterial();
                    break;
                case 13:
                    virologistCraftsAgentFromMaterial();
                    break;
                case 14:
                    virologistLearnsACode();
                    break;
                case 15:
                    virologistTouchEachOther();
                    break;
                case 16:
                    virologistUsesImmunityVaccine();
                    break;
                case 17:
                    virologistUsesForgetVirus();
                    break;
                case 18:
                    virologistUsesDanceVirus();
                    break;
                case 19:
                    virologistUsesStunVirus();
                    break;
                case 20:
                    virologistReflectsAgent();
                    break;
                case 21:
                    gameEnds();
                    break;
                default:
                    System.exit(0);
            }
        } while (caseNo != 0);
    }


    //use-casek

    private static void gameStarts() {
        //HD
        System.out.println("-------------------------------");
        System.out.println("Use-case: gameStarts");
        City city = new City();
        city.startGame();
        System.out.println("-------------------------------");
    }

    private static void nextRound() {
        //HD
        System.out.println("-------------------------------");
        System.out.println("Use-case: nextRound");
        City city = new City();
        city.nextRound();
        System.out.println("-------------------------------");
    }

    private static void virologistMoves() {
        //HD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistMoves");
        Virologist v = new Virologist();
        v.getMoves();
        v.nextRound();
        v.move();
        System.out.println("-------------------------------");
    }

    private static void virologistSteps() {
        //EP
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistStepsOnEmpty");
        Virologist virologist = new Virologist();
        virologist.move();
        System.out.println("-------------------------------");
    }

    private static void virologistPicksUpAnEquipment() {
        //EP
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistPicksUpAnEquipment");
        System.out.println("empty vagy shelter?");
        Scanner scanner = new Scanner(System.in);
        String nextTile = scanner.next();
        if (nextTile.equalsIgnoreCase("empty")) {
            Virologist virologist = new Virologist();
            Empty empty = new Empty();
            virologist.visit(empty);
        } else if (nextTile.equalsIgnoreCase("shelter")) {
            Virologist virologist = new Virologist();
            Shelter shelter = new Shelter();
            virologist.visit(shelter);
        } else {
            System.out.println("Ilyen mezon nem lehet felvenni");
        }
        System.out.println("-------------------------------");
    }

    private static void virologistDropsAnEquipment() {
        //EP
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistDropsAnEquipment");
        Virologist virologist = new Virologist();
        virologist.dropEquipment();
        System.out.println("-------------------------------");
    }

    private static void virologistEquipsACape() {
        //FN
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistEquipsACape");
        Virologist v = new Virologist();
        v.equip();
        //Cape c = new Cape();
        //v.addEffect(c.use());
        System.out.println("-------------------------------");
    }

    private static void virologistEquipsABag() {
        //FN
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistEquipsABag");
        Virologist v = new Virologist();
        Bag b = new Bag();
        v.addEffect(b.use());
        System.out.println("-------------------------------");
    }

    private static void virologistEquipsGloves() {
        //FN
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistEquipsGloves");
        Virologist v = new Virologist();
        Gloves g = new Gloves();
        v.addEffect(g.use());
        System.out.println("-------------------------------");
    }

    private static void virologistUnequipsEquipment() {
        //FN
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistUnequipsEquipment");
        Virologist v = new Virologist();
        v.unequip();
        System.out.println("-------------------------------");
    }

    private static void virologistStealsAnEquipment() {
        //FN
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistStealsAnEquipment");
        Virologist v = new Virologist();
        v.steal();
        System.out.println("-------------------------------");
    }

    private static void virologistPicksUpMaterial() {
        //BD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistPicksUpMaterial");
        Virologist virologist = new Virologist();
        Warehouse warehouse = new Warehouse();
        virologist.visit(warehouse);
        System.out.println("-------------------------------");
    }

    private static void virologistCraftsAgentFromMaterial() {
        //BD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistCraftsAgentFromMaterial");
        Virologist virologist = new Virologist();
        virologist.craft();
        System.out.println("-------------------------------");
    }

    private static void virologistLearnsACode() {
        //BD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistLearnsACode");
        Virologist virologist = new Virologist();
        Laboratory myField = new Laboratory();
        virologist.visit(myField);
        System.out.println("-------------------------------");
    }

    private static void virologistTouchEachOther() {
        //BD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistTouchEachOther");
        Virologist virologist = new Virologist();
        virologist.getMoves();
        System.out.println("-------------------------------");
    }

    private static void virologistUsesImmunityVaccine() {
        //BD
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistUsesImmunityVaccine");
        Virologist virologist = new Virologist();
        virologist.addEffect(new Immunity());
        System.out.println("-------------------------------");
    }

    private static void virologistUsesForgetVirus() {
        //KA
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistUsesForgetVirus");
        Virologist virologist = new Virologist();
        virologist.useAgent();
        System.out.println("-------------------------------");
    }

    private static void virologistUsesDanceVirus() {
        //KA
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistUsesDanceVirus");
        Virologist virologist = new Virologist();
        virologist.useAgent();
        System.out.println("-------------------------------");
    }

    private static void virologistUsesStunVirus() {
        //KA
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistUsesStunVirus");
        Virologist virologist = new Virologist();
        virologist.useAgent();
        System.out.println("-------------------------------");
    }

    private static void virologistReflectsAgent() {
        //KA
        System.out.println("-------------------------------");
        System.out.println("Use-case: virologistReflectsAgent");
        Virologist virologist = new Virologist();
        virologist.useAgent();
        System.out.println("-------------------------------");
    }

    private static void gameEnds() {
        //KA
        System.out.println("-------------------------------");
        System.out.println("Use-case: gameEnds");
        City city = new City();
        city.nextRound();
        System.out.println("-------------------------------");
    }
}
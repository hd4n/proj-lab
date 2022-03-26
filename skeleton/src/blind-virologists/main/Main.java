package main;

import citizens.Virologist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 - Game starts");
        System.out.println("2 - Next round");
        System.out.println("3 - Virologist moves");
        System.out.println("4 - Virologist steps on Empty");
        System.out.println("5 - Virologist steps on Shelter");
        System.out.println("6 - Virologist steps on Warehouse");
        System.out.println("7 - Virologist steps on Laboratory");
        System.out.println("8 - Virologist picks up an Equipment");
        System.out.println("9 - Virologist drops an Equipment");
        System.out.println("10 - Virologist equips a Cape");
        System.out.println("11 - Virologist equips a Bag");
        System.out.println("12 - Virologist equips Gloves");
        System.out.println("13 - Virologist unequips Equipment");
        System.out.println("14 - Virologist steals an equipment");
        System.out.println("15 - Virologist picks up material");
        System.out.println("16 - Virologist crafts agent from material");
        System.out.println("17 - Virologist learns a code");
        System.out.println("18 - Virologist touch each other");
        System.out.println("19 - Virologist uses immunity vaccine");
        System.out.println("20 - Virologist uses Forget virus");
        System.out.println("21 - Virologist uses Dance virus");
        System.out.println("22 - Virologist uses Stun Virus");
        System.out.println("23 - Virologist reflects agent");
        System.out.println("24 - Game ends");
        System.out.println("0 - Kilepes");

        Scanner sc=new Scanner(System.in);
        int caseNo;
        do {
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
                    virologistStepsOnEmpty();
                    break;
                case 5:
                    virologistStepsOnShelter();
                    break;
                case 6:
                    virologistStepsOnWarehouse();
                    break;
                case 7:
                    virologistStepsOnLaboratory();
                    break;
                case 8:
                    virologistPicksUpAnEquipment();
                    break;
                case 9:
                    virologistDropsAnEquipment();
                    break;
                case 10:
                    virologistEquipsACape();
                    break;
                case 11:
                    virologistEquipsABag();
                    break;
                case 12:
                    virologistEquipsGloves();
                    break;
                case 13:
                    virologistUnequipsEquipment();
                    break;
                case 14:
                    virologistStealsAnEquipment();
                    break;
                case 15:
                    virologistPicksUpMaterial();
                    break;
                case 16:
                    virologistCraftsAgentFromMaterial();
                    break;
                case 17:
                    virologistLearnsACode();
                    break;
                case 18:
                    virologistTouchEachOther();
                    break;
                case 19:
                    virologistUsesImmunityVaccine();
                    break;
                case 20:
                    virologistUsesForgetVirus();
                    break;
                case 21:
                    virologistUsesDanceVirus();
                    break;
                case 22:
                    virologistUsesStunVirus();
                    break;
                case 23:
                    virologistReflectsAgent();
                    break;
                case 24:
                    gameEnds();
                    break;
                default:
                    System.exit(0);

            }
        } while(caseNo!=0);
    }


    //use-casek

    private static void gameStarts(){
        //HD
    }

    private static void nextRound(){
        //HD
    }

    private static void virologistMoves(){
        //HD
    }

    private static void virologistStepsOnEmpty(){
        //HD
    }

    private static void virologistStepsOnShelter(){
        //EP
    }

    private static void virologistStepsOnWarehouse(){
        //EP
    }

    private static void virologistStepsOnLaboratory(){
        //EP
    }

    private static void virologistPicksUpAnEquipment(){
        //EP
    }

    private static void virologistDropsAnEquipment(){
        //EP
    }

    private static void virologistEquipsACape(){
        //FN
    }

    private static void virologistEquipsABag(){
        //FN
    }

    private static void virologistEquipsGloves(){
        //FN
    }

    private static void virologistUnequipsEquipment(){
        //FN
    }

    private static void virologistStealsAnEquipment(){
        //FN
    }

    private static void virologistPicksUpMaterial(){
        //BD
    }

    private static void virologistCraftsAgentFromMaterial(){
        Virologist virologist = new Virologist();
        virologist.craft();
        //BD
    }

    private static void virologistLearnsACode(){
        //BD
    }

    private static void virologistTouchEachOther(){
        //BD
    }

    private static void virologistUsesImmunityVaccine(){
        //BD
    }

    private static void virologistUsesForgetVirus(){
        //KA
    }

    private static void virologistUsesDanceVirus(){
        //KA
    }

    private static void virologistUsesStunVirus(){
        //KA
    }

    private static void virologistReflectsAgent(){
        //KA
    }

    private static void gameEnds(){
        //KA
    }
}
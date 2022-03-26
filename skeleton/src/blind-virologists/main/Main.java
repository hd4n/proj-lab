package main;

import citizens.Virologist;

public class Main {
    public static void main(String[] args) {

        int caseNo=0;

        switch (caseNo){
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
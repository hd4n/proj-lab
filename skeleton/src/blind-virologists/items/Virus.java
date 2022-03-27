package items;
import effects.*;

import java.util.Scanner;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Virus extends Agent{
    /**
     * A fuggveny letrehozza a megfelelo effect-et es visszaadja azt.
     */
    public Effect use(){
        System.out.printf("Virus: Milyen effectet hozzon letre.");
        Scanner sc = new Scanner(System.in);
        int caseNo;
        System.out.println("1 - Forget");
        System.out.println("2 - Dance");
        System.out.println("3 - Stun");
        caseNo = sc.nextInt();
        switch (caseNo) {
            case 1:
                System.out.println("Letrejott egy Forget effect");
                break;
            case 2:
                System.out.println("Letrejott egy Dance effect");
                break;
            case 3:
                System.out.println("Letrejott egy Stun effect");
                break;
            default:
                System.exit(0);
        }
        System.out.printf("Virus: Visszaadja ezt az effect-et.");
        return null;
    }
}

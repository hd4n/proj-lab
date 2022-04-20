package items;

import effects.*;

import java.util.Scanner;

/**
 * A kontrollalhatatlan tancot okozo virus effektjet megvalosito osztaly.
 *
 * @author Feher Norbert
 * @since 2022-03-26
 */
public class Virus extends Agent {
    /**
     * A fuggveny letrehozza a megfelelo effect-et es visszaadja azt.
     */
    public Effect use() {
        System.out.println("Virus: Milyen effectet hozzon letre.\n");
        Effect e = null;
        Scanner sc = new Scanner(System.in);
        int caseNo;
        System.out.println("1 - Forget");
        System.out.println("2 - Dance");
        System.out.println("3 - Stun");
        caseNo = sc.nextInt();
        switch (caseNo) {
            case 1:
                System.out.println("Letrejott egy Forget effect");
                e = new Forget();
                break;
            case 2:
                System.out.println("Letrejott egy Dance effect");
                e = new Dance();
                break;
            case 3:
                System.out.println("Letrejott egy Stun effect");
                e = new Stun();
                break;
            default:
                System.exit(0);
        }
        System.out.println("Virus: Visszaadja ezt az effect-et.\n");
        return e;
    }
}

package SOAPJavaBog;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Scanner;

public class BenytGalgeLogikKlient {
    static IGalgeLogikSOAP k;
    static Scanner scanner;

    public static void main(String[] arg) throws Exception {
        URL url = new URL("http://ubuntu4.saluton.dk:5021/galgelegtjeneste?wsdl");
        System.out.println("Forbinder til SOAP");
        QName qName = new QName("http://SOAPJavaBog/", "ImplGalgeLogikService");
        Service service = Service.create(url, qName);
        k = service.getPort(IGalgeLogikSOAP.class);
        dialogMethod();



//        URL url = new URL("http://ubuntu4.saluton.dk:9921/galgeleg?wsdl");
        // QName qName = new QName("http://galgeleg/", "GalgelegImplService");
        //k = (SOAPJavaBog.IGalgeLogikSOAP) Naming.lookup("rmi://localhost:1099/galgetjeneste");
        //k = (SOAPJavaBog.IGalgeLogikSOAP) Naming.lookup("rmi://freilarsen.ddns.net:20099/galgetjeneste");
    }

    public static void dialogMethod() throws Exception {
        scanner = new Scanner(System.in);

        System.out.println("**********************************************");
        System.out.println("**                                          **");
        System.out.println("**      VELKOMMEN TIL GALGELEG - SOAPJavaBog       **");
        System.out.println("**                                          **");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();
        System.out.println("Indtast 'exit' for at afbryde\n Tryk 'Enter' for at fortsætte");

        while (true) try {
            System.out.println();
            System.out.println("1 Spil med standard indstillinger");
            System.out.println("2 Spil med ord hentet fra dr");
            System.out.print("Skriv valg: ");
            String valgString = scanner.next();
            int valg = 0;
            try {
                valg = Integer.parseInt(valgString);
            } catch (Exception e) {
                if (valgString.equalsIgnoreCase("exit")) {
                    break;
                } else {
                }
            }

            if (valg == 1) {
                k.nulstil();
                guessMethod();

            } else if (valg == 2) {
                System.out.println("Henter ord fra DR!");
                k.hentOrdFraDr();
                Thread.sleep(2);
                guessMethod();

            } else {
                System.out.println("\nUlovligt valg!");
            }

            if (k.erSpilletSlut() || k.erSpilletTabt() || k.erSpilletVundet()) {

                System.out.println("\nSpillet er slut!");
                if (k.erSpilletTabt()) {
                    System.out.println("Trist, du tabte!");
                    System.out.println("Ordet var " + k.getOrdet());
                    break;
                } else {
                    //k.erSpilletVundet()
                    System.out.println("Tillykke du vandt!");
                }
            }

        } catch (
                Throwable t) {
            t.printStackTrace();
            scanner.nextLine();
        }
        System.out.println("Afslutter programmet... ");
        System.exit(0);
    }

    static private void guessMethod() throws RemoteException {
        System.out.println("Skriv et bogstav og tryk 'enter' for at gætte");
        while (!k.erSpilletSlut() && !k.erSpilletTabt() && !k.erSpilletVundet()) {
            System.out.println("\nForkerte gæt " + k.getAntalForkerteBogstaver());
            System.out.println(k.getSynligtOrd());
            k.gætBogstav(scanner.next());
        }
    }
}



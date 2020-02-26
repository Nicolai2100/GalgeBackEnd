import io.javalin.Javalin;
import SOAPJavaBog.IGalgeLogikSOAP;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static String ordet;
    static IGalgeLogikSOAP galgeService;


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.addStaticFiles("/public/galgeleg");
        }).start(7000);

        URL url = new URL("http://ubuntu4.saluton.dk:5021/galgelegtjeneste?wsdl");
        System.out.println("Forbinder til SOAP");
        QName qName = new QName("http://SOAPJavaBog/", "ImplGalgeLogikService");
        Service service = Service.create(url, qName);
        galgeService = service.getPort(IGalgeLogikSOAP.class);

        

        /*Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        String brugernavn = ctx.formParam("brugernavn1");
        String kodeord = ctx.formParam("kode");*/
        /*System.out.printf("Forbinder til Galgelegserver (%s)\n", SOAPJavaBog.IGalgeLogik.URL);
        SOAPJavaBog.IGalgeLogik server = (SOAPJavaBog.IGalgeLogik) Naming.lookup(SOAPJavaBog.IGalgeLogik.URL);
        System.out.println("Forbundet til server!");*/
       /* String synligtOrd = server.getSynligtOrd();
        app.get("/hej", ctx -> ctx.result(synligtOrd));*/

        ordet = galgeService.getSynligtOrd();
        app.get("/hej", ctx -> ctx.result(ordet));


    }
}

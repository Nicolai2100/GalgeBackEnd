package SOAPJavaBog;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;

@WebService
public interface IGalgeLogikSOAP {

    //todo Taget fra gruppe X ?
    int PORT = 5021;
    String PATH = "galgelegtjeneste";
    String DOMAIN = "dist.saluton.dk";

    @WebMethod
    ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;

    @WebMethod
    String getSynligtOrd() throws java.rmi.RemoteException;

    @WebMethod
    String getOrdet() throws java.rmi.RemoteException;

    @WebMethod
    int getAntalForkerteBogstaver() throws java.rmi.RemoteException;

    @WebMethod
    boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;

    @WebMethod
    boolean erSpilletVundet() throws java.rmi.RemoteException;

    @WebMethod
    boolean erSpilletTabt() throws java.rmi.RemoteException;

    @WebMethod
    boolean erSpilletSlut() throws java.rmi.RemoteException;

    @WebMethod
    void nulstil() throws java.rmi.RemoteException;

    @WebMethod
    void gætBogstav(String bogstav) throws java.rmi.RemoteException;

    @WebMethod
    void logStatus() throws java.rmi.RemoteException;

    @WebMethod
    String hentUrl(String url) throws java.rmi.RemoteException, IOException;

    @WebMethod
    void hentOrdFraDr() throws java.rmi.RemoteException, IOException;

    @WebMethod
    void hentOrdFraRegneark(String sværhedsgrader) throws java.rmi.RemoteException, IOException;
}
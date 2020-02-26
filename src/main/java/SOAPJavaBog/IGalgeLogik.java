package SOAPJavaBog;

import java.io.IOException;
import java.util.ArrayList;

public interface IGalgeLogik extends java.rmi.Remote {

    //todo Taget fra gruppe X ?
    int     PORT = 5021;
    String  PATH = "galgelegtjeneste";
    String  DOMAIN = "dist.saluton.dk";
    String  URL  = String.format("rmi://%s:%d/%s", DOMAIN, PORT, PATH);

    ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;

    String getSynligtOrd() throws java.rmi.RemoteException;

    String getOrdet() throws java.rmi.RemoteException;

    int getAntalForkerteBogstaver() throws java.rmi.RemoteException;

    boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;

    boolean erSpilletVundet() throws java.rmi.RemoteException;

    boolean erSpilletTabt() throws java.rmi.RemoteException;

    boolean erSpilletSlut() throws java.rmi.RemoteException;

    void nulstil() throws java.rmi.RemoteException;

    void gætBogstav(String bogstav) throws java.rmi.RemoteException;

    void logStatus() throws java.rmi.RemoteException;

    String hentUrl(String url) throws java.rmi.RemoteException, IOException;

    void hentOrdFraDr() throws java.rmi.RemoteException, IOException;

    void hentOrdFraRegneark(String sværhedsgrader) throws java.rmi.RemoteException, IOException;
}
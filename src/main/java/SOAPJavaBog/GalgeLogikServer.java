package SOAPJavaBog;

import javax.xml.ws.Endpoint;

public class GalgeLogikServer {
    public static void main(String[] arg) throws Exception {

		System.out.println("Publicerer galgetjeneste over SOAP");
		IGalgeLogikSOAP k = new ImplGalgeLogik();
		Endpoint.publish("http://[::]:5021/galgelegtjeneste", k);
		System.out.println("Galgetjeneste publiceret over SOAP.");
	}
}
/*
Hvis klienter skulle forbinde til server "javabog.dk" på port 20099 skulle der rettes til
		java.rmi.registry.LocateRegistry.createRegistry(20099); // lyt på port 20099
		KontoI k = new SOAPJavaBog.ImplGalgeLogik();
		System.setProperty("java.rmi.server.hostname", "javabog.dk");
		Naming.rebind("rmi://javabog.dk:20099/kontotjeneste", k);

Overfør JAR-fil til server, f.eks.:
scp /home/j/prog1/oop-projekt/dist/oop-projekt.jar javabog.dk:

Log ind på server, f.eks.:
ssh javabog.dk

Start med f.eks.:
java -cp oop-projekt.jar kapitel_19.SOAPJavaBog.GalgeLogikServer

I stedet for System.setProperty("java.rmi.server.hostname", "javabog.dk");
kunne du også starte serverprogrammet med:
java -Djava.rmi.server.hostname=javabog.dk -cp oop-projekt.jar kapitel_19.SOAPJavaBog.GalgeLogikServer


*/

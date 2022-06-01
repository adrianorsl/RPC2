import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;


public class ServidorRPC {
	
	private ServidorRPC() {
		try {
			//Cria o servidor web na porta 9001
			WebServer ws = new WebServer(9001);
			XmlRpcServer servidor = ws.getXmlRpcServer();
			// Adiciona um novo "handler ao PHM
			PropertyHandlerMapping phm = new PropertyHandlerMapping();
			phm.addHandler("Calc", CalculoMedia.class);
			//Define um hadler ao servidor
			servidor.setHandlerMapping(phm);
			//inicia o servidor
			ws.start();
				System.out.println("Servidor Iniciado com sucesso!");
			
		} catch (Exception exception) {
			System.out.println("JavaServer: " + exception);
		}
	}

	public static void main(String[] args) {
		new ServidorRPC();
	}
}
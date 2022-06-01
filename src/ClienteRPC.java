import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class ClienteRPC {

	//DEFINE A URL DO SERVIDOR
	private static final String URL_SERVIDOR = "http://localhost:9001";
	private XmlRpcClient cliente;
	
	public ClienteRPC() {
		try {
				//configura o cliente para que ele possa se conectar ao servidor
				XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl();
			
			configuracaoCliente.setServerURL(new URL(URL_SERVIDOR));
			//seta a configuração no cliente
			cliente = new XmlRpcClient();
			cliente.setConfig(configuracaoCliente);
		
		} catch (Exception exception) {
			System.out.println("JavaServer: " + exception);
		}
	}
	
	public double media(int x, int y, int f, int r) throws Exception {
		Object[] parametros = new Object[] {new Integer(x), new Integer(y), new Integer(f), new Integer(r)};
		Double resultado = (Double) cliente.execute("Calc.media", parametros);
		return resultado;
	}
	
	public static void main(String[] args) throws Exception {
		
		
		ClienteRPC x = new ClienteRPC();
		FileInputStream f = new FileInputStream("D:\\Nova pasta\\Faculdade\\POO\\RPC2\\img\\entradaBinario.pgm");
		DataInputStream d = new DataInputStream(f);
		d.readLine();//first line contains P5
	    String line = d.readLine();//second line contains height and width
	    Scanner s = new Scanner(line);
	    int width = s.nextInt();
	    int height = s.nextInt();
	    line = d.readLine();//third line contains maxVal
	    String line2;
	    s = new Scanner(line);
	    long tempoInicio = System.currentTimeMillis();
	    try {
	    	boolean check = true;
	        while (check) {
	        	int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
	        	for (int i = 0; i < 4; i++) {
	        		if(d.readLine() == null) {
	        			check = false;
	        			break;
	        		}else {
	        			if (i == 0) {
	        				line2 = d.readLine();
	        				a1 = Integer.parseInt(line2);
	        			}else if(i == 1) {
	        				line2 = d.readLine();
	        				a2 = Integer.parseInt(line2);
	        			}else if (i == 2) {
	        				line2 = d.readLine();
	        				a3 = Integer.parseInt(line2);
	        			}else if(i == 3) {
	        				line2 = d.readLine();
	        				a4 = Integer.parseInt(line2);
	        			}
	        		}
				}
	        	
	        	System.out.println("O Resultado da media é: " + x.media(a1,a2,a3,a4));
	        }
	    } catch (EOFException e) {
	    }
	    System.out.println("Height=" + height);
	    System.out.println("Width=" + height);
	    System.out.println("Required elemnts=" + (height * width));
	    System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio) + " milisegundos");
	  


	
	}
}
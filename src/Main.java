import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		CalculoMedia x = new CalculoMedia();
		
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

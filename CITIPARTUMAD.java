import java.io.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CITIPARTUMAD 
{
    private BufferedReader archivoIn;
	private PrintWriter archivoOut;
	
	public CITIPARTUMAD()
	{
		try
     	{
     		archivoIn = new BufferedReader(new FileReader("Boletos.txt"));
     		
     		while(archivoIn.ready())
     		capturar(archivoIn.readLine());
     	
     		archivoIn.close();
     		
     	}
     	catch(IOException ioe)
     	{
     		System.out.println("Error: "+ioe);
     	}
	}
	
		//Atributos
	private ClienteDP primero, ultimo, actual,anterior;
	
	//Metodos
	public String captura(String datos)
	{
		if(primero == null)
		{
		   primero = new ClienteDP(datos);
		   ultimo = primero;
		   ultimo.setNext(null);
		}
		
		else
		{
			actual = new ClienteDP(datos);
			//Enlace 
			ultimo.setNext(actual);
			ultimo = actual;
			ultimo.setNext(null);
			
		}
		
		return"Datos: "+datos;
	}
	
	public String consultaGeneral()
	{
		String datos="";
		
		if(primero == null)
		 datos = "Lista vacia...";
		 
		 else
		{
			actual = primero;
			while(actual != null)
			{
				//datos = datos + actual.getNboleto() + "    " + actual.getNombre() +"    "+ actual.getCorreo() +"    " +actual.getNumero()+"\n";
				
				//De esta forma te entrega la dirección donde se encuentran almacenados los datos
				datos = datos + actual.toJString() + "\n";
				
				actual = actual.getNext();
			}
			
		}
		
		return datos;
	}
	
	 public String consultarNom(String nom)
	{
        String datos="";
        boolean encontrado = false;
        int contador=0;
		
		if(primero == null)
		 datos = "EMPTY";
		 
		 else
		{
			actual = primero;
			while(actual != null && !encontrado )
			{
				if(nom.equals(actual.getNombre()))
				{
				   datos = actual.toJString();
				   encontrado = true;
			
				
				}
			    
			    else
			    {
			    	anterior = actual;
			    	actual = actual.getNext();
			    	contador++;
			    }
			      
			    
		
			}
			
			if(!encontrado)
			{
				datos = "No se encontro el cliente";
			}
			
		}
		
		return datos;
      
	}
	
	public String  capturar(String datos)
	 {
	 	String respuesta;
	 	String valid,nboleto;
	 	//boolean exist = false; 
	 	
	 	StringTokenizer st = new StringTokenizer(datos,"'");
	 	nboleto = st.nextToken();
	 	
	 	valid = consultarBoleto(nboleto);
	 	
	 	if(valid.equals("NOT_FOUND") || valid.equals("EMPTY"))
	 	{
	 		captura(datos);
	 		
	 		respuesta = "NO_EXISTE";
	 	}
	 	else
	 	{
			respuesta = "EXISTE";
	 	}
	 	
	 	
		return respuesta;
	 	
	 }
	  
	 public String consultarBoleto(String nboleto)
	{
        String datos="";
        boolean encontrado = false;
        int contador=0;
		
		if(primero == null)
		 datos = "EMPTY";
		 
		 else
		{
			actual = primero;
			
			
			while(actual != null && !encontrado)
			{
		
				if(nboleto.equals(actual.getNboleto()))
				{
				   
				   datos = actual.toString() + "\nActual es el nodo: "+contador;
				   encontrado = true;
				
				}
			    
			    else
			    {
			    	actual = actual.getNext();
			    	contador++;
			    }
			      
			    
		
			}
			
			if(!encontrado)
			{
				datos = "NOT_FOUND";

			}
			
		}
		
		
		return datos;
		
	
      
	}
	
	public String consultarBC(String nboleto)
	{
        String datos="";
        boolean encontrado = false;
        int contador=0;
		
		if(primero == null)
		 datos = "EMPTY";
		 
		 else
		{
			actual = primero;
			
			
			while(actual != null && !encontrado)
			{
		
				if(nboleto.equals(actual.getNboleto()))
				{
				   
				   datos = actual.getCorreo()+"_"+actual.getCode()+"_"+actual.getNombre();
				   encontrado = true;
				
				}
			    
			    else
			    {
			    	actual = actual.getNext();
			    	contador++;
			    }
			      
			    
		
			}
			
			if(!encontrado)
			{
				datos = "NOT_FOUND";

			}
			
		}
		
		
		return datos;
		
	
      
	}
	private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException 
	{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
    
    public void imgQr(String datos)
    {
    	StringTokenizer st = new StringTokenizer(datos,"'");
        String nboleto = st.nextToken();
        String nombre = st.nextToken();
        String correo = st.nextToken();
        String numero = st.nextToken();
        String inst   = st.nextToken();
        String trans  = st.nextToken();
        String cobro  = st.nextToken();
        String strFecha = st.nextToken();
        String hora = st.nextToken();
        String codigo = st.nextToken();
        
    	try 
    	{
            generateQRCodeImage(codigo, 350, 350, "./MyQRCode.png");
        } 
        catch (WriterException e) 
        {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } 
        catch (IOException e)
        {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        
    }
	
	    public String imgQrR(String codigo)
    {
        String res;
        
    	try 
    	{
            generateQRCodeImage(codigo, 350, 350, "./MyQRCodeR.png");
            res="CODE_YES";
            
            return res; 
        } 
        catch (WriterException e) 
        {
        	res="CODE_NO";
            
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
            
            return res; 
        } 
        catch (IOException e)
        {
        	res="CODE_NO";
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
            return res;
        }
        
    }
    public String capturarDatos(String datos) 
    {
    	StringTokenizer st = new StringTokenizer(datos,"'");
        String nboleto = st.nextToken();
        String nombre = st.nextToken();
        String correo = st.nextToken();
        String numero = st.nextToken();
        String inst   = st.nextToken();
        String trans  = st.nextToken();
        String cobro  = st.nextToken();
        String strFecha = st.nextToken();
        String hora = st.nextToken();
        String codigo = st.nextToken();

        String respuesta="";
        
    	try
    	{
    			respuesta = capturar(datos);
    			
    			if(respuesta.equals("EXISTE"))
    			{
    				JOptionPane.showMessageDialog(null,"Ya existe el boleto, checa tus folios");
    			}
    		    else
    		    {
    		    	
    		    	archivoOut = new PrintWriter(new FileWriter("Boletos.txt",true));
		    		archivoOut.println(datos);
		    		archivoOut.close();
		    		
		    		captura(datos);
    		    }
    	
    			
    	}
    	catch(IOException ios)
    	{
    		System.out.println("ERROR: "+ios);
    	}
    	
    	return"";
    }  
}
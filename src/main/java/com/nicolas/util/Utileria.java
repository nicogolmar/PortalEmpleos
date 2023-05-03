package com.nicolas.util;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
			// Obtenemos el nombre original del archivo.
			String nombreOriginal = multiPart.getOriginalFilename();
			//Remplazamos los espacios por guion para no tener problemas a la hora de descarga de imagenes
			nombreOriginal=nombreOriginal.replace(" ", "_");
			//agregamos el metodo random para generar 8 caracteres aleatorios antes de cada imagen para no tener duplicados
			String nombreFinal = randomAlphaNumeric(8)+nombreOriginal;
			try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreFinal;
			} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
			}
		}
	
	
	
	//Crea una cantidad de caracteres aleatorios depende lo pasado en count
	public static String randomAlphaNumeric(int count) {
	
		String caracteres= "ABCDEFGHIJKLMNÑOPQRSRTUVWXYZ123456789";
		StringBuilder builder = new StringBuilder();
		
		while(count-- != 0)
		{
			int caracter= (int) (Math.random()*caracteres.length());
			builder.append(caracteres.charAt(caracter));
		}
		return builder.toString();
	}
	
}

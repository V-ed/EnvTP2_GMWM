package outils;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;

public class OutilsFichiers {
	
	private OutilsFichiers(){}
	
	public static ImageIcon getImageFromFile(String path){
		
		ImageIcon image = null;
		
		// TODO getImageFromFile();
		
		return image;
		
	}
	
	public static String copyImageToProject(String filePath){
		
		String newRelativeFilePath = "";
		
		Path origin = Paths.get(filePath);
		Path destination = Paths.get("\\images");
		
		CopyOption[] options = new CopyOption[]
		{
			StandardCopyOption.COPY_ATTRIBUTES
		};
		
		try{
			Files.copy(origin, destination, options);
		}
		catch(IOException e){}
		
		return newRelativeFilePath;
		
	}
	
	public static String getFileNameFromPath(String filePath){
		return new File(filePath).getName();
	}
	
}

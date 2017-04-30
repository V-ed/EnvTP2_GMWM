package outils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class OutilsFichiers implements Constantes {
	
	private OutilsFichiers(){}
	
	public static String copyImageToProject(String filePath){
		
		Path origin = Paths.get(filePath);
		
		File projectFilePath = OutilsFichiers
				.getExecutablePathDirectoryAsFile();
		
		String projectPath = projectFilePath.getParent() + "\\"
				+ PROJECT_IMAGES_FOLDER_NAME;
		
		createDirIfNotExists(projectPath);
		
		String fileName = new File(filePath).getName();
		
		Path destination = Paths.get(projectPath + "\\" + fileName);
		
		CopyOption[] options = new CopyOption[]
		{
			StandardCopyOption.COPY_ATTRIBUTES
		};
		
		try{
			Files.copy(origin, destination, options);
		}
		catch(IOException e){}
		
		return fileName;
		
	}
	
	public static ImageIcon getImageFromProject(String path){
		
		String filePath = getExecutablePathDirectory() + "\\"
				+ PROJECT_IMAGES_FOLDER_NAME + "\\" + path;
		
		return getImageFromAbsolutePath(filePath);
		
	}
	
	public static ImageIcon getImageFromAbsolutePath(String filePath){
		return new ImageIcon(filePath);
	}
	
	public static String getFileNameFromPath(String filePath){
		return new File(filePath).getName();
	}
	
	public static String getFilePathFromFileNameInProject(String fileName){
		return getExecutablePathDirectory() + "\\" + PROJECT_IMAGES_FOLDER_NAME
				+ "\\" + fileName;
	}
	
	public static File getExecutablePathDirectoryAsFile(){
		try{
			return new File(OutilsFichiers.class.getProtectionDomain()
					.getCodeSource().getLocation().toURI().getPath());
		}
		catch(URISyntaxException e){
			return null;
		}
	}
	
	public static String getExecutablePathDirectory(){
		return getExecutablePathDirectoryAsFile().getParent();
	}
	
	private static void createDirIfNotExists(String directoryPath){
		
		File file = new File(directoryPath);
		
		if(!file.isDirectory()){
			file.mkdir();
		}
		
	}
	
	public static File getFileFromProject(String path){
		
		return new File(getExecutablePathDirectory() + "\\"
				+ PROJECT_IMAGES_FOLDER_NAME + "\\" + path);
		
	}
	
	public static BufferedImage getBufferedImageFromProject(String path){
		try{
			return ImageIO.read(getFileFromProject(path));
		}
		catch(IOException e){
			return null;
		}
	}
	
}

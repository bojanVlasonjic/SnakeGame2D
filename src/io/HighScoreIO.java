package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.HighScore;

public class HighScoreIO {
	
	private static final String directoryName = "Scores";
	private static final String fileName = "scores.sg";
	
	private static Path pathToFile = Paths.get(
			System.getProperty("user.dir") + "/" + directoryName + "/" + fileName);
	
	

	@SuppressWarnings("unchecked")
	public static void readHighScores() throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream(pathToFile.toString());
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<HighScore> highScores = (ArrayList<HighScore>) ois.readObject();
		ois.close(); 
		
		TopFiveHighScores.getInstance().setHighScores(highScores);
		
		
	}
	
	public static boolean writeHighScores(ArrayList<HighScore> highScores) throws IOException {
		
		//create directory if it does not exist
		if(!Files.exists(pathToFile.getParent())) {
			Files.createDirectories(pathToFile.getParent());
		}
		
		FileOutputStream fos = new FileOutputStream(pathToFile.toString());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(highScores);
		oos.close();
		
		return true;
	}



}

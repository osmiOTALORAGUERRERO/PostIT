package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String [] args)
	{
		File f = new File("src/persistenceFiles");
		if(f.isDirectory()) {
			System.out.println("es un directorio");
			File[] listFiles = f.listFiles();
			System.out.println(listFiles.length);
			for (File file : listFiles) {
			    System.out.println(file);
			    System.out.println(titleParser(file));
			    System.out.println(file.getPath());
			}
		}
	}
	private static String titleParser(File file) {
		String note = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();
			String text = br.readLine();
			while(text != null) {
				note += text+"\n";
				text = br.readLine();
			}
			note = note.replaceFirst("Note: ", "");
			br.close();
			note = note.replaceFirst("Title: ", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return note;
	}
}


package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	public static void main(String [] args)
	{
		String path = "src/persistenceFiles/Prueba eliminar";
		File f;
		if(path.equals(null)) {
			System.out.println("Esta nota se ha guardado");
		}else {
			f = new File(path);
			if(f.exists()) {
				f.delete();
			}
		}
	}
}


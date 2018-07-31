package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Handler {

	private File config = new File("config/config.xml");
	private File passwordFile = new File("config/password.txt");
	private String password;
	public Properties properties = new Properties();

	public Handler() {
		readConfig();
		readPassword();
	}

	public void readPassword() {
		
		//TODO Left off here
		if (passwordFile.exists()) {
			
			try {
				Scanner input = new Scanner(passwordFile);
				password = input.nextLine();
				System.out.println(password);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void readConfig() {
		
		// Check if config file exists. If it does, load it to properties
		if (config.exists()) {
			FileInputStream input = null;

			try {
				input = new FileInputStream(config);
				properties.loadFromXML(input);

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (InvalidPropertiesFormatException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();

			} finally {

				if (input != null) {

					try {
						input.close();

					} catch (IOException e) {
						e.printStackTrace();

					}
				}
			}

		} else {
			// Make a config file if it does not exist
			resetConfig();
		}
	}

	@SuppressWarnings("unused")
	private File locateFile() {
		// TODO Implement file browser window to search for and locate file
		return null;
	}

	public void writeConfig() {
		FileOutputStream output = null;
		
		try {
			output = new FileOutputStream(config);
			properties.storeToXML(output, "FBC ACS Auto-Login 1");

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			
			if (output != null) {
				
				try {
					output.close();
					
				} catch (IOException e) {
					e.printStackTrace();
					
				}
			}
		}
	}

	private void resetConfig() {
		// Delete config.xml and rewrite it with default attributes
		try {
			config.getParentFile().mkdirs();
			config.createNewFile();

			writeConfig();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}

package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Handler {

	private File config = new File("config/config.xml");
	private File passwordFile = new File("config/ACSpassword.txt");
	private String password;
	private GUI gui;

	public Properties properties = new Properties();

	public Handler(GUI gui) {
		this.gui = gui;
		readConfig();
	}

	public void readPassword() {

		// If expected password file exists
		if (passwordFile.exists()) {

			try {
				// Load password from file
				Scanner input = new Scanner(passwordFile);
				password = input.nextLine();
				properties.setProperty("password", password.toString());
				System.out.println(password);

				input.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			if (checkConnection()) {
				
			}
			// If the file does not exist, load password from stored config
			password = properties.getProperty("password");
		}
	}

	public boolean checkConnection() {
		// Check for internet connection by pinging google
		try {
			
			if (InetAddress.getByName("www.google.com").isReachable(10000))
				return true;
			else
				return false;
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
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
			properties.storeToXML(output, "FBC ACS Auto-Login");

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

			properties.setProperty("username", "username");
			properties.setProperty("password", "password");
			writeConfig();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}

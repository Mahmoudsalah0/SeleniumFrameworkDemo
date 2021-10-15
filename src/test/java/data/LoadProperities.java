package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {

	public static Properties userData = loadProperities(System.getProperty("user.dir")+"\\src\\main\\java\\Properities\\userdata.properties");


	private static Properties loadProperities(String path) {

		Properties pro =new Properties();

		try {
			FileInputStream stream=new FileInputStream(path);
			pro.load(stream);

		}catch (FileNotFoundException e) {
			System.out.println("Error occured : "+ e.getMessage());
		}catch (IOException e) {
			System.out.println("Error occured : "+ e.getMessage());}

		return pro;
	}
}


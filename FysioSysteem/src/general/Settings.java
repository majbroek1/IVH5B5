package general;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author IVH5B5
 *
 */

public class Settings {
	public static final String DATADIR = "service.DataDir";
	public static final String RMI_LOCATION = "service.RMILocation";
	
	public static Properties props = new Properties();

	public static void loadProperties(String propertiesFileName) {

		InputStream inputFile = null;

		try {
			inputFile = new FileInputStream(propertiesFileName);
			if (inputFile != null) {
				props.load(inputFile);

				// Set System properties.
				System.setProperty(DATADIR, props.getProperty(DATADIR));
				System.setProperty(RMI_LOCATION, props.getProperty(RMI_LOCATION));
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage()
					+ " - aborting.");
			System.exit(0);
		} catch (Error e) {
			System.out.println(e.getMessage());
		} finally {
			if (inputFile != null) {
				try {
					inputFile.close();
				} catch (IOException e) {
					System.out.println("Error closing file: " + e.getMessage());
				}
			}
		}
	}
}
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reading 
{
	public static Properties prop;
	public Reading() 
	{
		File file =new File("C:\\Users\\Admin3\\workspace2\\Hybrid_Project_FrameWork\\Configuration\\config.properties");

		try
		{
			FileInputStream fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String browsers()
	{
		String brow=prop.getProperty("browser");
		return brow;
	}
	public String urlApplication()
	{
		String url=prop.getProperty("baseURL");
		return url;
	}

	public String username()
	{
		String uName=prop.getProperty("validUserName");
		return uName;
	}

	public String password()
	{
		String pWord=prop.getProperty("validPassword");
		return pWord;
	}
}

package com.qa.gorest.configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.gorest.frameworkException.ApiFrameworkException;

public class ConfigurationManager {
	
	//s2
	private Properties prop;
	private FileInputStream ip;
	public Properties initProp() {
		prop= new Properties();
//start comment from start to end
		//added in s5
		//maven cmd line argument
		//mvn clean install -Denv="qa"
		//mvn clean install
		
		String envName=prop.getProperty("env");
		try {
			if(envName==null) {
				System.out.println("No env is given ,Hence Running in QA env..");
				ip=new FileInputStream("./src/test/resources/conifg/qa.config.properties");
			}else {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip=new FileInputStream("./src/test/resources/conifg/qa.config.properties");
					break;
				case "dev":
					ip=new FileInputStream("./src/test/resources/conifg/dev.config.properties");
					break;
				case "stage":
					ip=new FileInputStream("./src/test/resources/conifg/stage.config.properties");
					break;
				case "prod":
					ip=new FileInputStream("./src/test/resources/conifg/stage.config.properties");
					break;
				default:
					System.out.println("Please pass the right environment"+envName);
					throw new ApiFrameworkException("Wrong ENV is given");
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
///end		
		
		//comment on s5
		//
		/*
		 * try {
		 * ip=new FileInputStream("./src/test/resources/conifg/config.properties");
		 * prop.load(ip); } catch (FileNotFoundException e) { //TODO Auto-generated
		 * catch block e.printStackTrace();} catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
		return prop; 
		
	}
	

	


}

package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Enviornment;

public class JSONUtility {

	public static Enviornment readJSON(Env env) {
		
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir")+"\\config\\config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Enviornment enviornment = config.getEnviornments().get(env.name()); // enum -> String
		return enviornment;
		
		

	}

}

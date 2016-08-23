/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertiondedonnéesv2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 *
 * @author frus68904
 */
public class InsertionDeDonnéesV2 {

    
    public static void main(String[] args) {
		
		//Freemarker configuration object
		Configuration cfg = new Configuration();
		try {   
                        //Load template from source folder
			Template template = cfg.getTemplate("src/logconfFreemarker.ftl");
			
			// Build the data-model
			Map<String, Object> confFile = new HashMap<String, Object>();
                        confFile.put("path", "hello");
                        confFile.put("type", "csv");
                        confFile.put("indexCible", "");
                        confFile.put("numberofworkers", "string");
			//List parsing 
			List<String> countries= new ArrayList<String>();
			countries.add("id");
			countries.add("name");
			countries.add("message");
			countries.add("timestamp");
			
			confFile.put("countries", countries);

			
			// Console output
			Writer out = new OutputStreamWriter(System.out);
			template.process(confFile, out);
			out.flush();

			// File output
			Writer file = new FileWriter(new File("C:\\Users\\frus68904\\Documents\\NetBeansProjects\\InsertionDeDonnéesV2\\FTL_hellotest.conf"));
			template.process(confFile, file);
			file.flush();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
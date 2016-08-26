/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

import freemarker.core.ParseException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.StringTokenizer;
/**
 *
 * @author frus68904
 */
public class InsertionDeDonnéesV2 {
    
    private LogStashConf testfile = new LogStashConf();

    private  void loadUserConf (String UserConf ) throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(
                new FileReader(UserConf))) {
            readSections(br);
    
        }
    }
    private void readSections(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", ""); // supprimer les blancs
            if (!line.isEmpty()) {
                switch (line) {
                    case "[filePath]":
                        loadFilePath(br);
                        break;
                    case "[type]":
                        loadType(br);
                        break;
                    case "[fieldsForFilter]":
                        loadFields(br);
                        break;
                    case "[index]":
                        loadIndex(br);
                       break;
                    default:
                        readSections(br);
                        break;
                }
            }
        }
    }
    private void loadIndex(BufferedReader br) throws IOException{
        String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
             try {
                testfile.setIndex(line);
                return;
             }
             catch(NoSuchElementException e){
                e.printStackTrace();
                }
            }
        }    
    }   
    private void loadFilePath(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
                try{
                testfile.setFilePath(line);
                return;
                }
                catch(NoSuchElementException e){
                e.printStackTrace();
                }
            }
        }
        
    }   
   private void loadType(BufferedReader br) throws IOException {
    String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
               try{
                testfile.setType(line);
                return;
               }
               catch(NoSuchElementException e){
               e.printStackTrace();
               }
            }
        }
    }
    //charger les champs à partir du fichier de conf
    private void loadFields(BufferedReader br) throws IOException {
        Map<Integer,Field> fields = new HashMap<Integer,Field>();
        String line;
        StringTokenizer token;
        int position =0;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
                try{
                token = new StringTokenizer(line, ";");// columnName ;
                // columnType
                while (token.hasMoreTokens()){           //Maxsize
                    fields.put(position,new Field(token.nextToken(), token.nextToken(), token.nextToken(),token.nextToken()));
                    ++position;
                }
                }
                catch (NoSuchElementException e){
                e.printStackTrace();
                System.out.println("Votre Section Champ n'est pas lisible par le générateur de configuration");
                }
                
            }
        }
        testfile.setFields(fields);
    }

    public static void main(String[] args) throws IOException {
        
	InsertionDeDonnéesV2 firstTest = new InsertionDeDonnéesV2();
        String Conf = "C:\\Users\\frus68904\\Documents\\NetBeansProjects\\InsertionDeDonnéesV2\\test.conf" ;
        firstTest.loadUserConf(Conf);
        firstTest.toString();
        System.out.println(firstTest.testfile.getFields());
        
	//Freemarker configuration object
           
        Configuration cfg = new Configuration();
            try {   
                        //Load template from source folder
			Template template = cfg.getTemplate("src/logconfFreemarker.ftl");
			
			// Build the data-model
			Map<String, Object> confFile = new HashMap<>();
                        confFile.put("path", "firstTest.testfile.getFilePath()");
                        confFile.put("type", "firstTest.testfile.getType().toString()");
                        confFile.put("indexCible", "firstTest.testfile.getIndex().toString()");
                        confFile.put("numberofworkers", "string");
			//List parsing 
			List<String> countries= new ArrayList<String>();
			countries.add("id");
			countries.add("name");
			countries.add("message");
			countries.add("timestamp");
			
			confFile.put("countries", firstTest.testfile.getFields().keySet().toArray());

			
			// Console output
			Writer out = new OutputStreamWriter(System.out);
			template.process(confFile, out);
			out.flush();

            try ( // File output
                    Writer file = new FileWriter(new File("C:\\Users\\frus68904\\Documents\\NetBeansProjects\\InsertionDeDonnéesV2\\FTL_hellotest.conf"))) {
                template.process(confFile, file);
                file.flush();
            }
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
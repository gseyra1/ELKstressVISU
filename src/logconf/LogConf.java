/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logconf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author frus68904
 */
public class LogConf {

    /**
     * @param args the command line arguments
     */
    
    
    private CSVtemplate csvTemp = new CSVtemplate();
    private Field newData = new Field();
    
    private void loadSeparator(BufferedReader br) throws IOException{
    String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
                csvTemp.setSeparator(line);
                return;
            }
        }
    }
    
    private void loadFileType(BufferedReader br)throws IOException{
    String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", ""); // supprimer les blancs
            if (!line.isEmpty()) {
               csvTemp.getFileType(); 
            }
        }
    }
    
    private void loadFields(BufferedReader br) throws IOException{
    Map<Integer,Field> fields = new HashMap<Integer,Field>();
        String line;
        StringTokenizer token;
        int position =0;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", "");
            if (!line.isEmpty()) {
                token = new StringTokenizer(line, ";");// fieldsName ;
                // fieldsType
                while (token.hasMoreTokens()){           
                    fields.put(position,new Field(token.nextToken(), token.nextToken()));
                    ++position;
                }
            }
        }
        csvTemp.setFields(fields);
    }
    
    private void readSections(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line.replaceAll("\\s", ""); // supprimer les blancs
            if (!line.isEmpty()) {
                switch (line) {
                    case "[File type]":
                        loadFileType(br);
                        break;
                   
                    case "[Fields]":
                        loadFields(br);
                        break;
                    
                    case "[Separator]":
                        loadSeparator(br);
                        break;
                    default:
                        readSections(br);
                        break;
                }
            }
        }
    }
    public String toString(Map<Integer,Field[]> Fields){
        
    Map<Integer,Field []> test = new HashMap<Integer,Field[]>();
    
    /*[] aTest = {5,1,4};
    test.put(1, aTest);*/
    
    
    return"\"message\" : {\"type\" : \"\"},\n" + "\"tags\" : {\"type\" : \"string\", \"index_name\" : \"tag\"},\n"  ; 
    }
    
    public String MapField(String fieldsName, String fieldsType){
    
    
    String  Mps = "{\"tweet\" : {\n" +
"        \"properties\" : {\n" + toString() +
"            \"lists\" : {\n" +
"            }\n" +
"        }\n" +
"    }}\n";
    return Mps;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Type: ");
        Scanner sp = new Scanner(System.in);
        String p;
        p = sp.nextLine();

        System.out.print("Champs: ");
        Scanner sd = new Scanner(System.in);
        String d;
        d = sd.nextLine();
        
        System.out.print("Separator: ");
        Scanner sepa = new Scanner(System.in);
        String a;
        a = sepa.nextLine();
        
        
        
         try
             {
             
             System.out.print("Le chemin de votre fichier: ");
             Scanner monfichier = new Scanner(System.in);
             String Fch;
             Fch = monfichier.nextLine();
             File file = new File(Fch);
             
             BufferedReader reader = new BufferedReader(new FileReader(file));
             String line = "", oldtext = "";
             while((line = reader.readLine()) != null)
                 {
                 oldtext += line + "\r\n";
             }
             
             reader.close();
            

             String replacedtext  = oldtext.replaceAll("@type", "" + p);
             replacedtext = replacedtext.replaceAll("@columns", "" + d);
             replacedtext = replacedtext.replaceAll("@separator", "" + a);
             
             
             String LgsConf;
             LgsConf = Fch;
             FileWriter writer = new FileWriter(LgsConf);
             writer.write(replacedtext);

             writer.flush();
             writer.close();
             
             

            }         
            catch (IOException ioe)

            {
             ioe.printStackTrace();
            }
        
         
             
         }
        

    }
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

import java.util.Map;
import freemarker.template.Configuration;

/**
 *
 * @author frus68904
 */
public class LogStashConf extends Configuration{
    private String filePath;
    private String type;
    private String index;
    private int numberOfWorkers;
    Map<Integer,Field> fields;

    public LogStashConf() {
        super();
    }
    
    

    public LogStashConf(String filePath, String type, String index, int numberOfWorkers, Map<Integer, Field> fields) {
        this.filePath = filePath;
        this.type = type;
        this.index = index;
        this.numberOfWorkers = numberOfWorkers;
        this.fields = fields;
    }

    public Map<Integer, Field> getFields() {
        return fields;
    }
    public void setFields(Map<Integer, Field> fields) {
        this.fields = fields;
    }
 
    
    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }
    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }
    
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    
    
}

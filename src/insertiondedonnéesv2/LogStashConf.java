/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertiondedonnéesv2;

/**
 *
 * @author frus68904
 */
public class LogStashConf {
    private String path;
    private String type;
    private String index;
    private int numberOfWorkers;

    public LogStashConf(){
        super();
    }

    public LogStashConf(String path, String type, String index) {
        this.path = path;
        this.type = type;
        this.index = index;
    }
    
    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }
    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }
    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
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

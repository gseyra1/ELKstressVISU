/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logconf;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author frus68904
 */
public class CSVtemplate extends ShipperConfTemplate{
    

    private String Separator;
    private Map<Integer,Field> fields;
    private Map<Integer,Field []> ComplexFields;

    public Map<Integer, Field[]> getComplexFields() {
        return ComplexFields;
    }

    public void setComplexFields(Map<Integer, Field []> ComplexFields) {
        this.ComplexFields = ComplexFields;
    }
    
        public CSVtemplate() {
        super();
    }
        
        public CSVtemplate(String separ, Map<Integer,Field> fields, Map<Integer,Field[]> compFields){
        this.Separator = separ;
        this.fields = fields;
        this.ComplexFields = compFields;
        
        }


    public Map<Integer, Field> getFields() {
        return fields;
    }
    public void setFields(Map<Integer, Field> fields) {
        this.fields = fields;
    }
    
    
    public String getSeparator() {
        return Separator;
    }
    public void setSeparator(String Separator) {
        this.Separator = Separator;
    }
    

    

}

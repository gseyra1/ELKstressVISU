/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logconf;

/**
 *
 * @author frus68904
 */
 public class Field {
        private String fieldsName;
        private String fieldsType;

        
        public Field(){
        super();
        }
        
        
    public Field(String fieldsName, String fieldsType) {
        this.fieldsName = fieldsName;
        this.fieldsType = fieldsType;
    }

    public String getFieldsName() {
        return fieldsName;
    }
    public void setFieldsName(String fieldsName) {
        this.fieldsName = fieldsName;
    }

    public String getFieldsType() {
        return fieldsType;
    }
    public void setFieldsType(String fieldsType) {
        this.fieldsType = fieldsType;
    }

 }
    

   
        
        
        


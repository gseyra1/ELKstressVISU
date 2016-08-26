/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

/**
 *
 * @author frus68904
 */
public class Field {
    private String fieldName;
    private String fieldType;
    private String descriptor;
    private String analyzer;

    public Field() {
        super();
    }
    
    

    public Field(String fieldName, String fieldType, String descriptor, String analyzer) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.descriptor = descriptor;
        this.analyzer = analyzer;
    }
    

    public String getDescriptor() {
        return descriptor;
    }
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getAnalyzer() {
        return analyzer;
    }
    public void setAnalyzer(String analyzer) {
        this.analyzer = analyzer;
    }

    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

}

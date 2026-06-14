/*
Student:            Chen Jiaying
No. :               041191259
Class & Section:    CST8288 section 013
Description:        lab 1
*/
package TransferObjects;



/**
 * Data Transfer Object (DTO) used to store metadata
 * about database result set columns.
 *
 * @author Chen Jiaying
 */
public class MetaDTO {
    private String columnName;
    private String sqlType;
    private String className;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
    
}

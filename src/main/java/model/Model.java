
package model;

public class Model {
    public String name;
    private int id;
    private String date;
    
    public void setName(String name){
        this.name = name;                
    }
    
    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}

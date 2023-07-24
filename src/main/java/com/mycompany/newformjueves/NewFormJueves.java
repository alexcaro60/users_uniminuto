
package com.mycompany.newformjueves;
import view.View;
import model.Model;
import controller.Control;
import model.Administrator_SQL;

public class NewFormJueves {

    public static void main(String[] args) {
        View obj_view = new View(); 
        Model obj_model = new Model();
        Administrator_SQL obj_SQL = new Administrator_SQL();
        Control obj_Control = new Control(obj_view, obj_model, obj_SQL);        
    }
}

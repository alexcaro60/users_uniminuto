
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.View;
import model.Model;
import model.Administrator_SQL;

public class Control {
    private Model obj_model;
    private View obj_view;
    private Administrator_SQL obj_SQL;
    boolean confirmation;

    public Control(View obj_view, Model obj_model, Administrator_SQL obj_SQL) {
        this.obj_view = obj_view;
        this.obj_model = obj_model;
        this.obj_SQL = obj_SQL;
        this.obj_view.btnRegister.addActionListener(btn_register);
        this.obj_view.btnConsult.addActionListener(btn_consult);
        start_view();
        confirmation = obj_SQL.connect();
    }
    
    public void start_view(){
        obj_view.setVisible(true);
        obj_view.setLocationRelativeTo(null);
        for(int i=1; i<=31; i++){
            obj_view.optionDay.addItem(String.valueOf(i));            
        }
        for (int j=1900; j<=2100; j++) {
            obj_view.optionYear.addItem(String.valueOf(j));
        }
    }
    
    public void establish_user(){
        obj_model.setName(obj_view.txtName.getText());
        obj_model.setId(Integer.parseInt(obj_view.txtId.getText()));
        obj_model.setDate(obj_view.optionDay.getSelectedItem() + "-" + obj_view.optionMonth.getSelectedItem() + "-" + obj_view.optionYear.getSelectedItem());
    }
    
    public void clean_view () {
        obj_view.txtName.setText("");
        obj_view.txtId.setText("");
        obj_view.optionDay.setSelectedItem("1");
        obj_view.optionMonth.setSelectedItem("Enero");
        obj_view.optionYear.setSelectedItem("1900");
    }
    
    ActionListener btn_register = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
            if (confirmation){                
                establish_user();            
                obj_SQL.register(obj_model.getName(), obj_model.getId(), obj_model.getDate());
                clean_view();
            }      
            else {
                JOptionPane.showMessageDialog(null, "There is an error with the database connection");
            }
        }
    };
    
    ActionListener btn_consult = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            obj_view.txtResult.setText("");
            if (confirmation){
                ArrayList<String> array_users = obj_SQL.consult();
                for(int i=0; i<array_users.size(); i++){
                    obj_view.txtResult.append(String.valueOf(array_users.get(i)) + "\n");
                }
            }  
            else {
                JOptionPane.showMessageDialog(null, "There is an error with the database connection");
            }
        }
    };
}

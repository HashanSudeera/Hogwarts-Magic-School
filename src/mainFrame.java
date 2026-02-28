import javax.swing.*;
import java.awt.Color;


public class mainFrame extends JFrame {

    mainFrame(){

        this.setTitle("Hogwarts");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setResizable(false);
        this.setLayout(null);
        

        //icon
        this.setIconImage(resourcesLoad.image.getImage());
        this.getContentPane().setBackground(new Color(0x9D9167));

        


       
    }

    
}

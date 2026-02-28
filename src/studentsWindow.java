import javax.swing.JFrame;
import java.awt.Color;

public class studentsWindow extends JFrame  {
    studentsWindow(){
        this.setTitle("School Records");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900,600);
        this.setResizable(false);
        

        //icon
        this.setIconImage(resourcesLoad.image.getImage());
        this.getContentPane().setBackground(new Color(0x9D9167));

    }
    
}

import javax.swing.*;
import javax.swing.border.Border;

public class Header extends JPanel{
    Header(){

        this.setBackground(hogwartsTheam.COCOA);
        this.setBounds(0, 0 , 900, 40);
        this.setLayout(null);

        Border border = BorderFactory.createLineBorder(null,0);
        JLabel label = new JLabel();
        label.setText("Hogwarts Magic School");
        label.setForeground(hogwartsTheam.GOLDEN_BATTER);
        label.setFont(hogwartsTheam.HEAD_LINE);
        label.setBackground(hogwartsTheam.COCOA);
        label.setOpaque(true);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0,900,40);

        this.add(label);

    }
    
}

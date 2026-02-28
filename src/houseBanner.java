import javax.swing.*;
import java.awt.*;

public class houseBanner extends JPanel {
    public static boolean click = false;
    public static JTextArea textArea; 
    public houseBanner(String houseName, Color themeColor, String logoPath, Color fontColor,String reason) {
        // 1. Set the basic panel properties
        this.setLayout(null);
        this.setBackground(themeColor); 
        this.setPreferredSize(new Dimension(400, 460));
        this.setBorder(BorderFactory.createLineBorder(null, 0));

        // 2. Add the House Name Label
        String houseWelcome = "Welcome to "+ houseName.toUpperCase();
        JLabel nameLabel = new JLabel(houseWelcome);
        nameLabel.setFont(hogwartsTheam.HEAD_LINE);
        nameLabel.setForeground(fontColor);
        nameLabel.setBounds(10, 20, 400, 40);
        this.add(nameLabel);

        // 3. Add the House Logo
        try {
            ImageIcon icon = new ImageIcon(logoPath);
            // Resize logic to make sure any logo fits perfectly
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(img));
            logoLabel.setBounds(100, 60, 200, 210);
            this.add(logoLabel);
        } catch (Exception e) {
            System.out.println("Logo not found at: " + logoPath);
        }

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Ensures words aren't cut in half at the end of a line
        textArea.setBackground(themeColor);
        textArea.setForeground(fontColor);
        textArea.setFont(hogwartsTheam.REGULAR1);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 280, 380, 150); // Position it in your form panel
        scrollPane.setBorder(BorderFactory.createLineBorder(themeColor));


        textArea.setText(reason);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        this.add(scrollPane);

        JButton registerbtn = new JButton("Register");
        registerbtn.setBounds(150, 430, 100, 20);
        registerbtn.setBackground(fontColor);
        registerbtn.setForeground(themeColor);
        registerbtn.setFocusable(false);
        registerbtn.addActionListener(e ->{

            if(!click){
                register.getData(Form.getStudentName, Form.getDOB,hatpanel.houseName , Form.getIdentity, Form.getBlood , Form.getStick ,Form.getyear , Form.getPet );

                click = true;

            }else{
                System.out.println("you allready clicked register button");
            }

             

        });
        this.add(registerbtn);


        
    }
    
}

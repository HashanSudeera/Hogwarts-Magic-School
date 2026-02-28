import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame  {
    About(){
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.setLayout(null);
        //icon
        this.setIconImage(resourcesLoad.image.getImage());
        this.getContentPane().setBackground(hogwartsTheam.COCOA);

        JLabel aboutimg = new JLabel(resourcesLoad.aboutimg);
        aboutimg.setBounds(0, -40, 500, 310);

        JLabel title = new JLabel("ABOUT");
        title.setForeground(hogwartsTheam.GOLDEN_BATTER);
        title.setFont(hogwartsTheam.HEAD_LINE);
        title.setBackground(hogwartsTheam.COCOA);
        title.setBounds(190,270,500,40);

        // 1. Create the JTextArea
        JTextArea textArea = new JTextArea();

        // 2. Enable Line Wrapping (Crucial for long paragraphs)
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Ensures words aren't cut in half at the end of a line

        // 3. Apply your Hogwarts Theme
        textArea.setBackground(hogwartsTheam.COCOA);
        textArea.setForeground(hogwartsTheam.LIGHT_BROWN);
        textArea.setFont(hogwartsTheam.REGULAR1);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 310, 480, 100); // Position it in your form panel
        scrollPane.setBorder(BorderFactory.createLineBorder(hogwartsTheam.COCOA));


        textArea.setText("This is my first Java project. I started it for learning purposes and have already learned a lot along the way.\n" + //
                        "\n" + //
                        "Developer: Hashan Sudeera");
        textArea.setEditable(false);
        textArea.setFocusable(false);
        this.add(scrollPane);

        




        
        this.add(title);
        this.add(aboutimg);
        this.setVisible(true);
    }
    
}

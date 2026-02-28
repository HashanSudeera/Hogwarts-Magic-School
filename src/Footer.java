import javax.swing.JButton;
import javax.swing.JPanel;

public class Footer extends JPanel{
    Footer(){

        //----------------------------------------------------
        JButton pauseBtn = new JButton();
        pauseBtn.setIcon(resourcesLoad.pauseIcon);
        pauseBtn.setBounds(10, 20, 50, 30);
        pauseBtn.addActionListener(e -> SoundManager.pauseMusic());
        pauseBtn.setBackground(hogwartsTheam.LIGHT_BROWN);
        pauseBtn.setFocusable(false);

        JButton resumeBtn = new JButton();
        resumeBtn.setIcon(resourcesLoad.playIcon);
        resumeBtn.setBounds(70, 20, 50, 30);
        resumeBtn.addActionListener(e -> SoundManager.resumeMusic());
        resumeBtn.setBackground(hogwartsTheam.LIGHT_BROWN);
        resumeBtn.setFocusable(false);

        JButton about = new JButton("About");
        about.setBounds(750, 20, 100, 30);
        about.addActionListener(e -> {
            new About();

        });
        about.setBackground(hogwartsTheam.LIGHT_BROWN);
        about.setFocusable(false);
        
        this.setBackground(hogwartsTheam.COCOA);
        this.setBounds(0, 500, 900, 150);
        this.setLayout(null);
        this.add(pauseBtn);
        this.add(resumeBtn);
        this.add(about);
    }
    
}

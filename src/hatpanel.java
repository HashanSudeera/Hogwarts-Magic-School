import javax.swing.*;

public class hatpanel extends JPanel {

    public static String houseName;
    JLabel title;
    JLabel houses;
    JLabel hatLabel;
    JLabel p1;
    public static JTextArea textArea;
    JScrollPane scrollPane;
    public static JProgressBar magicProgress;
    JButton prompt;
    public static houseBanner currentBanner;

    public static String data;


    hatpanel() {
        this.setBackground(hogwartsTheam.CARAMEL);
        this.setBounds(500, 40, 400, 460);
        this.setLayout(null);

        // --- Labels and Components (Keeping your original setup) ---
        title = new JLabel("The Sorting Hat");
        title.setFont(hogwartsTheam.TABLE_HEAD_LINE1);
        title.setForeground(hogwartsTheam.GOLDEN_BATTER);
        title.setBounds(100, 10, 300, 20);
        this.add(title);

        houses = new JLabel(resourcesLoad.houselogo);
        houses.setBounds(100, -70, 400, 400);
        this.add(houses);

        hatLabel = new JLabel(resourcesLoad.hat);
        hatLabel.setBounds(0, 0, 400, 400);
        this.add(hatLabel);

        p1 = new JLabel("Who are you? ");
        p1.setFont(hogwartsTheam.REGULAR);
        p1.setForeground(hogwartsTheam.GOLDEN_BATTER);
        p1.setBounds(20, 350, 300, 20);
        this.add(p1);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(hogwartsTheam.COCOA);
        textArea.setForeground(hogwartsTheam.LIGHT_BROWN);
        textArea.setFont(hogwartsTheam.REGULAR1);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 370, 300, 50);
        scrollPane.setBorder(BorderFactory.createLineBorder(hogwartsTheam.COCOA));
        this.add(scrollPane);

        // --- The Progress Bar ---
        magicProgress = new JProgressBar(0, 100);
        magicProgress.setBounds(20, 430, 300, 15);
        magicProgress.setBackground(hogwartsTheam.COCOA);
        magicProgress.setForeground(hogwartsTheam.OLIVE_HARVEST);
        magicProgress.setBorderPainted(false);
        magicProgress.setStringPainted(true);
        magicProgress.setString("Ready for Sorting...");
        this.add(magicProgress);

        // --- The Button Logic ---
        prompt = new JButton("Go");
        prompt.setBounds(325, 370, 50, 50);
        prompt.setBackground(hogwartsTheam.LIGHT_BROWN);
        prompt.setFocusable(false);

        prompt.addActionListener(e -> {
            data = textArea.getText();
            
            // 1. Start UI Loading State
            prompt.setEnabled(false); // Disable button to prevent double-clicks
            magicProgress.setIndeterminate(true); // Start the "Magic" sliding animation
            magicProgress.setString("The Hat is reading your mind...");

            // 2. Start a Background Thread so the UI doesn't freeze
            new Thread(() -> {
                try {
                    // Call the API
                    String response = AISorthat.callSortingHat(Form.getStudentName, data);
                    
                    // 3. Update the UI back on the Main Thread
                    SwingUtilities.invokeLater(() -> {
                        processResponse(response, magicProgress, prompt);
                    });

                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> {
                        magicProgress.setIndeterminate(false);
                        magicProgress.setString("Connection Failed!");
                        prompt.setEnabled(true);
                    });
                }
            }).start();
        });

        this.add(prompt);
    }

    // Helper method to handle the AI result and switch view
    private void processResponse(String response, JProgressBar magicProgress, JButton prompt) {
        String reasonText = "";
        String[] parts = response.split("\\|");

        if (parts.length >= 2) {
            houseName = parts[0].trim();
            reasonText = parts[1].trim();
        }

        currentBanner = null;

        // Use .contains() or .equalsIgnoreCase() for safer matching
        if (houseName.contains("Gryffindor")) {
            currentBanner = new houseBanner("Gryffindor", hogwartsTheam.griffindor_main, "img/g.png", hogwartsTheam.griffindor_second, reasonText);
        } else if (houseName.contains("Slytherin")) {
            currentBanner = new houseBanner("Slytherin", hogwartsTheam.slythrin_main, "img/s.png", hogwartsTheam.slythrin_second, reasonText);
        } else if (houseName.contains("Ravenclaw")) {
            currentBanner = new houseBanner("Ravenclaw", hogwartsTheam.ravenclaw_main, "img/r.png", hogwartsTheam.revenclaw_second, reasonText);
        } else if (houseName.contains("Hufflepuff")) {
            currentBanner = new houseBanner("Hufflepuff", hogwartsTheam.Hufflepuff_main, "img/h.png", hogwartsTheam.Hufflepuff_second, reasonText);
        }

        if (currentBanner != null) {
            // Stop progress bar and show success
            magicProgress.setIndeterminate(false);
            magicProgress.setValue(100);
            
            this.removeAll(); // Switch to the House View
            currentBanner.setBounds(0, 0, 400, 460);
            this.add(currentBanner);
            this.revalidate();
            this.repaint();
        } else {
            // Handle error case
            magicProgress.setIndeterminate(false);
            magicProgress.setString("The Hat wanna internet for think...");
            prompt.setEnabled(true);
        }
        
    }
    

    
}
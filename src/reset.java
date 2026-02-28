
public class reset {

    public static void restartProcess() {
    
        Form.getStudentName = "";
        Form.isPushed = false;
        houseBanner.click = false;
        
        if (Form.inName != null) Form.inName.setText("");
        if (hatpanel.textArea != null) hatpanel.textArea.setText("");
        hatpanel.data = "";
        
        if (houseBanner.textArea != null) {
            houseBanner.textArea.setText("");
        }
        
        if (hatpanel.magicProgress != null) {
            hatpanel.magicProgress.setIndeterminate(false);
            hatpanel.magicProgress.setValue(0);
            hatpanel.magicProgress.setString("Ready for Sorting...");
        }

        // 2. Clear the Main Frame
        if (App.main != null) {
            // This wipes the old result screen and everything on it
            App.main.getContentPane().removeAll();

            App.header = new Header();
            App.mainForm = new Form();
            App.mainHouseSelect = new hatpanel();
            App.footer = new Footer();

            App.main.add(App.header);
            App.main.add(App.mainForm);
            App.main.add(App.mainHouseSelect);
            App.main.add(App.footer);

            App.main.revalidate();
            App.main.repaint();
            
            System.out.println("System Restarted: All panels are in default opening positions.");
        } else {
            System.err.println("Error: App.main is null or status is false.");
        }
    }
}
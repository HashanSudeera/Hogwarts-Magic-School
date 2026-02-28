public class App {

    public static mainFrame main;
    public static Header header;
    public static Form mainForm ;
    public static hatpanel mainHouseSelect;
    public static Footer footer;

    public static void main(String[] args){

        SoundManager.playBackgroundMusic("resources/theamMusic.wav");
        //SoundManager.playBackgroundMusic("resources/HarryPotterIndianTheme.wav");
       
        //main===================================================
        main = new mainFrame();
        //header=================================================
        header = new Header();
        //form==================================================
        mainForm = new Form();
        //Footer=================================================
        footer = new Footer();
        //hatpanel ==============================================
        mainHouseSelect = new hatpanel();
        
        //panels
        main.add(header);
        main.add(mainForm);
        main.add(mainHouseSelect);
        main.add(footer);

        main.setVisible(true);
        
         
    }
}

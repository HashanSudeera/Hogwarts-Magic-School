import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Form extends JPanel {

    public static boolean isPushed = false;
    public static String getStudentName;
    public static String getDOB;
    public static String getIdentity;
    public static String getBlood;
    public static String getyear;
    public static String getPet;
    public static String getStick;

    public static JTextField inName;


    Form(){
        this.setBackground(hogwartsTheam.GOLDEN_BATTER);
        this.setBounds(0, 40, 500, 460);
        this.setLayout(null);


        //name
        JLabel name = new JLabel("Name              : ");
        name.setFont(hogwartsTheam.REGULAR);
        name.setBounds(10, 10, 210, 20);

        //text field
        inName = new JTextField();
        inName.setBounds(220, 10, 200, 20);
        inName.setBackground(hogwartsTheam.LIGHT_BROWN); // Lighter Parchment
        inName.setBorder(BorderFactory.createLineBorder(hogwartsTheam.COCOA));
        inName.setFont(hogwartsTheam.REGULAR);


        JLabel dob = new JLabel("Date of Hatching  : ");
        dob.setFont(hogwartsTheam.REGULAR);
        dob.setBounds(10, 40, 210, 20);

        // 1. Create your spinner
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setBounds(220, 40, 200, 20);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd / MM / yyyy");
        dateSpinner.setEditor(editor);

        JTextField date = ((JSpinner.DefaultEditor)dateSpinner.getEditor()).getTextField();
        date.setBackground(hogwartsTheam.LIGHT_BROWN);
        date.setForeground(hogwartsTheam.COCOA);
        date.setBorder(null);
        

        JLabel blood = new JLabel("Blood Heritage    : ");
        blood.setFont(hogwartsTheam.REGULAR);
        blood.setBounds(10, 70, 210, 20);

        String[] blood_types = {"Pure-blood","Half-blood","Muggle-born"};
        JComboBox<String> bloodBox = new JComboBox<>(blood_types);
        bloodBox.setBounds(220, 70, 200, 20);
        bloodBox.setForeground(hogwartsTheam.COCOA);
        bloodBox.setBackground(hogwartsTheam.LIGHT_BROWN);

        
        JLabel identity = new JLabel("National Identity : ");
        identity.setFont(hogwartsTheam.REGULAR);
        identity.setBounds(10, 100, 210, 20);

        String[] nations = {
            "British", 
            "Bulgarian", 
            "French", 
            "American",
            "African",
            "Brazilian"
        };

        JComboBox<String> inIdentity = new JComboBox<>(nations);
        inIdentity.setBounds(220, 100, 200, 20);
        inIdentity.setBackground(hogwartsTheam.LIGHT_BROWN);
        this.add(inIdentity);

        JLabel stick = new JLabel("Broomstick Model  : ");
        stick.setFont(hogwartsTheam.REGULAR);
        stick.setBounds(10, 130, 210, 20);

        String[] brooms = {
            "Firebolt", 
            "Nimbus 2001", 
            "Nimbus 2000", 
            "Cleansweep Seven", 
            "Comet 260", 
            "Shooting Star"
        };

        JComboBox<String> inStick = new JComboBox<>(brooms);
        inStick.setBounds(220, 130, 200, 20);
        inStick.setBackground(hogwartsTheam.LIGHT_BROWN);
        inStick.setForeground(hogwartsTheam.COCOA);

        JLabel year = new JLabel("Enrollment Year   : ");
        year.setFont(hogwartsTheam.REGULAR);
        year.setBounds(10, 160, 210, 20);

                
        String[] hogwartsYears = {
            "1st Year", 
            "2nd Year", 
            "3rd Year", 
            "4th Year", 
            "5th Year", 
            "6th Year", 
            "7th Year"
        };

        JComboBox<String> yearDropdown = new JComboBox<>(hogwartsYears);
        yearDropdown.setBounds(220, 160, 200, 20);
        yearDropdown.setBackground(hogwartsTheam.LIGHT_BROWN);
        yearDropdown.setForeground(hogwartsTheam.COCOA);
        
        JLabel pet = new JLabel("Magic Pet         : ");
        pet.setFont(hogwartsTheam.REGULAR);
        pet.setBounds(10, 190, 210, 20);

        String[] pets = {
            "Owl", 
            "Cat", 
            "Toad", 
            "Rat", 
            "Pygmy Puff"
        };

        JComboBox<String> inPet = new JComboBox<>(pets);
        inPet.setBounds(220, 190, 200, 20);
        inPet.setBackground(hogwartsTheam.LIGHT_BROWN);
        inPet.setForeground(hogwartsTheam.COCOA);

        JButton submit = new JButton();
        submit.setText("Load Data");
        submit.setBounds(10, 230, 480, 20);
        submit.addActionListener(e -> {
            
            if(!isPushed){
                getStudentName = inName.getText();
                getDOB = date.getText();

                //get data from form
                getIdentity = (String) inIdentity.getSelectedItem();
                getBlood = (String)  bloodBox.getSelectedItem();
                getStick = (String) inStick.getSelectedItem();
                getyear = (String) yearDropdown.getSelectedItem();
                getPet = (String) inPet.getSelectedItem();

                /* System.out.println(getStudentName);
                System.out.println(getDOB);
                System.out.println(getIdentity);
                System.out.println(getBlood);
                System.out.println(getStick);
                System.out.println(getyear);
                System.out.println(getPet); */

                System.out.println("Data loaded successfully...");
                isPushed = true;

            }else{
                System.out.println("Already registered");
            }

        });
        submit.setBackground(hogwartsTheam.LIGHT_BROWN);
        submit.setFocusable(false);

        //new window 

        JButton records = new JButton();
        records.setText("View Records");
        records.setBounds(10, 290, 480, 20);
        records.setBackground(hogwartsTheam.LIGHT_BROWN);
        records.setFocusable(false);



        records.addActionListener(e -> { 
            studentsWindow recordsWindow = new studentsWindow(); 
            recordsWindow.setLayout(null);

                        // 1. Define Column Names
            String[] columns = {"Name", "DOB", "House","Blood","N.Identity","Broomstick","Year", "Pet"};

            // 2. Create the Data Model (This holds the inthisation)
            DefaultTableModel model = new DefaultTableModel(columns, 0);

            // 3. Create the Table using the model
            JTable studentTable = new JTable(model);
            // Set the colors for the table body
            studentTable.setBackground(hogwartsTheam.LIGHT_BROWN);
            studentTable.setForeground(hogwartsTheam.COCOA);
            studentTable.setFont(hogwartsTheam.REGULAR);
            studentTable.setRowHeight(20);

            // 1. Get the Column Model from your table
            TableColumnModel columnModel = studentTable.getColumnModel();

            // 2. Set preferred width for each column (Index starts at 0)
            columnModel.getColumn(0).setPreferredWidth(150); // Student Name (Wider)
            columnModel.getColumn(1).setPreferredWidth(150); // Date
            columnModel.getColumn(2).setPreferredWidth(80); // Nationality
            columnModel.getColumn(3).setPreferredWidth(80); // Blood
            columnModel.getColumn(4).setPreferredWidth(100); // Broomstick
            columnModel.getColumn(5).setPreferredWidth(80);  // Year (Narrower)
            columnModel.getColumn(6).setPreferredWidth(80);  // Pet
            columnModel.getColumn(6).setPreferredWidth(80);  // Pet

            // Set the colors for the header (the top row)
            studentTable.getTableHeader().setBackground(hogwartsTheam.COCOA);
            studentTable.getTableHeader().setForeground(hogwartsTheam.GOLDEN_BATTER);
            studentTable.getTableHeader().setFont(hogwartsTheam.TABLE_HEAD_LINE);

            // 4. Wrap it in a JScrollPane (Crucial for seeing the headers and scrolling)
            JScrollPane scrollPane = new JScrollPane(studentTable);
            scrollPane.setBounds(20, 10, 840, 500); // Adjust to fit your 'end' or a new panel

            String filepath1 = "resources/register.csv";
            register.loadDataToTable(model, filepath1);

            // 5. Add to your panel
            recordsWindow.add(scrollPane);

            recordsWindow.setVisible(true);
        });

        //all reset

        JButton resetbtn = new JButton();
        resetbtn.setText("Reset");
        resetbtn.setBounds(10, 260, 480, 20);
        resetbtn.setFocusable(false);
        resetbtn.setBackground(hogwartsTheam.LIGHT_BROWN);
        resetbtn.addActionListener(e ->{
            
            reset.restartProcess();
        });

        this.add(name); this.add(inName);
        this.add(dob); this.add(dateSpinner);
        this.add(blood); this.add(bloodBox);
        this.add(identity); this.add(identity);
        this.add(stick); this.add(inStick);
        this.add(year); this.add(yearDropdown);
        this.add(pet); this.add(inPet);

        //buttons
        this.add(submit);
        this.add(records);
        this.add(resetbtn);






        
    }
    
}

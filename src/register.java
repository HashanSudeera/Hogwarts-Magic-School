import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class register {

    public static void getData(String StudentName, String dob ,String house , String Identity, String Blood , String stick , String year , String pet ){

        
        try {
            File registerFile = new File("resources/register.csv");
            if (registerFile.createNewFile()) {  
                System.out.println("File created: " + registerFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); 
        }

        try{

            FileWriter registerWrite = new FileWriter("resources/register.csv",true);
            if(!StudentName.trim().isEmpty()){
                registerWrite.append(StudentName + "," + dob + ","+ house + "," + Identity + "," + Blood + "," + stick + "," + year + "," + pet + "\n");
                JOptionPane.showMessageDialog(null,
                     
                    "Registration Successful! Welcome to Hogwarts.", 
                    "Success", 
                JOptionPane.INFORMATION_MESSAGE
                );

                
               
            }
            else{
                JOptionPane.showMessageDialog(null,
                     
                    "Student Name Requrid..", 
                    "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            }
            
            registerWrite.close();

        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();

        }




        
    }

    
    public static void loadDataToTable(DefaultTableModel model, String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] rawData = line.split(",");
            String[] cleanData = new String[rawData.length];

            for (int i = 0; i < rawData.length; i++) {
                cleanData[i] = rawData[i].trim();
            }
        
            model.addRow(cleanData);
        }
    } catch (IOException e) {
        System.out.println("Error reading the registry: " + e.getMessage());
    }
}
}

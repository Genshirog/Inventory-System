import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.regex.*;

public class Register extends JFrame implements ActionListener{
    /*Register class must ask the user for his First name and Last name
     * Birthday
     * Contact info
     * Status(only the IT, Certified Public Accountant, owner, Inventory clerk can be allowed access to this)
     * Employee's code will be the passcode
     */
    String regex = "\\d{2}-\\d{2}-\\d{4}";
    Pattern pattern = Pattern.compile(regex);
    JButton button[] = new JButton[2];
    JLabel label[] = new JLabel[6];
    JTextField text[] = new JTextField[6];
    private JTextField firstName = new JTextField();
    private JTextField lastName = new JTextField();
    private JTextField bday = new JTextField();
    private JTextField contact = new JTextField();
    private JTextField status = new JTextField();
    private JTextField code = new JTextField();
    Register(){
        this.setSize(320,480);
        this.setTitle("Registration");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.add(panel());
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    JPanel panel(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0 , 320, 480);
        JLabel FirstName = new JLabel("First Name:");
        JLabel LastName = new JLabel("Last Name:");
        JLabel Birthday = new JLabel("Birthday:");
        JLabel Contact = new JLabel("Contact Info:");
        JLabel Status = new JLabel("Status:");
        JLabel Code = new JLabel("Employee code:");
        JButton login = new JButton("Sign in");
        JButton next = new JButton("NEXT");

        button[0] = login;
        button[1] = next;
        
        label[0] = FirstName;
        label[1] = LastName;
        label[2] = Birthday;
        label[3] = Contact;
        label[4] = Status;
        label[5] = Code;

        text[0] = firstName;
        text[1] = lastName;
        text[2] = bday;
        text[3] = contact;
        text[4] = status;
        text[5] = code;
        int j = 30;
        for(int i = 0; i < label.length; i++){
            label[i].setBounds(10, j, 150, 50);
            panel.add(label[i]);
            label[i].setFont(new Font("Poppins", Font.BOLD, 16));
            text[i].setPreferredSize(new Dimension(100,30));
            text[i].setBounds(160, j+10, 130, 30);
            panel.add(text[i]);
            j +=50;
        }
        int l = 25;
        for(int i = 0; i < button.length; i++){
            button[i].setBounds(l, 360, 100, 50);
            button[i].setFocusable(false);
            button[i].addActionListener(this);
            panel.add(button[i]);
            l +=150;
        }
        panel.setLayout(null);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button[0]){
            new Login();
            this.dispose();
            return;
        }
        if(e.getSource() == button[1]){
            try {
            if(!firstName.getText().isEmpty() && !lastName.getText().isEmpty() && !bday.getText().isEmpty() && !contact.getText().isEmpty() && !status.getText().isEmpty() && !code.getText().isEmpty() && !firstName.getText().matches("[0-9]+") && !lastName.getText().matches("[0-9]+") && !firstName.getText().matches(".*[^a-zA-Z\\s].*") ||
             !lastName.getText().matches(".*[^a-zA-Z\\s].*") && bday.getText().matches(regex) && contact.getText().matches("[0-9]+") && (status.getText().equalsIgnoreCase("IT") || status.getText().equalsIgnoreCase("Certified Public Accountant") || status.getText().equalsIgnoreCase("Admin") ||  status.getText().equalsIgnoreCase("Inventory Clerk")) && (!status.getText().equalsIgnoreCase("IT") || !status.getText().equalsIgnoreCase("Certified Public Accountant") || !status.getText().equalsIgnoreCase("Admin") ||  !status.getText().equalsIgnoreCase("Inventory Clerk")) && code.getText().matches("[0-9]+")){
                PrintWriter write = new PrintWriter(new FileWriter("Database.txt",true));
                write.println(firstName.getText() + " " +lastName.getText() + ":" +bday.getText() + ":" +contact.getText() + ":" +status.getText()+ ":" +code.getText() + ":");  
                write.close();  
            }
            if(firstName.getText().equals("") && lastName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a name");
            }
            if (firstName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a first name");
            }
            if (lastName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a last name");
            }
            if (firstName.getText().matches("[0-9]+") && lastName.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "Integer character detected please try again");
            }
            if (firstName.getText().matches(".*[^a-zA-Z\\s].*") || lastName.getText().matches(".*[^a-zA-Z\\s].*")) {
                JOptionPane.showMessageDialog(null, "Invalid character detected. Please try again.");
            }
            if(bday.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter birthday");
            }else if(!bday.getText().equals("")){
                Matcher matcher = pattern.matcher(bday.getText());
                if(matcher.matches()){
                  String[] parts = bday.getText().split("-");
                  int month = Integer.parseInt(parts[0]);
                  int day = Integer.parseInt(parts[1]);
                  int year = Integer.parseInt(parts[2]);
                  if(month < 1 || month > 12){
                    JOptionPane.showMessageDialog(null, "Invalid Birthday month");
                    }
                if(day <1 || day > 31){
                    JOptionPane.showMessageDialog(null, "Invalid Birthday day");
                }
                if(year < 1900 || day > 2200){
                    JOptionPane.showMessageDialog(null, "Invalid Birthday year");
                }
            }
            }
            if(!bday.getText().matches(regex)){
                JOptionPane.showMessageDialog(null, "Invalid birthday format. Please enter in MM-DD-YYYY format.");
            }
            if (contact.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter contact information");
            }
            if (!contact.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "Invalid contact information");
            }
            if (status.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter status");
            }
            if(!status.getText().equals("")){
                if(!status.getText().equalsIgnoreCase("IT") && !status.getText().equalsIgnoreCase("Certified Public Accountant") && !status.getText().equalsIgnoreCase("Admin") &&  !status.getText().equalsIgnoreCase("Inventory Clerk")){
                    JOptionPane.showMessageDialog(null, "Invalid status ask verification from supervisor");
                }
            }
            if (code.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your ID");
            }
            if (!code.getText().matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "Invalid ID");
            }
            
            for(int i = 0; i < text.length; i++){
                text[i].setText("");
                }
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error");
            }
            }
        }
}
    

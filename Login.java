import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Login implements ActionListener{
   JButton button[] = new JButton[2];
   JFrame login;
   JTextField textName = new JTextField();
   JTextField textID = new JTextField();
   String username, ID;
   Login(){
      login = new JFrame();
      login.setSize(290,300);
      login.setTitle("Inventory System");
      login.setResizable(false);
      login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      login.add(information());
      login.setLayout(null);
      login.setVisible(true);
      login.setLocationRelativeTo(null);
   } 
   
   JPanel information(){
      JPanel info = new JPanel();
      info.setBounds(0, 0, 290,300);
      JLabel username = new JLabel("Username: ");
      JLabel ID = new JLabel("ID: ");
      
      JButton login = new JButton("Login");
      JButton register = new JButton("Register");
      JLabel label[] = new JLabel[2];
      label[0] = username;
      label[1] = ID;

      JTextField text[] = new JTextField[2];
      text[0] = textName;
      text[1] = textID;


      button[0] = login;
      button[1] = register;
      
      int j = 30;
      int k = 20;
      for(int i = 0; i < label.length; i++){
         label[i].setBounds(30,j,80,30);
         text[i].setBounds(100,j,150,30);
         text[i].setPreferredSize(new Dimension(100,50));
         button[i].setBounds(k, 160, 100, 50);
         button[i].addActionListener(this);
         button[i].setFocusable(false);
         k+=130;
         j+=60;
      }
      info.add(username);
      info.add(textName);
      info.add(ID);
      info.add(textID);
      info.add(login);
      info.add(register);
      info.setLayout(null);
      return info;
   }
   @Override
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == button[0]){
         if(textID.getText().equals("") && textName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Username and ID");
         }
         if(!textID.getText().equals("") && !textName.getText().equals("")){
         try {
            Scanner scan = new Scanner(new FileReader("Database.txt"));
            PrintWriter write = new PrintWriter(new FileWriter("Login_History.txt",true));
            scan.useDelimiter(":");
            boolean isVerified = false;
            while(scan.hasNext()){
                username = scan.next();
                scan.next();
                scan.next();
                scan.next();
                ID = scan.next();
                if(textName.getText().equalsIgnoreCase(username) && textID.getText().equalsIgnoreCase(ID)){
                  isVerified = true;
                  write.println(username +":" + ID);
                  write.flush();
                }
                scan.nextLine();
            }
            if(!textName.getText().equalsIgnoreCase(username) && !textID.getText().equalsIgnoreCase(ID)){
                  JOptionPane.showMessageDialog(null, "Account does not match any existing account");
                  textName.setText("");
                  textID.setText("");
                }
            if(isVerified){
               new Product();
               login.dispose();
            }
            scan.close();
            write.close();
        } catch (Exception x) {
            // TODO: handle exception
        }
      }else if(textID.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Enter ID");
      }else if(textName.getText().equals("")){
         JOptionPane.showMessageDialog(null, "Enter Username");
      }
   }   
      if(e.getSource() == button[1]){
         new Register();
         login.dispose();
         return;
      }
   }
}

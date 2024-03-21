import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class SupplierButton extends Buttons implements ActionListener{
    JButton[] addSupplier = new JButton[2];
    JButton[] searchSupplier = new JButton[2];
    JButton[] updateSupplier = new JButton[2];
    JButton[] deleteSupplier = new JButton[2];
    JTextField textName = new JTextField();
    JTextField textAddress = new JTextField();
    JTextField textContact = new JTextField();
    JTextField searchName = new JTextField();
    JTextField deleteName = new JTextField();
    JTextField updateName = new JTextField();
    JTextField supplierTextName = new JTextField();
    JTextField supplierTextAddress = new JTextField();
    JTextField supplierTextContact = new JTextField();
    String name,address,contact;
    @Override
    public void OnClick(){
    }

    @Override
    public JButton ButtonDisplay(){
        JButton supplier = new JButton("SUPPLIER");
        return supplier;
    }

    
    public JButton add(){
        JButton addSupplier = new JButton("Add Supplier");
        return addSupplier;
    }

    public JButton search(){
        JButton searchSupplier = new JButton("Search Supplier");
        return searchSupplier;
    }

    public JButton update(){
        JButton updateSupplier = new JButton("Update Supplier");
        return updateSupplier;
    }

    public JButton delete(){
        JButton deleteSupplier = new JButton("Delete Supplier");
        return deleteSupplier;
    }

    public JPanel addbody(){
        JPanel body = new JPanel();
        JLabel[] add = new JLabel[3];
        body.setBounds(0, 0 , 600 , 500);
        JLabel name = new JLabel("Name of the Supplier");
        JLabel address = new JLabel("Address of the Supplier");
        JLabel contact = new JLabel("Contact Information of the Supplier");
        add[0] = name;
        add[1] = address;
        add[2] = contact;
        JTextField[] addText = new JTextField[3];
        addText[0] = textName;
        addText[1] = textAddress;
        addText[2] = textContact;
        int j = 70;
        for(int i = 0; i < 3; i++){
            add[i].setBounds(20, j, 500, 50);
            add[i].setFont(new Font("Poppins", Font.BOLD, 16));
            addText[i].setBounds(350, j+10, 200, 30);
            addText[i].setPreferredSize(new Dimension(200, 30));
            addText[i].setHorizontalAlignment(SwingConstants.RIGHT);
            body.add(add[i]);
            body.add(addText[i]);
            j += 50;
        }
        addSupplier[0] = add();
        addSupplier[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            addSupplier[i].setBounds(k, 400, 200, 50);
            addSupplier[i].setFocusable(false);
            addSupplier[i].addActionListener(this);
            k += 220;
            body.add(addSupplier[i]);
        }
        body.setLayout(null);
        body.setBackground(Color.gray);
        return body;
    }
    public JPanel searchbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Supplier you are looking for:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        searchName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(searchName);
        searchSupplier[0] = search();
        searchSupplier[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            searchSupplier[i].setBounds(k, 400, 200, 50);
            searchSupplier[i].setFocusable(false);
            searchSupplier[i].addActionListener(this);
            k += 220;
            body.add(searchSupplier[i]);
        }
        body.setLayout(null);
        return body;
    }
    public JPanel updatebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Supplier you want to update:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        updateName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(updateName);
        updateSupplier[0] = update();
        updateSupplier[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            updateSupplier[i].setBounds(k, 400, 200, 50);
            updateSupplier[i].setFocusable(false);
            updateSupplier[i].addActionListener(this);
            k += 220;
            body.add(updateSupplier[i]);
        }
        body.setLayout(null);
        return body;
    }
    public JPanel deletebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Supplier you want to delete:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        deleteName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(deleteName);
        
        deleteSupplier[0] = delete();
        deleteSupplier[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            deleteSupplier[i].setBounds(k, 400, 200, 50);
            deleteSupplier[i].setFocusable(false);
            deleteSupplier[i].addActionListener(this);
            k += 220;
            body.add(deleteSupplier[i]);
        }
        body.setLayout(null);
        return body;
    }
    @Override
    public JButton clear(){
        JButton clear = new JButton("Clear");
        return clear;
    }

    public JFrame searchSupplier(){
        JFrame newProduct = new JFrame();
        newProduct.setTitle("Inventory System");
        newProduct.setSize(420,550);
        newProduct.setVisible(true);
        JLabel SupplierName = new JLabel("Supplier name: " + name);
        JLabel SupplierPrice = new JLabel("Supplier address: " + address);
        JLabel SupplierCost = new JLabel("Supplier contact: " + contact);

        JLabel[] supplierSearch = new JLabel[3];
        supplierSearch[0] = SupplierName;
        supplierSearch[1] = SupplierPrice;
        supplierSearch[2] = SupplierCost;

        int j = 20;
        for(int i = 0; i < 3; i++){
            supplierSearch[i].setBounds(20, j, 420, 50);
            supplierSearch[i].setFont(new Font("Poppins", Font.BOLD, 16));
            newProduct.add(supplierSearch[i]);
            j += 60;
        }
        newProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newProduct.setLocationRelativeTo(null);
        newProduct.setLayout(null);
        return newProduct;
    }

    public JFrame updateSupplier(){
        JFrame newProduct = new JFrame();
        newProduct.setTitle("Inventory System");
        newProduct.setSize(420,550);
        newProduct.setVisible(true);
        JLabel SupplierName = new JLabel("Supplier name: ");
        JLabel SupplierPrice = new JLabel("Supplier address: ");
        JLabel SupplierCost = new JLabel("Supplier contact: ");

        JLabel[] supplierUpdate = new JLabel[3];
        supplierUpdate[0] = SupplierName;
        supplierUpdate[1] = SupplierPrice;
        supplierUpdate[2] = SupplierCost;
        
        JTextField[] supplierTextUpdate = {supplierTextName, supplierTextAddress, supplierTextContact};
        int j = 20;
        for(int i = 0; i < 3; i++){
            supplierUpdate[i].setBounds(20, j, 420, 50);
            supplierUpdate[i].setFont(new Font("Poppins", Font.BOLD, 16));
            supplierTextUpdate[i].setBounds(180, j+10, 200, 30);
            newProduct.add(supplierTextUpdate[i]);
            newProduct.add(supplierUpdate[i]);
            j += 60;
        }
        JButton save = new JButton("SAVE");
        save.setBounds(130, 400, 150, 50);
        save.setFocusable(false);
        save.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent q){
                if(q.getSource() == save){
                    try {
                        Scanner scan = new Scanner(new FileReader("Supplier.txt"));
                        PrintWriter writer = new PrintWriter(new FileWriter("tempt.txt", true));
                        scan.useDelimiter(":");
                        while (scan.hasNext()) {
                            name = scan.next();
                            address = scan.next();
                            contact = scan.next();
                            if(name.equalsIgnoreCase(updateName.getText())){
                                writer.println(supplierTextName.getText() + ":" + supplierTextAddress.getText() + ":" + supplierTextContact.getText() + ":");
                            }else{
                                writer.println(name + ":" + address + ":" + contact + ":");
                            }
                            scan.nextLine();
                        }
                        scan.close();
                        writer.close();
                        File file = new File("tempt.txt");
                        File refile = new File("Supplier.txt");
                        refile.delete();
                        file.renameTo(refile);
                        supplierTextName.setText("");
                        supplierTextAddress.setText("");
                        supplierTextContact.setText("");
                        updateName.setText("");
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });
        newProduct.add(save);
        newProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newProduct.setLocationRelativeTo(null);
        newProduct.setLayout(null);
        return newProduct;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addSupplier[0]){
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Supplier.txt", true));
                writer.println(textName.getText() + ":" + textAddress.getText() + ":" + textContact.getText() + ":");
                writer.close();
                textName.setText("");
                textAddress.setText("");
                textContact.setText("");
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == addSupplier[1]){
            textName.setText("");
            textAddress.setText("");
            textContact.setText("");
        }

        if(e.getSource() == searchSupplier[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Supplier.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    address = scan.next();
                    contact = scan.next();
                    if(name.equalsIgnoreCase(searchName.getText())){
                        isFound = true;
                        break;
                    }
                    scan.nextLine();
                }

                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The supplier you are searching for does not match in our database");
                    searchName.setText("");
                }
                if(isFound){
                    searchSupplier();
                    searchName.setText("");
                }
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if (e.getSource() == searchSupplier[1]){
            searchName.setText("");
        }

        if(e.getSource() == updateSupplier[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Supplier.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    address = scan.next();
                    contact = scan.next();
                    if(name.equalsIgnoreCase(updateName.getText())){
                        isFound = true;
                        break;
                    }
                    scan.nextLine();
                }
                if(isFound){
                    updateSupplier();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The supplier you are searching for does not match in our database");
                    updateName.setText("");
                }
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if (e.getSource() == updateSupplier[1]){
            updateName.setText("");
        }

        if(e.getSource() == deleteSupplier[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Supplier.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter("tempt.txt",true));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    address = scan.next();
                    contact = scan.next();
                    if(name.equalsIgnoreCase(deleteName.getText())){
                        isFound = true;
                        JOptionPane.showMessageDialog(null, "The supplier you are searching for no longer exist in our database");
                    }else{
                        writer.println(name + ":" + address + ":" + contact + ":");
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The supplier you are searching for does not match in our database");
                    updateName.setText("");
                }
                scan.close();
                writer.close();
                File file = new File("tempt.txt");
                File refile = new File("Supplier.txt");
                refile.delete();
                file.renameTo(refile);
                updateName.setText("");
            } catch (Exception x) {
                // TODO: handle exception
            }
        }
    }
}

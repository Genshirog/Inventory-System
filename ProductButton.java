
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class ProductButton extends Buttons implements ActionListener{
    JButton[] addProduct = new JButton[2];
    JButton[] searchProduct = new JButton[2];
    JButton[] updateProduct = new JButton[2];
    JButton[] deleteProduct = new JButton[2];
    JTextField Textname = new JTextField();
        JTextField Textprice = new JTextField();
        JTextField Textcost = new JTextField();
        JTextField Textcategory = new JTextField();
        JTextField Textsupplier = new JTextField();
        JTextField TextStock = new JTextField();
        JTextField searchName = new JTextField();
        JTextField updateName = new JTextField();
        JTextField deleteName = new JTextField();
        String name, price, cost, category, supplier, stock;
    JButton addProd;
    @Override
    public void OnClick(){
    }

    @Override
    public JButton ButtonDisplay(){
        JButton productionButton = new JButton("PRODUCT");
        return productionButton;
    }

    public JButton add(){
        addProd = new JButton("Add Product");
        return addProd;
    }

    public JButton search(){
        JButton searchProd = new JButton("Search Product");
        return searchProd;
    }

    public JButton update(){
        JButton updateProd = new JButton("Update Product");
        return updateProd;
    }

    public JButton delete(){
        JButton deleteProd = new JButton("Delete Product");
        return deleteProd;
    }
    

    public JPanel addbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Name of Product: ");
        JLabel price = new JLabel("Unit Price of Product: ");
        JLabel cost = new JLabel("Unit Cost of Product: ");
        JLabel category = new JLabel("Category of Product: ");
        JLabel supplier = new JLabel("Supplier of Product: ");
        JLabel stock = new JLabel("Add Stock: ");
        JTextField[] addText = new JTextField[6];
        addText[0] = Textname;
        addText[1] = Textprice;
        addText[2] = Textcost;
        addText[3] = Textcategory;
        addText[4] = Textsupplier;
        addText[5] = TextStock;
        JLabel[] add = new JLabel[6];
        add[0] = name;
        add[1] = price;
        add[2] = cost;
        add[3] = category;
        add[4] = supplier;
        add[5] = stock;
        int j = 70;
        for(int i = 0; i < 6; i++){
            add[i].setFont(new Font("Poppins", Font.BOLD, 16));
            add[i].setBounds(20, j, 200, 50);
            addText[i].setBounds(250, j+10, 300, 30);
            addText[i].setPreferredSize(new Dimension(200, 30));
            addText[i].setHorizontalAlignment(SwingConstants.RIGHT);
            body.add(add[i]);
            body.add(addText[i]);
            j += 50;
        }
        addProduct[0] = add();
        addProduct[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            addProduct[i].setBounds(k, 400, 200, 50);
            addProduct[i].setFocusable(false);
            addProduct[i].addActionListener(this);
            k += 220;
            body.add(addProduct[i]);
        }
        body.setLayout(null);
        return body;
    }

    public JPanel searchbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the product you are looking for:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        searchName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(searchName);
        searchProduct[0] = search();
        searchProduct[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            searchProduct[i].setBounds(k, 400, 200, 50);
            searchProduct[i].setFocusable(false);
            searchProduct[i].addActionListener(this);
            k += 220;
            body.add(searchProduct[i]);
        }
        body.setLayout(null);
        return body;
    }

    public JPanel updatebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the product you want to update:");
        
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        updateName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(updateName);
        updateProduct[0] = update();
        updateProduct[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            updateProduct[i].setBounds(k, 400, 200, 50);
            updateProduct[i].setFocusable(false);
            updateProduct[i].addActionListener(this);
            k += 220;
            body.add(updateProduct[i]);
        }
        body.setLayout(null);
        return body;
    }

    public JPanel deletebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the product you want to delete:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        deleteName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(deleteName);
        deleteProduct[0] = delete();
        deleteProduct[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            deleteProduct[i].setBounds(k, 400, 200, 50);
            deleteProduct[i].setFocusable(false);
            deleteProduct[i].addActionListener(this);
            k += 220;
            body.add(deleteProduct[i]);
        }
        body.setLayout(null);
        return body;
    }
    @Override
    public JButton clear(){
        JButton clear = new JButton("Clear");
        return clear;
    }


    public JFrame searchProduct(){
        JFrame newProduct = new JFrame();
        newProduct.setTitle("Inventory System");
        newProduct.setSize(420,550);
        newProduct.setVisible(true);
        JLabel productName = new JLabel("Product name: " + name);
        JLabel productPrice = new JLabel("Product price: " + price);
        JLabel productCost = new JLabel("Product cost: " + cost);
        JLabel productCategory = new JLabel("Product category: " + category);
        JLabel productSupplier = new JLabel("Product supplier: " + supplier);
        JLabel productStock = new JLabel("Product stock: " + stock);
        JLabel[] productSearch = new JLabel[6];
        productSearch[0] = productName;
        productSearch[1] = productPrice;
        productSearch[2] = productCost;
        productSearch[3] = productCategory;
        productSearch[4] = productSupplier;
        productSearch[5] = productStock;
        int j = 20;
        for(int i = 0; i < 6; i++){
            productSearch[i].setBounds(20, j, 420, 50);
            productSearch[i].setFont(new Font("Poppins", Font.BOLD, 16));
            newProduct.add(productSearch[i]);
            j += 60;
        }
        newProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newProduct.setLocationRelativeTo(null);
        newProduct.setLayout(null);
        return newProduct;
    }

    public JFrame updateProduct(){
        JFrame newProduct = new JFrame();
        newProduct.setTitle("Inventory System");
        newProduct.setSize(420,550);
        newProduct.setVisible(true);
        JLabel productName = new JLabel("Product name: ");
        JLabel productPrice = new JLabel("Product price: ");
        JLabel productCost = new JLabel("Product cost: ");
        JLabel productCategory = new JLabel("Product category: ");
        JLabel productSupplier = new JLabel("Product supplier: ");
        JLabel productStock = new JLabel("Product stock: ");
        JLabel[] productSearch = new JLabel[6];
        productSearch[0] = productName;
        productSearch[1] = productPrice;
        productSearch[2] = productCost;
        productSearch[3] = productCategory;
        productSearch[4] = productSupplier;
        productSearch[5] = productStock;
        JTextField updateProduct = new JTextField();
        JTextField updatePrice = new JTextField();
        JTextField updateCost = new JTextField();
        JTextField updateCategory = new JTextField();
        JTextField updateSupplier = new JTextField();
        JTextField updateStock = new JTextField();
        JTextField[] productUpdate = new JTextField[6];
        productUpdate[0] = updateProduct;
        productUpdate[1] = updatePrice;
        productUpdate[2] = updateCost;
        productUpdate[3] = updateCategory;
        productUpdate[4] = updateSupplier;
        productUpdate[5] = updateStock;
        int j = 20;
        for(int i = 0; i < 6; i++){
            productSearch[i].setBounds(20, j, 200, 50);
            productSearch[i].setFont(new Font("Poppins", Font.BOLD, 16));
            productUpdate[i].setBounds(200, j+10, 180, 30);
            newProduct.add(productUpdate[i]);
            newProduct.add(productSearch[i]);
            j += 60;
        }
        JButton save = new JButton("SAVE");
            save.setBounds(150, 400, 150, 50);
            save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent q){
                    if(q.getSource() == save){
                        try (Scanner scan = new Scanner(new FileReader("Products.txt"))) {
                            scan.useDelimiter(":");
                            PrintWriter writer = new PrintWriter(new FileWriter("temp.txt", true));
                            while (scan.hasNext()) {
                                name = scan.next();
                                price = scan.next();
                                cost = scan.next();
                                category = scan.next();
                                supplier = scan.next();
                                stock = scan.next();
                                if(name.equalsIgnoreCase(updateName.getText())){
                                    writer.println(updateProduct.getText() + ":" + updatePrice.getText() + ":"+ updateCost.getText() + ":"+ updateCategory.getText() + ":" + updateSupplier.getText() + ":"+ updateStock.getText()+ ":");
                                }else{
                                    writer.println(name + ":" + price + ":" + cost + ":" + category  + ":" + supplier + ":" + stock + ":");
                                } 
                                scan.nextLine();
                            }
                            scan.close();
                            writer.close();
                            File file = new File("temp.txt");
                            File refile = new File("Products.txt");
                            refile.delete();
                            file.renameTo(refile);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        newProduct.dispose();
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
        if(e.getSource() == addProduct[0]){
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Products.txt", true));
                writer.println(Textname.getText() + ":" + Textprice.getText() + ":" + Textcost.getText() + ":" + Textcategory.getText() + ":" + Textsupplier.getText()+ ":" + TextStock.getText() + ":");
                writer.close();
                Textname.setText("");
                Textprice.setText("");
                Textcost.setText("");
                Textcategory.setText("");
                Textsupplier.setText("");
                TextStock.setText("");
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == addProduct[1]){
            Textname.setText("");
                Textprice.setText("");
                Textcost.setText("");
                Textcategory.setText("");
                Textsupplier.setText("");
                TextStock.setText("");
        }

        if(e.getSource() == searchProduct[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Products.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while(scan.hasNext()){
                    name = scan.next();
                    price = scan.next();
                    cost = scan.next();
                    category = scan.next();
                    supplier = scan.next();
                    stock = scan.next();
                    if(name.equalsIgnoreCase(searchName.getText())){
                        isFound = true;
                        break;
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The product you are searching for does not match in our database");
                    searchName.setText("");
                }
                if(isFound && true){
                    searchProduct();
                }
                searchName.setText("");
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if (e.getSource() == searchProduct[1]){
            searchName.setText("");
        }

        if(e.getSource() == updateProduct[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Products.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    price = scan.next();
                    cost = scan.next();
                    category = scan.next();
                    supplier = scan.next();
                    stock = scan.next();
                    if(name.equalsIgnoreCase(updateName.getText())){
                        isFound = true;
                        updateProduct();
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The product you are searching for does not match in our database");
                    updateName.setText("");
                }
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == updateProduct[1]){
            updateName.setText("");
        }

        if(e.getSource() == deleteProduct[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Products.txt"));
                PrintWriter writer = new PrintWriter(new File("temp.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    price = scan.next();
                    cost = scan.next();
                    category = scan.next();
                    supplier = scan.next();
                    stock = scan.next();
                    if(name.equalsIgnoreCase(deleteName.getText())){
                        JOptionPane.showMessageDialog(null, "The product named " + name + " has been deleted");
                        isFound = true;
                    }else{
                        writer.println(name + ":" + price + ":" + cost + ":" + category + ":" + supplier + ":" + stock + ":");
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The product cannot be found in the database");
                }
                scan.close();
                writer.close();
                File file = new File("temp.txt");
                File refile = new File("Products.txt");
                refile.delete();
                file.renameTo(refile);
                deleteName.setText("");
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == deleteProduct[1]){
            deleteName.setText("");
        }
    }
}

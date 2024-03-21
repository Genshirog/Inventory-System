import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class CategoryButton extends Buttons implements ActionListener{
    JButton[] addCategory = new JButton[2];
    JButton[] searchCategory = new JButton[2];
    JButton[] updateCategory = new JButton[2];
    JButton[] deleteCategory = new JButton[2];
    JTextField[] textCat = new JTextField[1];
    JTextField textName = new JTextField();
    JTextArea descripArea = new JTextArea();
    JTextField searchName = new JTextField();
    JTextField updateName = new JTextField();
    JTextField deleteName = new JTextField();
    String name, descript;
    @Override
    public void OnClick(){
        
    }

    @Override
    public JButton ButtonDisplay(){
        JButton categoryButton = new JButton("CATEGORY");
        return categoryButton;
    }

    public JButton add(){
        JButton addCat = new JButton("Add Category");
        return addCat;
    }

    public JButton search(){
        JButton searchCat = new JButton("Search Category");
        return searchCat;
    }

    public JButton update(){
        JButton updateCat = new JButton("Update Category");
        return updateCat;
    }

    public JButton delete(){
        JButton deleteCat = new JButton("Delete Category");
        return deleteCat;
    }

    public JPanel addbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        JLabel name = new JLabel("Name of the Category:");
        JLabel description = new JLabel("Description of the category");
        JLabel[] cats = new JLabel[3];
        cats[0] = name;
        cats[1] = description;
        textCat[0] = textName;
        int j = 70;
        for(int i = 0; i < 2; i++){
            cats[i].setBounds(20, j, 500, 50);
            cats[i].setFont(new Font("Poppins", Font.BOLD, 16));
            j += 50;
            body.add(cats[i]);
        }
        
        j = 70;
        for(int i = 0; i < 1; i++){
            textCat[i].setBounds(250, j+10 , 300, 30);
            j += 50;
            body.add(textCat[i]);
        }

        descripArea.setSize(200,100);
        descripArea.setBounds(70, 220, 450, 150);
        body.add(descripArea);
        addCategory[0] = add();
        addCategory[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            addCategory[i].setBounds(k, 400, 200, 50);
            addCategory[i].setFocusable(false);
            addCategory[i].addActionListener(this);
            k += 220;
            body.add(addCategory[i]);
        }
        body.setLayout(null);
        body.setBackground(Color.gray);
        return body;
    }
    public JPanel searchbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Category you are looking for:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        searchName.setBounds(20, 110, 400, 30);
        body.add(name);
        body.add(searchName);
        searchCategory[0] = search();
        searchCategory[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            searchCategory[i].setBounds(k, 400, 200, 50);
            searchCategory[i].setFocusable(false);
            searchCategory[i].addActionListener(this);
            k += 220;
            body.add(searchCategory[i]);
        }
        body.setLayout(null);
        return body;
    }
    public JPanel updatebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Category you want to update:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        updateName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(updateName);
        updateCategory[0] = update();
        updateCategory[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            updateCategory[i].setBounds(k, 400, 200, 50);
            updateCategory[i].setFocusable(false);
            updateCategory[i].addActionListener(this);
            k += 220;
            body.add(updateCategory[i]);
        }
        body.setLayout(null);
        return body;
    }
    public JPanel deletebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.gray);
        JLabel name = new JLabel("Enter the name of the Category you want to delete:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        deleteName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(deleteName);
        deleteCategory[0] = delete();
        deleteCategory[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            deleteCategory[i].setBounds(k, 400, 200, 50);
            deleteCategory[i].setFocusable(false);
            deleteCategory[i].addActionListener(this);
            k += 220;
            body.add(deleteCategory[i]);
        }
        body.setLayout(null);
        return body;
    }
    @Override
    public JButton clear(){
        JButton clear = new JButton("Clear");
        return clear;
    }

    public JFrame searchCategory(){
        JFrame newCategory = new JFrame();
        newCategory.setTitle("Inventory System");
        newCategory.setSize(420,550);
        newCategory.setVisible(true);
        JLabel Catname = new JLabel("Category name: " + name);
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel descriptionbox = new JLabel(descript);
        JLabel[] label = {Catname, descriptionLabel ,descriptionbox};
        int j = 20;
        for(int i = 0; i < 3; i++){
            label[i].setBounds(20, j, 420, 50);
            label[i].setFont(new Font("Poppins", Font.BOLD, 16));
            j +=50;
            newCategory.add(label[i]);
        }
        newCategory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newCategory.setLocationRelativeTo(null);
        newCategory.setLayout(null);
        return newCategory;
    }
    public JFrame updateCategory(){
        JFrame newCategory = new JFrame();
        newCategory.setTitle("Inventory System");
        newCategory.setSize(420,550);
        newCategory.setVisible(true);
        JLabel Catname = new JLabel("Category name: ");
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel[] label = {Catname, descriptionLabel};
        JTextField textCat = new JTextField();
        JTextField[] text = {textCat};
        int j = 20;
        for(int i = 0; i < 2; i++){
            label[i].setBounds(20, j, 220, 50);
            label[i].setFont(new Font("Poppins", Font.BOLD, 16));
            newCategory.add(label[i]);
            j += 50;
        }
        j = 20;
        for (int i = 0; i < 1; i++){
            text[i].setBounds(180, j+10, 200, 30);
            newCategory.add(text[i]);
            j +=50;
        }
        
        Border lineBorder = BorderFactory.createLineBorder(Color.black, 1);
        JTextArea textDes = new JTextArea();
        textDes.setMargin(new Insets(10, 10, 10, 10));
        textDes.setBounds(40, 180, 330, 200);
        textDes.setBorder(BorderFactory.createCompoundBorder(lineBorder, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        newCategory.add(textDes, BorderLayout.CENTER);
        JButton save = new JButton("SAVE");
        save.setBounds(130, 400, 150, 50);
        save.setFocusable(false);
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent q){
                if(q.getSource() == save){
                    try {
                        Scanner scan = new Scanner(new FileReader("Category.txt"));
                        scan.useDelimiter(":");
                        PrintWriter writer = new PrintWriter(new FileWriter("tempt.txt",true));
                        while (scan.hasNext()) {
                        name = scan.next();
                        descript = scan.next();
                        if(name.equalsIgnoreCase(updateName.getText())){
                            writer.println(textCat.getText() + ":" + textDes.getText()+ ":" );
                        }else{
                            writer.println(name + ":" + descript + ":") ;
                        }
                        scan.nextLine();
                    }
                    updateName.setText("");
                    writer.flush();
                    scan.close();
                    writer.close();
                    File file = new File("tempt.txt");
                    File refile = new File("Category.txt");
                    refile.delete();
                    file.renameTo(refile);
                    textCat.setText("");
                    textDes.setText("");
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });
        newCategory.add(save);
        newCategory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newCategory.setLocationRelativeTo(null);
        newCategory.setLayout(null);
        return newCategory;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addCategory[0]){
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("Category.txt", true));
                writer.println(textName.getText() + ":" + descripArea.getText() + ":");
                textName.setText("");
                descripArea.setText("");
                writer.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == addCategory[1]){
            textName.setText("");
        }

        if(e.getSource() == searchCategory[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Category.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    descript = scan.next();
                    if(name.equalsIgnoreCase(searchName.getText())){
                        isFound = true;
                        searchCategory();
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The Category you are searching for does not match in our database");
                    searchName.setText("");
                }
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if (e.getSource() == searchCategory[1]){
            searchName.setText("");
        }

        if(e.getSource() == updateCategory[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Category.txt"));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                name = scan.next();
                descript = scan.next();
                if(name.equalsIgnoreCase(updateName.getText())){
                    isFound = true;
                    break;
                }
                scan.nextLine();
                }
                if(isFound){
                    updateCategory();
                }

                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The Category you are searching for does not match in our database");
                    updateName.setText("");
                }
                scan.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == updateCategory[1]){
            updateName.setText("");
        }

        if(e.getSource() == deleteCategory[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Category.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter("tempt.txt", true));
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                name = scan.next();
                descript = scan.next();
                if(name.equalsIgnoreCase(deleteName.getText())){
                    isFound = true;
                    JOptionPane.showMessageDialog(null, "The Category you are searching for no longer exist in our database");
                }else{
                    writer.println(name + ":" + descript + ":");
                }
                scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The Category you are searching for does not match in our database");
                    updateName.setText("");
                }
                scan.close();
                writer.close();
                File file = new File("tempt.txt");
                File refile = new File("Category.txt");
                refile.delete();
                file.renameTo(refile);
            } catch (Exception x) {
                // TODO: handle exception
            }
        }else if(e.getSource() == deleteCategory[1]){
            deleteName.setText("");
        }
    }
}

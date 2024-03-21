import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class Product extends JFrame implements ActionListener{
    ProductButton productButton = new ProductButton();
    CategoryButton categoryButton = new CategoryButton();
    SupplierButton supplierButton = new SupplierButton();
    TransactionButton transactionButton = new TransactionButton();
    ReportButton reportButton = new ReportButton();
    Buttons[] button = {productButton, categoryButton, supplierButton, transactionButton, reportButton};
    JPanel insideButtonInput = new JPanel();
    JPanel insideInputPanel = new JPanel();
    JPanel insideDisplay = new JPanel();
    JButton[] all = new JButton[5];
    JButton[] allProd = new JButton[4], allCat = new JButton[4], allSup = new JButton[4], allTrans = new JButton[1];
    JButton newProd[] = new JButton[2];
    Border lineborder = BorderFactory.createLineBorder(Color.black);

    Product(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Inventory System");
        this.setSize(1600,900);
        this.setResizable(false);
        this.add(buttons());
        this.add(inputs());
        this.add(display());
        this.setLayout(null);
    }

    JPanel inputs(){
        JPanel inputs = new JPanel();
        inputs.setBounds(0, 0, 800, 800);
        JPanel buttonInputs = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel[] inputGroup = new JPanel[2];
        inputGroup[0] = inputPanel;
        inputGroup[1] = buttonInputs;
        int j = 0;
        int k = 500;
        for( int i = 0; i < 2; i++){
            inputGroup[i].setBounds(0, j, 800, k);
            j += 500;
            k -= 200;
        }
        insideButtonInput.setBounds(100, 20, 600, 250);
        insideButtonInput.setBackground(Color.gray);
        insideButtonInput.setLayout(null);
        insideInputPanel.setBounds(100, 0, 600, 500);
        buttonInputs.setBackground(Color.gray);
        buttonInputs.setBorder(lineborder);
        inputPanel.add(insideInputPanel);
        buttonInputs.add(insideButtonInput);
        inputPanel.setLayout(null);
        buttonInputs.setLayout(null);
        inputs.add(inputPanel);
        inputs.add(buttonInputs);
        inputs.setLayout(null);
        inputs.setBorder(lineborder);
        return inputs;
    }

    JPanel buttons(){
        JPanel buttons = new JPanel();
        buttons.setBounds(0, 780,800,250);
        for(int i = 0; i < button.length; i++){
            all[i] = button[i].ButtonDisplay();
            all[i].setPreferredSize(new Dimension(150, 50));
            all[i].addActionListener(this);
            all[i].setFocusable(false);
            buttons.add(all[i]);
        }
        buttons.setBorder(lineborder);
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        return buttons;
    }

    JPanel display(){
        JPanel display = new JPanel();
        display.setBounds(800, 0, 800, 882);
        display.setBackground(Color.gray);
        insideDisplay.setBounds(0, 130, 800, 600);
        insideDisplay.setBackground(Color.white);
        insideDisplay.setBorder(lineborder);
        insideDisplay.setLayout(null);
        display.add(insideDisplay);
        display.setLayout(null);
        display.setBorder(lineborder);
        return display;
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == all[0]) {
        allProd[0] = button[0].add();
        allProd[1] = button[0].search();
        allProd[2] = button[0].update();
        allProd[3] = button[0].delete();
        insideButtonInput.removeAll();
        for (int i = 0; i < 4; i++) {
            allProd[i].setPreferredSize(new Dimension(100, 50));
            allProd[i].addActionListener(this);
            allProd[i].setFocusable(false);
            insideButtonInput.add(allProd[i]);
        }
        insideButtonInput.setLayout(new GridLayout(2, 2, 100, 50));
        insideButtonInput.revalidate();
        insideButtonInput.repaint();
    } else if (e.getSource() == all[1]) {
        allCat[0] = button[1].add();
        allCat[1] = button[1].search();
        allCat[2] = button[1].update();
        allCat[3] = button[1].delete();
        insideButtonInput.removeAll();
        for (int i = 0; i < 4; i++) {
            allCat[i].setPreferredSize(new Dimension(100, 50));
            allCat[i].addActionListener(this);
            allCat[i].setFocusable(false);
            insideButtonInput.add(allCat[i]);
        }
        insideButtonInput.setLayout(new GridLayout(2, 2, 100, 50));
        insideButtonInput.revalidate();
        insideButtonInput.repaint();
    } else if (e.getSource() == all[2]) {
        allSup[0] = button[2].add();
        allSup[1] = button[2].search();
        allSup[2] = button[2].update();
        allSup[3] = button[2].delete();
        insideButtonInput.removeAll();
        for (int i = 0; i < 4; i++) {
            allSup[i].setPreferredSize(new Dimension(100, 50));
            allSup[i].addActionListener(this);
            allSup[i].setFocusable(false);
            insideButtonInput.add(allSup[i]);
        }
        insideButtonInput.setLayout(new GridLayout(2, 2, 100, 50));
        insideButtonInput.revalidate();
        insideButtonInput.repaint();
    } else if (e.getSource() == all[3]) {
        allTrans[0] = button[3].add();
        insideButtonInput.removeAll();
        for (int i = 0; i < 1; i++) {
            allTrans[i].setPreferredSize(new Dimension(100, 50));
            allTrans[i].setBounds(100, 80, 400, 100);
            allTrans[i].addActionListener(this);
            allTrans[i].setFocusable(false);
            insideButtonInput.add(allTrans[i]);
        }
        insideButtonInput.setLayout(null);
        insideButtonInput.revalidate();
        insideButtonInput.repaint();
    }else if (e.getSource() == all[4]){
        insideDisplay.removeAll();
        String[] col = {"Product Name", "Price per Unit", "Cost per Unit", "Category", "Supplier", "Stock"};
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {}, col));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(15, 0, 700, 600);
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            while (model.getRowCount() > 0) {
                model.removeRow(0);
            }

            Scanner scan = new Scanner(new FileReader("Products.txt"));
            String rec;
            String[] details;

            while (scan.hasNext()) {
                rec = scan.nextLine();
                details = rec.split(":");
                model.addRow(details);
            }
            scan.close();
        } catch (Exception x) {
            // TODO: handle exception
        }
        insideDisplay.add(scroll);
        insideDisplay.setLayout(null);
        insideDisplay.validate();
        insideDisplay.repaint();
    }
    
    
    if (e.getSource() == allProd[0]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[0].addbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allProd[1]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[0].searchbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allProd[2]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[0].updatebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allProd[3]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[0].deletebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allCat[0]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[1].addbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allCat[1]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[1].searchbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allCat[2]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[1].updatebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allCat[3]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[1].deletebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allSup[0]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[2].addbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allSup[1]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[2].searchbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allSup[2]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[2].updatebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allSup[3]) {
        insideInputPanel.removeAll();
        insideInputPanel.add(button[2].deletebody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } else if (e.getSource() == allTrans[0]){
        insideInputPanel.removeAll();
        insideInputPanel.add(button[3].addbody());
        insideInputPanel.setLayout(null);
        insideInputPanel.revalidate();
        insideInputPanel.repaint();
    } 
}
}

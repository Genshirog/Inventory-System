import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class TransactionButton extends Buttons implements ActionListener{
    JTextField ProductName = new JTextField();
    JButton[] Calculate_Buttons = new JButton[2];
    String name, price, cost, category, supplier, stock, formatRev, formatCost, formattotalRev, formatProf;
    int remain;
    @Override
    public void OnClick(){
        
    }

    @Override
    public JButton ButtonDisplay(){
        JButton TransactionButton = new JButton("TRANSACTION");
        return TransactionButton;
    }

    public JButton add(){
        JButton Calculate = new JButton("Do you want to calculate your business?");
        return Calculate;
    }

    public JButton search(){
        JButton Calculate = new JButton("Calculate");
        return Calculate;
    }

    public JButton update(){
        return null;
    }

    public JButton delete(){
        return null;
    }

    public JPanel addbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        JLabel name = new JLabel("Enter the name of the Product you want to calculate:");
        name.setBounds(20, 70, 500, 50);
        name.setFont(new Font("Poppins", Font.BOLD, 16));
        ProductName.setBounds(20, 130, 400, 30);
        body.add(name);
        body.add(ProductName);
        Calculate_Buttons[0] = search();
        Calculate_Buttons[1] = clear();
        int k = 100;
        for(int i = 0; i < 2; i++){
            Calculate_Buttons[i].setBounds(k, 400, 200, 50);
            Calculate_Buttons[i].setFocusable(false);
            Calculate_Buttons[i].addActionListener(this);
            k += 220;
            body.add(Calculate_Buttons[i]);
        }
        body.setLayout(null);
        body.setBackground(Color.gray);
        return body;
    }
    public JPanel searchbody(){
        return null;
    }
    public JPanel updatebody(){
        return null;
    }
    public JPanel deletebody(){
        return null;
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
        JLabel product = new JLabel("Product Name: \t" + name);
        JLabel TotalStock = new JLabel("Total Stock Purchased: \t" + stock);
        JLabel Price = new JLabel("Unit Price: \t" + price);
        JLabel Cost = new JLabel("Unit Cost: " + cost);
        JLabel currentStock = new JLabel("Current Stock: \t" + remain);
        JLabel totalPrice = new JLabel("Total Sales Revenue: \t" + formatRev);
        JLabel totalCost = new JLabel("Total Cost: \t" + formatCost);
        JLabel totalRevenue = new JLabel("Revenue from Sold Units: \t" + formattotalRev);
        JLabel profit = new JLabel("Profit: \t" + formatProf);
        JLabel[] labels = new JLabel[9];
        labels[0] = product;
        labels[1] = TotalStock;
        labels[2] = Price;
        labels[3] = Cost;
        labels[4] = currentStock;
        labels[5] = totalPrice;
        labels[6] = totalCost;
        labels[7] = totalRevenue;
        labels[8] = profit;
        int j = 20;
        for(int i = 0; i < 9; i++){
            labels[i].setBounds(20, j,400, 30);
            labels[i].setFont(new Font("Poppins", Font.BOLD, 16));
            j += 50;
            newProduct.add(labels[i]);
        }
        newProduct.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newProduct.setLocationRelativeTo(null);
        newProduct.setLayout(null);
        return newProduct;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == Calculate_Buttons[0]){
            try {
                Scanner scan = new Scanner(new FileReader("Products.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter("Transaction.txt"), true);
                scan.useDelimiter(":");
                boolean isFound = false;
                while (scan.hasNext()) {
                    name = scan.next();
                    price = scan.next();
                    cost = scan.next();
                    category = scan.next();
                    supplier = scan.next();
                    stock = scan.next();
                    if(name.equalsIgnoreCase(ProductName.getText())){
                        isFound = true;
                        remain = Integer.parseInt(JOptionPane.showInputDialog("How many stocks are remaining?"));
                        int Stock = Integer.parseInt(stock);
                        int customerPurchase = Stock - remain;
                        double Price = Double.parseDouble(price);
                        double Cost = Double.parseDouble(cost);
                        double Revenuecalculation = Price * Stock;
                        formatRev = String.format("%.2f", Revenuecalculation);
                        double CostCalculation = Cost * Stock;
                        formatCost = String.format("%.2f", CostCalculation);
                        double totalRevenue = Price * customerPurchase;
                        formattotalRev = String.format("%.2f", totalRevenue);
                        double profit = totalRevenue - CostCalculation;
                        formatProf = String.format("%.2f", profit);
                        searchProduct();
                        writer.println(name + ":" + stock +":" + price + ":" + cost + ":" + remain + ":" + formatRev + ":" + formatCost + ":" + formattotalRev + ":" + formatProf + ":");
                    }
                    scan.nextLine();
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(null, "The Product does not match in our database");
                }
                scan.close();
                writer.close();
            } catch (Exception x) {
                // TODO: handle exception
            }
        }
    }
}

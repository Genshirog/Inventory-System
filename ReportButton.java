import javax.swing.*;
import java.awt.*;
public class ReportButton extends Buttons{
    @Override
    public void OnClick(){
        
    }

    @Override
    public JButton ButtonDisplay(){
        JButton reportButton = new JButton("DISPLAY REPORT");
        return reportButton;
    }

    public JButton add(){
        return null;
    }

    public JButton search(){
        return null;
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
        body.setBackground(Color.pink);
        return body;
    }
    public JPanel searchbody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.pink);
        return body;
    }
    public JPanel updatebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.pink);
        return body;
    }
    public JPanel deletebody(){
        JPanel body = new JPanel();
        body.setBounds(0, 0 , 600 , 500);
        body.setBackground(Color.pink);
        return body;
    }
    
    @Override
    public JButton clear(){
        JButton clear = new JButton("Clear");
        return clear;
    }

}

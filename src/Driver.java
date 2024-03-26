
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
public class Driver extends JFrame implements ActionListener{
    CreateFile c = new CreateFile();
    WriteFile w = new WriteFile();
    DecimalFormat d2 = new DecimalFormat("###,###.##");//formats final answer


    FlowLayout flow = new FlowLayout();
    JLabel fn = new JLabel("File Name: ");
    JTextField ft = new JTextField(6);
    JLabel cf = new JLabel("Content: ");
    JTextField ct = new JTextField(6);


    JButton create = new JButton("Create File");
    JButton write = new JButton("Write To File");
    JButton exit = new JButton("Exit");

    public static void main(String[] args) {
        Driver add = new Driver();
        add.setTitle("Menu");
        add.setSize(450,450);
        add.setVisible(true);//makes the gui visible

    }


    Driver(){
        Container con = getContentPane();
        con.setLayout(flow); //setsLayout
        con.add(fn);
        con.add(ft);
        con.add(cf);
        con.add(ct);

        con.add(create);
        con.add(write);
        con.add(exit);

        create.addActionListener(this);
        write.addActionListener(this);
        exit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == create){
            c.setinput(ft.getText());
            c.create();
        }
        if(source == write){
            w.setFilename(ft.getText());
            w.setinputtwo(ct.getText());
            w.write();

        }
        if(source == exit){
            System.exit(0);
        }
    }
}
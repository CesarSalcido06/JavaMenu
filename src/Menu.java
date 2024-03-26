import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Image;


public class Menu implements ActionListener {

    static JLabel text;
    static JLabel textNo;

    static JTextField ft;
    static JTextArea st;
    static JTextField ss;

    static JButton create;
    static JButton write;
    static JButton search;

    public static void main(String args[])
    {
        CreateFile c = new CreateFile();
        WriteFile w = new WriteFile();
        ReadFiles r = new ReadFiles();

        //Create a frame
        JFrame frame = new JFrame("Menu");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridb = new GridBagConstraints();
        //
        Image img = Toolkit.getDefaultToolkit().getImage("/Users/CesarSalcido/Desktop/JavaPrograms/BlackDog.png");
        frame.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(img, 250,0,null);
        }
    });


        //Create an object
        Menu obj = new Menu();
        //Create a Menu
        JMenu menu = new JMenu("Select Here");
        //Create Menu Items
        JMenuItem item1 = new JMenuItem("Create File");
        item1.addActionListener(obj);
        menu.add(item1);

        JMenuItem item2 = new JMenuItem("Search");
        item2.addActionListener(obj);
        menu.add(item2);

        JMenuItem item3 = new JMenuItem("Exit");
        item3.addActionListener(obj);
        menu.add(item3);

        //Create a menu bar
        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        frame.setJMenuBar(mb);
        //Display the frame
        frame.setVisible(true);
        //Create the label
        text = new JLabel();
        frame.add(text);
        //creates file text field
        ft = new JTextField(6);
        frame.add(ft);
        //creates search text field
        ss = new JTextField(6);
        frame.add(ss);
        //creates search text area
        st = new JTextArea(10, 30);
        frame.add(st);
        //creates a file dont exist JLabel
        textNo = new JLabel();
        textNo.setText("Doesnt Exist!!!");
        frame.add(textNo);
        //creates JButton and ActionListener
        search = new JButton("search");
        frame.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source == search){
                    st.setText("");
                    textNo.setVisible(false);
                    if(Files.notExists(Paths.get("/Users/CesarSalcido/Desktop/JavaPrograms/"+ ss.getText() +".txt"))){
                      textNo.setVisible(true);
                    }
                    else{
                        st.append(r.readFile(r.getinput(ss.getText())));
                  }

                }
            }
        });
        //creates JButton and ActionListener
        create = new JButton("create");
        frame.add(create);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source == create){
                    c.setinput(ft.getText());
                    c.create();
                }
            }
        });
        //creates Jbutton for write
        write = new JButton("write");
        frame.add(write);
        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if(source == write){
                    w.setFilename(ss.getText());
                    w.setinputtwo(st.getText());
                    w.write();
                }
            }
        });
        textNo.setVisible(false);
        write.setVisible(false);
        ft.setVisible(false);
        create.setVisible(false);
        st.setVisible(false);
        ss.setVisible(false);
        search.setVisible(false);
    }

    //Function to display the menu item selected
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(e.getActionCommand() == "Create File"){
            textNo.setVisible(false);
            ss.setVisible(false);
            search.setVisible(false);
            st.setVisible(false);
            write.setVisible(false);
            text.setText("Create:");
            ft.setVisible(true);
            create.setVisible(true);

        }
        if (e.getActionCommand() == "Search"){
            textNo.setVisible(false);
            ft.setVisible(false);
            create.setVisible(false);
            write.setVisible(false);
            text.setText("Search:");
            ss.setVisible(true);
            st.setVisible(true);
            search.setVisible(true);
            write.setVisible(true);
        }
        if (e.getActionCommand() == "Exit"){
            System.exit(0);
        }
    }
}



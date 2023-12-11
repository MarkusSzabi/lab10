import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import javax.naming.ldap.Control;
import javax.swing.*;

public class SwingControlDemo {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlpanel;

    public SwingControlDemo(){
        prepareGUI();

    }
    public static void main(String[] args){
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showLabelDemo();
    }   private void prepareGUI() {
        mainFrame = new JFrame("Java Swing Examples");
        mainFrame.setSize(1000, 1000);
        mainFrame.setLayout(new GridLayout(3,
     1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlpanel = new JPanel();
        controlpanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlpanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

        private void showLabelDemo(){
        headerLabel.setText("Bine ai venit la ORA de PROGRAMARE");
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setText("Welcome to ora de programare");
        label.setOpaque(true);
        label.setBackground(Color.gray);
        label.setForeground(Color.white);
        JButton button = new JButton("Culori");
        controlpanel.add(label);
        controlpanel.add(button);
        JButton chooseButton = new JButton("Choose background color:");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Color backgroundColor = JColorChooser.showDialog(mainFrame,"Choose background color", Color.white);
                if(backgroundColor != null){
                    controlpanel.setBackground(backgroundColor);
                    mainFrame.getContentPane().setBackground(backgroundColor);
                }
            }
        });
        JCheckBox checkBox1 = new JCheckBox("GHILEA");
        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("ghilea e in clasa???? no clickbait");
            }
        });
        controlpanel.add(checkBox1);
        mainFrame.setVisible(true);
        JRadioButton radioButton = new JRadioButton("MAGIC FM");
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("ASCULTI MAGIC FM");
            }

        });
        controlpanel.add(radioButton);
        mainFrame.setVisible(true);
        JList list = new JList();
        final DefaultListModel fruitsName = new DefaultListModel();
        fruitsName.addElement("Mere");
        fruitsName.addElement("Pere");
        fruitsName.addElement("Banane");
        fruitsName.addElement("Portocale");
        final DefaultListModel vegName = new DefaultListModel();
        vegName.addElement("Rosii");
        vegName.addElement("Castraveti");
        vegName.addElement("Varza");
        vegName.addElement("Salata");
        final JList fruitList = new JList(fruitsName);
        final JList vegList = new JList(vegName);
        fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fruitList.setSelectedIndex(0);
        fruitList.setVisibleRowCount(3);
        vegList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vegList.setSelectedIndex(0);
        vegList.setVisibleRowCount(3);
        controlpanel.add(fruitList);
        controlpanel.add(vegList);
        mainFrame.setVisible(true);

        JLabel namelabel = new JLabel("Nume:",JLabel.RIGHT);
        JLabel passLabel = new JLabel( "Pass:", JLabel.CENTER);
        final JTextField userText = new JTextField(6);
        final JPasswordField passText = new JPasswordField(6);
        JButton loginButton = new JButton("Logare:");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Logat!");
            }
        });
        String data = "Nume" + userText.getText();
        data += ", Password: " + new String(passText.getPassword());
        statusLabel.setText(data);
        controlpanel.add(namelabel);
        controlpanel.add(userText);
        controlpanel.add(passLabel);
        controlpanel.add(passText);
        controlpanel.add(loginButton);
        mainFrame.setVisible(true);

    }
}


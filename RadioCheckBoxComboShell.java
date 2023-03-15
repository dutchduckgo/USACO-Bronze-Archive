import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class RadioCheckBoxComboShell extends JFrame implements ActionListener, ItemListener {
    // declare component variables
    private JPanel leftPanel, midPanel, rightPanel, bottomPanel, mainPanel;
    private JComboBox comboBox1;
    private JCheckBox wwCB, sbCB, adkinsCB;
    private JRadioButton maleRB, femaleRB;
    private JTextField personField1, dietField2, genderField3;
    private String diets = "", ww = "", sb = "", adkins = "";

    public static void main(String[] args) throws IOException {
        JFrame frame = new RadioCheckBoxComboShell();

        frame.pack();
        frame.setVisible(true);

        WindowListener w = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        frame.addWindowListener(w);
    }

    RadioCheckBoxComboShell() // constructor
    {
        super("Radio Buttons, CheckBoxes, and Combo Boxes");
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1, 1));
        leftPanel.setPreferredSize(new Dimension(150, 70));
        leftPanel.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 0, Color.blue));

        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(3, 1));
        midPanel.setPreferredSize(new Dimension(200, 100));
        midPanel.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.blue));

        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2, 1));
        rightPanel.setPreferredSize(new Dimension(100, 70));
        rightPanel.setBorder(BorderFactory.createMatteBorder(25, 0, 25, 25, Color.blue));

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));
        bottomPanel.setPreferredSize(new Dimension(200, 125));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(25, 25, 25, 25, Color.blue));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(500, 300));

        wwCB = new JCheckBox("Weight Watchers", false);
        sbCB = new JCheckBox("South Beach", false);
        adkinsCB = new JCheckBox("Adkins", false);
        midPanel.add(wwCB);
        midPanel.add(sbCB);
        midPanel.add(adkinsCB);
        wwCB.addItemListener(this);
        sbCB.addItemListener(this);
        adkinsCB.addItemListener(this);

        ButtonGroup genderGroup = new ButtonGroup();
        maleRB = new JRadioButton("Male", false);
        femaleRB = new JRadioButton("Female", false);
        genderGroup.add(maleRB);
        genderGroup.add(femaleRB);
        rightPanel.add(maleRB);
        rightPanel.add(femaleRB);
        maleRB.addItemListener(this);
        femaleRB.addItemListener(this);
        personField1 = new JTextField("");
        dietField2 = new JTextField("");
        genderField3 = new JTextField("");
        bottomPanel.add(personField1);
        bottomPanel.add(dietField2);
        bottomPanel.add(genderField3);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);

        comboBox1 = new JComboBox();
        comboBox1.addItem("Choose one:");
        comboBox1.addItem("Kid");
        comboBox1.addItem("Adult");
        comboBox1.addItem("Senior Citizen");
        leftPanel.add(comboBox1);
        comboBox1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox1) {
            if (comboBox1.getSelectedItem() == "Kid")
                personField1.setText("Kid");
            if (comboBox1.getSelectedItem() == "Adult")
                personField1.setText("Adult");
            if (comboBox1.getSelectedItem() == "Senior Citizen")
                personField1.setText("Senior Citizen");
        }
    }

    public void itemStateChanged(ItemEvent ie) {
        if (ie.getItemSelectable() == wwCB) {
            if (ie.getStateChange() == ItemEvent.DESELECTED) {
                ww = "";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(wwCB.getLabel() + " has been deselected.");
            } else {
                ww = "Weight Watchers ";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(wwCB.getLabel());
            }
        }

        if (ie.getItemSelectable() == sbCB) {
            if (ie.getStateChange() == ItemEvent.DESELECTED) {
                sb = "";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(sbCB.getLabel() + " has been deselected.");
            } else {
                sb = "South Beach ";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(sbCB.getLabel());
            }
        }

        if (ie.getItemSelectable() == adkinsCB) {
            if (ie.getStateChange() == ItemEvent.DESELECTED) {
                adkins = "";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(adkinsCB.getLabel() + " has been deselected.");
            } else {
                adkins = "Adkins ";
                diets = ww + sb + adkins;
                dietField2.setText(diets);
                // dietField2.setText(adkinsCB.getLabel());
            }
        }

        if (ie.getItemSelectable() == maleRB) {
            // genderField3.setText(maleRB.getLabel()); either of these two works
            genderField3.setText("Male");
        }

        if(ie.getItemSelectable() == femaleRB) {
            // genderField3.setText(femaleRB.getLabel()); either of these two works
            genderField3.setText("Female");
        }
    }
}

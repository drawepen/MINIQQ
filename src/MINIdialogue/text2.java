package MINIdialogue;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class text2 extends JFrame {
 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 private JTextField textField;
 private JTextField textField_1;
 private JTextField textField_2;
 private JTextField textField_3;
 private JTextField textField_4;
 private JTextField textField_5;
 private JTextField textField_6;

/**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     text2 frame = new text2();
     frame.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

/**
  * Create the frame.
  */
 public text2() {
  setTitle("\u6D4B\u8BD5");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 689, 437);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);

  JLabel lblNewLabel = new JLabel("New label");

  JScrollBar scrollBar = new JScrollBar();

  textField = new JTextField();
  textField.setColumns(10);

  JLabel lblNewLabel_1 = new JLabel("New label");

  JLabel lblNewLabel_2 = new JLabel("New label");

  JLabel lblNewLabel_3 = new JLabel("New label");

  textField_1 = new JTextField();
  textField_1.setColumns(10);

  textField_2 = new JTextField();
  textField_2.setColumns(10);

  textField_3 = new JTextField();
  textField_3.setColumns(10);

  JLabel lblNewLabel_4 = new JLabel("New label");

  JLabel lblNewLabel_5 = new JLabel("New label");

  textField_4 = new JTextField();
  textField_4.setColumns(10);

  textField_5 = new JTextField();
  textField_5.setColumns(10);

  JLabel lblNewLabel_6 = new JLabel("New label");

  textField_6 = new JTextField();
  textField_6.setColumns(10);
  GroupLayout gl_contentPane = new GroupLayout(contentPane);
  gl_contentPane.setHorizontalGroup(
   gl_contentPane.createParallelGroup(Alignment.LEADING)
    .addGroup(gl_contentPane.createSequentialGroup()
     .addGap(45)
     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      .addGroup(gl_contentPane.createSequentialGroup()
       .addComponent(lblNewLabel)
       .addGap(18)
       .addComponent(textField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addPreferredGap(ComponentPlacement.RELATED)
       .addComponent(lblNewLabel_1)
       .addGap(18)
       .addComponent(textField_1))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addPreferredGap(ComponentPlacement.RELATED)
       .addComponent(lblNewLabel_2)
       .addGap(18)
       .addComponent(textField_2))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addPreferredGap(ComponentPlacement.RELATED)
       .addComponent(lblNewLabel_3)
       .addGap(18)
       .addComponent(textField_3))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addComponent(lblNewLabel_4)
       .addGap(18)
       .addComponent(textField_4))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addPreferredGap(ComponentPlacement.RELATED)
       .addComponent(lblNewLabel_5)
       .addGap(18)
       .addComponent(textField_5))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addComponent(lblNewLabel_6)
       .addGap(18)
       .addComponent(textField_6)))
     .addGap(268)
     .addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
     .addContainerGap())
  );
  gl_contentPane.setVerticalGroup(
   gl_contentPane.createParallelGroup(Alignment.LEADING)
    .addGroup(gl_contentPane.createSequentialGroup()
     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      .addGroup(gl_contentPane.createSequentialGroup()
       .addGap(18)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel)
        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       .addGap(32)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addComponent(lblNewLabel_1))
       .addGap(38)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel_2)
        .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       .addGap(33)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel_3)
        .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       .addGap(39)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel_4)
        .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       .addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel_5)
        .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       .addGap(32)
       .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        .addComponent(lblNewLabel_6)
        .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
      .addGroup(gl_contentPane.createSequentialGroup()
       .addContainerGap()
       .addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)))
     .addContainerGap())
  );
  contentPane.setLayout(gl_contentPane);
 }
}
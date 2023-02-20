package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window implements ActionListener {
    public long rub;
    URLConnect urlConnect = new URLConnect();
    Parse parse = new Parse(urlConnect);

     JFrame jFrame = new JFrame();
     JLabel dollarLabel = new JLabel("USD:");
     JLabel curs = new JLabel(parse.USDParse());
    JLabel rubLabel = new JLabel("CON:");
    JTextField inputUSD = new JTextField();
    JLabel getMassege = new JLabel();
    JButton buttonGo = new JButton("Go");

public Window(){
    rubLabel.setBounds(40,100,75,25);
    inputUSD.setBounds(100,100,150,25);
    dollarLabel.setBounds(40,60,75,25);
    getMassege.setBounds(100,200,200,25);
    curs.setBounds(100,60,75,25);
    buttonGo.setBounds(80,150,100,25);
    buttonGo.setFocusable(false);
    buttonGo.addActionListener(this);
    getMassege.setFont(new Font(null,Font.BOLD,15));
    dollarLabel.setFont(new Font(null,Font.ITALIC,15));
    curs.setFont(new Font(null,Font.ITALIC,15));
    rubLabel.setFont(new Font(null,Font.ITALIC,15));
    jFrame.add(rubLabel);
    jFrame.add(dollarLabel);
    jFrame.add(curs);
    jFrame.add(getMassege);
    jFrame.add(inputUSD);
    jFrame.add(buttonGo);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setSize(300,300);
    jFrame.setLayout(null);
    jFrame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
    String countRub = inputUSD.getText();
       if(e.getSource()==buttonGo){
            getMassege.setForeground(Color.BLACK);
            System.out.println(countRub);
            double data= Double.parseDouble(countRub)*Double.parseDouble(Parse.getUSD());
            getMassege.setText(String.valueOf(data));
       }
    }
}

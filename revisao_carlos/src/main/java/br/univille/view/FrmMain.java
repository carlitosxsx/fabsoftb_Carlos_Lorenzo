package br.univille.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmMain extends JFrame {
    public FrmMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Revision Carlos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        var texto = new JLabel("Hey, Carlos!");
        getContentPane().add(texto);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FrmMain();
    }


}

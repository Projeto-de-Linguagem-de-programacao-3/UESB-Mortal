package src.visao;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaIni {

    private static BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(800, 150, "src//utils/UESB.jpeg");
    private static JLabel labelImgBackground = new JLabel();
    
    private static String imgPersonagem1 = "src//utils//scorpion//paradoP1.gif";
    private static JLabel label1 = new JLabel();
    private static String imgPersonagem2 = "src//utils//subzero//paradoP2.gif";
    private static JLabel label2 = new JLabel();
    private static JPanel panel = new JPanel();

    private static JLabel labelOverall1 = new JLabel("Points: 125");

    private static JLabel labelOverall2 = new JLabel("Points: 180");

    public static JPanel criarTela() {

        panel.setVisible(true);
        panel.setSize(800, 600);
        panel.setLayout(null);

        labelImgBackground.setIcon(new ImageIcon(imgBackground));
      
        label1.setIcon(new ImageIcon(imgPersonagem1));
        label2.setIcon(new ImageIcon(imgPersonagem2));

        labelImgBackground.setBounds(0, 0, 800, 150);
        
        label1.setBounds(250, 360, 170, 170);
        label2.setBounds(410, 360, 170, 170);

        labelOverall1.setBounds(150, 400, 100, 100);

        labelOverall2.setBounds(530, 400, 100, 100);

        labelOverall1.setForeground(Color.RED);

        labelOverall2.setForeground(Color.RED);

        panel.add(labelImgBackground);
        
        panel.add(label1);
        panel.add(label2);

        panel.add(labelOverall1);

        panel.add(labelOverall2);
        panel.setBackground(Color.DARK_GRAY);

        return panel;
    }

  
    public static JLabel getLabel1() {
        return label1;
    }

    public static void setLabel1(JLabel label3) {
        TelaIni.label1 = label3;
    }

    public static JLabel getLabel2() {
        return label2;
    }

    public static void setLabel2(JLabel label4) {
        TelaIni.label2 = label4;
    }

}

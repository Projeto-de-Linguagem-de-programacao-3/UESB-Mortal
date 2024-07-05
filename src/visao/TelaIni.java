package src.visao;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaIni {

    private static BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(800, 150, "src//utils/UESB.jpeg");
    private static JLabel labelImgBackground = new JLabel();
    
    private static String imgPersonagem3 = "src//utils//scorpion//paradoP1.gif";
    private static JLabel label3 = new JLabel();
    private static String imgPersonagem4 = "src//utils//subzero//paradoP2.gif";
    private static JLabel label4 = new JLabel();
    private static JPanel panel = new JPanel();

    private static JLabel labelOverall2 = new JLabel("Points: 0");

    private static JLabel labelOverall4 = new JLabel("Points: 0");

    public static JPanel criarTela() {

        panel.setVisible(true);
        panel.setSize(800, 600);
        panel.setLayout(null);

        labelImgBackground.setIcon(new ImageIcon(imgBackground));
      
        label3.setIcon(new ImageIcon(imgPersonagem3));
        label4.setIcon(new ImageIcon(imgPersonagem4));

        labelImgBackground.setBounds(0, 0, 800, 150);
        
        label3.setBounds(250, 360, 170, 170);
        label4.setBounds(410, 360, 170, 170);

        labelOverall2.setBounds(150, 400, 100, 100);

        labelOverall4.setBounds(530, 400, 100, 100);

        labelOverall2.setForeground(Color.RED);

        labelOverall4.setForeground(Color.RED);

        panel.add(labelImgBackground);
        
        panel.add(label3);
        panel.add(label4);

        panel.add(labelOverall2);

        panel.add(labelOverall4);
        panel.setBackground(Color.DARK_GRAY);

        return panel;
    }

  
    public static JLabel getLabel3() {
        return label3;
    }

    public static void setLabel3(JLabel label3) {
        TelaIni.label3 = label3;
    }

    public static JLabel getLabel4() {
        return label4;
    }

    public static void setLabel4(JLabel label4) {
        TelaIni.label4 = label4;
    }

}

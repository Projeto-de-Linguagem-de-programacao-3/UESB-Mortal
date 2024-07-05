package src.visao;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import src.controle.ControleFrame;

public class TelaLuta {

    // Carrega a imagem de fundo
    private static BufferedImage imgBackground = new Utils.ImgUtils().scaleImage(800, 600, "src//utils/cenario.png");
    private static BufferedImage lifeBarIcon = new Utils.ImgUtils().scaleImage(100, 100, "src//utils/LifeBarIcon.png");
    private static BufferedImage imgChao = new Utils.ImgUtils().scaleImage(800, 100, "src//utils/chao.jpg");

    // Declaração de componentes do painel
    private static BackgroundPanel panel;
    private static JLabel lifeBar1 = new JLabel();
    private static JLabel lifeBar2 = new JLabel();
    private static JLabel labelImgBackground = new JLabel();
    private static JLabel labelImgChao = new JLabel();

    // Criação de uma classe interna que estende JPanel para desenhar o fundo
    private static class BackgroundPanel extends JPanel {
        private BufferedImage background;

        // Construtor que recebe a imagem de fundo
        public BackgroundPanel(BufferedImage background) {
            this.background = background;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Desenha a imagem de fundo redimensionada para preencher o painel
            g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    // Método para criar a tela de luta
    public static JPanel criarTela() {
        // Criação do painel de fundo com a imagem
        panel = new BackgroundPanel(imgBackground);

        panel.setVisible(true);
        panel.setSize(800, 600);
        panel.setLayout(null); // Definindo layout nulo para posicionamento absoluto dos componentes

        // Configuração dos ícones para as barras de vida e imagens
        lifeBar1.setIcon(new ImageIcon(lifeBarIcon));
        lifeBar2.setIcon(new ImageIcon(lifeBarIcon));
        labelImgBackground.setIcon(new ImageIcon(imgBackground));
        labelImgChao.setIcon(new ImageIcon(imgChao));

        // Definindo as posições e tamanhos dos componentes
        lifeBar1.setBounds(0, 160, ControleFrame.getPersonagem1().getVida() + 1, 20);
        lifeBar2.setBounds(670, 160, ControleFrame.getPersonagem2().getVida() + 1, 20);
        labelImgBackground.setBounds(0, 0, 0, 0);
        labelImgChao.setBounds(0, 460, 800, 100);

        // Adicionando os componentes ao painel
        panel.add(labelImgChao);
        panel.add(lifeBar1);
        panel.add(lifeBar2);
        panel.add(labelImgBackground);
        panel.add(ControleFrame.getPlayUm());
        panel.add(ControleFrame.getPlayDois());

        // Retorna o painel configurado
        return panel;
    }

    // Métodos para obter as barras de vida e o painel principal
    public static JLabel getLifebar1() {
        return lifeBar1;
    }

    public static JLabel getLifebar2() {
        return lifeBar2;
    }

    public static JPanel getJPanel() {
        return panel;
    }
}

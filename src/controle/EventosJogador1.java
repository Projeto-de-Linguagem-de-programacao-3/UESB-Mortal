package src.controle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import src.visao.TelaLuta;

public class EventosJogador1 implements Runnable {

    // Vetor para controlar a direção do movimento (cima, direita, baixo, esquerda, soco, chute)
    private boolean[] movieDirection = {
            false, // cima
            false, // direita
            false, // baixo
            false, // esquerda
            false, // soco
            false  // chute
    };

    // Getter para movieDirection
    public boolean[] getMovieDirection() {
        return movieDirection;
    }

    // Setter para movieDirection
    public void setMovieDirection(boolean[] movieDirection) {
        this.movieDirection = movieDirection;
    }

    private int Opcao; // Variável para armazenar a opção de controle

    // Getter para Opcao
    public int getOpcao() {
        return Opcao;
    }

    // Setter para Opcao
    public void setOpcao(int Opcao) {
        this.Opcao = Opcao;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Verifica a direção do movimento e atualiza a posição do jogador
                if (getMovieDirection()[1]) { // Movimentação para a direita
                    if (ControleFrame.getPlayUm().getLocation().x < 720
                            && ControleFrame.getPlayUm().getLocation().x < (ControleFrame.getPlayDois().getLocation().x
                                    - (ControleFrame.getPlayDois().getWidth() / 2)))
                        ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x + 5,
                                ControleFrame.getPlayUm().getLocation().y);
                    ControleFrame.getPlayUm().andar();

                } else if (getMovieDirection()[3]) { // Movimentação para a esquerda
                    if (ControleFrame.getPlayUm().getLocation().x > 0)
                        ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x - 5,
                                ControleFrame.getPlayUm().getLocation().y);
                    ControleFrame.getPlayUm().andar();

                } else if (getMovieDirection()[0]) { // Movimentação para cima (pulo)
                    float vlc = 0;

                    // Atualiza a imagem do jogador para a sprite de parado
                    ControleFrame.getPlayUm().setIcon(new ImageIcon(ControleFrame.getPlayUm().getParadoSprite()));

                    // Animação de pulo (subida)
                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += -(10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x,
                                    Math.round(ControleFrame.getPlayUm().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }

                    // Animação de pulo (descida)
                    vlc = 0;
                    for (int i = 0; i < 15; i++) {
                        try {
                            vlc += (10 * 0.0333333333333);
                            ControleFrame.getPlayUm().setLocation(ControleFrame.getPlayUm().getLocation().x,
                                    Math.round(ControleFrame.getPlayUm().getY() + vlc));
                            Thread.sleep(10);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    ControleFrame.getPlayUm().andar();
                } else if (getMovieDirection()[4]) { // Executa o soco
                    soco();
                    movieDirection[4] = false; // Reseta a direção do soco
                    setMovieDirection(movieDirection);
                } else if (getMovieDirection()[5]) { // Executa o chute
                    chute();
                    movieDirection[5] = false; // Reseta a direção do chute
                    setMovieDirection(movieDirection);
                }

                Thread.sleep(30); // Intervalo entre as verificações
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Método estático para executar o soco
    public static void soco() {
        ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + 2),
                ControleFrame.getPlayUm().getY());
        colision_check(ControleFrame.getPlayUm(), ControleFrame.getPlayDois(),
                ControleFrame.getPersonagem1().getsoco());
        ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() - 2),
                ControleFrame.getPlayUm().getY());
    }

    // Método estático para executar o chute
    public static void chute() {
        ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() + 2),
                ControleFrame.getPlayUm().getY());
        colision_check(ControleFrame.getPlayUm(), ControleFrame.getPlayDois(),
                ControleFrame.getPersonagem1().getChute());
        ControleFrame.getPlayUm().setLocation(Math.round(ControleFrame.getPlayUm().getX() - 2),
                ControleFrame.getPlayUm().getY());
    }

    // Método estático para verificar colisão entre dois jogadores
    public static boolean colision_check(JLabel LA, JLabel LB, int forca) {
        // Coleta informações do primeiro jogador
        int label_A_x = LA.getX();
        int label_A_y = LA.getY();
        int label_A_h = LA.getHeight();
        int label_A_w = LA.getWidth();

        // Coleta informações do segundo jogador
        int label_B_x = LB.getX();
        int label_B_y = LB.getY();
        int label_B_h = LB.getHeight();
        int label_B_w = LB.getWidth();

        // Verifica se houve colisão
        if (label_A_x < label_B_x + label_B_w &&
                label_A_x + label_A_w > label_B_x &&
                label_A_y < label_B_y + label_B_h &&
                label_A_y + label_A_h > label_B_y) {
            // Houve colisão, atualiza a barra de vida do jogador 2
            TelaLuta.getLifebar2().setSize(TelaLuta.getLifebar2().getWidth() - forca,
                    TelaLuta.getLifebar2().getHeight());
            if (TelaLuta.getLifebar2().getWidth() <= 0) {
                ControleFrame.getPlayDois().morrer();
                ControleFrame.setControle(GameState.END);
                JOptionPane.showMessageDialog(null, "Jogador 1 venceu!");
                ControleFrame.resetTheGame(ControleFrame.getPlayDois());
            }
        }
        return true;
    }
}

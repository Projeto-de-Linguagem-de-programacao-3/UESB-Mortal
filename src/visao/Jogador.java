package src.visao;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// Classe Jogador que herda de JLabel para representar um jogador com diferentes sprites
public class Jogador extends JLabel {
    private String andarSprite;
    private String paradoSprite;
    private String socarSprite;
    private String chutarSprite;
    private String morteSprite;

    // Construtor que inicializa os sprites com base no nome do personagem e jogador
    public Jogador(String name, String player) {
        andarSprite = "src//utils//" + name + "//andando" + player + ".gif";
        paradoSprite = "src//utils//" + name + "//parado" + player + ".gif";

        socarSprite = "src//utils//" + name + "//soco" + player + ".gif";

        chutarSprite = "src//utils//" + name + "//chute" + player + ".gif";

        morteSprite = "src//utils//morrer.jpg";
    }

    // Métodos para alterar o ícone do JLabel para diferentes ações
    public void andar() {

        this.setIcon(new ImageIcon(andarSprite));

    }

    public void Parado() {

        this.setIcon(new ImageIcon(paradoSprite));

    }

    public void morrer() {
        this.setIcon(new ImageIcon(getMorteSprite()));
    }

    public void soco() {
        this.setIcon(new ImageIcon(socarSprite));
    }

    public void chute() {
        this.setIcon(new ImageIcon(chutarSprite));
    }

    public void recuar() {

        this.setIcon(new ImageIcon(chutarSprite));

    }

    public String getAndarSprite() {
        return andarSprite;
    }

    public String getParadoSprite() {
        return paradoSprite;
    }

    public String getSocarSprite() {
        return socarSprite;
    }

    public String getChutarSprite() {
        return chutarSprite;
    }

    public String getMorteSprite() {
        return morteSprite;
    }

}

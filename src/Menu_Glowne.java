import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_Glowne {
    private JButton stwozNowaKarteBibiliotecznąButton;
    private JButton zarządzajKsiążkamiButton;
    private JButton wyporzyczenieOddanieButton;
    private JButton szukajKsiążkiButton;
    private JButton książkiKlientaButton;
    private JPanel Menu;


    public Menu_Glowne() {
        stwozNowaKarteBibiliotecznąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.out.println("hej");

            }



        });



        }


    public static void main(String[] args) {

        JFrame menu = new JFrame("Menu");
        menu.setContentPane(new Menu_Glowne().Menu);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(600, 600);
        menu.setVisible(true);


    }




}

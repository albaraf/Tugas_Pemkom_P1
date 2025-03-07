package tugas.p1;

/**
 *
 * @author ASUS
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TugasP1 {
    private int angkaRahasia;
    private int percobaan;
    private JTextField inputField;
    private JLabel messageLabel;

    public TugasP1() {
        angkaRahasia = new Random().nextInt(100) + 1;
        percobaan = 0;

        JFrame frame = new JFrame("Game Tebak Angka");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Tebak angka antara 1 - 100:");
        inputField = new JTextField(5);
        JButton tebakButton = new JButton("Tebak");
        messageLabel = new JLabel("Masukkan tebakan Anda");

        tebakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cekTebakan();
            }
        });

        frame.add(label);
        frame.add(inputField);
        frame.add(tebakButton);
        frame.add(messageLabel);

        frame.setVisible(true);
    }

    private void cekTebakan() {
        try {
            int tebakan = Integer.parseInt(inputField.getText());
            percobaan++;

            if (tebakan > angkaRahasia) {
                messageLabel.setText("Terlalu besar! Coba lagi.");
            } else if (tebakan < angkaRahasia) {
                messageLabel.setText("Terlalu kecil! Coba lagi.");
            } else {
                messageLabel.setText("Selamat! Anda benar dalam " + percobaan + " percobaan.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Masukkan angka yang valid!");
        }
    }

    public static void main(String[] args) {
        new TugasP1();
    }
}

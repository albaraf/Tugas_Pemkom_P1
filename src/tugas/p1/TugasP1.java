package tugas.p1;

/**
 *
 * @author ASUS
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class TugasP1 {
    private JFrame frame = new JFrame("Game Ikuti Instruksi");
    private JLabel instructionLabel = new JLabel("Tekan tombol yang benar!", SwingConstants.CENTER);
    private JLabel scoreLabel = new JLabel("Skor: 0", SwingConstants.CENTER);
    private char currentKey;
    private int score = 0;
    private Random random = new Random();
    
    public TugasP1() {
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        instructionLabel.setBounds(50, 50, 200, 30);
        scoreLabel.setBounds(50, 90, 200, 30);
        
        frame.add(instructionLabel);
        frame.add(scoreLabel);
        
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == currentKey) {
                    score++;
                    scoreLabel.setText("Skor: " + score);
                    generateNewInstruction();
                } else {
                    JOptionPane.showMessageDialog(frame, "Salah! Skor akhir: " + score);
                    score = 0;
                    scoreLabel.setText("Skor: 0");
                    generateNewInstruction();
                }
            }
        });
        
        frame.setFocusable(true);
        frame.setVisible(true);
        generateNewInstruction();
    }
    
    private void generateNewInstruction() {
        currentKey = (char) ('A' + random.nextInt(26)); // Random huruf A-Z
        instructionLabel.setText("Tekan huruf: " + currentKey);
    }
    
    public static void main(String[] args) {
        new TugasP1();
    }
}
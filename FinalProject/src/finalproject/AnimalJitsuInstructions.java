/**
 * Caroline Widdecombe, Aidan Goodyer, Harjas Sran
 * Instructions Menu
 * April 10 2021
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author carolinewiddecombe
 */
public class AnimalJitsuInstructions extends javax.swing.JFrame {

    /**
     * Creates new form AnimalJitsuInstructions
     */
    MainMenuGUI m;
    
    static Font pixelFont;
    static Font smallPixel;
    static Font mediumPixel; 

    public AnimalJitsuInstructions(MainMenuGUI mainMenu) {
        m = mainMenu;
        initComponents();

        // set icon image to penguin character
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/windowIcon.png")));
        howToPlayArea.setOpaque(false);
        howToPlayArea.setBackground(new Color(0, 0, 0, 200)); //Background
        
       
        //Creates fonts
       try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/pixelfont.ttf"));//custom font
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("fonts/pixelfont.ttf")));
        } catch (IOException | FontFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
       //different sized texts
        smallPixel = pixelFont.deriveFont(35.0f);
        mediumPixel = pixelFont.deriveFont(60.0f);

       //fonts for areas and labels
       earnYourBowsArea.setFont(smallPixel);
       howToPlayArea.setFont(smallPixel);
       lblInstructions.setFont(mediumPixel);
       lblRules.setFont(smallPixel);
       lblBows.setFont(smallPixel);

        
        jScrollPane2.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInstructions = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        lblBows = new javax.swing.JLabel();
        lblRules = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        howToPlayArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        earnYourBowsArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Instructions");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInstructions.setFont(new java.awt.Font("Krungthep", 0, 24)); // NOI18N
        lblInstructions.setForeground(new java.awt.Color(255, 0, 0));
        lblInstructions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstructions.setText("Instructions");
        getContentPane().add(lblInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 380, 40));

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/StartButton1.png"))); // NOI18N
        btnStart.setBorderPainted(false);
        btnStart.setContentAreaFilled(false);
        btnStart.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/StartButton2.png"))); // NOI18N
        btnStart.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/StartButton3.png"))); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 650, 250, -1));

        lblBows.setFont(new java.awt.Font("Krungthep", 0, 18)); // NOI18N
        lblBows.setForeground(new java.awt.Color(255, 255, 255));
        lblBows.setText("Earn Your Bows");
        getContentPane().add(lblBows, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 67, -1, -1));

        lblRules.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
        lblRules.setForeground(new java.awt.Color(51, 153, 0));
        lblRules.setText("How to Play");
        getContentPane().add(lblRules, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jScrollPane2.setHorizontalScrollBar(null);
        jScrollPane2.setOpaque(false);

        howToPlayArea.setEditable(false);
        howToPlayArea.setColumns(20);
        howToPlayArea.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        howToPlayArea.setLineWrap(true);
        howToPlayArea.setRows(5);
        howToPlayArea.setText(" 1\n When the game begins \n you and Sensei Penguin\n each receive 5 cards \n each with an element and a \n number\n\n 2\n Snow cards defeat \n Water cards\n\n Water cards defeat \n Fire cards \n\n Fire cards defeat\n Snow cards\n\n 3\n If both you and Sensei \n Penguin choose\n the same element\n the winner of the round \n will be the card with\n the highest number\n\n\n\n 4\n You will have \n 15 seconds to \n choose a card\n that will help you \n win the game\n\n 5\n The game ends \n when you \n or Sensei Penguin\n have won at \n least 1 round \n with each element \n OR won 3 rounds with \n the same element\n");
        howToPlayArea.setBorder(null);
        howToPlayArea.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(howToPlayArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 470, 350));

        jScrollPane1.setOpaque(false);

        earnYourBowsArea.setEditable(false);
        earnYourBowsArea.setColumns(20);
        earnYourBowsArea.setLineWrap(true);
        earnYourBowsArea.setRows(5);
        earnYourBowsArea.setText("   Challenge \n   Sensei Penguin \n   to gain experience\n   and level up\n\n   When you win a match \n   you will advance \n   to the next bow level\n");
        jScrollPane1.setViewportView(earnYourBowsArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 460, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/legend.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, -1, -1));

        returnButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        returnButton.setForeground(new java.awt.Color(255, 0, 0));
        returnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/arrowButtonLeft1.png"))); // NOI18N
        returnButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0), 3));
        returnButton.setBorderPainted(false);
        returnButton.setContentAreaFilled(false);
        returnButton.setFocusPainted(false);
        returnButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/arrowButtonLeft2.png"))); // NOI18N
        returnButton.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buttons/arrowButtonLeft3.png"))); // NOI18N
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 80, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/pixeltown.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 0, 1350, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        //if the user presses the back button, close this window and open the main menu window
        this.setVisible(false);
        m.setVisible(true);


    }//GEN-LAST:event_returnButtonActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        //if the user presses the start window, close this window and open the animal selectionwindow
        CharacterSelectMenu s = new CharacterSelectMenu(m);
        s.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnStartActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JTextArea earnYourBowsArea;
    private javax.swing.JTextArea howToPlayArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBows;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblRules;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}

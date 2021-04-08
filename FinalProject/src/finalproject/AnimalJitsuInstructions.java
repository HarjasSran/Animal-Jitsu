/*
INSTRUCTIONS MENU 
 */
package finalproject;

import java.awt.Color;

/**
 *
 * @author carolinewiddecombe
 */
public class AnimalJitsuInstructions extends javax.swing.JFrame {

    /**
     * Creates new form AnimalJitsuInstructions
     */
     MainMenuGUI m; 
    public AnimalJitsuInstructions(MainMenuGUI mainMenu) {
         m = mainMenu; 
        initComponents();
        jTextArea1.setOpaque(false);
    jTextArea1.setBackground(new Color(0,0,0,200));
    
    jScrollPane2.getViewport().setOpaque(false);
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
        lblBows = new javax.swing.JLabel();
        lblRules = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInstructions.setFont(new java.awt.Font("Krungthep", 0, 24)); // NOI18N
        lblInstructions.setForeground(new java.awt.Color(255, 0, 0));
        lblInstructions.setText("Instructions");
        getContentPane().add(lblInstructions, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 16, 180, 40));

        lblBows.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
        lblBows.setForeground(new java.awt.Color(0, 153, 0));
        lblBows.setText("Earn Your Bows");
        getContentPane().add(lblBows, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 67, -1, -1));

        lblRules.setFont(new java.awt.Font("Krungthep", 0, 13)); // NOI18N
        lblRules.setForeground(new java.awt.Color(51, 153, 0));
        lblRules.setText("How to Play");
        getContentPane().add(lblRules, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 198, -1, -1));

        jScrollPane2.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 51, 51));
        jTextArea1.setRows(5);
        jTextArea1.setText("1. When the game begins, you and Sensei Penguin each \nreceive 5 cards, each with an element and a number.\n\n2. Snow cards defeat Water cards. Water cards beat \nFire cards Fire cards beat Snow cards.\n\n3. If both you and Sensei Penguin choose the same element,\nthe winner of the round will be the card with the highest \nnumber.\n\n4. If you and Sensei Penguin choose a card of the same \nelement and number, nobody wins the round.\n\n5. You will have 15 seconds to choose a card that will\n win help you win the game.\n\n6. The game ends when you or Sensei Penguin have won at \nleast 1 round with each element OR won 3 rounds with \nthe same element.\n");
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 227, 470, 400));

        jScrollPane1.setOpaque(false);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Challenge Sensei Penguin to gain experience\nand level up. When you win a match, you will \nadvance to the next bow level.\n");
        jScrollPane1.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 96, 329, -1));

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
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 657, 80, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/pixeltown.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 0, 1350, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        
        this.setVisible(false);
        m.setVisible(true); 
        
        
    }//GEN-LAST:event_returnButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lblBows;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblRules;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundatela;

import java.util.Arrays;

/**
 *
 * @author victorxavier
 */
public class TelaJava extends javax.swing.JFrame {
    
    String[] nums = new String[50];
    int ctrl = 0;

    /**
     * Creates new form TelaJava
     */
    public TelaJava() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn7 = new javax.swing.JButton();
        textField = new javax.swing.JTextField();
        Btn4 = new javax.swing.JButton();
        Btn1 = new javax.swing.JButton();
        Btn5 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        Btn8 = new javax.swing.JButton();
        Btn0 = new javax.swing.JButton();
        Btn9 = new javax.swing.JButton();
        Btn6 = new javax.swing.JButton();
        Btn3 = new javax.swing.JButton();
        BtnX = new javax.swing.JButton();
        BtnDiv = new javax.swing.JButton();
        BtnSoma = new javax.swing.JButton();
        BtnSub = new javax.swing.JButton();
        BtnIgual = new javax.swing.JButton();
        BtnC = new javax.swing.JButton();
        Btn10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn7.setText("7");
        Btn7.setSize(new java.awt.Dimension(50, 50));
        Btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn7ActionPerformed(evt);
            }
        });

        textField.setEditable(false);
        textField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        Btn4.setText("4");
        Btn4.setSize(new java.awt.Dimension(50, 50));
        Btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn4ActionPerformed(evt);
            }
        });

        Btn1.setText("1");
        Btn1.setToolTipText("");
        Btn1.setSize(new java.awt.Dimension(50, 50));
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });

        Btn5.setText("5");
        Btn5.setSize(new java.awt.Dimension(50, 50));
        Btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn5ActionPerformed(evt);
            }
        });

        Btn2.setText("2");
        Btn2.setSize(new java.awt.Dimension(50, 50));
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        Btn8.setText("8");
        Btn8.setSize(new java.awt.Dimension(50, 50));
        Btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn8ActionPerformed(evt);
            }
        });

        Btn0.setText("0");
        Btn0.setSize(new java.awt.Dimension(50, 50));
        Btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn0ActionPerformed(evt);
            }
        });

        Btn9.setText("9");
        Btn9.setSize(new java.awt.Dimension(50, 50));
        Btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn9ActionPerformed(evt);
            }
        });

        Btn6.setText("6");
        Btn6.setSize(new java.awt.Dimension(50, 50));
        Btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn6ActionPerformed(evt);
            }
        });

        Btn3.setText("3");
        Btn3.setSize(new java.awt.Dimension(50, 50));
        Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn3ActionPerformed(evt);
            }
        });

        BtnX.setText("x");
        BtnX.setSize(new java.awt.Dimension(50, 50));
        BtnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnXActionPerformed(evt);
            }
        });

        BtnDiv.setText("/");
        BtnDiv.setSize(new java.awt.Dimension(50, 50));
        BtnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDivActionPerformed(evt);
            }
        });

        BtnSoma.setText("+");
        BtnSoma.setSize(new java.awt.Dimension(50, 50));
        BtnSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSomaActionPerformed(evt);
            }
        });

        BtnSub.setText("-");
        BtnSub.setSize(new java.awt.Dimension(50, 50));
        BtnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubActionPerformed(evt);
            }
        });

        BtnIgual.setText("=");
        BtnIgual.setSize(new java.awt.Dimension(50, 50));
        BtnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIgualActionPerformed(evt);
            }
        });

        BtnC.setText("c");
        BtnC.setSize(new java.awt.Dimension(50, 50));
        BtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCActionPerformed(evt);
            }
        });

        Btn10.setText(".");
        Btn10.setSize(new java.awt.Dimension(50, 50));
        Btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn10ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/segundatela/tiago.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label1.setText("ANNNHH AAANN OOH OOOAANNHHAAAN ONNH!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(Btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(BtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtnSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BtnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn0ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"0");
        if (nums[ctrl] == null) {
            nums[ctrl] = "0";
        } else {
            nums[ctrl] = nums[ctrl] + "0";
        }
    }//GEN-LAST:event_Btn0ActionPerformed

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"1");
        if (nums[ctrl] == null) {
            nums[ctrl] = "1";
        } else {
            nums[ctrl] = nums[ctrl] + "1";
        }
    }//GEN-LAST:event_Btn1ActionPerformed

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"2");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "2";
        } else {
            nums[ctrl] = "2";
        }
    }//GEN-LAST:event_Btn2ActionPerformed

    private void Btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn3ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"3");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "3";
        } else {
            nums[ctrl] = "3";
        }
    }//GEN-LAST:event_Btn3ActionPerformed

    private void Btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn4ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"4");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "4";
        } else {
            nums[ctrl] = "4";
        }
    }//GEN-LAST:event_Btn4ActionPerformed

    private void Btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn5ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"5");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "5";
        } else {
            nums[ctrl] = "5";
        }
    }//GEN-LAST:event_Btn5ActionPerformed

    private void Btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn6ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"6");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "6";
        } else {
            nums[ctrl] = "6";
        }
    }//GEN-LAST:event_Btn6ActionPerformed

    private void Btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn7ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"7");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "7";
        } else {
            nums[ctrl] = "7";
        }
    }//GEN-LAST:event_Btn7ActionPerformed

    private void Btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn8ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"8");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "8";
        } else {
            nums[ctrl] = "8";
        }
    }//GEN-LAST:event_Btn8ActionPerformed

    private void Btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn9ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"9");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + "9";
        } else {
            nums[ctrl] = "9";
        }
    }//GEN-LAST:event_Btn9ActionPerformed

    private void BtnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"x");
        ctrl++;
        nums[ctrl] = "x";
        ctrl++;
    }//GEN-LAST:event_BtnXActionPerformed

    private void BtnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDivActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"/");
        ctrl++;
        nums[ctrl] = "/";
        ctrl++;
    }//GEN-LAST:event_BtnDivActionPerformed

    private void BtnSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSomaActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"+");
        ctrl++;
        nums[ctrl] = "+";
        ctrl++;
    }//GEN-LAST:event_BtnSomaActionPerformed

    private void BtnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+"-");
        ctrl++;
        nums[ctrl] = "-";
        ctrl++;
    }//GEN-LAST:event_BtnSubActionPerformed

    private void BtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCActionPerformed
        // TODO add your handling code here:
        textField.setText("");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = null;
        }
    }//GEN-LAST:event_BtnCActionPerformed

    private void BtnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIgualActionPerformed
        // TODO add your handling code here:
        boolean result = false;
        double res = 0;
        while(!result){
            if (!Arrays.asList(nums).contains("x") && !Arrays.asList(nums).contains("/") && !Arrays.asList(nums).contains("+") && !Arrays.asList(nums).contains("-")){
                result = true;
            }
            
            for (int i = 0; i < ctrl; i++) {
                if (Arrays.asList(nums).contains("x") || Arrays.asList(nums).contains("/")){
                    if ("x".equals(nums[i])){
                        res = Double.parseDouble(nums[i-1]) * Double.parseDouble(nums[i+1]);
                        nums[i] = String.valueOf(res);
                        nums[i-1] = null;
                        nums[i+1] = null;
                        break;
                    }
                    if ("/".equals(nums[i])){
                        res = Double.parseDouble(nums[i-1]) / Double.parseDouble(nums[i+1]);
                        nums[i] = String.valueOf(res);
                        nums[i-1] = null;
                        nums[i+1] = null;
                        break;
                    }
                } else {
                    if (Arrays.asList(nums).contains("+") || Arrays.asList(nums).contains("-")) {
                        if ("+".equals(nums[i])){
                            res = Double.parseDouble(nums[i-1]) + Double.parseDouble(nums[i+1]);
                            nums[i] = String.valueOf(res);
                            nums[i-1] = null;
                            nums[i+1] = null;
                            break;
                        }
                        if ("-".equals(nums[i])){
                            res = Double.parseDouble(nums[i-1]) - Double.parseDouble(nums[i+1]);
                            nums[i] = String.valueOf(res);
                            nums[i-1] = null;
                            nums[i+1] = null;
                            break;
                        }
                    }
                }
            }
            ctrl = ctrl - 2;
            for (int i = 0; i <= ctrl; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j] == null){
                        for (int k=j+1; k<nums.length; k++){
                            nums[k-1] = nums[k];
                            }
                        nums[nums.length-1] = null;
                        break;
                    }
                }
            }
        }
        ctrl = 0;
        textField.setText(nums[ctrl]);
    }//GEN-LAST:event_BtnIgualActionPerformed

    private void Btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn10ActionPerformed
        // TODO add your handling code here:
        textField.setText(textField.getText()+".");
        if (nums[ctrl] != null) {
            nums[ctrl] = nums[ctrl] + ".";
        } else {
            nums[ctrl] = ".";
        }
    }//GEN-LAST:event_Btn10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        label1.setSize(375, 31);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJava().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn0;
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn10;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton Btn4;
    private javax.swing.JButton Btn5;
    private javax.swing.JButton Btn6;
    private javax.swing.JButton Btn7;
    private javax.swing.JButton Btn8;
    private javax.swing.JButton Btn9;
    private javax.swing.JButton BtnC;
    private javax.swing.JButton BtnDiv;
    private javax.swing.JButton BtnIgual;
    private javax.swing.JButton BtnSoma;
    private javax.swing.JButton BtnSub;
    private javax.swing.JButton BtnX;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label1;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}

package testtool.views.testdb;

import testtool.models.testdb.TestDatabase;
import testtool.views.grader.Grading;
import testtool.views.questiondb.QuestionDBFrame;

/**
 * 
 * @author Kevin
 */

public class TestGenUI extends javax.swing.JFrame {
   TestDatabase tdb = new TestDatabase();
   /**
    * Creates new form TestGenUI
    */
   public TestGenUI() {
      initComponents();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private void initComponents() {

      jMenu3 = new javax.swing.JMenu();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();
      jButton4 = new javax.swing.JButton();
      jButton5 = new javax.swing.JButton();
      jMenuBar1 = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      jMenuItem1 = new javax.swing.JMenuItem();
      jMenuItem2 = new javax.swing.JMenuItem();
      jMenuItem3 = new javax.swing.JMenuItem();
      jMenuItem4 = new javax.swing.JMenuItem();
      jMenuItem5 = new javax.swing.JMenuItem();
      jMenuItem6 = new javax.swing.JMenuItem();
      jMenuItem7 = new javax.swing.JMenuItem();
      jMenuItem8 = new javax.swing.JMenuItem();
      jMenuItem9 = new javax.swing.JMenuItem();
      jMenuItem11 = new javax.swing.JMenuItem();
      jMenu2 = new javax.swing.JMenu();
      jMenuItem10 = new javax.swing.JMenuItem();
      jMenuItem12 = new javax.swing.JMenuItem();
      jMenuItem13 = new javax.swing.JMenuItem();
      jMenuItem14 = new javax.swing.JMenuItem();
      jMenuItem15 = new javax.swing.JMenuItem();
      jMenuItem16 = new javax.swing.JMenuItem();
      jMenuItem17 = new javax.swing.JMenuItem();
      jMenuItem18 = new javax.swing.JMenuItem();
      jMenuItem19 = new javax.swing.JMenuItem();
      jMenuItem20 = new javax.swing.JMenuItem();
      jMenu4 = new javax.swing.JMenu();
      jMenuItem21 = new javax.swing.JMenuItem();
      jMenuItem22 = new javax.swing.JMenuItem();
      jMenuItem23 = new javax.swing.JMenuItem();
      jMenuItem24 = new javax.swing.JMenuItem();
      jMenu5 = new javax.swing.JMenu();
      jMenuItem25 = new javax.swing.JMenuItem();
      jMenuItem26 = new javax.swing.JMenuItem();
      jMenuItem27 = new javax.swing.JMenuItem();
      jMenuItem28 = new javax.swing.JMenuItem();
      jMenuItem29 = new javax.swing.JMenuItem();
      jMenu6 = new javax.swing.JMenu();
      jMenuItem30 = new javax.swing.JMenuItem();
      jMenuItem31 = new javax.swing.JMenuItem();
      jMenuItem32 = new javax.swing.JMenuItem();
      jMenu7 = new javax.swing.JMenu();
      jMenuItem33 = new javax.swing.JMenuItem();
      jMenuItem34 = new javax.swing.JMenuItem();
      jMenuItem35 = new javax.swing.JMenuItem();
      jMenu8 = new javax.swing.JMenu();

      jMenu3.setText("jMenu3");

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jButton1.setLabel("Question Bank");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setLabel("Test");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      jButton3.setLabel("Grade");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      jButton4.setLabel("Options");

      jButton5.setLabel("Admin");

      jMenu1.setText("File");

      jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem1.setText("New");
      jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem1ActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuItem1);

      jMenuItem2.setText("Tools");
      jMenu1.add(jMenuItem2);

      jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem3.setText("Save");
      jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem3ActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuItem3);

      jMenuItem4.setText("Save As");
      jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem4ActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuItem4);

      jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem5.setText("Open");
      jMenu1.add(jMenuItem5);

      jMenuItem6.setText("Close Test");
      jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem6ActionPerformed(evt);
         }
      });
      jMenu1.add(jMenuItem6);

      jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK
                  | java.awt.event.InputEvent.SHIFT_MASK
                  | java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem7.setText("Print");
      jMenu1.add(jMenuItem7);

      jMenuItem8.setText("Print Preview");
      jMenu1.add(jMenuItem8);

      jMenuItem9.setText("Sign Out");
      jMenu1.add(jMenuItem9);

      jMenuItem11.setText("Exit");
      jMenu1.add(jMenuItem11);

      jMenuBar1.add(jMenu1);

      jMenu2.setText("Edit");

      jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem10.setText("Undo");
      jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem10ActionPerformed(evt);
         }
      });
      jMenu2.add(jMenuItem10);

      jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem12.setText("Cut");
      jMenu2.add(jMenuItem12);

      jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem13.setText("Copy");
      jMenu2.add(jMenuItem13);

      jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem14.setText("Paste");
      jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem14ActionPerformed(evt);
         }
      });
      jMenu2.add(jMenuItem14);

      jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_DELETE, 0));
      jMenuItem15.setText("Delete");
      jMenu2.add(jMenuItem15);

      jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem16.setText("Find...");
      jMenu2.add(jMenuItem16);

      jMenuItem17.setText("Find Next");
      jMenu2.add(jMenuItem17);

      jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem18.setText("Replace");
      jMenu2.add(jMenuItem18);

      jMenuItem19.setText("Go To...");
      jMenu2.add(jMenuItem19);

      jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
      jMenuItem20.setText("Select All");
      jMenu2.add(jMenuItem20);

      jMenuBar1.add(jMenu2);

      jMenu4.setText("View");

      jMenuItem21.setText("Refresh");
      jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem21ActionPerformed(evt);
         }
      });
      jMenu4.add(jMenuItem21);

      jMenuItem22.setText("Zoom In");
      jMenu4.add(jMenuItem22);

      jMenuItem23.setText("Zoom Out");
      jMenu4.add(jMenuItem23);

      jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
            java.awt.event.KeyEvent.VK_ENTER,
            java.awt.event.InputEvent.ALT_MASK
                  | java.awt.event.InputEvent.SHIFT_MASK));
      jMenuItem24.setText("Enter Fullscreen");
      jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem24ActionPerformed(evt);
         }
      });
      jMenu4.add(jMenuItem24);

      jMenuBar1.add(jMenu4);

      jMenu5.setText("Tests");

      jMenuItem25.setText("Add");
      jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem25ActionPerformed(evt);
         }
      });
      jMenu5.add(jMenuItem25);

      jMenuItem26.setText("Remove");
      jMenu5.add(jMenuItem26);

      jMenuItem27.setText("Edit");
      jMenu5.add(jMenuItem27);

      jMenuItem28.setText("Take");
      jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem28ActionPerformed(evt);
         }
      });
      jMenu5.add(jMenuItem28);

      jMenuItem29.setText("Edit Flags");
      jMenu5.add(jMenuItem29);

      jMenuBar1.add(jMenu5);

      jMenu6.setText("Question");

      jMenuItem30.setText("Add");
      jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem30ActionPerformed(evt);
         }
      });
      jMenu6.add(jMenuItem30);

      jMenuItem31.setText("Remove");
      jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem31ActionPerformed(evt);
         }
      });
      jMenu6.add(jMenuItem31);

      jMenuItem32.setText("Edit");
      jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem32ActionPerformed(evt);
         }
      });
      jMenu6.add(jMenuItem32);

      jMenuBar1.add(jMenu6);

      jMenu7.setText("Admin");

      jMenuItem33.setText("Release Tests");
      jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem33ActionPerformed(evt);
         }
      });
      jMenu7.add(jMenuItem33);

      jMenuItem34.setText("Close Tests");
      jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem34ActionPerformed(evt);
         }
      });
      jMenu7.add(jMenuItem34);

      jMenuItem35.setText("Edit Test Options");
      jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jMenuItem35ActionPerformed(evt);
         }
      });
      jMenu7.add(jMenuItem35);

      jMenuBar1.add(jMenu7);

      jMenu8.setText("Option");
      jMenuBar1.add(jMenu8);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
            getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
            layout.createParallelGroup(
                  javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup()
                              .addContainerGap(319, Short.MAX_VALUE)
                              .addGroup(
                                    layout.createParallelGroup(
                                          javax.swing.GroupLayout.Alignment.LEADING)
                                          .addComponent(
                                                jButton4,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                134,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(
                                                jButton5,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                134,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(
                                                jButton3,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                134,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(
                                                jButton2,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                134,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(
                                                jButton1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                134,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(317, 317, 317))
            );
      layout.setVerticalGroup(
            layout.createParallelGroup(
                  javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(
                        layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jButton1,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                    17, Short.MAX_VALUE)
                              .addComponent(jButton2,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(
                                    javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(jButton3,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(jButton5,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(jButton4,
                                    javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                    javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addContainerGap())
            );

      jButton1.getAccessibleContext().setAccessibleName("Question Bank");

      pack();
   }// </editor-fold>

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
      new QuestionDBFrame();
   }

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
      new TestDatabaseGUI(1, tdb);
   }

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
      new Grading();
   }

   private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {
      // TODO add your handling code here:
   }

   /**
    * @param args
    *           the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      // <editor-fold defaultstate="collapsed"
      // desc=" Look and feel setting code (optional) ">
      /*
       * If Nimbus (introduced in Java SE 6) is not available, stay with the
       * default look and feel. For details see
       * http://download.oracle.com/javase
       * /tutorial/uiswing/lookandfeel/plaf.html
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
               .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(TestGenUI.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(TestGenUI.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(TestGenUI.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(TestGenUI.class.getName()).log(
               java.util.logging.Level.SEVERE, null, ex);
      }
      // </editor-fold>
      /*
       * /* Create and display the form
       */

      java.awt.EventQueue.invokeLater(new Runnable() {

         @Override
         public void run() {
            new TestGenUI().setVisible(true);
         }
      });

   }

   // Variables declaration - do not modify
   private javax.swing.JButton   jButton1;
   private javax.swing.JButton   jButton2;
   private javax.swing.JButton   jButton3;
   private javax.swing.JButton   jButton4;
   private javax.swing.JButton   jButton5;
   private javax.swing.JMenu     jMenu1;
   private javax.swing.JMenu     jMenu2;
   private javax.swing.JMenu     jMenu3;
   private javax.swing.JMenu     jMenu4;
   private javax.swing.JMenu     jMenu5;
   private javax.swing.JMenu     jMenu6;
   private javax.swing.JMenu     jMenu7;
   private javax.swing.JMenu     jMenu8;
   private javax.swing.JMenuBar  jMenuBar1;
   private javax.swing.JMenuItem jMenuItem1;
   private javax.swing.JMenuItem jMenuItem10;
   private javax.swing.JMenuItem jMenuItem11;
   private javax.swing.JMenuItem jMenuItem12;
   private javax.swing.JMenuItem jMenuItem13;
   private javax.swing.JMenuItem jMenuItem14;
   private javax.swing.JMenuItem jMenuItem15;
   private javax.swing.JMenuItem jMenuItem16;
   private javax.swing.JMenuItem jMenuItem17;
   private javax.swing.JMenuItem jMenuItem18;
   private javax.swing.JMenuItem jMenuItem19;
   private javax.swing.JMenuItem jMenuItem2;
   private javax.swing.JMenuItem jMenuItem20;
   private javax.swing.JMenuItem jMenuItem21;
   private javax.swing.JMenuItem jMenuItem22;
   private javax.swing.JMenuItem jMenuItem23;
   private javax.swing.JMenuItem jMenuItem24;
   private javax.swing.JMenuItem jMenuItem25;
   private javax.swing.JMenuItem jMenuItem26;
   private javax.swing.JMenuItem jMenuItem27;
   private javax.swing.JMenuItem jMenuItem28;
   private javax.swing.JMenuItem jMenuItem29;
   private javax.swing.JMenuItem jMenuItem3;
   private javax.swing.JMenuItem jMenuItem30;
   private javax.swing.JMenuItem jMenuItem31;
   private javax.swing.JMenuItem jMenuItem32;
   private javax.swing.JMenuItem jMenuItem33;
   private javax.swing.JMenuItem jMenuItem34;
   private javax.swing.JMenuItem jMenuItem35;
   private javax.swing.JMenuItem jMenuItem4;
   private javax.swing.JMenuItem jMenuItem5;
   private javax.swing.JMenuItem jMenuItem6;
   private javax.swing.JMenuItem jMenuItem7;
   private javax.swing.JMenuItem jMenuItem8;
   private javax.swing.JMenuItem jMenuItem9;
   // End of variables declaration
}

/*
 * ConsolePanel.java
 *
 * Created on June 4, 2008, 4:05 PM
 */

package simx.react.guibase;

/**
 *
 * @author  pstickne
 */
public class ConsolePanel extends javax.swing.JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form ConsolePanel */
    public ConsolePanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        split1 = new javax.swing.JSplitPane();
        scrollOutput = new javax.swing.JScrollPane();
        txtPaneOutput = new javax.swing.JTextPane();
        scrollInput = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnTemplates = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        split1.setDividerLocation(200);
        split1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split1.setResizeWeight(1.0);
        split1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                split1ComponentShown(evt);
            }
        });

        txtPaneOutput.setEditable(false);
        scrollOutput.setViewportView(txtPaneOutput);

        split1.setTopComponent(scrollOutput);

        txtInput.setColumns(20);
        txtInput.setRows(5);
        scrollInput.setViewportView(txtInput);

        split1.setRightComponent(scrollInput);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnPrev.setText("<< Prev");
        btnPrev.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Next >>");
        btnNext.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnTemplates.setText("Templates...");
        btnTemplates.setMargin(new java.awt.Insets(2, 4, 2, 4));
        btnTemplates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemplatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(split1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(btnTemplates)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSend)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(split1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnSend)
                    .addComponent(btnTemplates))
                .addContainerGap())
        );
    }//GEN-END:initComponents

    protected void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        return;
}//GEN-LAST:event_btnSendActionPerformed

    protected void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        return;
}//GEN-LAST:event_btnNextActionPerformed

    private void split1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_split1ComponentShown
        // TODO add your handling code here:
        // PST-- why doesn't this, uhm, "work"?
        split1.setDividerLocation(split1.getHeight() - 40);
    }//GEN-LAST:event_split1ComponentShown

    protected void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        return;
    }//GEN-LAST:event_btnPrevActionPerformed

    protected void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        return;
    }//GEN-LAST:event_formComponentShown

    protected void btnTemplatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemplatesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTemplatesActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnNext;
    public javax.swing.JButton btnPrev;
    public javax.swing.JButton btnSend;
    public javax.swing.JButton btnTemplates;
    private javax.swing.JScrollPane scrollInput;
    private javax.swing.JScrollPane scrollOutput;
    private javax.swing.JSplitPane split1;
    public javax.swing.JTextArea txtInput;
    public javax.swing.JTextPane txtPaneOutput;
    // End of variables declaration//GEN-END:variables
    
}
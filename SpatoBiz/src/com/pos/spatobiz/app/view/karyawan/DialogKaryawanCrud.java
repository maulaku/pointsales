/*
 *  Copyright 2009 Eko Kurniawan Khannedy.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */

/*
 * DialogKaryawanCrud.java
 *
 * Created on 10 Feb 09, 12:10:22
 */
package com.pos.spatobiz.app.view.karyawan;

import com.pos.spatobiz.app.view.ButtonStandard;
import com.pos.spatobiz.common.entity.Karyawan;
import com.pos.spatobiz.common.error.SpatoBizException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author echo
 */
public class DialogKaryawanCrud extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    public static enum Type {

        /**
         * insert proses
         */
        INSERT,
        /**
         * update proses
         */
        UPDATE
    }

    private Type type;

    private Karyawan karyawan;

    /** Creates new form DialogKaryawanCrud
     * @param parent
     * @param modal 
     */
    public DialogKaryawanCrud(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setType(Type.INSERT);

        buttonStandard1.getButtonOK().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    DialogKaryawanCrud.this.karyawan = panelKaryawanCrud1.getKaryawan();
                    setVisible(false);
                } catch (SpatoBizException sbe) {
                    JOptionPane.showMessageDialog(DialogKaryawanCrud.this, sbe.getMessage());
                }
            }
        });
        buttonStandard1.getButtonBatal().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DialogKaryawanCrud.this.karyawan = null;
                setVisible(false);
            }
        });
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Karyawan startDialog(Karyawan karyawan) throws SpatoBizException {
        this.karyawan = new Karyawan();
        setVisible(true);
        return this.karyawan;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelKaryawanCrud1 = new PanelKaryawanCrud();
        buttonStandard1 = new ButtonStandard();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().add(panelKaryawanCrud1, BorderLayout.CENTER);
        getContentPane().add(buttonStandard1, BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DialogKaryawanCrud dialog = new DialogKaryawanCrud(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected ButtonStandard buttonStandard1;
    protected PanelKaryawanCrud panelKaryawanCrud1;
    // End of variables declaration//GEN-END:variables
}

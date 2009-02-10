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
 * ButtonCrud.java
 *
 * Created on 10 Feb 09, 11:42:36
 */
package com.pos.spatobiz.app.view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

/**
 *
 * @author echo
 */
public class ButtonCrud extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    /** Creates new form ButtonCrud */
    public ButtonCrud() {
        initComponents();
    }

    public JButton getButtonHapus() {
        return buttonHapus;
    }

    public JButton getButtonSegarkan() {
        return buttonSegarkan;
    }

    public JButton getButtonTambah() {
        return buttonTambah;
    }

    public JButton getButtonUbah() {
        return buttonUbah;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonTambah = new JButton();
        buttonUbah = new JButton();
        buttonHapus = new JButton();
        buttonSegarkan = new JButton();

        buttonTambah.setText("Tambah");
        add(buttonTambah);

        buttonUbah.setText("Ubah");
        add(buttonUbah);

        buttonHapus.setText("Hapus");
        add(buttonHapus);

        buttonSegarkan.setText("Segarkan");
        add(buttonSegarkan);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected JButton buttonHapus;
    protected JButton buttonSegarkan;
    protected JButton buttonTambah;
    protected JButton buttonUbah;
    // End of variables declaration//GEN-END:variables
}

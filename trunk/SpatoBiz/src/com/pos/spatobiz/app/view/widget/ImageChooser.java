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
 * ImageChooser.java
 *
 * Created on 11 Feb 09, 14:21:37
 */
package com.pos.spatobiz.app.view.widget;

import echo.gokil.desktop.swing.Button;
import echo.gokil.desktop.util.DesktopManager;
import echo.gokil.desktop.util.DesktopUtilities;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import usu.widget.FileBrowserImage;

/**
 *
 * @author echo
 */
public class ImageChooser extends javax.swing.JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JFileChooser fileChooser;

    private ImageIcon image;

    /** Creates new form ImageChooser */
    public ImageChooser() {
        fileChooser = new FileBrowserImage();
        initComponents();
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon object) {
        labelImage.setIcon(object);
        this.image = object;
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        buttonOpen.setEnabled(enabled);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonOpen = new Button();
        scrollPane1 = new ScrollPane();
        labelImage = new JLabel();

        setOpaque(false);

        buttonOpen.setMnemonic('C');
        buttonOpen.setText("Cari");
        buttonOpen.setName("buttonOpen"); // NOI18N
        buttonOpen.addActionListener(this);

        scrollPane1.setName("scrollPane1"); // NOI18N

        labelImage.setHorizontalAlignment(SwingConstants.CENTER);
        labelImage.setName("labelImage"); // NOI18N
        scrollPane1.setViewportView(labelImage);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(buttonOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonOpen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == buttonOpen) {
            ImageChooser.this.buttonOpenActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOpenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        // TODO add your handling code here:
        if (fileChooser.showOpenDialog(DesktopManager.getApplication()) == JFileChooser.APPROVE_OPTION) {
            try {
                image = new ImageIcon(fileChooser.getSelectedFile().toURI().toURL());
                Image img = image.getImage();
                if (img.getWidth(null) > 170 || img.getHeight(null) > 170) {
                    if (img.getWidth(null) > img.getHeight(null)) {
                        img = img.getScaledInstance(170, -1, Image.SCALE_FAST);
                    } else {
                        img = img.getScaledInstance(-1, 170, Image.SCALE_FAST);
                    }
                    image = new ImageIcon(img);
                }
                img = null;
                labelImage.setIcon(image);
            } catch (Exception e) {
                DesktopUtilities.showErrorMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", e.getMessage());
            }
        }
    }//GEN-LAST:event_buttonOpenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected Button buttonOpen;
    protected JLabel labelImage;
    protected ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
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
package com.pos.spatobiz.app.view.widget;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author echo
 */
public class WhiteTextArea extends ScrollPane {

    private static final long serialVersionUID = 1L;

    private JTextArea textArea;

    public WhiteTextArea() {
        textArea = new JTextArea() {

            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                if (!textArea.isEnabled()) {
                    Graphics2D gd = (Graphics2D) g.create();
                    gd.setColor(Color.WHITE);
                    gd.setComposite(AlphaComposite.SrcOver.derive(0.5F));
                    gd.fillRect(0, 0, getWidth(), getHeight());
                }
                super.paintComponent(g);
            }
        };
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(textArea.getFont().deriveFont(Font.BOLD).deriveFont(12F));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        setViewportView(textArea);
    }

    public void setText(String t) {
        textArea.setText(t);
    }

    public String getText() {
        return textArea.getText();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        textArea.setEnabled(enabled);
        textArea.repaint();
    }
}

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

import echo.gokil.desktop.swing.TextBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author echo
 */
public class TextBoxTransfer extends TextBox implements ActionListener, FocusListener {

    private static final long serialVersionUID = 1L;

    public TextBoxTransfer() {
        addActionListener(this);
        addFocusListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        transferFocus();
    }

    public void focusGained(FocusEvent e) {
        selectAll();
    }

    public void focusLost(FocusEvent e) {
    }
}

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
package com.pos.spatobiz.app.controller.karyawan;

import echo.gokil.desktop.util.DesktopManager;
import echo.gokil.desktop.util.DesktopUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author echo
 */
public class BatalTambahKaryawanController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (DesktopUtilities.showConfirmMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", new String[]{
                    "Anda yakin akan membatalkan", "penambahan karyawan ?"
                }) == JOptionPane.OK_OPTION) {
            DesktopManager.getApplication().showChildPane("menuKaryawan");
        }
    }
}

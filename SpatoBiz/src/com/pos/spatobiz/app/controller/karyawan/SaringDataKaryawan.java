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

import com.pos.spatobiz.app.view.karyawan.DataKaryawan;
import echo.gokil.desktop.util.DesktopManager;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author echo
 */
public class SaringDataKaryawan implements DocumentListener {

    public void insertUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void removeUpdate(DocumentEvent e) {
        changedUpdate(e);
    }

    public void changedUpdate(DocumentEvent e) {
        try {
            String filter = e.getDocument().getText(0, e.getDocument().getLength());
            DataKaryawan dataKaryawan = (DataKaryawan) DesktopManager.getPanel("dataKaryawan");
            @SuppressWarnings("unchecked")
            TableRowSorter<TableModel> rowSorter = (TableRowSorter<TableModel>) dataKaryawan.getTable().getTable().getRowSorter();
            rowSorter.setRowFilter(RowFilter.regexFilter(filter));
        } catch (Exception exception) {
        }
    }
}

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

import javax.swing.JTable;

/**
 *
 * @author echo
 */
public class Table extends ScrollPane {

    private static final long serialVersionUID = 1L;

    private JTable table;

    public Table() {
        table = new JTable();
        table.setOpaque(true);
        table.setAutoCreateRowSorter(true);
        setViewportView(table);
    }

    public JTable getTable() {
        return table;
    }
}

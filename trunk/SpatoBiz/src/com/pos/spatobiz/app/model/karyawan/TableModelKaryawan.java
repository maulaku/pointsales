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
package com.pos.spatobiz.app.model.karyawan;

import com.pos.spatobiz.common.entity.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author echo
 */
public class TableModelKaryawan extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Karyawan> karyawans;

    public TableModelKaryawan() {
        setKaryawans(new ArrayList<Karyawan>());
    }

    public void addKaryawan(List<Karyawan> list) {
        int index = getRowCount();
        getKaryawans().addAll(list);
        fireTableRowsInserted(index, getRowCount());
    }

    public List<Karyawan> getKaryawans() {
        return karyawans;
    }

    public void setKaryawans(List<Karyawan> karyawans) {
        this.karyawans = karyawans;
        fireTableDataChanged();
    }

    public void addKaryawan(Karyawan karyawan) {
        int index = getRowCount();
        getKaryawans().add(karyawan);
        fireTableRowsInserted(index, getRowCount());
    }

    public void removeKaryawan(int index) {
        getKaryawans().remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void removeAll() {
        while (getKaryawans().size() > 0) {
            getKaryawans().remove(0);
        }
        fireTableDataChanged();
    }

    public void editKaryawan(Karyawan karyawan, int index) {
        getKaryawans().set(index, karyawan);
        fireTableRowsUpdated(index, index);
    }

    public int getRowCount() {
        return getKaryawans().size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return getKaryawans().get(rowIndex).getKode();
            case 1:
                return getKaryawans().get(rowIndex).getNama();
            case 2:
                return getKaryawans().get(rowIndex).getTanggalLahir();
            case 3:
                return getKaryawans().get(rowIndex).getTelepon();
            case 4:
                return getKaryawans().get(rowIndex).getEmail();
            case 5:
                return getKaryawans().get(rowIndex).getAlamat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Kode";
            case 1:
                return "Nama";
            case 2:
                return "Tanggal Lahir";
            case 3:
                return "Telepon";
            case 4:
                return "Email";
            case 5:
                return "Alamat";
            default:
                return null;
        }
    }
}

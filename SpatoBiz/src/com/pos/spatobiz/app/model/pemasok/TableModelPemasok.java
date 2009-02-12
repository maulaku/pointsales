/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.spatobiz.app.model.pemasok;

import com.pos.spatobiz.common.entity.Pemasok;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * jdk version : jdk 1.6.0_06
 * OS : Ubuntu 8.04 i386
 * email : brain64bit@gmail.com
 * @author agung prasetyo, Planet Earth
 * @date 11 Feb 09
 */
//semua komponen SWING itu udh SErializable
public class TableModelPemasok extends AbstractTableModel
{
    private static final long serialVersionUID = 1L;

    private List<Pemasok> grupPemasok;

    public TableModelPemasok()
    {
        setGrupPemasok(new ArrayList<Pemasok>());
    }

    public List<Pemasok> getGrupPemasok() {
        return grupPemasok;
    }

    public void setGrupPemasok(List<Pemasok> grupPemasok) {
        this.grupPemasok = grupPemasok;
        fireTableDataChanged(); //semua data dlm table berubah
    }

    public void addPemasok(Pemasok pemasok)
    {
        int index = getRowCount();
        getGrupPemasok().add(pemasok);
        fireTableRowsInserted(index, getRowCount());//menginsert antara range index-getrowcount
    }

    public void removePemasok(int index)
    {
        getGrupPemasok().remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void editPemasok(Pemasok pemasok, int index)
    {
        getGrupPemasok().set(index, pemasok);
        fireTableRowsUpdated(index, index);
    }







    public int getRowCount() {
        return getGrupPemasok().size();
    }

    public int getColumnCount() {
        return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0 :
                return getGrupPemasok().get(rowIndex).getKode();
            case 1 :
                return getGrupPemasok().get(rowIndex).getNama();
            case 2 :
                return getGrupPemasok().get(rowIndex).getTelepon();
            case 3 :
                return getGrupPemasok().get(rowIndex).getKontak();
            case 4 :
                return getGrupPemasok().get(rowIndex).getFax();
            case 5 :
                return getGrupPemasok().get(rowIndex).getEmail();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0 : return "Kode";
            case 1 : return "Nama";
            case 2 : return "Telepon";
            case 3 : return "Kontak";
            case 4 : return "Fax";
            case 5 : return "Email";
            default: return null;
        }
    }

}

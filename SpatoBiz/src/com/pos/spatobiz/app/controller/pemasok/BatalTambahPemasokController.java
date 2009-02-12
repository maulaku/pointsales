/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.spatobiz.app.controller.pemasok;

import echo.gokil.desktop.util.DesktopManager;
import echo.gokil.desktop.util.DesktopUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * jdk version : jdk 1.6.0_06
 * OS : Ubuntu 8.04 i386
 * email : brain64bit@gmail.com
 * @author agung prasetyo, Planet Earth
 * @date 12 Feb 09
 */
public class BatalTambahPemasokController implements ActionListener
{

    public void actionPerformed(ActionEvent e) {
        if(DesktopUtilities.showConfirmMessage(DesktopManager.getApplication(), "Spatobiz 1.0", new String[]{
                    "Anda yakin akan membatalkan", "penambahan pemasok ?"
                }) == JOptionPane.OK_OPTION)
        {
            DesktopManager.getApplication().showChildPane("menuPemasok");
        }
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.spatobiz.app.controller.pemasok;

import echo.gokil.desktop.application.Application;
import echo.gokil.desktop.util.DesktopManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * jdk version : jdk 1.6.0_06
 * OS : Ubuntu 8.04 i386
 * email : brain64bit@gmail.com
 * @author agung prasetyo, Planet Earth
 * @date 12 Feb 09
 */
public class TampilkanTambahPemasokAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        Application application = DesktopManager.getApplication();
        application.showChildPane("tambahPemasok");
    }
}

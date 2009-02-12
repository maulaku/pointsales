/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.spatobiz.app.controller.pemasok;

import com.pos.spatobiz.app.util.SpringUtilities;
import com.pos.spatobiz.app.view.pemasok.TambahPemasok;
import com.pos.spatobiz.common.dao.PemasokDao;
import com.pos.spatobiz.common.entity.Pemasok;
import com.pos.spatobiz.common.error.SpatoBizException;
import echo.gokil.desktop.application.Application;
import echo.gokil.desktop.util.DesktopManager;
import echo.gokil.desktop.util.DesktopUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * jdk version : jdk 1.6.0_06
 * OS : Ubuntu 8.04 i386
 * email : brain64bit@gmail.com
 * @author agung prasetyo, Planet Earth
 * @date 12 Feb 09
 */
public class TambahPemasokController implements ActionListener
{

    public void actionPerformed(ActionEvent e) {
        try
        {
        TambahPemasok tambahPemasok = (TambahPemasok) DesktopManager.getPanel("tambahPemasok");
        Pemasok pemasok = tambahPemasok.getPemasok();
        PemasokDao dao = (PemasokDao) SpringUtilities.getApplicationContext().getBean("pemasokDao");
        dao.insertSupplier(pemasok);
        DesktopUtilities.showInfoMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", "Penambahan Pemasok Sukses");
        Application application = DesktopManager.getApplication();
        application.showChildPane("menuPemasok");
        }
        catch (SpatoBizException sbe)
        {
            DesktopUtilities.showErrorMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", sbe.getMessage());
        }

    }

}

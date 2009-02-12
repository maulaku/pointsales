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

import com.pos.spatobiz.app.util.SpringUtilities;
import com.pos.spatobiz.app.view.karyawan.HapusKaryawan;
import com.pos.spatobiz.common.dao.KaryawanDao;
import com.pos.spatobiz.common.entity.Karyawan;
import echo.gokil.desktop.util.DesktopManager;
import echo.gokil.desktop.util.DesktopUtilities;
import echo.gokil.desktop.worker.DesktopWorker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author echo
 */
public class HapusKaryawanController implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        new HapusWorker(true).execute();
    }

    public class HapusWorker extends DesktopWorker<Karyawan, Void> {

        public HapusWorker(boolean blockInput) {
            super(blockInput);
        }

        @Override
        public boolean beforeDone() {
            try {
                Karyawan karyawan = get();
                KaryawanDao karyawanDao = SpringUtilities.getKaryawanDao();
                karyawanDao.deleteKaryawan(karyawan);
                return true;
            } catch (Exception e) {
                DesktopUtilities.showErrorMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", e.getMessage());
                return false;
            }
        }

        @Override
        public void afterDone() {
            DesktopUtilities.showInfoMessage(DesktopManager.getApplication(), "SpatoBiz 1.0", "Penghapusan karyawan berhasil");
            DesktopManager.getApplication().showChildPane("menuKaryawan");
        }

        @Override
        protected Karyawan doInBackground() throws Exception {
            HapusKaryawan hapusKaryawan = (HapusKaryawan) DesktopManager.getPanel("hapusKaryawan");
            Karyawan karyawan = hapusKaryawan.getKaryawan();
            return karyawan;
        }
    }
}

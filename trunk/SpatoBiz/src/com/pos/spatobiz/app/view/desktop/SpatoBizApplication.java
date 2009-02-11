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
package com.pos.spatobiz.app.view.desktop;

import echo.gokil.desktop.application.Application;
import echo.gokil.desktop.util.DesktopUtilities;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author echo
 */
public class SpatoBizApplication extends Application implements ApplicationContextAware {

    private static final long serialVersionUID = 1L;

    private ApplicationContext applicationContext;

    /**
     * create SpatoBiz Application
     */
    public SpatoBizApplication() {
        super();
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    @Override
    public boolean canClose() {
        if (DesktopUtilities.showConfirmMessage(this, getTitle(),
                applicationContext.getMessage("application.close", null, Locale.getDefault())) == JOptionPane.OK_OPTION) {
            return true;
        }
        return false;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();

        setTitle(applicationContext.getMessage("application.title", null, Locale.getDefault()) + " " +
                applicationContext.getMessage("application.version", null, Locale.getDefault()));
    }
}

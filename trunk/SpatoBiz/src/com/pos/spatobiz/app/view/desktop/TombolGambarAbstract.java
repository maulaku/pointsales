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

import com.pos.spatobiz.app.controller.TombolGambarAbstractController;
import echo.gokil.desktop.swing.Button;
import java.util.Locale;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author echo
 */
public class TombolGambarAbstract extends Button implements ApplicationContextAware, InitializingBean {

    private static final long serialVersionUID = 1L;

    private TombolGambarAbstractController tombolGambarAbstractController;

    private ApplicationContext applicationContext;

    public TombolGambarAbstract(TombolGambarAbstractController tombolGambarAbstractController) {
        this.tombolGambarAbstractController = tombolGambarAbstractController;
        addActionListener(tombolGambarAbstractController);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterPropertiesSet() throws Exception {
        setText(applicationContext.getMessage("tombolgambarabstract.text", null, Locale.getDefault()));
    }
}

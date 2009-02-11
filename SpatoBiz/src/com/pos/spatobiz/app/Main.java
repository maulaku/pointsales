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
package com.pos.spatobiz.app;

import com.pos.spatobiz.app.util.SpringUtilities;
import echo.gokil.desktop.application.Application;
import echo.gokil.desktop.util.DesktopManager;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.SplashScreen;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author echo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // change bright color
        DesktopManager.setBrightColor(new Color(141, 223, 0));
        // change dark color
        DesktopManager.setDarkColor(new Color(32, 52, 0));
        // get ApplicationContext
        ApplicationContext applicationContext = SpringUtilities.getApplicationContext();
        // get Application
        Application application = (Application) applicationContext.getBean("application");
        // start Application
        DesktopManager.startApplication(application);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.spatobiz.app.view.pemasok;

import com.pos.spatobiz.app.controller.pemasok.TombolPemasokController;
import echo.gokil.desktop.swing.Button;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * jdk version : jdk 1.6.0_06
 * OS : Ubuntu 8.04 i386
 * email : brain64bit@gmail.com
 * @author agung prasetyo, Planet Earth
 * @date 12 Feb 09
 */
public class TombolPemasok extends Button implements ApplicationContextAware,InitializingBean
{
    private static final long serialVersionUID = 1L;

    private ApplicationContext applicationContext;

    private TombolPemasokController tombolPemasokController;


    public TombolPemasok(TombolPemasokController tombolPemasokController)
    {
        this.tombolPemasokController = tombolPemasokController;
        addActionListener(tombolPemasokController);
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterPropertiesSet() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        setText("Pemasok");
    }

}

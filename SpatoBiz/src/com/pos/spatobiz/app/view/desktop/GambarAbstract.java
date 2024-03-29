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

import echo.gokil.desktop.swing.Panel;
import java.awt.BorderLayout;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author echo
 */
public class GambarAbstract extends Panel implements ApplicationContextAware, InitializingBean {

    private static final long serialVersionUID = 1L;

    private ApplicationContext applicationContext;

    /** Creates new form GambarAbstract */
    public GambarAbstract() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAbstract = new JLabel();

        setLayout(new BorderLayout());

        labelAbstract.setHorizontalAlignment(SwingConstants.CENTER);
        labelAbstract.setIcon(new ImageIcon(getClass().getResource("/com/pos/spatobiz/app/resource/image/abstract.png"))); // NOI18N
        add(labelAbstract, BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected JLabel labelAbstract;
    // End of variables declaration//GEN-END:variables

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterPropertiesSet() throws Exception {
        setTitle(applicationContext.getMessage("gambarabstract.title", null, Locale.getDefault()));
    }
}

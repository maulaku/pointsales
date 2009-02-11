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
package com.pos.spatobiz.app.util;

import com.pos.spatobiz.common.dao.KaryawanDao;
import com.pos.spatobiz.common.dao.PelangganDao;
import com.pos.spatobiz.common.dao.PemasokDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author echo
 */
public class SpringUtilities {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext("com/pos/spatobiz/app/resource/spring/spring.ctx.xml");
        }
        return applicationContext;
    }

    public KaryawanDao getKaryawanDao() {
        return (KaryawanDao) getApplicationContext().getBean("karyawanDao");
    }

    public PelangganDao getPelangganDao() {
        return (PelangganDao) getApplicationContext().getBean("pelangganDao");
    }

    public PemasokDao getPemasokDao() {
        return (PemasokDao) getApplicationContext().getBean("pemasokDao");
    }
}

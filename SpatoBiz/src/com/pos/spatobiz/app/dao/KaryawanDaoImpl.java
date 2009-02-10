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
package com.pos.spatobiz.app.dao;

import com.pos.spatobiz.common.dao.KaryawanDao;
import com.pos.spatobiz.common.error.SpatoBizException;
import com.pos.spatobiz.common.entity.Karyawan;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author echo
 */
public class KaryawanDaoImpl extends HibernateDaoSupport implements KaryawanDao {

    @Transactional(readOnly = false)
    public void insertKaryawan(Karyawan karyawan) throws SpatoBizException {
        try {
            Long id = (Long) getHibernateTemplate().save(karyawan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void updateKaryawan(Karyawan karyawan) throws SpatoBizException {
        try {
            getHibernateTemplate().update(karyawan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deleteKaryawan(Karyawan karyawan) throws SpatoBizException {
        try {
            getHibernateTemplate().delete(karyawan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deleteKaryawan(Long id) throws SpatoBizException {
        try {
            Karyawan karyawan = (Karyawan) getHibernateTemplate().load(Karyawan.class, id);
            getHibernateTemplate().delete(karyawan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Karyawan getKaryawan(final Long id) throws SpatoBizException {
        try {
            return (Karyawan) getHibernateTemplate().execute(new HibernateCallback() {

                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    return session.getNamedQuery("Karyawan.getById").setParameter("id", id).uniqueResult();
                }
            });
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Karyawan> selectKaryawan() throws SpatoBizException {
        try {
            return getHibernateTemplate().loadAll(Karyawan.class);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }
}

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

import com.pos.spatobiz.common.dao.PelangganDao;
import com.pos.spatobiz.common.error.SpatoBizException;
import com.pos.spatobiz.common.entity.Pelanggan;
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
public class PelangganDaoImpl extends HibernateDaoSupport implements PelangganDao {

    @Transactional(readOnly = false)
    public void insertPelanggan(Pelanggan pelanggan) throws SpatoBizException {
        try {
            getHibernateTemplate().save(pelanggan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void updatePelanggan(Pelanggan pelanggan) throws SpatoBizException {
        try {
            getHibernateTemplate().update(pelanggan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deletePelanggan(Pelanggan pelanggan) throws SpatoBizException {
        try {
            getHibernateTemplate().delete(pelanggan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deletePelanggan(Long id) throws SpatoBizException {
        try {
            Pelanggan pelanggan = (Pelanggan) getHibernateTemplate().load(Pelanggan.class, id);
            getHibernateTemplate().delete(pelanggan);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Pelanggan getPelanggan(final Long id) throws SpatoBizException {
        try {
            return (Pelanggan) getHibernateTemplate().execute(new HibernateCallback() {

                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    return session.getNamedQuery("Pelanggan.getById").setParameter("id", id).uniqueResult();
                }
            });
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Pelanggan> selectPelanggan() throws SpatoBizException {
        try {
            return getHibernateTemplate().loadAll(Pelanggan.class);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }
}

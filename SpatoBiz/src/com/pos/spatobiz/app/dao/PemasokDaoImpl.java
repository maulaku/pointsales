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

import com.pos.spatobiz.common.dao.PemasokDao;
import com.pos.spatobiz.common.error.SpatoBizException;
import com.pos.spatobiz.common.entity.Pemasok;
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
public class PemasokDaoImpl extends HibernateDaoSupport implements PemasokDao {

    @Transactional(readOnly = false)
    public void insertSupplier(Pemasok supplier) throws SpatoBizException {
        try {
            Long id = (Long) getHibernateTemplate().save(supplier);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void updateSupplier(Pemasok supplier) throws SpatoBizException {
        try {
            getHibernateTemplate().update(supplier);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deleteSupplier(Pemasok supplier) throws SpatoBizException {
        try {
            getHibernateTemplate().delete(supplier);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = false)
    public void deleteSupplier(Long id) throws SpatoBizException {
        try {
            Pemasok supplier = (Pemasok) getHibernateTemplate().load(Pemasok.class, id);
            getHibernateTemplate().delete(supplier);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Pemasok getSupplier(final Long id) throws SpatoBizException {
        try {
            return (Pemasok) getHibernateTemplate().execute(new HibernateCallback() {

                public Object doInHibernate(Session session) throws HibernateException, SQLException {
                    return session.getNamedQuery("Pemasok.getById").setParameter("id", id).uniqueResult();
                }
            });
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Pemasok> selectSupplier() throws SpatoBizException {
        try {
            return getHibernateTemplate().loadAll(Pemasok.class);
        } catch (Throwable t) {
            throw new SpatoBizException(t.getMessage());
        }
    }
}

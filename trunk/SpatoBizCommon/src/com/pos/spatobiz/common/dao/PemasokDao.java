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
package com.pos.spatobiz.common.dao;

import com.pos.spatobiz.common.error.SpatoBizException;
import com.pos.spatobiz.common.entity.Pemasok;
import java.util.List;

/**
 *
 * @author echo
 */
public interface PemasokDao {

    public void insertSupplier(Pemasok supplier) throws SpatoBizException;

    public void updateSupplier(Pemasok supplier) throws SpatoBizException;

    public void deleteSupplier(Pemasok supplier) throws SpatoBizException;

    public void deleteSupplier(Long id) throws SpatoBizException;

    public Pemasok getSupplier(Long id) throws SpatoBizException;

    public List<Pemasok> selectSupplier() throws SpatoBizException;
}

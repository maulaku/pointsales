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
import com.pos.spatobiz.common.entity.Karyawan;
import java.util.List;

/**
 *
 * @author echo
 */
public interface KaryawanDao {

    public void insertKaryawan(Karyawan karyawan) throws SpatoBizException;

    public void updateKaryawan(Karyawan karyawan) throws SpatoBizException;

    public void deleteKaryawan(Karyawan karyawan) throws SpatoBizException;

    public void deleteKaryawan(Long id) throws SpatoBizException;

    public Karyawan getKaryawan(Long id) throws SpatoBizException;

    public Karyawan getKaryawan(String kode) throws SpatoBizException;

    public List<Karyawan> selectKaryawan() throws SpatoBizException;
}

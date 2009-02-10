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
package com.pos.spatobiz.common.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author echo
 */
@Entity
@Table(name = "tabel_pemasok")
@NamedQueries({
    @NamedQuery(name = "Pemasok.getById", query = "select a from Pemasok a where a.id = :id")
})
@Indexed(index = "pemasok")
public class Pemasok implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pemasok")
    @DocumentId
    private Long id;

    @Field(name = "kode", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "kode_pemasok", unique = true)
    private String kode;

    @Field(name = "nama", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "nama_pemasok", nullable = false)
    private String nama;

    @Field(name = "telepon", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "telepon_pemasok")
    private String telepon;

    @Field(name = "kontak", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "kontak_pemasok")
    private String kontak;

    @Field(name = "fax", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "fax_pemasok")
    private String fax;

    @Field(name = "email", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "email_pemasok")
    private String email;

    public Pemasok() {
    }

    public Pemasok(String kode, String nama, String telepon, String kontak, String fax, String email) {
        this.kode = kode;
        this.nama = nama;
        this.telepon = telepon;
        this.kontak = kontak;
        this.fax = fax;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pemasok other = (Pemasok) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.kode == null) ? (other.kode != null) : !this.kode.equals(other.kode)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if ((this.telepon == null) ? (other.telepon != null) : !this.telepon.equals(other.telepon)) {
            return false;
        }
        if ((this.kontak == null) ? (other.kontak != null) : !this.kontak.equals(other.kontak)) {
            return false;
        }
        if ((this.fax == null) ? (other.fax != null) : !this.fax.equals(other.fax)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.kode != null ? this.kode.hashCode() : 0);
        hash = 89 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 89 * hash + (this.telepon != null ? this.telepon.hashCode() : 0);
        hash = 89 * hash + (this.kontak != null ? this.kontak.hashCode() : 0);
        hash = 89 * hash + (this.fax != null ? this.fax.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }
}

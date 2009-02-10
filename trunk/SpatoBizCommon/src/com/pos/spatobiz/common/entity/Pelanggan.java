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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author echo
 */
@Entity
@Table(name = "tabel_pelanggan")
@NamedQueries({
    @NamedQuery(name = "Pelanggan.getById", query = "select a from Pelanggan a where a.id = :id")
})
@Indexed(index = "pelanggan")
public class Pelanggan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelanggan")
    @DocumentId
    private Long id;

    @Field(name = "nama", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @Column(name = "nama_pelanggan")
    private String nama;

    @Field(name = "tanggal_lahir", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @DateBridge(resolution = Resolution.DAY)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "tanggal_lahir_pelanggan")
    private Date tanggalLahir;

    @Field(name = "alamat", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @Column(name = "alamat_pelanggan")
    private String alamat;

    @Field(name = "telepon", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @Column(name = "telepon_pelanggan")
    private String telepon;

    @Field(name = "email", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @Column(name = "email_pelanggan")
    private String email;

    @Field(name = "status", store = Store.NO, index = org.hibernate.search.annotations.Index.TOKENIZED)
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pelanggan")
    private StatusPelanggan statusPelanggan;

    public Pelanggan() {
    }

    public Pelanggan(String nama, Date tanggalLahir, String alamat, String telepon, String email, StatusPelanggan statusPelanggan) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.statusPelanggan = statusPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public StatusPelanggan getStatusPelanggan() {
        return statusPelanggan;
    }

    public void setStatusPelanggan(StatusPelanggan statusPelanggan) {
        this.statusPelanggan = statusPelanggan;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelanggan other = (Pelanggan) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if (this.tanggalLahir != other.tanggalLahir && (this.tanggalLahir == null || !this.tanggalLahir.equals(other.tanggalLahir))) {
            return false;
        }
        if ((this.alamat == null) ? (other.alamat != null) : !this.alamat.equals(other.alamat)) {
            return false;
        }
        if ((this.telepon == null) ? (other.telepon != null) : !this.telepon.equals(other.telepon)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.statusPelanggan != other.statusPelanggan) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 89 * hash + (this.tanggalLahir != null ? this.tanggalLahir.hashCode() : 0);
        hash = 89 * hash + (this.alamat != null ? this.alamat.hashCode() : 0);
        hash = 89 * hash + (this.telepon != null ? this.telepon.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.statusPelanggan != null ? this.statusPelanggan.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.pos.spatobiz.common.model.Pelanggan[id=" + id + "]";
    }
}

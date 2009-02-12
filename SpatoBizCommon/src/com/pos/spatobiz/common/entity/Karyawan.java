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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.ImageIcon;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author echo
 */
@Entity
@Table(name = "tabel_karyawan")
@NamedQueries({
    @NamedQuery(name = "Karyawan.getById", query = "select a from Karyawan a where a.id = :id"),
    @NamedQuery(name = "Karyawan.getByKode", query = "select a from Karyawan a where a.kode = :kode")
})
@Indexed(index = "karyawan")
public class Karyawan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_karyawan")
    @DocumentId
    private Long id;

    @Field(name = "kode", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "kode_karyawan", unique = true)
    private String kode;

    @Field(name = "nama", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "nama_karyawan")
    private String nama;

    @Field(name = "tanggal_lahir", store = Store.NO, index = Index.TOKENIZED)
    @DateBridge(resolution = Resolution.DAY)
    @Column(name = "tanggal_lahir_karyawan")
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;

    @Field(name = "alamat", store = Store.NO, index = Index.TOKENIZED)
    @Lob
    @Column(name = "alamat_karyawan", columnDefinition = "TEXT")
    private String alamat;

    @Field(name = "telepon", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "telepon_karyawan")
    private String telepon;

    @Field(name = "email", store = Store.NO, index = Index.TOKENIZED)
    @Column(name = "email_karyawan")
    private String email;

    @Lob
    @Column(name = "photo_karyawan", columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private ImageIcon photo;

    @Enumerated(EnumType.STRING)
    @Column(name = "jeni_kelamin_karyawan")
    private JenisKelamin jenisKelamin;

    public Karyawan() {
    }

    public Karyawan(String kode, String nama, Date tanggalLahir, String alamat, String telepon, String email, ImageIcon photo, JenisKelamin jenisKelamin) {
        this.kode = kode;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        this.telepon = telepon;
        this.email = email;
        this.photo = photo;
        this.jenisKelamin = jenisKelamin;
    }

    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Karyawan other = (Karyawan) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.kode == null) ? (other.kode != null) : !this.kode.equals(other.kode)) {
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
        if (this.photo != other.photo && (this.photo == null || !this.photo.equals(other.photo))) {
            return false;
        }
        if (this.jenisKelamin != other.jenisKelamin) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 23 * hash + (this.kode != null ? this.kode.hashCode() : 0);
        hash = 23 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 23 * hash + (this.tanggalLahir != null ? this.tanggalLahir.hashCode() : 0);
        hash = 23 * hash + (this.alamat != null ? this.alamat.hashCode() : 0);
        hash = 23 * hash + (this.telepon != null ? this.telepon.hashCode() : 0);
        hash = 23 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 23 * hash + (this.photo != null ? this.photo.hashCode() : 0);
        hash = 23 * hash + (this.jenisKelamin != null ? this.jenisKelamin.hashCode() : 0);
        return hash;
    }
}

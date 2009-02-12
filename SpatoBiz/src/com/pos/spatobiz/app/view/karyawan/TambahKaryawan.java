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
package com.pos.spatobiz.app.view.karyawan;

import com.pos.spatobiz.app.controller.karyawan.BatalTambahKaryawanController;
import com.pos.spatobiz.app.controller.karyawan.TambahKaryawanController;
import com.pos.spatobiz.app.view.widget.DateBox;
import com.pos.spatobiz.app.view.widget.ImageChooser;
import com.pos.spatobiz.app.view.widget.RedLabel;
import com.pos.spatobiz.app.view.widget.TextBoxTransfer;
import com.pos.spatobiz.app.view.widget.WhiteLabel;
import com.pos.spatobiz.app.view.widget.WhiteTextArea;
import com.pos.spatobiz.common.entity.JenisKelamin;
import com.pos.spatobiz.common.entity.Karyawan;
import com.pos.spatobiz.common.error.SpatoBizException;
import echo.gokil.desktop.swing.Button;
import echo.gokil.desktop.swing.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author echo
 */
public class TambahKaryawan extends Panel implements ApplicationContextAware, InitializingBean {

    private static final long serialVersionUID = 1L;

    private ApplicationContext applicationContext;

    private TambahKaryawanController tambahKaryawanController;

    private BatalTambahKaryawanController batalTambahKaryawanController;

    /** Creates new form TambahKaryawan */
    public TambahKaryawan() {
        initComponents();
    }

    public void setTambahKaryawanController(TambahKaryawanController tambahKaryawanController) {
        this.tambahKaryawanController = tambahKaryawanController;
        buttonTambah.addActionListener(tambahKaryawanController);
    }

    public void setBatalTambahKaryawanController(BatalTambahKaryawanController batalTambahKaryawanController) {
        this.batalTambahKaryawanController = batalTambahKaryawanController;
        buttonBatal.addActionListener(batalTambahKaryawanController);
    }

    public Karyawan getKaryawan() throws SpatoBizException {
        boolean valid = true;

        if (textKode.getText().isEmpty()) {
            errorKode.setText("Kode tidak boleh kosong");
            valid = false;
        } else {
            errorKode.setText("");
        }

        if (textNama.getText().isEmpty()) {
            errorNama.setText("Nama tidak boleh kosong");
            valid = false;
        } else {
            errorNama.setText("");
        }

        if (textAlamat.getText().isEmpty()) {
            errorAlamat.setText("Alamat tidak boleh kosong");
            valid = false;
        } else {
            errorAlamat.setText("");
        }

        if (textEmail.getText().isEmpty()) {
        } else {
            if (textEmail.getText().contains("@") && textEmail.getText().contains(".")) {
                errorEmail.setText("");
            } else {
                errorEmail.setText("Email tidak valid");
                valid = false;
            }
        }
        if (!valid) {
            throw new SpatoBizException("Data karyawan belum lengkap");
        }

        Karyawan karyawan = new Karyawan();
        karyawan.setAlamat(textAlamat.getText());
        karyawan.setEmail(textEmail.getText());
        if (radioPria.isSelected()) {
            karyawan.setJenisKelamin(JenisKelamin.Pria);
        } else {
            karyawan.setJenisKelamin(JenisKelamin.Wanita);
        }
        karyawan.setKode(textKode.getText());
        karyawan.setNama(textNama.getText());
        karyawan.setPhoto(imageChooser.getImage());
        karyawan.setTanggalLahir((Date) textTanggalLahir.getValue());
        karyawan.setTelepon(textTelepon.getText());

        return karyawan;
    }

    @Override
    public void onOpen() throws Exception {
        errorAlamat.setText("Alamat tidak boleh kosong");
        errorEmail.setText("");
        errorKode.setText("Kode tidak boleh kosong");
        errorNama.setText("Nama tidak boleh kosong");
        errorTanggalLahir.setText("");
        errorTelepon.setText("");

        textAlamat.setText("");
        textEmail.setText("");
        textKode.setText("");
        textNama.setText("");
        textTanggalLahir.setValue(new Date());
        textTelepon.setText("");

        imageChooser.setImage(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jeniskelamin = new ButtonGroup();
        labelKode = new WhiteLabel();
        labelNama = new WhiteLabel();
        labelTanggalLahir = new WhiteLabel();
        labelAlamat = new WhiteLabel();
        textKode = new TextBoxTransfer();
        textNama = new TextBoxTransfer();
        textTanggalLahir = new DateBox();
        textAlamat = new WhiteTextArea();
        errorKode = new RedLabel();
        errorNama = new RedLabel();
        errorTanggalLahir = new RedLabel();
        errorAlamat = new RedLabel();
        textTelepon = new TextBoxTransfer();
        labelTelepon = new WhiteLabel();
        labelEmail = new WhiteLabel();
        labelJenisKelamin = new WhiteLabel();
        labelPhoto = new WhiteLabel();
        textEmail = new TextBoxTransfer();
        radioPria = new JRadioButton();
        radioWanita = new JRadioButton();
        errorTelepon = new RedLabel();
        errorEmail = new RedLabel();
        imageChooser = new ImageChooser();
        buttonBatal = new Button();
        buttonTambah = new Button();

        setBackground(new Color(0, 0, 0));

        labelKode.setHorizontalAlignment(SwingConstants.RIGHT);
        labelKode.setText("Kode :");

        labelNama.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNama.setText("Nama :");

        labelTanggalLahir.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTanggalLahir.setText("Tanggal Lahir :");

        labelAlamat.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAlamat.setText("Alamat :");

        textTanggalLahir.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getDateInstance(DateFormat.LONG))));
        textTanggalLahir.setPreferredSize(new Dimension(120, 24));
        textTanggalLahir.setValue(new Date());

        errorKode.setText("error kode");

        errorNama.setText("error nama");

        errorTanggalLahir.setText("error tanggal lahir");

        errorAlamat.setText("error alamat");

        labelTelepon.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTelepon.setText("Telepon :");

        labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        labelEmail.setText("Email :");

        labelJenisKelamin.setHorizontalAlignment(SwingConstants.RIGHT);
        labelJenisKelamin.setText("Jenis Kelamin :");

        labelPhoto.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPhoto.setText("Photo :");

        jeniskelamin.add(radioPria);
        radioPria.setFont(new Font("Tahoma", 1, 11)); // NOI18N
        radioPria.setForeground(new Color(255, 255, 255));
        radioPria.setSelected(true);
        radioPria.setText("Pria");
        radioPria.setOpaque(false);

        jeniskelamin.add(radioWanita);
        radioWanita.setFont(new Font("Tahoma", 1, 11));
        radioWanita.setForeground(new Color(255, 255, 255));
        radioWanita.setText("Wanita");
        radioWanita.setOpaque(false);

        errorTelepon.setText("error telepon");

        errorEmail.setText("error email");

        buttonBatal.setMnemonic('B');
        buttonBatal.setText("Batal");

        buttonTambah.setMnemonic('T');
        buttonTambah.setText("Tambah");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(labelPhoto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelJenisKelamin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
                                .addComponent(labelTelepon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelTanggalLahir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelAlamat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelNama, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelKode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                            .addComponent(textAlamat, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(textNama, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(textTanggalLahir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(textKode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addComponent(textTelepon, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                            .addGroup(Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(radioPria)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(radioWanita))
                            .addComponent(imageChooser, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(errorKode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTanggalLahir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorAlamat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorTelepon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonTambah, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(buttonBatal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(labelKode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textKode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorKode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(labelNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(labelTanggalLahir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTanggalLahir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorTanggalLahir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(labelAlamat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAlamat, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorAlamat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(textTelepon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelepon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorTelepon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(labelEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(labelJenisKelamin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPria)
                    .addComponent(radioWanita))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(labelPhoto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageChooser, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(buttonBatal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTambah, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterPropertiesSet() throws Exception {
        setTitle(applicationContext.getMessage("tambahkaryawan.title", null, Locale.getDefault()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected Button buttonBatal;
    protected Button buttonTambah;
    protected RedLabel errorAlamat;
    protected RedLabel errorEmail;
    protected RedLabel errorKode;
    protected RedLabel errorNama;
    protected RedLabel errorTanggalLahir;
    protected RedLabel errorTelepon;
    protected ImageChooser imageChooser;
    protected ButtonGroup jeniskelamin;
    protected WhiteLabel labelAlamat;
    protected WhiteLabel labelEmail;
    protected WhiteLabel labelJenisKelamin;
    protected WhiteLabel labelKode;
    protected WhiteLabel labelNama;
    protected WhiteLabel labelPhoto;
    protected WhiteLabel labelTanggalLahir;
    protected WhiteLabel labelTelepon;
    protected JRadioButton radioPria;
    protected JRadioButton radioWanita;
    protected WhiteTextArea textAlamat;
    protected TextBoxTransfer textEmail;
    protected TextBoxTransfer textKode;
    protected TextBoxTransfer textNama;
    protected DateBox textTanggalLahir;
    protected TextBoxTransfer textTelepon;
    // End of variables declaration//GEN-END:variables
}

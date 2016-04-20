/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Pelanggan;
import javax.swing.table.DefaultTableModel;
import view.Pelanggan_Tambah;
import view.Pelanggan_Tampil;
import view.Petugas_Tambah;

/**
 *
 * @author Name
 */
public class ControllerPelanggan_Tampil {
   private Pelanggan_Tampil view;
    private Aplikasi model;

    ControllerPelanggan_Tampil(Aplikasi model) {
        DefaultTableModel tabel = (DefaultTableModel) view.getTablePel().getModel();
        tabel.setRowCount(0);
        Pelanggan p = model.getPelanggan(0);
        Object[] o = new Object[]{p.getIdPelanggan(),p.getNama(),p.getJenisKelamin(),p.getAlamat()};
        tabel.addRow(o);
    }
    
    }

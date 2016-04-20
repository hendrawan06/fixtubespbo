/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Pelanggan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Pelanggan_Edit;
import view.Pelanggan_Hapus;

/**
 *
 * @author Name
 */
public class ControllerPelanggan_Hapus implements ActionListener{
    private Aplikasi model;
    private Pelanggan_Hapus view;

    public ControllerPelanggan_Hapus(Aplikasi model) {
        this.model = model;
        view = new Pelanggan_Hapus();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnHapus())) {
            Pelanggan p = model.getPelanggan(Integer.parseInt(view.getIdPelanggan()));
            if (p != null) {
                model.hapusPelanggan(Integer.parseInt(view.getIdPelanggan()));
                new ControllerPelanggan_Tampil(model);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "ID Pelanggan tidak ditemukan");
            }
        }
    }
    
    
}

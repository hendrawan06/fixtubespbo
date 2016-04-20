/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import Model.Pelanggan;
import Model.Petugas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Pelanggan_Hapus;
import view.Petugas_Hapus;

/**
 *
 * @author Name
 */
public class ControllerPetugas_Hapus implements ActionListener{
    private Aplikasi model;
    private Petugas_Hapus view;

    public ControllerPetugas_Hapus(Aplikasi model) {
        this.model = model;
        view = new Petugas_Hapus();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnHapus())) {
            Petugas p = model.getPetugas(Integer.parseInt(view.getIdPetugas()));
            if (p != null) {
                model.hapusPetugas(Integer.parseInt(view.getIdPetugas()));
                new ControllerPetugas_Tampil(model);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "ID Petugas tidak ditemukan");
            }
        }
    }
    
    
}

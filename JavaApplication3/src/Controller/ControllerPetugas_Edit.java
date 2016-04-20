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
import view.Pelanggan_Edit;
import view.Petugas_Edit;

/**
 *
 * @author Name
 */
public class ControllerPetugas_Edit implements ActionListener{
    private Aplikasi model;
    private Petugas_Edit view;

    public ControllerPetugas_Edit(Aplikasi model) {
        this.model = model;
        view = new Petugas_Edit();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String pil = null;
        if (source.equals(view.getBtnCari())) {
            Petugas p = model.getPetugas(Integer.parseInt(view.getIdPetugas()));
            if (p != null) {
                view.getNamapet().setText(p.getNama());
                if (p.getJenisKelamin() == "Laki-laki") {
                    view.getJk1().setSelected(true);
                } else {
                    view.getJk2().setSelected(true);
                }
                view.getAlamatpet().setText(p.getAlamat());
            } else {
                JOptionPane.showMessageDialog(view, "ID Pelanggan tidak ditemukan");
            }
        }
        if (source.equals(view.getBtnAdd())) {
            if (view.getJk1().isSelected()) {
                pil = "Laki - Laki";
            } else if (view.getJk2().isSelected()) {
                pil = "Perempuan";
            }
            Petugas tmpPet = null;
            tmpPet.setNama(view.getNamapet().getText());
            tmpPet.setJenisKelamin(pil);
            tmpPet.setAlamat(view.getAlamatpet().getText());
            tmpPet.setIdPetugas(Integer.parseInt(view.getIdPetugas()));
            
            
            model.updatePetugas(tmpPet);
            new ControllerPelanggan_Tampil(model);
            view.dispose();
        }

    }
}

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

/**
 *
 * @author Name
 */
public class ControllerPelanggan_Edit implements ActionListener {

    private Aplikasi model;
    private Pelanggan_Edit view;

    public ControllerPelanggan_Edit(Aplikasi model) {
        this.model = model;
        view = new Pelanggan_Edit();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String pil = null;
        if (source.equals(view.getBtnCari())) {
            Pelanggan p = model.getPelanggan(Integer.parseInt(view.getIdPelanggan()));
            if (p != null) {
                view.getNamapel().setText(p.getNama());
                if (p.getJenisKelamin() == "Laki-laki") {
                    view.getJk1().setSelected(true);
                } else {
                    view.getJk2().setSelected(true);
                }
                view.getAlamatpel().setText(p.getAlamat());
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
            
            Pelanggan tmpPel = null;
            tmpPel.setNama(view.getNamapel().getText());
            tmpPel.setJenisKelamin(pil);
            tmpPel.setAlamat(view.getAlamatpel().getText());
            tmpPel.setIdPelanggan(Integer.parseInt(view.getIdPelanggan()));
            
            model.updatePelanggan(view.getNama(), view.getAlamat(), pil);
            new ControllerPelanggan_Tampil(model);
            view.dispose();
        }

    }
}
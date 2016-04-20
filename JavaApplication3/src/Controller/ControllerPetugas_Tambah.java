/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Petugas_Tambah;

/**
 *
 * @author Name
 */
public class ControllerPetugas_Tambah implements ActionListener{
    private Aplikasi model;
    private Petugas_Tambah view;
    
    public ControllerPetugas_Tambah(Aplikasi model){
        this.model=model;
        view=new Petugas_Tambah();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        String pil=null;
        if (source.equals(view.getBtnAdd())){
            if(view.getJk1().isSelected()){
                pil = "Laki - Laki";
            } else if (view.getJk2().isSelected()){
                pil="Perempuan";
            }
            model.createPetugas(view.getNama(), view.getAlamat(),pil );
            new ControllerPetugas_Tampil(model);
            view.dispose();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.PaketWisata_Tambah;
import view.Pelanggan_Tambah;

/**
 *
 * @author Name
 */
public class ControllerPaketWisata_Tambah implements ActionListener{
    private Aplikasi model;
    private PaketWisata_Tambah view;
    
    public ControllerPaketWisata_Tambah(Aplikasi model) {
        this.model=model;
        view=new PaketWisata_Tambah();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object source=e.getSource();
       if (source.equals(view.getBtnAdd())){
        new ControllerPaketWisata_Tampil(model);
            view.dispose();}
    }
}

    
   

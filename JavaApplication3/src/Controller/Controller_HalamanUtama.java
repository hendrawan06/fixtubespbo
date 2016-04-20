/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Halaman_Utama;

/**
 *
 * @author Name
 */
public class Controller_HalamanUtama implements ActionListener{
    private Aplikasi model;
    private Halaman_Utama view;
    
    public Controller_HalamanUtama(Aplikasi model){
        this.model=model;
        view=new Halaman_Utama();
        view.setVisible(true);
        view.addListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object source=ae.getSource();
        
        if (source.equals(view.getBtnPetugas())){
            new ControllerPetugas_Tambah(model);
            view.dispose();
        } else if (source.equals(view.getBtnPelanggan())){
            new ControllerPelanggan_Tambah(model);
            view.dispose();
        } else if (source.equals(view.getBtnTempat())){
            new ControllerTempatWisata_Tambah(model);
            view.dispose();
        } else if (source.equals(view.getBtnPaket())){
            new ControllerPaketWisata_Tambah(model);
            view.dispose();
        }else if (source.equals(view.getBtnPerjalanan())){
            new ControllerPerjalanan_Tambah(model);
            view.dispose();}
    }
}
        
        
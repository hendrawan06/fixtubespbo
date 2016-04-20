/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TempatPariwisata_Tambah;

/**
 *
 * @author Name
 */
public class ControllerTempatWisata_Tambah implements ActionListener{
    private Aplikasi model;
    private TempatPariwisata_Tambah view;
    
    public ControllerTempatWisata_Tambah(Aplikasi model){
        this.model=model;
        view=new TempatPariwisata_Tambah();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
  
            model.createTempatWisata(view.getNamatempat(), view.getKotatempat(),view.getProvtempat());
            new ControllerTempatWisata_Tampil(model);
            view.dispose();
        }
    }

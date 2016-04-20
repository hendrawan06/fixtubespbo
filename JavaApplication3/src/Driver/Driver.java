/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Model.Aplikasi;
import Model.PaketWisata;
import Model.Pelanggan;
import Model.TempatWisata;

/**
 *
 * @author MR.SBS
 */

public class Driver {
    public static void main(String[] argh){
        
        Aplikasi model = new Aplikasi();
        
        model.createPelanggan("Budi", "Bojongsoang","Laki");
        model.createPelanggan("Ali", "Dakol","Laki");
        /*
        model.createPetugas("cekidot", "tester", "Perempuan");
        model.createPetugas("SBS","Uhu","laki");
        model.createTempatWisata("CIATER", "Bandung", "Jabar", "Kolam");
        model.createTempatWisata("Pangandaran", "Ciamis", "Jabar", "Pantai");
        TempatWisata wisa= model.getTempatWisata(3);
        model.createPaketWisata(wisa, 100, 90);
        */
        //Pelanggan pel1 = model.getPelanggan(2);
        //PaketWisata pw1 = model.getPaketWisata(1);
        //model.createPerjalanan(pel1, pw1);
        /*
        String[] daftarId = model.getListIdPelanggan();
        for (int i = 0; i < daftarId.length; i++) {
            System.out.println(daftarId[i]);
        } 
        */
        
        // new ControllerLogin(model);
    }
}

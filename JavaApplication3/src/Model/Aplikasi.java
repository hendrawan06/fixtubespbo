/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;


import java.util.ArrayList;

/**
 *
 * @author MR.SBS
 */
public class Aplikasi {
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<TempatWisata> daftarTempatWisata;
    private ArrayList<PaketWisata> daftarPaketWisata;
    private ArrayList<Perjalanan> daftarPerjalanan;
    private Database data;
    
    public Aplikasi() {
        this.daftarPelanggan = new ArrayList<>();
        this.daftarPetugas = new ArrayList<>();
        this.daftarTempatWisata = new ArrayList<>();
        this.data = new Database();
        data.connect();
    }
    
    public int createPelanggan(String nama, String alamat, String jeniskelamin) {
        Pelanggan p = new Pelanggan(nama, alamat,jeniskelamin);
        daftarPelanggan.add(p);
        data.savePelanggan(p);
        return p.getIdPelanggan();
    }
    
    public int createPetugas(String nama, String alamat, String jeniskelamin) {
        Petugas p = new Petugas(nama, alamat,jeniskelamin);
        daftarPetugas.add(p);
        data.savePetugas(p);
        return p.getIdPetugas();
    }
    
    public int createTempatWisata(String nama, String kota, String provinsi){
        TempatWisata tw = new TempatWisata(nama,kota,provinsi);
        daftarTempatWisata.add(tw);
        data.saveTempatWisata(tw);
        return tw.getId();
    }
    
    public Pelanggan getPelanggan(int idP) {
        for (Pelanggan p : daftarPelanggan) {
            if (p.getIdPelanggan() == idP) {
                return p;
            }
        }
        Pelanggan p = data.getPelanggan(idP);
        daftarPelanggan.add(p);
        return p;
    }
    
    public Petugas getPetugas(int idP) {
        for (Petugas p : daftarPetugas) {
            if (p.getIdPetugas() == idP) {
                return p;
            }
        }
        Petugas p = data.getPetugas(idP);
        daftarPetugas.add(p);
        return p;
    }
    
    public TempatWisata getTempatWisata(int idP) {
        for (TempatWisata p : daftarTempatWisata) {
            if (p.getId() == idP) {
                return p;
            }
        }
        TempatWisata p = data.getTempatWisata(idP);
        daftarTempatWisata.add(p);
        return p;
    }
    
    public void updatePelanggan(Pelanggan p) {
        data.updatePelanggan(p);
    }
    
    public void updatePetugas(Petugas p) {
        data.updatePetugas(p);
    }
    
    public void updateTempatWisata(TempatWisata p) {
        data.updateTempatWisata(p);
    }
    
    public String[] getListIdPelanggan() {
        return data.getListIDPelanggan();
    }

    public void updatePelanggan(String nama, String alamat, String pil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

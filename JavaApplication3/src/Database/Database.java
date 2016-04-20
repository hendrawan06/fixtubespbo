/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.PaketWisata;
import Model.Pelanggan;
import Model.Perjalanan;
import Model.Petugas;
import Model.TempatWisata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author MR.SBS
 */
public class Database {
    private String server = "jdbc:mysql://localhost:3306/tubespbo", dbuser = "root", dbpass = "";
    private Statement st;
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(server, dbuser, dbpass);
            st = con.createStatement();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public void savePelanggan(Pelanggan p) {
        try {
            String query = "INSERT INTO `pelanggan`(`nama`, `alamat`, `jeniskelamin`) VALUES ("
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getJenisKelamin() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setIdPelanggan(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void savePetugas(Petugas p) {
        try {
            String query = "INSERT INTO `petugas`(`nama`, `alamat`, `jeniskelamin`) VALUES ("
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getJenisKelamin() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setIdPetugas(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void saveTempatWisata(TempatWisata p) {
        try {
            String query = "INSERT INTO `tempatwisata`(`nama`, `kota`, `provinsi`,`jeniswisata`) VALUES ("
                    + "'" + p.getNama() + "',"
                    + "'" + p.getKota() + "',"
                    + "'" + p.getProvinsi() + "',"
                    + "'" + p.getJenisWisata() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setIdTempatWisata(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void savePaketWisata(PaketWisata p, TempatWisata tw) {
        try {
            String query = "INSERT INTO `paketwisata`(`kapasitas`, `biaya`,`namatempat`,`kota`,`provinsi`) VALUES ("
                    + "'" + p.getKapasitas() + "',"
                    + "'" + p.getBiaya() + "',"
                    + "'" + tw.getNama() + "',"
                    + "'" + tw.getKota() + "',"
                    + "'" + tw.getProvinsi() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setIdPaketWisata(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void savePerjalanan(Perjalanan cek, Pelanggan p, PaketWisata paket) {
        try {
            String query = "INSERT INTO `perjalanan`(`idPelanggan`, `nama`,`alamat`,`jeniskelamin`,`idPaket`,`kapasitas`,`biaya`) VALUES ("
                    + "'" + p.getIdPelanggan() + "',"
                    + "'" + p.getNama() + "',"
                    + "'" + p.getAlamat() + "',"
                    + "'" + p.getJenisKelamin() + "',"
                    + "'" + paket.getId() + "',"
                    + "'" + paket.getKapasitas() + "',"
                    + "'" + paket.getBiaya() + "')";
            st.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            cek.setNomorPerjalanan(generatedId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Pelanggan getPelanggan(int idPelanggan) {
        Pelanggan p = null;
        try {
            String query = "SELECT * FROM `pelanggan` WHERE `idPelanggan` = " + idPelanggan;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Pelanggan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public Petugas getPetugas(int idPetugas) {
        Petugas p = null;
        try {
            String query = "SELECT * FROM `petugas` WHERE `idPetugas` = " + idPetugas;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new Petugas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    
    public TempatWisata getTempatWisata(int idWisata) {
        TempatWisata p = null;
        try {
            String query = "SELECT * FROM `TempatWisata` WHERE `idWisata` = " + idWisata;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new TempatWisata(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public PaketWisata getPaketWisata(int idPaket) {
        PaketWisata p = null;
        try {
            String query = "SELECT * FROM `PaketWisata` WHERE `idPaket` = " + idPaket;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new PaketWisata(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    /*
    public Perjalanan getPerjalanan(int nomorPerjalanan){
        Perjalanan p = null;
        try {
            String query = "SELECT * FROM `Perjalanan` WHERE `nomorperjalanan` = " + nomorPerjalanan;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                p = new PaketWisata(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    */
    
    public void updatePelanggan(Pelanggan p) {
        try {
            String query = "update pelanggan set nama ='"
                    + p.getNama() + "', alamat= '"
                    + p.getAlamat() + "', jeniskelamin= '"
                    + p.getJenisKelamin() + "' where idPelanggan = "
                    + p.getIdPelanggan();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updatePetugas(Petugas p) {
        try {
            String query = "update petugas set nama ='"
                    + p.getNama() + "', alamat= '"
                    + p.getAlamat() + "', jeniskelamin= '"
                    + p.getJenisKelamin() + "' where idPetugas = "
                    + p.getIdPetugas();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateTempatWisata(TempatWisata p) {
        try {
            String query = "update tempatwisata set nama ='"
                    + p.getNama() + "', kota= '"
                    + p.getKota() + "', provinsi= '"
                    + p.getKota() + "', jeniswisata= '"
                    + p.getProvinsi() + "' where idWisata = "
                    + p.getId();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void HapusPelanggan(Pelanggan p) {
        try {
            String query = "delete from `pelanggan` where idPelanggan ='"
                    + p.getIdPelanggan();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void HapusPetugas(Petugas p) {
        try {
            String query = "delete from `petugas` where idPetugas ='"
                    + p.getIdPetugas();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void HapusTempatWisata(TempatWisata p) {
        try {
            String query = "delete from `tempatwisata` where idWisata ='"
                    + p.getId();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //Tinggal perjalanan sama PaketWisata
    public String[] getListIDPelanggan() {
        ArrayList<String> listId = new ArrayList<>();
        try {
            //Query?
            String query = "SELECT idPelanggan FROM `pelanggan`";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                listId.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listId.toArray(new String[0]);
    }
    
}

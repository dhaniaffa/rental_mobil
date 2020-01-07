
package database;
import java.sql.*;
public class Sewa implements TransaksiDatabase{
    String namaKaryawan;
    public void setKaryawan(String nama){
        this.namaKaryawan = nama;
    }
    private String getKaryawan(){
        return this.namaKaryawan;
    }
    
    @Override
    public void transaksibaru(Koneksi k, String jenis, String customer, String tgl_pinjam, String tgl_kembali, String total_hari) {
        Connection koneksi = k.kon;
        try {
            String sqlKar = "select * from karyawan where nama_karyawan='"+getKaryawan()+"'";
            String sqlMob = "select * from mobil where jenis='"+jenis+"'";
            String sqlCus = "select * from customer where nama_customer='"+customer+"'";
            String sqlSew = "insert into sewa(id_karyawan, id_customer, id_mobil, tgl_pinjam, tgl_kembali, total_hari, total_bayar, qty) values (?,?,?,?,?,?,?,?)";
            Statement statek = koneksi.createStatement();
            ResultSet rsk = statek.executeQuery(sqlKar);
            rsk.next();
            Statement statem = koneksi.createStatement();
            ResultSet rsm = statem.executeQuery(sqlMob);
            rsm.next();
            Statement statec = koneksi.createStatement();
            ResultSet rsc = statec.executeQuery(sqlCus);
            rsc.next();
            
            String idKaryawan = rsk.getString("id_karyawan");
            String idCustomer = rsc.getString("id_customer");
            String idMobil = rsm.getString("id_mobil");
            PreparedStatement states = koneksi.prepareStatement(sqlSew);
            states.setString(1, idKaryawan);
            states.setString(2, idCustomer);
            states.setString(3, idMobil);
            states.setString(4, tgl_pinjam);
            states.setString(5, tgl_kembali);
            states.setString(6, total_hari);
            Integer totbayar = Integer.valueOf(total_hari) * Integer.valueOf(rsm.getString("harga"));
            states.setString(7, totbayar.toString());
            states.setString(8, "1");
            states.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("GAGAL");
        }
    }
    
    @Override
    public void hapustransaksi(Koneksi k, String id) {
        String sql = "delete from sewa where id_sewa=?";
        Connection koneksi = k.kon;
        try {
            PreparedStatement state = koneksi.prepareStatement(sql);
            state.setString(1, id);
            int cek = state.executeUpdate();
            if(cek>0){
                System.out.println("Sukses Menghapus Data");
            }else{
                System.out.println("Gagal Menghapus Data");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Gagal Menghapus Data");
        }
    }

}

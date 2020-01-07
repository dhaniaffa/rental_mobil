
package database;
import java.sql.*;
public class Mobil extends MobilDatabase {

    @Override
    public void insert(Koneksi k, String plat, String jenis, String merk, String tahun, String warna, String harga, String stok) {
        Connection koneksi = k.kon;
        String sql = "insert into mobil(no_plat, jenis, merk, tahun, warna, harga, stok) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement state = koneksi.prepareStatement(sql);
            state.setString(1, plat);
            state.setString(2, jenis);
            state.setString(3, merk);
            state.setString(4, tahun);
            state.setString(5, warna);
            state.setString(6, harga);
            state.setString(7, stok);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("Insert Mobil Berhasil");
            }else{
                System.out.println("Insert Mobil Gagal");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Koneksi k, String id, String plat, String jenis, String merk, String tahun, String warna, String harga, String stok) {
        Connection koneksi = k.kon;
        String sql = "update mobil set no_plat=?, jenis=?, merk=?, tahun=?, warna=?, harga=?, stok=? where id_mobil=?";
        try {
            PreparedStatement state = koneksi.prepareCall(sql);
            state.setString(1, plat);
            state.setString(2, jenis);
            state.setString(3, merk);
            state.setString(4, tahun);
            state.setString(5, warna);
            state.setString(6, harga);
            state.setString(7, stok);
            state.setString(8, id);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("Update Data Mobil Berhasil");
            }else{
                System.out.println("Update Data Mobil Gagal");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Koneksi k, String id) {
        Connection koneksi = k.kon;
        String sql = "delete from mobil where id_mobil =?";
        try {
            PreparedStatement state = koneksi.prepareStatement(sql);
            state.setString(1, id);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("Hapus Data Mobil Berhasil");
            }else{
                System.out.println("Hapus Data Mobil Gagal");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void show(Koneksi k) {
        Connection koneksi = k.kon;
        String sql = "select * from mobil";
        try {
            Statement state = koneksi.createStatement();
            ResultSet result = state.executeQuery(sql);
            System.out.println("=================================================================================");
            String header = "%3s %10s %10s %10s %10s %10s %10s %10s";
            System.out.println(String.format(header, "Id", "Plat No", "Jenis", "Merk", "Tahun", "Warna", "Harga", "Stok"));
            System.out.println("---------------------------------------------------------------------------------");
            while(result.next()){
                System.out.println(String.format(header, result.getString("id_mobil"), result.getString("no_plat"), result.getString("jenis"), result.getString("merk"), result.getString("tahun"), result.getString("warna"), result.getString("harga"), result.getString("stok")));
                System.out.println("---------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

}

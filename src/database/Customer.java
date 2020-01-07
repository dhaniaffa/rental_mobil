
package database;
import java.sql.*;
public class Customer extends CustomerDatabase{

    @Override
    public void insert(Koneksi k, String nama, String alamat, String telp) {
        Connection koneksi = k.kon;
        String sql = "insert into customer(nama_customer, alamat, no_tlp) values(?,?,?)";
        try {
            PreparedStatement state = koneksi.prepareStatement(sql);
            state.setString(1, nama);
            state.setString(2, alamat);
            state.setString(3, telp);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("");
                System.out.println("=============================");
                System.out.println("Insert Data Customer Berhasil");
                System.out.println("=============================");
                System.out.println("");
            }else{
                System.out.println("");
                System.out.println("==========================");
                System.out.println("Insert Data Customer Gagal");
                System.out.println("===========================");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Koneksi k, String id, String nama, String alamat, String telp) {
        Connection koneksi = k.kon;
        String sql = "update customer set nama_customer=?, alamat=?, no_tlp=? where id_customer=?";
        try {
            PreparedStatement state = koneksi.prepareCall(sql);
            state.setString(1, nama);
            state.setString(2, alamat);
            state.setString(3, telp);
            state.setString(4, id);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("Update Data Customer Berhasil");
            }else{
                System.out.println("Update Data Customer Gagal");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Koneksi k, String id) {
        Connection koneksi = k.kon;
        String sql = "delete from customer where id_customer =?";
        try {
            PreparedStatement state = koneksi.prepareStatement(sql);
            state.setString(1, id);
            int cek = state.executeUpdate();
            if(cek > 0){
                System.out.println("Hapus Data Customer Berhasil");
            }else{
                System.out.println("Hapus Data Customer Gagal");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void show(Koneksi k) {
        Connection koneksi = k.kon;
        String sql = "select * from customer";
        try {
            Statement state = koneksi.createStatement();
            ResultSet result = state.executeQuery(sql);
            System.out.println("=================================================================================");
            String header = "%3s %10s %30s %20s ";
            System.out.println(String.format(header, "Id", "Nama", "Alamat", "No Telepon"));
            System.out.println("---------------------------------------------------------------------------------");
            while(result.next()){
                System.out.println(String.format(header, result.getString("id_customer"), result.getString("nama_customer"), result.getString("alamat"), result.getString("no_tlp")));
                System.out.println("---------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

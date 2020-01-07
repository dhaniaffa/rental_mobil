
package main;
import database.*;
import java.util.Scanner;
import java.sql.*;
public class Main {
    Koneksi k = new Koneksi("rentalmobil");
    Mobil m = new Mobil();
    Customer c = new Customer();
    Sewa s = new Sewa();
    Scanner in = new Scanner(System.in);
    
    public void login(){
        System.out.println("================");
        System.out.println("Pilih salah satu");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("================");
        System.out.println("Pilih: ");
        int jawab = in.nextInt();
        if(jawab == 1){
            int login = 1;
            while(login == 1){
                System.out.println("");
                System.out.println("-----");
                System.out.println("Login");
                System.out.println("-----");
                System.out.println("Username :");
                String username = in.next();
                System.out.println("Password :");
                String password = in.next();
                k.login(username, password);
                if(k.login==true){
                    login = 0;
                }else if(k.login==false){
                    login();
                }
            }
        }else{
            System.out.println("Register");
            System.out.println("--------");
            System.out.println("Nama :");
            String nama = in.next();
            System.out.println("Username :");
            String username = in.next();
            System.out.println("Password :");
            String password = in.next();
            k.register(username, password, nama);
            login();
        }
    }
    
    public void program(){
        System.out.println("Program Rental Mobil");
        System.out.println("---------------------");
        System.out.println("1. Manajemen Mobil");
        System.out.println("2. Manajemen Customer");
        System.out.println("3. Sewa Mobil");
        System.out.println("---------------------");
        int jawab = in.nextInt();
        if(jawab == 1){
            manajemenmobil();
        }else if(jawab == 2){
            manajemencust();
        }else if(jawab == 3){
            progsewa();
        }else{
            System.out.println("Program exited");
        }
        
    }
    
    private void manajemenmobil(){
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Program Manajemen Mobil");
        System.out.println("-----------------------");
        System.out.println("");
        m.show(k);
        System.out.println("");
        System.out.println("1. Tambah data mobil");
        System.out.println("2. Update data mobil");
        System.out.println("3. Hapus data mobil");
        System.out.println("4. Kembali");
        System.out.println("");
        System.out.println("Pilih: ");
        int jawab = in.nextInt();
        if(jawab == 1){
            System.out.println("Plat Nomor :");
            String plat = in.next();
            System.out.println("Jenis Mobil :");
            String jenis = in.next();
            System.out.println("Merk Mobil :");
            String merk = in.next();
            System.out.println("Tahun Mobil :");
            String tahun = in.next();
            System.out.println("Warna Mobil :");
            String warna = in.next();
            System.out.println("Harga Mobil :");
            String harga = in.next();
            System.out.println("Stok Mobil :");
            String stok = in.next();
            m.insert(k, plat, jenis, merk, tahun, warna, harga, stok);
            manajemenmobil();
        }else if(jawab == 2){
            System.out.println("Id Mobil :");
            String id = in.next();
            System.out.println("Plat Nomor :");
            String plat = in.next();
            System.out.println("Jenis Mobil :");
            String jenis = in.next();
            System.out.println("Merk Mobil :");
            String merk = in.next();
            System.out.println("Tahun Mobil :");
            String tahun = in.next();
            System.out.println("Warna Mobil :");
            String warna = in.next();
            System.out.println("Harga Mobil :");
            String harga = in.next();
            System.out.println("Stok Mobil :");
            String stok = in.next();
            m.update(k, id, plat, jenis, merk, tahun, warna, harga, stok);
            manajemenmobil();
        }else if(jawab == 3){
            System.out.println("Id Mobil :");
            String id = in.next();
            m.delete(k, id);
            manajemenmobil();
        }else{
            program();
            System.out.println("Pilihan Hanya 1 - 3");
        }
    }
    
    private void manajemencust(){
        System.out.println("Program Manajemen Customer");
        System.out.println("--------------------------");
        System.out.println("");
        c.show(k);
        System.out.println("");
        System.out.println("1. Tambah Data Customer");
        System.out.println("2. Update Data Customer");
        System.out.println("3. Hapus Data Customer");
        System.out.println("4. Kembali");
        int jawab = in.nextInt();
        if (jawab == 1){
            System.out.println("Nama Customer :");
            String nama = in.next();
            System.out.println("Alamat Customer :");
            String alamat = in.next();
            System.out.println("Nomor Telepon :");
            String tlp = in.next();
            c.insert(k, nama, alamat, tlp);
            manajemencust();
        }else if(jawab == 2){
            System.out.println("Id Customer :");
            String id = in.next();
            System.out.println("Nama Customer :");
            String nama = in.next();
            System.out.println("Alamat Customer :");
            String alamat = in.next();
            System.out.println("Nomor Telepon :");
            String tlp = in.next();
            c.update(k, id, nama, alamat, tlp);
            manajemencust();
        }else if(jawab == 3){
            System.out.println("Id Customer ");
            String id = in.next();
            c.delete(k, id);
            manajemencust();
        }else{
            program();
        }
    }
    private void progsewa() {
        System.out.println("Perentalan Mobil");
        System.out.println("----------------");
        System.out.println("1. Sewa Baru");
        System.out.println("2. Kembali");
        System.out.println("----------------");
        System.out.println("");
        System.out.println("Pilih : ");
        int jawab = in.nextInt();
        if (jawab == 1){
            boolean ulang = true;
            while (ulang){
                programtampil();
                System.out.println("Nama Karyawan :");
                String nama = in.next();
                s.setKaryawan(nama);
                System.out.println("Jenis Mobil :");
                String jenis = in.next();
                System.out.println("Nama Customer :");
                String customer = in.next();
                System.out.println("Tgl Pinjam :");
                String tgl_pinjam = in.next();
                System.out.println("Tgl Kembali :");
                String tgl_kembali = in.next();
                System.out.println("Total Hari :");
                String total_hari = in.next();
                s.transaksibaru(k, jenis, customer, tgl_pinjam, tgl_kembali, total_hari);
                
                System.out.println("Transaksi lagi? (y/n)");
                String konfirm = in.next();
                if("y".equals(konfirm)){
                    ulang = true;
                }else if("n".equals(konfirm)){
                    cleartmp();
                    ulang = false;
                    progsewa();
                }
            }
        }else if(jawab == 2){
            program();
        }
    }
    private void programtampil(){
        String sql = "SELECT tmp.id_sewa, karyawan.nama_karyawan, customer.nama_customer, mobil.jenis, mobil.no_plat, tmp.tgl_pinjam, tmp.tgl_kembali, tmp.total_hari, tmp.total_bayar FROM (((tmp INNER JOIN mobil ON tmp.id_mobil = mobil.id_mobil) INNER JOIN customer ON tmp.id_customer = customer.id_customer) INNER JOIN karyawan ON tmp.id_karyawan = karyawan.id_karyawan)";
        String tot = "select sum(total_bayar) as 'bayar' from tmp";
        try {
            Connection con = k.kon;
            Statement state = con.createStatement();
            ResultSet result = state.executeQuery(sql);
            Statement statetot = con.createStatement();
            ResultSet resulttot = statetot.executeQuery(tot);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            String header = "%3s %15s %15s %15s %15s %15s %15s %15s %15s";
            System.out.println(String.format(header, "ID", "KARYAWAN", "CUSTOMER", "JENIS MOBIL", "PLAT NO", "TGL PINJAM", "TGL KEMBALI", "TOTAL HARI", "TOTAL BAYAR"));
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
            while(result.next()){
                String id = result.getString("id_sewa");
                String namakaryawan = result.getString("nama_karyawan");
                String namacustomer = result.getString("nama_customer");
                String jenis = result.getString("jenis");
                String plat = result.getString("no_plat");
                String tglpinjam = result.getString("tgl_pinjam");
                String tglkembali = result.getString("tgl_kembali");
                String tothari = result.getString("total_hari");
                String totbayar = result.getString("total_bayar");
                System.out.println(String.format(header, id, namakaryawan, namacustomer, jenis, plat, tglpinjam, tglkembali, tothari, totbayar));
            }
        } catch (Exception e) {
        }
    }
    private void cleartmp(){
        String sql = "delete from tmp";
        try {
            Connection kon = k.kon;
            PreparedStatement state = kon.prepareStatement(sql);
            state.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.login();
        m.program();
    }

    
}

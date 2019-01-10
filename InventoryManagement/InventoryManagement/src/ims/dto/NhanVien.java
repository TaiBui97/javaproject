/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dto;

import java.util.Date;


/**
 *
 * @author agfor
 */
public class NhanVien {
    private String maNhanVien;
    private String soTaiKhoan;
    private String maSoThue;
    private String maQuanHuyen;
    private int dienThoai;
    private int chungMinhThu;
    private Date ngayCap;
    private String maNoiCap;
    private String maNguyenQuan;
    private String maDantoc;
    private String maTonGiao;
    private String thuongTru;
    private String maHoKhau;
    private String tenDem;  
    private String ten;
    private Date ngaySinh;
    private String maNoiSinh;
    private String tamTru;
    private String maQuocTich;
    private String maTinhTrangHonNhan;
    private Date ngayNhapDoan;
    private String chucVuDoan;
    private String noiSinhHoatDoan;
    private Date ngayNhapDang;
    private String chucVuDang;
    private String noiSinhHoatDang;
    private Date ngayNhapNgu;
    private Date ngayXuatNgu;
    private String noiSinhHoat;
    private int diDong;
    private String maVanHoa;
    private String maHocVan;
    private String eMail;
    private String ghiChu;
    private String gioiTinh;
    byte[] imgByte;
    private String img;
    

    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String soTaiKhoan, String maSoThue, String maQuanHuyen, int dienThoai, int chungMinhThu, Date ngayCap, String maNoiCap, String maNguyenQuan, String maDantoc, String maTonGiao, String thuongTru, String maHoKhau, String tenDem, String ten, Date ngaySinh, String maNoiSinh, String tamTru, String maQuocTich, String maTinhTrangHonNhan, Date ngayNhapDoan, String chucVuDoan, String noiSinhHoatDoan, Date ngayNhapDang, String chucVuDang, String noiSinhHoatDang, Date ngayNhapNgu, Date ngayXuatNgu, String noiSinhHoat, int diDong, String maVanHoa, String maHocVan, String eMail, String ghiChu, String gioiTinh, byte[] imgByte, String img) {
        this.maNhanVien = maNhanVien;
        this.soTaiKhoan = soTaiKhoan;
        this.maSoThue = maSoThue;
        this.maQuanHuyen = maQuanHuyen;
        this.dienThoai = dienThoai;
        this.chungMinhThu = chungMinhThu;
        this.ngayCap = ngayCap;
        this.maNoiCap = maNoiCap;
        this.maNguyenQuan = maNguyenQuan;
        this.maDantoc = maDantoc;
        this.maTonGiao = maTonGiao;
        this.thuongTru = thuongTru;
        this.maHoKhau = maHoKhau;
        this.tenDem = tenDem;
        this.ten = ten;
        
        this.ngaySinh = ngaySinh;
        this.maNoiSinh = maNoiSinh;
        this.tamTru = tamTru;
        this.maQuocTich = maQuocTich;
        this.maTinhTrangHonNhan = maTinhTrangHonNhan;
        this.ngayNhapDoan = ngayNhapDoan;
        this.chucVuDoan = chucVuDoan;
        this.noiSinhHoatDoan = noiSinhHoatDoan;
        this.ngayNhapDang = ngayNhapDang;
        this.chucVuDang = chucVuDang;
        this.noiSinhHoatDang = noiSinhHoatDang;
        this.ngayNhapNgu = ngayNhapNgu;
        this.ngayXuatNgu = ngayXuatNgu;
        this.noiSinhHoat = noiSinhHoat;
        this.diDong = diDong;
        this.maVanHoa = maVanHoa;
        this.maHocVan = maHocVan;
        this.eMail = eMail;
        this.ghiChu = ghiChu;
        this.gioiTinh = gioiTinh;
        this.imgByte = imgByte;
        this.img = img;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getMaQuanHuyen() {
        return maQuanHuyen;
    }

    public void setMaQuanHuyen(String maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public int getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }

    public int getChungMinhThu() {
        return chungMinhThu;
    }

    public void setChungMinhThu(int chungMinhThu) {
        this.chungMinhThu = chungMinhThu;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getMaNoiCap() {
        return maNoiCap;
    }

    public void setMaNoiCap(String maNoiCap) {
        this.maNoiCap = maNoiCap;
    }

    public String getMaNguyenQuan() {
        return maNguyenQuan;
    }

    public void setMaNguyenQuan(String maNguyenQuan) {
        this.maNguyenQuan = maNguyenQuan;
    }

    public String getMaDantoc() {
        return maDantoc;
    }

    public void setMaDantoc(String maDantoc) {
        this.maDantoc = maDantoc;
    }

    public String getMaTonGiao() {
        return maTonGiao;
    }

    public void setMaTonGiao(String maTonGiao) {
        this.maTonGiao = maTonGiao;
    }

    public String getThuongTru() {
        return thuongTru;
    }

    public void setThuongTru(String thuongTru) {
        this.thuongTru = thuongTru;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaNoiSinh() {
        return maNoiSinh;
    }

    public void setMaNoiSinh(String maNoiSinh) {
        this.maNoiSinh = maNoiSinh;
    }

    public String getTamTru() {
        return tamTru;
    }

    public void setTamTru(String tamTru) {
        this.tamTru = tamTru;
    }

    public String getMaQuocTich() {
        return maQuocTich;
    }

    public void setMaQuocTich(String maQuocTich) {
        this.maQuocTich = maQuocTich;
    }

    public String getMaTinhTrangHonNhan() {
        return maTinhTrangHonNhan;
    }

    public void setMaTinhTrangHonNhan(String maTinhTrangHonNhan) {
        this.maTinhTrangHonNhan = maTinhTrangHonNhan;
    }

    public Date getNgayNhapDoan() {
        return ngayNhapDoan;
    }

    public void setNgayNhapDoan(Date ngayNhapDoan) {
        this.ngayNhapDoan = ngayNhapDoan;
    }

    public String getChucVuDoan() {
        return chucVuDoan;
    }

    public void setChucVuDoan(String chucVuDoan) {
        this.chucVuDoan = chucVuDoan;
    }

    public String getNoiSinhHoatDoan() {
        return noiSinhHoatDoan;
    }

    public void setNoiSinhHoatDoan(String noiSinhHoatDoan) {
        this.noiSinhHoatDoan = noiSinhHoatDoan;
    }

    public Date getNgayNhapDang() {
        return ngayNhapDang;
    }

    public void setNgayNhapDang(Date ngayNhapDang) {
        this.ngayNhapDang = ngayNhapDang;
    }

    public String getChucVuDang() {
        return chucVuDang;
    }

    public void setChucVuDang(String chucVuDang) {
        this.chucVuDang = chucVuDang;
    }

    public String getNoiSinhHoatDang() {
        return noiSinhHoatDang;
    }

    public void setNoiSinhHoatDang(String noiSinhHoatDang) {
        this.noiSinhHoatDang = noiSinhHoatDang;
    }

    public Date getNgayNhapNgu() {
        return ngayNhapNgu;
    }

    public void setNgayNhapNgu(Date ngayNhapNgu) {
        this.ngayNhapNgu = ngayNhapNgu;
    }

    public Date getNgayXuatNgu() {
        return ngayXuatNgu;
    }

    public void setNgayXuatNgu(Date ngayXuatNgu) {
        this.ngayXuatNgu = ngayXuatNgu;
    }

    public String getNoiSinhHoat() {
        return noiSinhHoat;
    }

    public void setNoiSinhHoat(String noiSinhHoat) {
        this.noiSinhHoat = noiSinhHoat;
    }

    public int getDiDong() {
        return diDong;
    }

    public void setDiDong(int diDong) {
        this.diDong = diDong;
    }

    public String getMaVanHoa() {
        return maVanHoa;
    }

    public void setMaVanHoa(String maVanHoa) {
        this.maVanHoa = maVanHoa;
    }

    public String getMaHocVan() {
        return maHocVan;
    }

    public void setMaHocVan(String maHocVan) {
        this.maHocVan = maHocVan;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

    

    
}

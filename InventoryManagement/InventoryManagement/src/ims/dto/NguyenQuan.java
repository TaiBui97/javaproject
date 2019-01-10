/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.dto;

/**
 *
 * @author agfor
 */
public class NguyenQuan {

    public NguyenQuan() {
    }
    private String nguyenQuan;
    private String maNguyenQuan;

    public NguyenQuan(String nguyenQuan, String maNguyenQuan) {
        this.nguyenQuan = nguyenQuan;
        this.maNguyenQuan = maNguyenQuan;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getMaNguyenQuan() {
        return maNguyenQuan;
    }

    public void setMaNguyenQuan(String maNguyenQuan) {
        this.maNguyenQuan = maNguyenQuan;
    }

}

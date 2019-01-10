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
public class TinhTrangHonNhan {

    public TinhTrangHonNhan() {
    }
    
    private String tinhTrang;
    private String maTinhTrang;

    public TinhTrangHonNhan(String tinhTrang, String maTinhTrang) {
        this.tinhTrang = tinhTrang;
        this.maTinhTrang = maTinhTrang;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaTinhTrang() {
        return maTinhTrang;
    }

    public void setMaTinhTrang(String maTinhTrang) {
        this.maTinhTrang = maTinhTrang;
    }

    
    
    
}

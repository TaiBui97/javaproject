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
public class DanToc {
    private String tenDanToc;
    private String maDanToc;

    public DanToc() {
    }

    public DanToc(String tenDanToc, String maDanToc) {
        this.tenDanToc = tenDanToc;
        this.maDanToc = maDanToc;
    }

    public String getTenDanToc() {
        return tenDanToc;
    }

    public void setTenDanToc(String tenDanToc) {
        this.tenDanToc = tenDanToc;
    }

    public String getMaDanToc() {
        return maDanToc;
    }

    public void setMaDanToc(String maDanToc) {
        this.maDanToc = maDanToc;
    }

    
}

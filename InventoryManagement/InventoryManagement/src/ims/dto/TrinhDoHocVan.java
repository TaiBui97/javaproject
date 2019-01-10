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
public class TrinhDoHocVan {
    private String trinhDoHocVan;
    private String maTrinhDoHocVan;
    

    public TrinhDoHocVan() {
    }

    public TrinhDoHocVan(String trinhDoHocVan, String maTrinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
        this.maTrinhDoHocVan = maTrinhDoHocVan;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getMaTrinhDoHocVan() {
        return maTrinhDoHocVan;
    }

    public void setMaTrinhDoHocVan(String maTrinhDoHocVan) {
        this.maTrinhDoHocVan = maTrinhDoHocVan;
    }

    
    
    
    
}

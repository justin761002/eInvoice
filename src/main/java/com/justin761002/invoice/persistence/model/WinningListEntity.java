package com.justin761002.invoice.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "winning_list", schema = "public", catalog = "dcaui5g0daebb2")
public class WinningListEntity implements Serializable {
    private String invoYm;
    private String superPrizeAmt;
    private String superPrizeNo;
    private String spcPrizeAmt;
    private String spcPrizeNo;
    private String spcPrizeNo2;
    private String spcPrizeNo3;
    private String firstPrizeAmt;
    private String firstPrizeNo1;
    private String firstPrizeNo2;
    private String firstPrizeNo3;
    private String firstPrizeNo4;
    private String firstPrizeNo5;
    private String firstPrizeNo6;
    private String firstPrizeNo7;
    private String firstPrizeNo8;
    private String firstPrizeNo9;
    private String firstPrizeNo10;
    private String secondPrizeAmt;
    private String thirdPrizeAmt;
    private String fourthPrizeAmt;
    private String fifthPrizeAmt;
    private String sixthPrizeAmt;
    private String sixthPrizeNo1;
    private String sixthPrizeNo2;
    private String sixthPrizeNo3;
    private String sixthPrizeNo4;
    private String sixthPrizeNo5;
    private String sixthPrizeNo6;

    @Id
    @Column(name = "invo_ym")
    public String getInvoYm() {
        return invoYm;
    }

    public void setInvoYm(String invoYm) {
        this.invoYm = invoYm;
    }

    @Basic
    @Column(name = "super_prize_amt")
    public String getSuperPrizeAmt() {
        return superPrizeAmt;
    }

    public void setSuperPrizeAmt(String superPrizeAmt) {
        this.superPrizeAmt = superPrizeAmt;
    }

    @Basic
    @Column(name = "super_prize_no")
    public String getSuperPrizeNo() {
        return superPrizeNo;
    }

    public void setSuperPrizeNo(String superPrizeNo) {
        this.superPrizeNo = superPrizeNo;
    }

    @Basic
    @Column(name = "spc_prize_amt")
    public String getSpcPrizeAmt() {
        return spcPrizeAmt;
    }

    public void setSpcPrizeAmt(String spcPrizeAmt) {
        this.spcPrizeAmt = spcPrizeAmt;
    }

    @Basic
    @Column(name = "spc_prize_no")
    public String getSpcPrizeNo() {
        return spcPrizeNo;
    }

    public void setSpcPrizeNo(String spcPrizeNo) {
        this.spcPrizeNo = spcPrizeNo;
    }

    @Basic
    @Column(name = "spc_prize_no2")
    public String getSpcPrizeNo2() {
        return spcPrizeNo2;
    }

    public void setSpcPrizeNo2(String spcPrizeNo2) {
        this.spcPrizeNo2 = spcPrizeNo2;
    }

    @Basic
    @Column(name = "spc_prize_no3")
    public String getSpcPrizeNo3() {
        return spcPrizeNo3;
    }

    public void setSpcPrizeNo3(String spcPrizeNo3) {
        this.spcPrizeNo3 = spcPrizeNo3;
    }

    @Basic
    @Column(name = "first_prize_amt")
    public String getFirstPrizeAmt() {
        return firstPrizeAmt;
    }

    public void setFirstPrizeAmt(String firstPrizeAmt) {
        this.firstPrizeAmt = firstPrizeAmt;
    }

    @Basic
    @Column(name = "first_prize_no1")
    public String getFirstPrizeNo1() {
        return firstPrizeNo1;
    }

    public void setFirstPrizeNo1(String firstPrizeNo1) {
        this.firstPrizeNo1 = firstPrizeNo1;
    }

    @Basic
    @Column(name = "first_prize_no2")
    public String getFirstPrizeNo2() {
        return firstPrizeNo2;
    }

    public void setFirstPrizeNo2(String firstPrizeNo2) {
        this.firstPrizeNo2 = firstPrizeNo2;
    }

    @Basic
    @Column(name = "first_prize_no3")
    public String getFirstPrizeNo3() {
        return firstPrizeNo3;
    }

    public void setFirstPrizeNo3(String firstPrizeNo3) {
        this.firstPrizeNo3 = firstPrizeNo3;
    }

    @Basic
    @Column(name = "first_prize_no4")
    public String getFirstPrizeNo4() {
        return firstPrizeNo4;
    }

    public void setFirstPrizeNo4(String firstPrizeNo4) {
        this.firstPrizeNo4 = firstPrizeNo4;
    }

    @Basic
    @Column(name = "first_prize_no5")
    public String getFirstPrizeNo5() {
        return firstPrizeNo5;
    }

    public void setFirstPrizeNo5(String firstPrizeNo5) {
        this.firstPrizeNo5 = firstPrizeNo5;
    }

    @Basic
    @Column(name = "first_prize_no6")
    public String getFirstPrizeNo6() {
        return firstPrizeNo6;
    }

    public void setFirstPrizeNo6(String firstPrizeNo6) {
        this.firstPrizeNo6 = firstPrizeNo6;
    }

    @Basic
    @Column(name = "first_prize_no7")
    public String getFirstPrizeNo7() {
        return firstPrizeNo7;
    }

    public void setFirstPrizeNo7(String firstPrizeNo7) {
        this.firstPrizeNo7 = firstPrizeNo7;
    }

    @Basic
    @Column(name = "first_prize_no8")
    public String getFirstPrizeNo8() {
        return firstPrizeNo8;
    }

    public void setFirstPrizeNo8(String firstPrizeNo8) {
        this.firstPrizeNo8 = firstPrizeNo8;
    }

    @Basic
    @Column(name = "first_prize_no9")
    public String getFirstPrizeNo9() {
        return firstPrizeNo9;
    }

    public void setFirstPrizeNo9(String firstPrizeNo9) {
        this.firstPrizeNo9 = firstPrizeNo9;
    }

    @Basic
    @Column(name = "first_prize_no10")
    public String getFirstPrizeNo10() {
        return firstPrizeNo10;
    }

    public void setFirstPrizeNo10(String firstPrizeNo10) {
        this.firstPrizeNo10 = firstPrizeNo10;
    }

    @Basic
    @Column(name = "second_prize_amt")
    public String getSecondPrizeAmt() {
        return secondPrizeAmt;
    }

    public void setSecondPrizeAmt(String secondPrizeAmt) {
        this.secondPrizeAmt = secondPrizeAmt;
    }

    @Basic
    @Column(name = "third_prize_amt")
    public String getThirdPrizeAmt() {
        return thirdPrizeAmt;
    }

    public void setThirdPrizeAmt(String thirdPrizeAmt) {
        this.thirdPrizeAmt = thirdPrizeAmt;
    }

    @Basic
    @Column(name = "fourth_prize_amt")
    public String getFourthPrizeAmt() {
        return fourthPrizeAmt;
    }

    public void setFourthPrizeAmt(String fourthPrizeAmt) {
        this.fourthPrizeAmt = fourthPrizeAmt;
    }

    @Basic
    @Column(name = "fifth_prize_amt")
    public String getFifthPrizeAmt() {
        return fifthPrizeAmt;
    }

    public void setFifthPrizeAmt(String fifthPrizeAmt) {
        this.fifthPrizeAmt = fifthPrizeAmt;
    }

    @Basic
    @Column(name = "sixth_prize_amt")
    public String getSixthPrizeAmt() {
        return sixthPrizeAmt;
    }

    public void setSixthPrizeAmt(String sixthPrizeAmt) {
        this.sixthPrizeAmt = sixthPrizeAmt;
    }

    @Basic
    @Column(name = "sixth_prize_no1")
    public String getSixthPrizeNo1() {
        return sixthPrizeNo1;
    }

    public void setSixthPrizeNo1(String sixthPrizeNo1) {
        this.sixthPrizeNo1 = sixthPrizeNo1;
    }

    @Basic
    @Column(name = "sixth_prize_no2")
    public String getSixthPrizeNo2() {
        return sixthPrizeNo2;
    }

    public void setSixthPrizeNo2(String sixthPrizeNo2) {
        this.sixthPrizeNo2 = sixthPrizeNo2;
    }

    @Basic
    @Column(name = "sixth_prize_no3")
    public String getSixthPrizeNo3() {
        return sixthPrizeNo3;
    }

    public void setSixthPrizeNo3(String sixthPrizeNo3) {
        this.sixthPrizeNo3 = sixthPrizeNo3;
    }

    @Basic
    @Column(name = "sixth_prize_no4")
    public String getSixthPrizeNo4() {
        return sixthPrizeNo4;
    }

    public void setSixthPrizeNo4(String sixthPrizeNo4) {
        this.sixthPrizeNo4 = sixthPrizeNo4;
    }

    @Basic
    @Column(name = "sixth_prize_no5")
    public String getSixthPrizeNo5() {
        return sixthPrizeNo5;
    }

    public void setSixthPrizeNo5(String sixthPrizeNo5) {
        this.sixthPrizeNo5 = sixthPrizeNo5;
    }

    @Basic
    @Column(name = "sixth_prize_no6")
    public String getSixthPrizeNo6() {
        return sixthPrizeNo6;
    }

    public void setSixthPrizeNo6(String sixthPrizeNo6) {
        this.sixthPrizeNo6 = sixthPrizeNo6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningListEntity that = (WinningListEntity) o;
        return Objects.equals(invoYm, that.invoYm) && Objects.equals(superPrizeAmt, that.superPrizeAmt) && Objects.equals(superPrizeNo, that.superPrizeNo) && Objects.equals(spcPrizeAmt, that.spcPrizeAmt) && Objects.equals(spcPrizeNo, that.spcPrizeNo) && Objects.equals(spcPrizeNo2, that.spcPrizeNo2) && Objects.equals(spcPrizeNo3, that.spcPrizeNo3) && Objects.equals(firstPrizeAmt, that.firstPrizeAmt) && Objects.equals(firstPrizeNo1, that.firstPrizeNo1) && Objects.equals(firstPrizeNo2, that.firstPrizeNo2) && Objects.equals(firstPrizeNo3, that.firstPrizeNo3) && Objects.equals(firstPrizeNo4, that.firstPrizeNo4) && Objects.equals(firstPrizeNo5, that.firstPrizeNo5) && Objects.equals(firstPrizeNo6, that.firstPrizeNo6) && Objects.equals(firstPrizeNo7, that.firstPrizeNo7) && Objects.equals(firstPrizeNo8, that.firstPrizeNo8) && Objects.equals(firstPrizeNo9, that.firstPrizeNo9) && Objects.equals(firstPrizeNo10, that.firstPrizeNo10) && Objects.equals(secondPrizeAmt, that.secondPrizeAmt) && Objects.equals(thirdPrizeAmt, that.thirdPrizeAmt) && Objects.equals(fourthPrizeAmt, that.fourthPrizeAmt) && Objects.equals(fifthPrizeAmt, that.fifthPrizeAmt) && Objects.equals(sixthPrizeAmt, that.sixthPrizeAmt) && Objects.equals(sixthPrizeNo1, that.sixthPrizeNo1) && Objects.equals(sixthPrizeNo2, that.sixthPrizeNo2) && Objects.equals(sixthPrizeNo3, that.sixthPrizeNo3) && Objects.equals(sixthPrizeNo4, that.sixthPrizeNo4) && Objects.equals(sixthPrizeNo5, that.sixthPrizeNo5) && Objects.equals(sixthPrizeNo6, that.sixthPrizeNo6);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoYm, superPrizeAmt, superPrizeNo, spcPrizeAmt, spcPrizeNo, spcPrizeNo2, spcPrizeNo3, firstPrizeAmt, firstPrizeNo1, firstPrizeNo2, firstPrizeNo3, firstPrizeNo4, firstPrizeNo5, firstPrizeNo6, firstPrizeNo7, firstPrizeNo8, firstPrizeNo9, firstPrizeNo10, secondPrizeAmt, thirdPrizeAmt, fourthPrizeAmt, fifthPrizeAmt, sixthPrizeAmt, sixthPrizeNo1, sixthPrizeNo2, sixthPrizeNo3, sixthPrizeNo4, sixthPrizeNo5, sixthPrizeNo6);
    }
}

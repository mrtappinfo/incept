/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  com.fasterxml.jackson.annotation.JsonPropertyOrder
 */
package com.snaplync.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@JsonInclude(value=JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(value={"recruiterID", "recruiterName", "recruiterCompanyID", "recruiterEmail", "recruiterCompanyName", "recruiterQuality", "recruiterPhoneNo", "recruiterCity", "recruiterState", "recruiterClient1", "recruiterClient2", "recruiterClient3", "recruiterClient4", "recruiterClient5", "isAcceptingEmail", "isAcceptingPhone", "recruiterLinkedInURL", "recruiterCompanyURL", "isVendorRecruiter", "isActive", "isVerified", "recruiterRateMin", "recruiterRateMax", "recruiterIndustry1", "recruiterIndustry2", "recruiterIndustry3", "recruiterIndustry4", "recruiterSkill1", "recruiterSkill2", "recruiterSkill3", "recruiterSkill4", "recruiterSkill5", "recruiterSkill6", "recruiterSkill7", "recruiterSkill8", "recruiterSkill9", "recruiterSkill10", "recruiterRole1", "recruiterRole2", "recruiterRole3", "recruiterRole4", "recruiterRole5", "recruiterOneYearSkill", "recruiterTwoYearSkill", "recruiterThreeYearSkill", "recruiterFourYearSkill", "recruiterFiveYearSkill", "recruiterSixYearSkill", "recruiterSevenYearSkill", "recruiterEightYearSkill", "recruiterNineYearSkill", "recruiterTenYearSkill", "recruiterPostingDate", "recruiterExpirationDate"})
@XmlRootElement
public class RecruiterObject {
    @JsonProperty(value="recruiterID")
    private Integer recruiterID;
    @JsonProperty(value="recruiterName")
    private String recruiterName;
    @JsonProperty(value="recruiterCompanyID")
    private Integer recruiterCompanyID;
    @JsonProperty(value="recruiterEmail")
    private String recruiterEmail;
    @JsonProperty(value="recruiterCompanyName")
    private String recruiterCompanyName;
    @JsonProperty(value="recruiterQuality")
    private Integer recruiterQuality;
    @JsonProperty(value="recruiterPhoneNo")
    private String recruiterPhoneNo;
    @JsonProperty(value="recruiterCity")
    private String recruiterCity;
    @JsonProperty(value="recruiterState")
    private String recruiterState;
    @JsonProperty(value="recruiterClient1")
    private String recruiterClient1;
    @JsonProperty(value="recruiterClient2")
    private String recruiterClient2;
    @JsonProperty(value="recruiterClient3")
    private String recruiterClient3;
    @JsonProperty(value="recruiterClient4")
    private String recruiterClient4;
    @JsonProperty(value="recruiterClient5")
    private String recruiterClient5;
    @JsonProperty(value="isAcceptingEmail")
    private char isAcceptingEmail;
    @JsonProperty(value="isAcceptingPhone")
    private char isAcceptingPhone;
    @JsonProperty(value="recruiterLinkedInURL")
    private String recruiterLinkedInURL;
    @JsonProperty(value="recruiterCompanyURL")
    private String recruiterCompanyURL;
    @JsonProperty(value="isVendorRecruiter")
    private char isVendorRecruiter;
    @JsonProperty(value="isActive")
    private char isActive;
    @JsonProperty(value="isVerified")
    private char isVerified;
    @JsonProperty(value="recruiterRateMin")
    private Integer recruiterRateMin;
    @JsonProperty(value="recruiterRateMax")
    private Integer recruiterRateMax;
    @JsonProperty(value="recruiterIndustry1")
    private String recruiterIndustry1;
    @JsonProperty(value="recruiterIndustry2")
    private String recruiterIndustry2;
    @JsonProperty(value="recruiterIndustry3")
    private String recruiterIndustry3;
    @JsonProperty(value="recruiterIndustry4")
    private String recruiterIndustry4;
    @JsonProperty(value="recruiterSkill1")
    private String recruiterSkill1;
    @JsonProperty(value="recruiterSkill2")
    private String recruiterSkill2;
    @JsonProperty(value="recruiterSkill3")
    private String recruiterSkill3;
    @JsonProperty(value="recruiterSkill4")
    private String recruiterSkill4;
    @JsonProperty(value="recruiterSkill5")
    private String recruiterSkill5;
    @JsonProperty(value="recruiterSkill6")
    private String recruiterSkill6;
    @JsonProperty(value="recruiterSkill7")
    private String recruiterSkill7;
    @JsonProperty(value="recruiterSkill8")
    private String recruiterSkill8;
    @JsonProperty(value="recruiterSkill9")
    private String recruiterSkill9;
    @JsonProperty(value="recruiterSkill10")
    private String recruiterSkill10;
    @JsonProperty(value="recruiterRole1")
    private String recruiterRole1;
    @JsonProperty(value="recruiterRole2")
    private String recruiterRole2;
    @JsonProperty(value="recruiterRole3")
    private String recruiterRole3;
    @JsonProperty(value="recruiterRole4")
    private String recruiterRole4;
    @JsonProperty(value="recruiterRole5")
    private String recruiterRole5;
    @JsonProperty(value="recruiterOneYearSkill")
    private String recruiterOneYearSkill;
    @JsonProperty(value="recruiterTwoYearSkill")
    private String recruiterTwoYearSkill;
    @JsonProperty(value="recruiterThreeYearSkill")
    private String recruiterThreeYearSkill;
    @JsonProperty(value="recruiterFourYearSkill")
    private String recruiterFourYearSkill;
    @JsonProperty(value="recruiterFiveYearSkill")
    private String recruiterFiveYearSkill;
    @JsonProperty(value="recruiterSixYearSkill")
    private String recruiterSixYearSkill;
    @JsonProperty(value="recruiterSevenYearSkill")
    private String recruiterSevenYearSkill;
    @JsonProperty(value="recruiterEightYearSkill")
    private String recruiterEightYearSkill;
    @JsonProperty(value="recruiterNineYearSkill")
    private String recruiterNineYearSkill;
    @JsonProperty(value="recruiterTenYearSkill")
    private String recruiterTenYearSkill;
    @JsonProperty(value="recruiterPostingDate")
    private Date recruiterPostingDate;
    @JsonProperty(value="recruiterExpirationDate")
    private Date recruiterExpirationDate;
    @JsonProperty(value="averageHike")
    private Long averageHike;
    private Map<String, String> recruiterClientMap = new HashMap<String, String>();
    private Map<String, String> recruiterIndustryMap = new HashMap<String, String>();
    private Map<String, String> recruiterSkillsMap = new HashMap<String, String>();
    private Map<String, String> recruiterRolesMap = new HashMap<String, String>();
    private Map<String, String> recDesiredExpSkillsMap = new HashMap<String, String>();

    public Map<String, String> getRecruiterIndustryMap() {
        return this.recruiterIndustryMap;
    }

    public Map<String, String> getRecruiterSkillsMap() {
        return this.recruiterSkillsMap;
    }

    public Map<String, String> getRecruiterRolesMap() {
        return this.recruiterRolesMap;
    }

    @JsonProperty(value="recruiterID")
    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    @JsonProperty(value="recruiterID")
    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }

    @JsonProperty(value="recruiterName")
    public String getRecruiterName() {
        return this.recruiterName;
    }

    @JsonProperty(value="recruiterName")
    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    @JsonProperty(value="recruiterCompanyID")
    public Integer getRecruiterCompanyID() {
        return this.recruiterCompanyID;
    }

    @JsonProperty(value="recruiterCompanyID")
    public void setRecruiterCompanyID(Integer recruiterCompanyID) {
        this.recruiterCompanyID = recruiterCompanyID;
    }

    @JsonProperty(value="recruiterEmail")
    public String getRecruiterEmail() {
        return this.recruiterEmail;
    }

    @JsonProperty(value="recruiterEmail")
    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    @JsonProperty(value="recruiterCompanyName")
    public String getRecruiterCompanyName() {
        return this.recruiterCompanyName;
    }

    @JsonProperty(value="recruiterCompanyName")
    public void setRecruiterCompanyName(String recruiterCompanyName) {
        this.recruiterCompanyName = recruiterCompanyName;
    }

    @JsonProperty(value="recruiterQuality")
    public Integer getRecruiterQuality() {
        return this.recruiterQuality;
    }

    @JsonProperty(value="recruiterQuality")
    public void setRecruiterQuality(Integer recruiterQuality) {
        this.recruiterQuality = recruiterQuality;
    }

    @JsonProperty(value="recruiterPhoneNo")
    public String getRecruiterPhoneNo() {
        return this.recruiterPhoneNo;
    }

    @JsonProperty(value="recruiterPhoneNo")
    public void setRecruiterPhoneNo(String recruiterPhoneNo) {
        this.recruiterPhoneNo = recruiterPhoneNo;
    }

    @JsonProperty(value="recruiterCity")
    public String getRecruiterCity() {
        return this.recruiterCity;
    }

    @JsonProperty(value="recruiterCity")
    public void setRecruiterCity(String recruiterCity) {
        this.recruiterCity = recruiterCity;
    }

    @JsonProperty(value="recruiterState")
    public String getRecruiterState() {
        return this.recruiterState;
    }

    @JsonProperty(value="recruiterState")
    public void setRecruiterState(String recruiterState) {
        this.recruiterState = recruiterState;
    }

    @JsonProperty(value="recruiterClient1")
    public String getRecruiterClient1() {
        return this.recruiterClient1;
    }

    @JsonProperty(value="recruiterClient1")
    public void setRecruiterClient1(String recruiterClient1) {
        this.recruiterClient1 = recruiterClient1;
        this.recruiterClientMap.put("recruiterClient1", recruiterClient1);
    }

    @JsonProperty(value="recruiterClient2")
    public String getRecruiterClient2() {
        return this.recruiterClient2;
    }

    @JsonProperty(value="recruiterClient2")
    public void setRecruiterClient2(String recruiterClient2) {
        this.recruiterClient2 = recruiterClient2;
        this.recruiterClientMap.put("recruiterClient2", recruiterClient2);
    }

    @JsonProperty(value="recruiterClient3")
    public String getRecruiterClient3() {
        return this.recruiterClient3;
    }

    @JsonProperty(value="recruiterClient3")
    public void setRecruiterClient3(String recruiterClient3) {
        this.recruiterClient3 = recruiterClient3;
        this.recruiterClientMap.put("recruiterClient3", recruiterClient3);
    }

    @JsonProperty(value="recruiterClient4")
    public String getRecruiterClient4() {
        return this.recruiterClient4;
    }

    @JsonProperty(value="recruiterClient4")
    public void setRecruiterClient4(String recruiterClient4) {
        this.recruiterClient4 = recruiterClient4;
        this.recruiterClientMap.put("recruiterClient4", recruiterClient4);
    }

    @JsonProperty(value="recruiterClient5")
    public String getRecruiterClient5() {
        return this.recruiterClient5;
    }

    @JsonProperty(value="recruiterClient5")
    public void setRecruiterClient5(String recruiterClient5) {
        this.recruiterClient5 = recruiterClient5;
        this.recruiterClientMap.put("recruiterClient5", recruiterClient5);
    }

    @JsonProperty(value="isAcceptingEmail")
    public char getIsAcceptingEmail() {
        return this.isAcceptingEmail;
    }

    @JsonProperty(value="isAcceptingEmail")
    public void setIsAcceptingEmail(char isAcceptingEmail) {
        this.isAcceptingEmail = isAcceptingEmail;
    }

    @JsonProperty(value="isAcceptingPhone")
    public char getIsAcceptingPhone() {
        return this.isAcceptingPhone;
    }

    @JsonProperty(value="isAcceptingPhone")
    public void setIsAcceptingPhone(char isAcceptingPhone) {
        this.isAcceptingPhone = isAcceptingPhone;
    }

    @JsonProperty(value="recruiterLinkedInURL")
    public String getRecruiterLinkedInURL() {
        return this.recruiterLinkedInURL;
    }

    @JsonProperty(value="recruiterLinkedInURL")
    public void setRecruiterLinkedInURL(String recruiterLinkedInURL) {
        this.recruiterLinkedInURL = recruiterLinkedInURL;
    }

    @JsonProperty(value="recruiterCompanyURL")
    public String getRecruiterCompanyURL() {
        return this.recruiterCompanyURL;
    }

    @JsonProperty(value="recruiterCompanyURL")
    public void setRecruiterCompanyURL(String recruiterCompanyURL) {
        this.recruiterCompanyURL = recruiterCompanyURL;
    }

    @JsonProperty(value="isVendorRecruiter")
    public char getIsVendorRecruiter() {
        return this.isVendorRecruiter;
    }

    @JsonProperty(value="isVendorRecruiter")
    public void setIsVendorRecruiter(char isVendorRecruiter) {
        this.isVendorRecruiter = isVendorRecruiter;
    }

    @JsonProperty(value="isActive")
    public char getIsActive() {
        return this.isActive;
    }

    @JsonProperty(value="isActive")
    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    @JsonProperty(value="isVerified")
    public char getIsVerified() {
        return this.isVerified;
    }

    @JsonProperty(value="isVerified")
    public void setIsVerified(char isVerified) {
        this.isVerified = isVerified;
    }

    @JsonProperty(value="recruiterRateMin")
    public Integer getRecruiterRateMin() {
        return this.recruiterRateMin;
    }

    @JsonProperty(value="recruiterRateMin")
    public void setRecruiterRateMin(Integer recruiterRateMin) {
        this.recruiterRateMin = recruiterRateMin;
    }

    @JsonProperty(value="recruiterRateMax")
    public Integer getRecruiterRateMax() {
        return this.recruiterRateMax;
    }

    @JsonProperty(value="recruiterRateMax")
    public void setRecruiterRateMax(Integer recruiterRateMax) {
        this.recruiterRateMax = recruiterRateMax;
    }

    @JsonProperty(value="recruiterIndustry1")
    public String getRecruiterIndustry1() {
        return this.recruiterIndustry1;
    }

    @JsonProperty(value="recruiterIndustry1")
    public void setRecruiterIndustry1(String recruiterIndustry1) {
        this.recruiterIndustry1 = recruiterIndustry1;
        this.recruiterIndustryMap.put("recruiterIndustry1", recruiterIndustry1);
    }

    @JsonProperty(value="recruiterIndustry2")
    public String getRecruiterIndustry2() {
        return this.recruiterIndustry2;
    }

    @JsonProperty(value="recruiterIndustry2")
    public void setRecruiterIndustry2(String recruiterIndustry2) {
        this.recruiterIndustry2 = recruiterIndustry2;
        this.recruiterIndustryMap.put("recruiterIndustry2", recruiterIndustry2);
    }

    @JsonProperty(value="recruiterIndustry3")
    public String getRecruiterIndustry3() {
        return this.recruiterIndustry3;
    }

    @JsonProperty(value="recruiterIndustry3")
    public void setRecruiterIndustry3(String recruiterIndustry3) {
        this.recruiterIndustry3 = recruiterIndustry3;
        this.recruiterIndustryMap.put("recruiterIndustry3", recruiterIndustry3);
    }

    @JsonProperty(value="recruiterIndustry4")
    public String getRecruiterIndustry4() {
        return this.recruiterIndustry4;
    }

    @JsonProperty(value="recruiterIndustry4")
    public void setRecruiterIndustry4(String recruiterIndustry4) {
        this.recruiterIndustry4 = recruiterIndustry4;
        this.recruiterIndustryMap.put("recruiterIndustry4", recruiterIndustry4);
    }

    @JsonProperty(value="recruiterSkill1")
    public String getRecruiterSkill1() {
        return this.recruiterSkill1;
    }

    @JsonProperty(value="recruiterSkill1")
    public void setRecruiterSkill1(String recruiterSkill1) {
        this.recruiterSkill1 = recruiterSkill1;
        this.recruiterSkillsMap.put("recruiterSkill1", recruiterSkill1);
    }

    @JsonProperty(value="recruiterSkill2")
    public String getRecruiterSkill2() {
        return this.recruiterSkill2;
    }

    @JsonProperty(value="recruiterSkill2")
    public void setRecruiterSkill2(String recruiterSkill2) {
        this.recruiterSkill2 = recruiterSkill2;
        this.recruiterSkillsMap.put("recruiterSkill2", recruiterSkill2);
    }

    @JsonProperty(value="recruiterSkill3")
    public String getRecruiterSkill3() {
        return this.recruiterSkill3;
    }

    @JsonProperty(value="recruiterSkill3")
    public void setRecruiterSkill3(String recruiterSkill3) {
        this.recruiterSkill3 = recruiterSkill3;
        this.recruiterSkillsMap.put("recruiterSkill3", recruiterSkill3);
    }

    @JsonProperty(value="recruiterSkill4")
    public String getRecruiterSkill4() {
        return this.recruiterSkill4;
    }

    @JsonProperty(value="recruiterSkill4")
    public void setRecruiterSkill4(String recruiterSkill4) {
        this.recruiterSkill4 = recruiterSkill4;
        this.recruiterSkillsMap.put("recruiterSkill4", recruiterSkill4);
    }

    @JsonProperty(value="recruiterSkill5")
    public String getRecruiterSkill5() {
        return this.recruiterSkill5;
    }

    @JsonProperty(value="recruiterSkill5")
    public void setRecruiterSkill5(String recruiterSkill5) {
        this.recruiterSkill5 = recruiterSkill5;
        this.recruiterSkillsMap.put("recruiterSkill5", recruiterSkill5);
    }

    @JsonProperty(value="recruiterSkill6")
    public String getRecruiterSkill6() {
        return this.recruiterSkill6;
    }

    @JsonProperty(value="recruiterSkill6")
    public void setRecruiterSkill6(String recruiterSkill6) {
        this.recruiterSkill6 = recruiterSkill6;
        this.recruiterSkillsMap.put("recruiterSkill6", recruiterSkill6);
    }

    @JsonProperty(value="recruiterSkill7")
    public String getRecruiterSkill7() {
        return this.recruiterSkill7;
    }

    @JsonProperty(value="recruiterSkill7")
    public void setRecruiterSkill7(String recruiterSkill7) {
        this.recruiterSkill7 = recruiterSkill7;
        this.recruiterSkillsMap.put("recruiterSkill7", recruiterSkill7);
    }

    @JsonProperty(value="recruiterSkill8")
    public String getRecruiterSkill8() {
        return this.recruiterSkill8;
    }

    @JsonProperty(value="recruiterSkill8")
    public void setRecruiterSkill8(String recruiterSkill8) {
        this.recruiterSkill8 = recruiterSkill8;
        this.recruiterSkillsMap.put("recruiterSkill8", recruiterSkill8);
    }

    @JsonProperty(value="recruiterSkill9")
    public String getRecruiterSkill9() {
        return this.recruiterSkill9;
    }

    @JsonProperty(value="recruiterSkill9")
    public void setRecruiterSkill9(String recruiterSkill9) {
        this.recruiterSkill9 = recruiterSkill9;
        this.recruiterSkillsMap.put("recruiterSkill9", recruiterSkill9);
    }

    @JsonProperty(value="recruiterSkill10")
    public String getRecruiterSkill10() {
        return this.recruiterSkill10;
    }

    @JsonProperty(value="recruiterSkill10")
    public void setRecruiterSkill10(String recruiterSkill10) {
        this.recruiterSkill10 = recruiterSkill10;
        this.recruiterSkillsMap.put("recruiterSkill10", recruiterSkill10);
    }

    @JsonProperty(value="recruiterRole1")
    public String getRecruiterRole1() {
        return this.recruiterRole1;
    }

    @JsonProperty(value="recruiterRole1")
    public void setRecruiterRole1(String recruiterRole1) {
        this.recruiterRole1 = recruiterRole1;
        this.recruiterRolesMap.put("recruiterRole1", recruiterRole1);
    }

    @JsonProperty(value="recruiterRole2")
    public String getRecruiterRole2() {
        return this.recruiterRole2;
    }

    @JsonProperty(value="recruiterRole2")
    public void setRecruiterRole2(String recruiterRole2) {
        this.recruiterRole2 = recruiterRole2;
        this.recruiterRolesMap.put("recruiterRole2", recruiterRole2);
    }

    @JsonProperty(value="recruiterRole3")
    public String getRecruiterRole3() {
        return this.recruiterRole3;
    }

    @JsonProperty(value="recruiterRole3")
    public void setRecruiterRole3(String recruiterRole3) {
        this.recruiterRole3 = recruiterRole3;
        this.recruiterRolesMap.put("recruiterRole3", recruiterRole3);
    }

    @JsonProperty(value="recruiterRole4")
    public String getRecruiterRole4() {
        return this.recruiterRole4;
    }

    @JsonProperty(value="recruiterRole4")
    public void setRecruiterRole4(String recruiterRole4) {
        this.recruiterRole4 = recruiterRole4;
        this.recruiterRolesMap.put("recruiterRole4", recruiterRole4);
    }

    @JsonProperty(value="recruiterRole5")
    public String getRecruiterRole5() {
        return this.recruiterRole5;
    }

    @JsonProperty(value="recruiterRole5")
    public void setRecruiterRole5(String recruiterRole5) {
        this.recruiterRole5 = recruiterRole5;
        this.recruiterRolesMap.put("recruiterRole5", recruiterRole5);
    }

    @JsonProperty(value="recruiterOneYearSkill")
    public String getRecruiterOneYearSkill() {
        return this.recruiterOneYearSkill;
    }

    @JsonProperty(value="recruiterOneYearSkill")
    public void setRecruiterOneYearSkill(String recruiterOneYearSkill) {
        this.recruiterOneYearSkill = recruiterOneYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill1", recruiterOneYearSkill);
    }

    @JsonProperty(value="recruiterTwoYearSkill")
    public String getRecruiterTwoYearSkill() {
        return this.recruiterTwoYearSkill;
    }

    @JsonProperty(value="recruiterTwoYearSkill")
    public void setRecruiterTwoYearSkill(String recruiterTwoYearSkill) {
        this.recruiterTwoYearSkill = recruiterTwoYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill2", recruiterTwoYearSkill);
    }

    @JsonProperty(value="recruiterThreeYearSkill")
    public String getRecruiterThreeYearSkill() {
        return this.recruiterThreeYearSkill;
    }

    @JsonProperty(value="recruiterThreeYearSkill")
    public void setRecruiterThreeYearSkill(String recruiterThreeYearSkill) {
        this.recruiterThreeYearSkill = recruiterThreeYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill3", recruiterThreeYearSkill);
    }

    @JsonProperty(value="recruiterFourYearSkill")
    public String getRecruiterFourYearSkill() {
        return this.recruiterFourYearSkill;
    }

    @JsonProperty(value="recruiterFourYearSkill")
    public void setRecruiterFourYearSkill(String recruiterFourYearSkill) {
        this.recruiterFourYearSkill = recruiterFourYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill4", recruiterFourYearSkill);
    }

    @JsonProperty(value="recruiterFiveYearSkill")
    public String getRecruiterFiveYearSkill() {
        return this.recruiterFiveYearSkill;
    }

    @JsonProperty(value="recruiterFiveYearSkill")
    public void setRecruiterFiveYearSkill(String recruiterFiveYearSkill) {
        this.recruiterFiveYearSkill = recruiterFiveYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill5", recruiterFiveYearSkill);
    }

    @JsonProperty(value="recruiterSixYearSkill")
    public String getRecruiterSixYearSkill() {
        return this.recruiterSixYearSkill;
    }

    @JsonProperty(value="recruiterSixYearSkill")
    public void setRecruiterSixYearSkill(String recruiterSixYearSkill) {
        this.recruiterSixYearSkill = recruiterSixYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill6", recruiterSixYearSkill);
    }

    @JsonProperty(value="recruiterSevenYearSkill")
    public String getRecruiterSevenYearSkill() {
        return this.recruiterSevenYearSkill;
    }

    @JsonProperty(value="recruiterSevenYearSkill")
    public void setRecruiterSevenYearSkill(String recruiterSevenYearSkill) {
        this.recruiterSevenYearSkill = recruiterSevenYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill7", recruiterSevenYearSkill);
    }

    @JsonProperty(value="recruiterEightYearSkill")
    public String getRecruiterEightYearSkill() {
        return this.recruiterEightYearSkill;
    }

    @JsonProperty(value="recruiterEightYearSkill")
    public void setRecruiterEightYearSkill(String recruiterEightYearSkill) {
        this.recruiterEightYearSkill = recruiterEightYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill8", recruiterEightYearSkill);
    }

    @JsonProperty(value="recruiterNineYearSkill")
    public String getRecruiterNineYearSkill() {
        return this.recruiterNineYearSkill;
    }

    @JsonProperty(value="recruiterNineYearSkill")
    public void setRecruiterNineYearSkill(String recruiterNineYearSkill) {
        this.recruiterNineYearSkill = recruiterNineYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill9", recruiterNineYearSkill);
    }

    @JsonProperty(value="recruiterTenYearSkill")
    public String getRecruiterTenYearSkill() {
        return this.recruiterTenYearSkill;
    }

    @JsonProperty(value="recruiterTenYearSkill")
    public void setRecruiterTenYearSkill(String recruiterTenYearSkill) {
        this.recruiterTenYearSkill = recruiterTenYearSkill;
        this.recDesiredExpSkillsMap.put("recDesiredExpSkill10", recruiterTenYearSkill);
    }

    @JsonProperty(value="recruiterPostingDate")
    public Date getRecruiterPostingDate() {
        return this.recruiterPostingDate;
    }

    @JsonProperty(value="recruiterPostingDate")
    public void setRecruiterPostingDate(Date recruiterPostingDate) {
        this.recruiterPostingDate = recruiterPostingDate;
    }

    @JsonProperty(value="recruiterExpirationDate")
    public Date getRecruiterExpirationDate() {
        return this.recruiterExpirationDate;
    }

    @JsonProperty(value="recruiterExpirationDate")
    public void setRecruiterExpirationDate(Date recruiterExpirationDate) {
        this.recruiterExpirationDate = recruiterExpirationDate;
    }

    public Map<String, String> getRecruiterClientMap() {
        return this.recruiterClientMap;
    }

    public void setRecruiterClientMap(Map<String, String> recruiterClientMap) {
        this.recruiterClientMap = recruiterClientMap;
    }

    public Map<String, String> getRecDesiredExpSkillsMap() {
        return this.recDesiredExpSkillsMap;
    }

    public void setRecDesiredExpSkillsMap(Map<String, String> recDesiredExpSkillsMap) {
        this.recDesiredExpSkillsMap = recDesiredExpSkillsMap;
    }

    public Long getAverageHike() {
        return this.averageHike;
    }

    public void setAverageHike(Long averageHike) {
        this.averageHike = averageHike;
    }
}

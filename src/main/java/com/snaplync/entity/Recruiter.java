/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 */
package com.snaplync.entity;

import com.snaplync.entity.Company;
import com.snaplync.entity.RecruiterClient;
import com.snaplync.entity.RecruiterInfoDates;
import com.snaplync.entity.RecruiterJobIndustry;
import com.snaplync.entity.RecruiterQuality;
import com.snaplync.entity.RecruiterRateRange;
import com.snaplync.entity.RecruiterRole;
import com.snaplync.entity.RecruiterSkills;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Entity
@Table(name="RECRUITER")
public class Recruiter
implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @Column(name="REC_ID", unique=true)
    private Integer recruiterID;
    @Column(name="REC_FIRST_NAME")
    private String recruiterFirstName;
    @Column(name="REC_LAST_NAME")
    private String recruiterLastName;
    @Column(name="REC_CMP_ID")
    private Integer recruiterCompanyID;
    @Column(name="REC_EMAIL")
    private String recruiterEmail;
    @Column(name="REC_PHONE_NO")
    private String recruiterPhoneNo;
    @Column(name="REC_LOC_CITY")
    private String recruiterCity;
    @Column(name="REC_LOC_STATE")
    private String recruiterState;
    @Column(name="IS_ACCEPTING_EMAILS")
    private char isAcceptingEmail;
    @Column(name="IS_ACCEPTING_PHONES")
    private char isAcceptingPhone;
    @Column(name="REC_LINKEDIN_URL")
    private String recruiterLinkedInURL;
    @Column(name="REC_CMP_URL")
    private String recruiterCompanyURL;
    @Column(name="IS_VENDOR_RECRUITER")
    private char isVendorRecruiter;
    @Column(name="IS_ACTIVE")
    private char isActive;
    @Column(name="IS_VERIFIED")
    private char isVerified;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="REC_CMP_ID", referencedColumnName="CMP_ID", insertable=true, updatable=true)
    private Company company;
    @OneToMany(cascade={CascadeType.ALL})
    private Set<RecruiterClient> recruiterClient = new HashSet<RecruiterClient>();
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="REC_ID", insertable=true, updatable=true)
    private RecruiterInfoDates recruiterInfoDates;
    @OneToMany(cascade={CascadeType.ALL})
    private Set<RecruiterJobIndustry> recruiterJobIndustry = new HashSet<RecruiterJobIndustry>();
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="REC_ID", insertable=true, updatable=true)
    private RecruiterQuality recruiterQuality;
    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="REC_ID", insertable=true, updatable=true)
    private RecruiterRateRange recruiterRateRange;
    @OneToMany(cascade={CascadeType.ALL})
    private Set<RecruiterRole> recruiterRole = new HashSet<RecruiterRole>();
    @OneToMany(cascade={CascadeType.ALL})
    private Set<RecruiterSkills> recruiterSkills = new HashSet<RecruiterSkills>();

    public Integer getRecruiterID() {
        return this.recruiterID;
    }

    public void setRecruiterID(Integer recruiterID) {
        this.recruiterID = recruiterID;
    }

    public String getRecruiterEmail() {
        return this.recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    public String getRecruiterPhoneNo() {
        return this.recruiterPhoneNo;
    }

    public void setRecruiterPhoneNo(String recruiterPhoneNo) {
        this.recruiterPhoneNo = recruiterPhoneNo;
    }

    public String getRecruiterCity() {
        return this.recruiterCity;
    }

    public void setRecruiterCity(String recruiterCity) {
        this.recruiterCity = recruiterCity;
    }

    public String getRecruiterState() {
        return this.recruiterState;
    }

    public void setRecruiterState(String recruiterState) {
        this.recruiterState = recruiterState;
    }

    public char getIsAcceptingEmail() {
        return this.isAcceptingEmail;
    }

    public void setIsAcceptingEmail(char isAcceptingEmail) {
        this.isAcceptingEmail = isAcceptingEmail;
    }

    public char getIsAcceptingPhone() {
        return this.isAcceptingPhone;
    }

    public void setIsAcceptingPhone(char isAcceptingPhone) {
        this.isAcceptingPhone = isAcceptingPhone;
    }

    public String getRecruiterLinkedInURL() {
        return this.recruiterLinkedInURL;
    }

    public void setRecruiterLinkedInURL(String recruiterLinkedInURL) {
        this.recruiterLinkedInURL = recruiterLinkedInURL;
    }

    public String getRecruiterCompanyURL() {
        return this.recruiterCompanyURL;
    }

    public void setRecruiterCompanyURL(String recruiterCompanyURL) {
        this.recruiterCompanyURL = recruiterCompanyURL;
    }

    public char getIsVendorRecruiter() {
        return this.isVendorRecruiter;
    }

    public void setIsVendorRecruiter(char isVendorRecruiter) {
        this.isVendorRecruiter = isVendorRecruiter;
    }

    public char getIsActive() {
        return this.isActive;
    }

    public void setIsActive(char isActive) {
        this.isActive = isActive;
    }

    public char getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(char isVerified) {
        this.isVerified = isVerified;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<RecruiterClient> getRecruiterClient() {
        return this.recruiterClient;
    }

    public void setRecruiterClient(Set<RecruiterClient> recruiterClient) {
        this.recruiterClient = recruiterClient;
    }

    public RecruiterInfoDates getRecruiterInfoDates() {
        return this.recruiterInfoDates;
    }

    public void setRecruiterInfoDates(RecruiterInfoDates recruiterInfoDates) {
        this.recruiterInfoDates = recruiterInfoDates;
    }

    public Set<RecruiterJobIndustry> getRecruiterJobIndustry() {
        return this.recruiterJobIndustry;
    }

    public void setRecruiterJobIndustry(Set<RecruiterJobIndustry> recruiterJobIndustry) {
        this.recruiterJobIndustry = recruiterJobIndustry;
    }

    public RecruiterQuality getRecruiterQuality() {
        return this.recruiterQuality;
    }

    public void setRecruiterQuality(RecruiterQuality recruiterQuality) {
        this.recruiterQuality = recruiterQuality;
    }

    public RecruiterRateRange getRecruiterRateRange() {
        return this.recruiterRateRange;
    }

    public void setRecruiterRateRange(RecruiterRateRange recruiterRateRange) {
        this.recruiterRateRange = recruiterRateRange;
    }

    public Set<RecruiterRole> getRecruiterRole() {
        return this.recruiterRole;
    }

    public void setRecruiterRole(Set<RecruiterRole> recruiterRole) {
        this.recruiterRole = recruiterRole;
    }

    public Set<RecruiterSkills> getRecruiterSkills() {
        return this.recruiterSkills;
    }

    public void setRecruiterSkills(Set<RecruiterSkills> recruiterSkills) {
        this.recruiterSkills = recruiterSkills;
    }

    public String getRecruiterFirstName() {
        return this.recruiterFirstName;
    }

    public void setRecruiterFirstName(String recruiterFirstName) {
        this.recruiterFirstName = recruiterFirstName;
    }

    public String getRecruiterLastName() {
        return this.recruiterLastName;
    }

    public void setRecruiterLastName(String recruiterLastName) {
        this.recruiterLastName = recruiterLastName;
    }

    public Integer getRecruiterCompanyID() {
        return this.recruiterCompanyID;
    }

    public void setRecruiterCompanyID(Integer recruiterCompanyID) {
        this.recruiterCompanyID = recruiterCompanyID;
    }
}

/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package com.snaplync.util;

import com.snaplync.entity.Company;
import com.snaplync.entity.Recruiter;
import com.snaplync.entity.RecruiterClient;
import com.snaplync.entity.RecruiterInfoDates;
import com.snaplync.entity.RecruiterJobIndustry;
import com.snaplync.entity.RecruiterQuality;
import com.snaplync.entity.RecruiterRateRange;
import com.snaplync.entity.RecruiterRole;
import com.snaplync.entity.RecruiterSkills;
import com.snaplync.json.RecruiterObject;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectUtil {
    static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    public static void convertJsonEntityObject(RecruiterObject recjsonObject, Recruiter recruiterEntityObject) {
        String key;
        String skill;
        recruiterEntityObject.setRecruiterID(recjsonObject.getRecruiterID());
        recruiterEntityObject.setRecruiterFirstName(recjsonObject.getRecruiterName());
        recruiterEntityObject.setRecruiterLastName(recjsonObject.getRecruiterName());
        recruiterEntityObject.setRecruiterCity(recjsonObject.getRecruiterCity());
        recruiterEntityObject.setRecruiterState(recjsonObject.getRecruiterState());
        recruiterEntityObject.setRecruiterCompanyURL(recjsonObject.getRecruiterCompanyURL());
        recruiterEntityObject.setRecruiterEmail(recjsonObject.getRecruiterEmail());
        recruiterEntityObject.setRecruiterPhoneNo(recjsonObject.getRecruiterPhoneNo());
        recruiterEntityObject.setRecruiterLinkedInURL(recjsonObject.getRecruiterLinkedInURL());
        recruiterEntityObject.setRecruiterCompanyID(recjsonObject.getRecruiterCompanyID());
        recruiterEntityObject.setIsAcceptingEmail(recjsonObject.getIsAcceptingEmail());
        recruiterEntityObject.setIsAcceptingEmail(recjsonObject.getIsAcceptingEmail());
        recruiterEntityObject.setIsVendorRecruiter(recjsonObject.getIsVendorRecruiter());
        recruiterEntityObject.setIsActive(recjsonObject.getIsActive());
        recruiterEntityObject.setIsVerified(recjsonObject.getIsVerified());
        logger.info("recjsonObject.getRecruiterCompanyID()" + recjsonObject.getRecruiterCompanyID());
        logger.info("recjsonObject.getRecruiterCompanyName()" + recjsonObject.getRecruiterCompanyName());
        Company companyEntityObject = new Company();
        companyEntityObject.setCompanyID(recjsonObject.getRecruiterCompanyID());
        companyEntityObject.setRecruiterCompanyName(recjsonObject.getRecruiterCompanyName());
        logger.info("companyEntityObject.getRecruiterCompanyID()" + companyEntityObject.getCompanyID());
        logger.info("companyEntityObject.getRecruiterCompanyName()" + companyEntityObject.getRecruiterCompanyName());
        RecruiterRateRange recRateRangeEntityObj = new RecruiterRateRange();
        recRateRangeEntityObj.setCurrency("USD");
        recRateRangeEntityObj.setRecruiterID(recjsonObject.getRecruiterID());
        recRateRangeEntityObj.setRecruiterRateMax(recjsonObject.getRecruiterRateMax());
        recRateRangeEntityObj.setRecruiterRateMin(recjsonObject.getRecruiterRateMin());
        HashSet<RecruiterClient> recruiterClientSet = new HashSet<RecruiterClient>();
        HashSet<RecruiterJobIndustry> recruiterJobIndustrySet = new HashSet<RecruiterJobIndustry>();
        HashSet<RecruiterSkills> recruiterSkillsSet = new HashSet<RecruiterSkills>();
        HashSet<RecruiterRole> recruiterRoleSet = new HashSet<RecruiterRole>();
        Map<String, String> recruiterClientMap = recjsonObject.getRecruiterClientMap();
        Map<String, String> recruiterIndustryMap = recjsonObject.getRecruiterIndustryMap();
        Map<String, String> recruiterRolesMap = recjsonObject.getRecruiterRolesMap();
        Map<String, String> recruiterSkillsMap = recjsonObject.getRecruiterSkillsMap();
        for (Map.Entry<String, String> entry : recruiterClientMap.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length() <= 0) continue;
            RecruiterClient recClient = new RecruiterClient();
            recClient.setRecruiter_ID(recjsonObject.getRecruiterID());
            recClient.setRecruiterClientName(entry.getValue());
            recruiterClientSet.add(recClient);
        }
        for (Map.Entry<String, String> entry : recruiterIndustryMap.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length() <= 0) continue;
            RecruiterJobIndustry recJobIndustry = new RecruiterJobIndustry();
            recJobIndustry.setRecruiterID(recjsonObject.getRecruiterID());
            recJobIndustry.setRecruiterIndustry(entry.getValue());
            recruiterJobIndustrySet.add(recJobIndustry);
        }
        for (Map.Entry<String, String> entry : recruiterSkillsMap.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length() <= 0) continue;
            key = entry.getKey();
            skill = key.substring(key.length() - 1, key.length());
            RecruiterSkills recskills = new RecruiterSkills();
            recskills.setRecruiterID(recjsonObject.getRecruiterID());
            recskills.setRecruiterSkill(entry.getValue());
            recskills.setRecruiterSkillExp(new Integer(skill));
            recruiterSkillsSet.add(recskills);
        }
        for (Map.Entry<String, String> entry : recruiterRolesMap.entrySet()) {
            if (entry.getValue() == null || entry.getValue().length() <= 0) continue;
            key = entry.getKey();
            skill = key.substring(key.length() - 1, key.length());
            RecruiterRole recRole = new RecruiterRole();
            recRole.setRecruiterID(recjsonObject.getRecruiterID());
            recRole.setRecruiterDesiredRole(entry.getValue());
            recRole.setRecruiterRoleExp(new Integer(skill));
            recruiterRoleSet.add(recRole);
        }
        RecruiterQuality recQuality = new RecruiterQuality();
        recQuality.setRecruiterID(recjsonObject.getRecruiterID());
        recQuality.setRecruiterQuality(recjsonObject.getRecruiterQuality());
        RecruiterInfoDates recInfoDates = new RecruiterInfoDates();
        recInfoDates.setRecruiterID(recjsonObject.getRecruiterID());
        recInfoDates.setInfoStartDate(recjsonObject.getRecruiterPostingDate());
        recInfoDates.setInfoEndDate(recjsonObject.getRecruiterExpirationDate());
        recruiterEntityObject.setCompany(companyEntityObject);
        recruiterEntityObject.setRecruiterRateRange(recRateRangeEntityObj);
        recruiterEntityObject.setRecruiterClient(recruiterClientSet);
        recruiterEntityObject.setRecruiterJobIndustry(recruiterJobIndustrySet);
        recruiterEntityObject.setRecruiterSkills(recruiterSkillsSet);
        recruiterEntityObject.setRecruiterRole(recruiterRoleSet);
        recruiterEntityObject.setRecruiterQuality(recQuality);
        recruiterEntityObject.setRecruiterInfoDates(recInfoDates);
    }

    public static void convertEntityJsonObject(RecruiterObject recjsonObject, Recruiter recruiter, int salary) {
        recjsonObject.setRecruiterID(recruiter.getRecruiterID());
        recjsonObject.setRecruiterPhoneNo(recruiter.getRecruiterPhoneNo());
        recjsonObject.setIsAcceptingEmail(recruiter.getIsAcceptingEmail());
        recjsonObject.setIsAcceptingPhone(recruiter.getIsAcceptingPhone());
        recjsonObject.setRecruiterLinkedInURL(recruiter.getRecruiterLinkedInURL());
        recjsonObject.setRecruiterName(recruiter.getRecruiterFirstName());
        recjsonObject.setRecruiterCompanyName(recruiter.getCompany().getRecruiterCompanyName());
        recjsonObject.setRecruiterCompanyURL(recruiter.getRecruiterCompanyURL());
        recjsonObject.setRecruiterPostingDate(recruiter.getRecruiterInfoDates().getInfoStartDate());
        recjsonObject.setRecruiterExpirationDate(recruiter.getRecruiterInfoDates().getInfoEndDate());
        Integer recruiterRateMax = recruiter.getRecruiterRateRange().getRecruiterRateMax();
        Integer recruiterRateMin = recruiter.getRecruiterRateRange().getRecruiterRateMin();
        recjsonObject.setRecruiterRateMax(recruiterRateMax);
        recjsonObject.setRecruiterRateMin(recruiterRateMin);
        Double actualSalary = new Double(salary);
        double hike = Math.round(((double)recruiterRateMin.intValue() - actualSalary) / actualSalary * 100.0);
        if (hike > 0.0) {
            recjsonObject.setAverageHike(new Double(hike).longValue());
        } else {
            recjsonObject.setAverageHike(new Long(0));
        }
        Set<RecruiterClient> recruiterClient = recruiter.getRecruiterClient();
        Iterator<RecruiterClient> recClientIterator = recruiterClient.iterator();
        StringBuffer recClientBuffer = new StringBuffer();
        while (recClientIterator.hasNext()) {
            RecruiterClient recClient = recClientIterator.next();
            recClientBuffer.append(String.valueOf(recClient.getRecruiterClientName()) + ",  ");
        }
        recjsonObject.setRecruiterClient1(recClientBuffer.toString());
        Set<RecruiterJobIndustry> recruiterJobIndustry = recruiter.getRecruiterJobIndustry();
        Iterator<RecruiterJobIndustry> recIndusties = recruiterJobIndustry.iterator();
        StringBuffer recIndustiesBuffer = new StringBuffer();
        while (recIndusties.hasNext()) {
            RecruiterJobIndustry recClient = recIndusties.next();
            recIndustiesBuffer.append(String.valueOf(recClient.getRecruiterIndustry()) + ",  ");
        }
        recjsonObject.setRecruiterIndustry1(recIndustiesBuffer.toString());
        Set<RecruiterSkills> recruiterSkills = recruiter.getRecruiterSkills();
        Iterator<RecruiterSkills> recSkills = recruiterSkills.iterator();
        StringBuffer recSkillsBuffer = new StringBuffer();
        while (recSkills.hasNext()) {
            RecruiterSkills recClient = recSkills.next();
            recSkillsBuffer.append(String.valueOf(recClient.getRecruiterSkill()) + ",  ");
        }
        recjsonObject.setRecruiterSkill1(recSkillsBuffer.toString());
        Set<RecruiterRole> recruiterRole = recruiter.getRecruiterRole();
        Iterator<RecruiterRole> recRoles = recruiterRole.iterator();
        StringBuffer recRolesBuffer = new StringBuffer();
        while (recRoles.hasNext()) {
            RecruiterRole recClient = recRoles.next();
            recRolesBuffer.append(String.valueOf(recClient.getRecruiterDesiredRole()) + ",  ");
        }
        recjsonObject.setRecruiterRole1(recRolesBuffer.toString());
    }
}

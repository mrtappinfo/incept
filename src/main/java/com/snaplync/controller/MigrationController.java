/*
 * Decompiled with CFR 0_119.
 * 
 * Could not load the following classes:
 *  javax.transaction.Transactional
 *  org.apache.commons.io.FilenameUtils
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.poifs.filesystem.POIFSFileSystem
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.Row
 *  org.apache.poi.ss.usermodel.Sheet
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 */
package com.snaplync.controller;

import com.snaplync.entity.City;
import com.snaplync.entity.Country;
import com.snaplync.entity.Currency;
import com.snaplync.entity.Industry;
import com.snaplync.entity.Role;
import com.snaplync.entity.Skill;
import com.snaplync.entity.State;
import com.snaplync.entity.TimeUnit;
import com.snaplync.repository.CityRepository;
import com.snaplync.repository.CountryRepository;
import com.snaplync.repository.CurrencyRepository;
import com.snaplync.repository.IndustryRepository;
import com.snaplync.repository.RoleRepository;
import com.snaplync.repository.SkillRepository;
import com.snaplync.repository.StateRepository;
import com.snaplync.repository.TimeUnitRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import javax.transaction.Transactional;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MigrationController {
    private final Logger log;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private IndustryRepository industryRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private TimeUnitRepository timeUnitRepository;
    @Autowired
    private CityRepository cityRepository;

    public MigrationController() {
        this.log = LoggerFactory.getLogger(this.getClass());
    }

    @RequestMapping(value={"/migration/init"})
    @Transactional
    public String migrate() throws URISyntaxException, IOException {
        this.createIndustries();
        this.createRoles();
        this.createSkills_();
        this.createLocation_();
        this.createCurrencyAndTimeUnit();
        return "redirect:/";
    }

    @RequestMapping(value={"/migration/currencyAndTime"})
    @Transactional
    public void createCurrencyAndTimeUnit() {
        String[] names = new String[]{"HOURLY", "MONTHLY", "YEARLY"};
        Currency currency = new Currency();
        currency.setName("USD");
        currency.setCreated(new Date());
        currency.setUpdated(new Date());
        this.currencyRepository.save((Object)currency);
        for (String name : names) {
            TimeUnit unit = new TimeUnit();
            unit.setCreated(new Date());
            unit.setUpdated(new Date());
            unit.setName(name);
            this.timeUnitRepository.save((Object)unit);
        }
    }

    private void createRoles() {
        String[] names;
        for (String name : names = new String[]{"Project Management", "Project Manager", "Software Engineer", "Big Data", "Quality Assurance", "Business Process", "Support and Maintainance", "Strategy and Governance", "Consultant"}) {
            Role role = this.roleRepository.findByName(name);
            if (role != null) continue;
            role = new Role();
            role.setCreated(new Date());
            role.setName(name);
            role.setUpdated(new Date());
            this.roleRepository.save((Object)role);
        }
    }

    private void createIndustries() {
        String[] names;
        for (String name : names = new String[]{"Banking", "Insurance", "Finance", "Telecommunications", "Engineering", "Education", "Automative", "Electronics", "Media", "Retail", "Healthcare"}) {
            Industry industry = this.industryRepository.findByName(name);
            if (industry != null) continue;
            industry = new Industry();
            industry.setCreated(new Date());
            industry.setName(name);
            industry.setUpdated(new Date());
            this.industryRepository.save((Object)industry);
        }
    }

    @RequestMapping(value={"/migration/uploadSkills"})
    public void createSkills_() throws URISyntaxException {
        System.out.println("called skills creation");
        File excelfile = new File(this.getClass().getClassLoader().getResource("Skills.xlsx").getFile());
        String filename = excelfile.getName();
        HSSFWorkbook wb_xssf = null;
        Sheet sheet = null;
        try {
            FileInputStream file = new FileInputStream(excelfile);
            String fileExtn = FilenameUtils.getExtension((String)filename);
            if (fileExtn.equalsIgnoreCase("xlsx")) {
                // empty if block
            }
            if (fileExtn.equalsIgnoreCase("xls")) {
                POIFSFileSystem fs = new POIFSFileSystem((InputStream)file);
                wb_xssf = new HSSFWorkbook(fs);
            }
            int noOfSheets = wb_xssf.getNumberOfSheets();
            for (int i = 0; i < noOfSheets; ++i) {
                sheet = wb_xssf.getSheetAt(i);
                for (Row row : sheet) {
                    if (row.getZeroHeight()) continue;
                    Cell c = row.getCell(0);
                    System.out.println(c.getStringCellValue());
                    Skill skill = new Skill();
                    skill.setName(c.getStringCellValue());
                    skill.setCreated(new Date());
                    skill.setUpdated(new Date());
                    this.skillRepository.save((Object)skill);
                }
            }
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value={"/migration/uploadLoc"})
    public void createLocation_() throws URISyntaxException, IOException {
        String strLine;
        Country country = this.countryRepository.findByName("USA");
        if (country == null) {
            country = new Country();
            country.setName("USA");
            country.setCreated(new Date());
            country.setUpdated(new Date());
            country = (Country)this.countryRepository.save((Object)country);
        }
        FileInputStream fstream = new FileInputStream(this.getClass().getClassLoader().getResource("StateCity.txt").getFile());
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        while ((strLine = br.readLine()) != null) {
            try {
                if ((strLine = strLine.trim()).equals("")) continue;
                String[] args = strLine.split(",");
                String stateName = args[1];
                State state = this.stateRepository.findByName(stateName);
                if (state == null) {
                    state = new State();
                    state.setName(stateName);
                    state.setCode(args[0]);
                    state.setUpdated(new Date());
                    state.setCreated(new Date());
                    state.setCountry(country);
                    state = (State)this.stateRepository.save((Object)state);
                }
                String cityName = args[2];
                City city = this.cityRepository.findByNameAndState(cityName, state);
                System.out.println(stateName + " - " + cityName);
                if (city != null && city.getState().getId() == state.getId()) continue;
                city = new City();
                city.setState(state);
                city.setName(cityName);
                city.setCreated(new Date());
                city.setUpdated(new Date());
                city = (City)this.cityRepository.save((Object)city);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        br.close();
    }
}

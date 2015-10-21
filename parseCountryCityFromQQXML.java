package com.plusnet.search.core.dal.daointerface;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CountryTest extends BaseDaoTestCase{

    @Resource
    private CountryDAO countryDao;
    
    @Resource
    private RegionDAO regionDao;
    
    @Test
    public void countryInsert(){
        try {
            XMLConfiguration configuration = new XMLConfiguration("e:/files/LocList.xml");
            List<Object> list = configuration.getList("CountryRegion[@Name]");
            System.out.println(list.size());
            for(int i = 0 ; i < list.size() ; i++){
                System.out.print("国家: "+list.get(i));
                if(StringUtils.isBlank(configuration.getString("CountryRegion("+i+").State[@Name]"))){
                    List<Object> citys = configuration.getList("CountryRegion("+i+").State.City[@Name]");
                    for (Object city : citys) {
                        System.out.print(","+city);
                    }
                    System.out.println("");
                }else {
                    List<Object> citys = configuration.getList("CountryRegion("+i+").State[@Name]");
                    for (Object city : citys) {
                        System.out.print(","+city);
                    }
                    System.out.println("");
                }
            }
            
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}

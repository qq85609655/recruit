package com.csot.recruit.common.util;

import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

public class ElasticSearchConfig implements InitializingBean {

    private String clusterName;

    private String type;
    private List<NetAddress> addressesList;
    private String addresses;

    public ElasticSearchConfig(){
    	PropertiesUtil propertiesUtil = new PropertiesUtil(
				"constant.properties");
    	this.clusterName = propertiesUtil.readProperty("elasticsearch.clusterName");
    	this.type = propertiesUtil.readProperty("elasticsearch.type");
    	this.addresses = propertiesUtil.readProperty("elasticsearch.addresses");
    	if (addresses == null) {
            throw new RuntimeException("ElasticSearch 配置错误");
        }
        addressesList = new ArrayList<NetAddress>();
        String[] splits = addresses.split(",");
        for (String address : splits) {
            int index = address.lastIndexOf(':');
            String ip = address.substring(0, index);
            int port = Integer.valueOf(address.substring(index + 1));
            addressesList.add(new NetAddress(ip, port));
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if (addresses == null) {
            throw new RuntimeException("ElasticSearch 配置错误");
        }
        addressesList = new ArrayList<NetAddress>();
        String[] splits = addresses.split(",");
        for (String address : splits) {
            int index = address.lastIndexOf(':');
            String ip = address.substring(0, index);
            int port = Integer.valueOf(address.substring(index + 1));
            addressesList.add(new NetAddress(ip, port));
        }
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public List<NetAddress> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(List<NetAddress> addressesList) {
        this.addressesList = addressesList;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

}

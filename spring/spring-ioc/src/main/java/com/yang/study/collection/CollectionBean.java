/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.yang.study.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author fuyang
 * @version $Id: CollectionBean.java, v 0.1 2018年07月30日 下午12:14 fuyang Exp $
 */
public class CollectionBean {

    private Time time;

    private List<Object>        list;
    private Object[]            arrays;
    private Set<Object>         set;
    private Map<String, Object> map;
    private Properties properties;

    /**
     * Getter method for property <tt>properties</tt>.
     *
     * @return property value of properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Setter method for property <tt>properties</tt>.
     *
     * @param properties value to be assigned to property properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public CollectionBean() {}

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Getter method for property <tt>list</tt>.
     *
     * @return property value of list
     */
    public List<Object> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<Object> list) {
        this.list = list;
    }

    /**
     * Getter method for property <tt>arrays</tt>.
     *
     * @return property value of arrays
     */
    public Object[] getArrays() {
        return arrays;
    }

    /**
     * Setter method for property <tt>arrays</tt>.
     *
     * @param arrays value to be assigned to property arrays
     */
    public void setArrays(Object[] arrays) {
        this.arrays = arrays;
    }

    /**
     * Getter method for property <tt>set</tt>.
     *
     * @return property value of set
     */
    public Set<Object> getSet() {
        return set;
    }

    /**
     * Setter method for property <tt>set</tt>.
     *
     * @param set value to be assigned to property set
     */
    public void setSet(Set<Object> set) {
        this.set = set;
    }

    /**
     * Getter method for property <tt>map</tt>.
     *
     * @return property value of map
     */
    public Map<String, Object> getMap() {
        return map;
    }

    /**
     * Setter method for property <tt>map</tt>.
     *
     * @param map value to be assigned to property map
     */
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
package com.hsenid.employee.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Service
public class EmployeeService {

    private List<String> employeeNames;

    @PostConstruct
    public void init() {
       employeeNames = new ArrayList<String>();
        System.out.println("The PostConstructor");




        try {
            Properties prop = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");
            prop.load(input);
            String xmlFilePath = prop.getProperty("xml.file.path");

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(getClass().getClassLoader().getResourceAsStream(xmlFilePath));
            NodeList employeeNodes = doc.getElementsByTagName("employee");
            for (int i = 0; i < employeeNodes.getLength(); i++) {
                Element employeeElement = (Element) employeeNodes.item(i);
                String name = employeeElement.getElementsByTagName("name").item(0).getTextContent();
                employeeNames.add(name);
            }
            System.out.println("Employee names loaded from xml: " + employeeNames);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
    //  Collection.removeAll(employeeNames);
        System.out.println("EmployeeService is being destroyed.");
    }

    public List<String> fetchEmployee() {
        return employeeNames;
    }
}

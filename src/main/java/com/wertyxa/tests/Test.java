package com.wertyxa.tests;

import com.wertyxa.Controller.CreatePaneController;
import com.wertyxa.Model.AllTests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Test {
    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(AllTests.class);
        String filename = "C:\\java_libs\\index.xml";
        AllTests allList = new CreatePaneController().getAllList();
        convertObjToXml(allList,filename,context);
        //System.out.println(convertXmlToObj(new File(filename),context));
        File file1 = new File(filename);
    }
    private static void convertObjToXml(AllTests allTests, String filename, JAXBContext context) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(allTests,new File(filename));
    }
    private static AllTests convertXmlToObj(File file, JAXBContext  context) throws JAXBException, IOException {
        Unmarshaller um = context.createUnmarshaller();
        Reader is = new FileReader("C:\\java_libs\\index.xml");

        System.out.println(is);
        AllTests allTests = (AllTests) um.unmarshal(is);
        return allTests;
    }

}

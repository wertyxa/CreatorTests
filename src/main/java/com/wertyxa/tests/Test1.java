package com.wertyxa.tests;

import com.wertyxa.Controller.CreatePaneController;
import com.wertyxa.Model.AllTests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test1 {
    public static void main(String[] args) throws JAXBException {
        AllTests at = new CreatePaneController().getAllList();
        String filename = "src/main/resources/index.xml";
        convertDataToXML(at,filename);

        AllTests at1 = convertXmlToData(new File(filename));
        System.out.println(at1);
    }

    private static AllTests convertXmlToData(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AllTests.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (AllTests) unmarshaller.unmarshal(file);
    }

    private static void convertDataToXML(AllTests at, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AllTests.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(at,new File(filename));
        System.out.println("Convert good");
    }
}

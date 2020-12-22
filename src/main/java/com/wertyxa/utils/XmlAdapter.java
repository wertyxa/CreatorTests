package com.wertyxa.utils;

import com.wertyxa.Model.AllTests;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlAdapter {
    public XmlAdapter() {
    }
    public static AllTests convertXmlToData(File file)throws NullPointerException, IllegalArgumentException{
        try {
            JAXBContext context = JAXBContext.newInstance(AllTests.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (AllTests) unmarshaller.unmarshal(file);
        }catch (JAXBException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void convertDataToXML(AllTests data, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(AllTests.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(data,new File(filename));
        System.out.println("Convert good");
    }

}

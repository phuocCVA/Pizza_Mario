/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dom;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TransformerXML {
    String result;

    public String getResult() {
        return result;
    }
    
    public TransformerXML(String xml){
        try{
        Source inputSource = new StreamSource(new StringReader(xml));
        Source xsltSource = new StreamSource(new File("C:\\Users\\ivy\\Documents\\NetBeansProjects\\Mario_pizza\\src\\java\\data\\Tranformation_Commande.xsl"));
        
        Writer outputWriter = new StringWriter();
        Result outputResult = new StreamResult(outputWriter);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsltSource);
        transformer.transform(inputSource, outputResult);
        String outputString = outputWriter.toString();
        this.result=outputString;
      
    }catch(Exception e){ }
    
    }
}

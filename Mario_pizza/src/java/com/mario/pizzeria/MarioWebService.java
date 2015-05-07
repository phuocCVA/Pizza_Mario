/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mario.pizzeria;

import dom.Commande;
import dom.TransformerXML;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.transform.TransformerException;

/**
 *
 * @author ivy
 */
@WebService(serviceName = "MarioWebService")
public class MarioWebService {
    ArrayList<Commande> listeCommandes = new ArrayList<>();

    /**
     * This is a sample web service operation
     */
    public MarioWebService() {
        Commande commande;
        String xml= " <ns1:commande  xmlns:xsi="+ "'" + " http://www.w3.org/2001/XMLSchema-instance' \n "
                               + " xmlns:ns1='http://chez.mario.fr/commande' \n"
                               + " xsi:schemaLocation='http://chez.mario.fr/commande commande.xsd'> \n"
                  + " <ns1:numéro>124</ns1:numéro> \n"
                  + " <ns1:date>2013-12-11-19:20</ns1:date> \n"
                  + " <ns1:client noAdherent='"+"124"+"'> \n"
                    + "   <ns2:nom>NGUYEN</ns2:nom> \n"
                    + "   <ns2:prénom>Huu Phuoc</ns2:prénom> \n"
                    + "   <ns2:téléphone>0781654618</ns2:téléphone> \n"
                    + "   <ns2:adresse>8 rue Pierre Courtade</ns2:adresse> \n"
                  + " </ns1:client> \n"
                  + " <ns1:pizza> \n"
                    + "   <ns3:base>Tomate</ns3:base> \n"
                    + "   <ns3:ingrédients>3</ns3:ingrédients> \n"
                    + "   <ns3:taille>M</ns3:taille> \n"
                  + " </ns1:pizza> \n"
                  + " </ns1:commande> \n" ;
        commande = new Commande(xml);
        this.listeCommandes.add(commande);  
    }
  
   public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }
    
   
    @WebMethod(operationName = "getClientFromOrder")
    public String getClientFromOrder(@WebParam(name = "numeroOrder") int numeroOrder) {
        String nom = null; 
        for(Commande cmd: this.listeCommandes) {
            if (cmd.getNuméro()==numeroOrder) {           
                nom = cmd.getClient().getNom();
                break;
            }  
        }    
        return nom;
    }    
    
    @WebMethod(operationName = "addCommande")
    public String addCommande(@WebParam(name = "filename") String filename) {
       Commande commande;
       int numero =listeCommandes.get(listeCommandes.size()-1).getNuméro()+1;
       filename+="<ns1:date>"+now("yyyy-MM-dd-hh:mm" )+"</ns1:date> \n"
               +" <ns1:numéro>"+numero+"</ns1:numéro> \n";
       commande = new Commande(filename);
       this.listeCommandes.add(commande);
       return filename;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Transformer")
    public String Transformer(@WebParam(name = "xml") String xml){
        TransformerXML transfor;
        transfor=new TransformerXML(xml);
        String result=transfor.getResult();
        return result;
    }
    
    
    
}

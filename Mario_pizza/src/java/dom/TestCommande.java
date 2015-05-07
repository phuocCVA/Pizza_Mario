/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dom;

import java.io.IOException;
import java.util.Calendar;
import javax.xml.parsers.ParserConfigurationException;
import dom.Client;
import dom.Client;
import dom.Commande;
import dom.Commande;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.xml.sax.SAXException;

/**
 *
 * @author ivy
 */
public class TestCommande {
    
    public static Calendar getNewCalendar(int annee, int mois, int jour, int heure, int min) {
        Calendar c = Calendar.getInstance();// Calendar.getInstance();
        c.clear(); 
        c.set(Calendar.YEAR, annee);
        c.set(Calendar.MONTH, mois);
        c.set(Calendar.DAY_OF_MONTH, jour);
        c.set(Calendar.HOUR_OF_DAY, heure);
        c.set(Calendar.MINUTE, min);     
        return c;
    }
   
    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }
    
    public static void main(String[] args){
        Client client;
        Commande commande;
        TransformerXML transfor;
        String xml= " <ns1:commande  xmlns:xsi="+ "'" + " http://www.w3.org/2001/XMLSchema-instance' \n "
                               + " xmlns:ns1='http://chez.mario.fr/commande' \n"
                               + " xmlns:ns2='http://chez.mario.fr/client' \n"
                               + " xmlns:ns3='http://chez.mario.fr/pizza' \n"
                               + " xsi:schemaLocation='http://chez.mario.fr/commande commande.xsd'> \n"
                  + " <ns1:numéro>123</ns1:numéro> \n"
                  + " <ns1:date>2013-12-11-19:20</ns1:date> \n"
                  + " <ns1:client noAdherent='"+"124"+"'> \n"
                    + "   <ns2:nom>NGUYEN</ns2:nom> \n"
                    + "   <ns2:prénom>Huu Phuoc</ns2:prénom> \n"
                    + "   <ns2:téléphone>0781654618</ns2:téléphone> \n"
                    + "   <ns2:adresse>8 rue Pierre Courtade</ns2:adresse> \n"
                  + " </ns1:client> \n"
                  + " <ns1:pizza> \n"
                    + "   <ns3:base>Tomate</ns3:base> \n"
                    + "   <ns3:ingrédients>"
                    +            "<ns3:ingrédient>saumon</ns3:ingrédient>\n"
                    +            "<ns3:ingrédient>saumon</ns3:ingrédient>\n"    
                    + "</ns3:ingrédients> \n"
                    + "   <ns3:taille>M</ns3:taille> \n"
                  + " </ns1:pizza> \n"
                  + " </ns1:commande> \n" ;
        commande = new Commande(xml);
        transfor=new TransformerXML(xml);
        String result=transfor.getResult();
        String str=commande.toString();
        out.println(str);
       
    }

}

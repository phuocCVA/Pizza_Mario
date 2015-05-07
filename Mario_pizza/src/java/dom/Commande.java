package dom;
 
import dom.TestCommande;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document; 
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
public class Commande { 
    int numéro;
    Calendar date;
    Client client;
    ArrayList<Pizza> pizzas;

    public int getNuméro() {
        return numéro;
    }

    public Client getClient() {
        return client;
    }

    public Commande(int numéro, Calendar date, Client client, ArrayList<Pizza> pizzas) {
        this.numéro = numéro;
        this.date = date;
        this.client = client;
        this.pizzas = pizzas;
    }
 
    public Commande(String filename) {
    try{ 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder p = dbFactory.newDocumentBuilder();
        Document doc = p.parse(new InputSource(new StringReader(filename))); 
        
        Element commande=(Element) doc.getElementsByTagName("ns1:commande").item(0);
        this.numéro = Integer.parseInt(commande.getElementsByTagName("ns1:numéro").item(0).getTextContent());
     
        String dateStr = commande.getElementsByTagName("ns1:date").item(0).getTextContent();
        int année  = Integer.parseInt(dateStr.substring(0, 4)); 
        int mois   = Integer.parseInt(dateStr.substring(5, 7));
        int jour   = Integer.parseInt(dateStr.substring(8, 10)); 
        int heure  = Integer.parseInt(dateStr.substring(11, 13));
        int minute = Integer.parseInt(dateStr.substring(14, 16));
        this.date  = TestCommande.getNewCalendar(année, mois, jour, heure, minute);       
         
        Element clt = (Element) commande.getElementsByTagName("ns1:client").item(0);      
        int noAdhérent = -1;
        if (clt.hasAttribute("noAdherent")) { 
            String noStr = clt.getAttribute("noAdherent"); 
            noAdhérent = Integer.parseInt(noStr); 
        }
        String nom      = clt.getElementsByTagName("ns2:nom").item(0).getTextContent(); 
        String prénom   = clt.getElementsByTagName("ns2:prénom").item(0).getTextContent();   
        String téléphone= clt.getElementsByTagName("ns2:téléphone").item(0).getTextContent();
        String adresse  = clt.getElementsByTagName("ns2:adresse").item(0).getTextContent();  
        this.client = new Client(nom, prénom, téléphone, adresse, noAdhérent);
        
        this.pizzas = new ArrayList<Pizza>();
        NodeList lesPizzas = commande.getElementsByTagName("ns1:pizza");  
        for (int i = 0; i < lesPizzas.getLength(); i++) {
            Element unePizza = (Element) lesPizzas.item(i);
            boolean tomate = unePizza.getElementsByTagName("ns3:base").item(0).getTextContent().equals("Tomate");
            String taille = unePizza.getElementsByTagName("ns3:taille").item(0).getTextContent(); 
            int nbIngrédients = unePizza.getElementsByTagName("ns3:ingrédient").getLength();
            
            Pizza pizza = new Pizza(tomate, taille, nbIngrédients);
            this.pizzas.add(pizza);
        }

    } catch (Exception e) { 
    }
}
   
    public double prixTotal() {
        double prix = 0.0;
        for(Pizza pizza: pizzas) {
            prix += pizza.prix();
        }
        if (client.estAdherent()) {
            prix=prix-(0.05*prix);
        }
        return prix;
    }
 
    public String toString() {
      String res = "Commande numéro: " + numéro + "\n\n";
      res += "Client:" + client.getNom()+" "+ client.getPrénom()+ "\n";
        res += "--------------------\n";
        for (Pizza pizza: pizzas) {
            res += pizza.toString();
            res += "--------------------\n";
        }
        if (client.estAdherent()) {
            res += " Adhérent n° : " + client.getNuméroAdhérent() + ", remise 5%\n";
        }
        res += "Total : " + prixTotal();
 
        return res;
    }

}
package dom;
 
public class Client {
    String nom;
    String prénom;
    String tel;
    String adresse;
    int numéroAdhérent;
 
    public Client(String nom, String prénom, String tel, String adresse, int numéroAdhérent) {
        this.nom = nom;
        this.prénom = prénom;
        this.tel = tel;
        this.adresse = adresse;
        this.numéroAdhérent = numéroAdhérent;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }
 
    boolean estAdherent() {
        return (numéroAdhérent != -1);
    }
 
    int getNuméroAdhérent() {
        return numéroAdhérent;
    }
  
}
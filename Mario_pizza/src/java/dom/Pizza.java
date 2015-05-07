package dom;
public class Pizza {
 
    // Vrai si la pizza est à base de tomate
    // faux si la pizza est à base de crème
    boolean tomate;
    // Taille de la pizza: peut être "M", "L" ou "XL". Par défaut: "L".
    String taille;
    // Le nombre d'ingrédients d'une pizza est forcément compris entre 3 et 6.
    int nbIngrédients;
 
    public Pizza(boolean tomate, String taille, int nbIngrédients) {
        this.tomate = tomate;
        this.taille = taille;
        this.nbIngrédients = nbIngrédients;
    }
 
    double prix() {
        double prix=0.0;
        if(this.tomate) {
            if (this.taille.equals("M")) { prix=(6+2*this.nbIngrédients); }  
            else if (this.taille.equals("XL")) { prix=(8+2*this.nbIngrédients); }
            else prix=(7+2*this.nbIngrédients);                
        }
        else {
            if (this.taille.equals("M")) { prix=(8+2*this.nbIngrédients); }  
            else if (this.taille.equals("XL")) { prix=(10+2*this.nbIngrédients); }
            else prix=(9+2*this.nbIngrédients);                
        }
        return prix;
    }
 
    public String toString() {
        String res = "Pizza ";
 
        res += taille + " ";
        if (tomate)
            res += " tomate ";
        else
            res += " crème ";
 
        res += nbIngrédients + " ingrédients.    ->    ";
        res += prix() + " €\n";
 
        return res;
    }
}

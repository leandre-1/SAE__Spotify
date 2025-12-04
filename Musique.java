package SAE_spotify;

import java.time.LocalDate;

public class Musique {
    String titre_Musique;
    String id_titre;
    int duree_titre;
    String type_album;
    String nom_Album;
    LocalDate date_album;
    String nom_Artiste;
    int popularite;
    String artiste;

    public Musique(String titre, String id, int duree, String type, String nomAlb, LocalDate date, String nomArt, int pop, String art) {
        titre_Musique = titre;
        id_titre = id;
        duree_titre = duree;
        type_album = type;
        nom_Album = nomAlb;
        date_album = date;
        nom_Artiste = nomArt;
        popularite = pop;
        artiste = art;
    }

    public String toString(){
        return ("Titre : "+titre_Musique+", id du titre : "+id_titre+", Duree du titre : "+duree_titre+", Genre de l'album : "+type_album+
                ", Nom de l'abum : "+nom_Album+", Nom de l'artiste : "+nom_Artiste+", Popularité : "+popularite+"\n");
    }
}

package SAE_spotify;

import java.time.LocalDate;

public class Musique {
    public String nom_Musique;
    public String id_Musique;
    public int duree_titre;
    public String type_album;
    public String nom_Album;
    public LocalDate date_album;
    public String nom_Artiste;
    public int popularite;
    public String artiste;

    public Musique (String titre, String id_titre, int duree, String type, String nomAl, LocalDate date, String nomArt, int pop, String art){
            nom_Musique = titre;
            id_Musique = id_titre;
            duree_titre = duree;
            type_album = type;
            nom_Album = nomAl;
            date_album = date;
            nom_Artiste = nomArt;
            popularite = pop;
            artiste = art;
        }
}

    
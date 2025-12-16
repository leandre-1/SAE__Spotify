package SAE_spotify;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public class AppliMusique {

    private static String[] titre;
    private static int[] tabPopularite;
    private static List<Musique> ListMusique;
    private static String nom;

    public static void main(String[] args) {
        boolean ARRAYlist = false;
        int choix = -1;
        long start, stop;

        if (ARRAYlist) {
            ListMusique = new ArrayList<>();
        } else {
            ListMusique = new LinkedList<>();
        }

        while (choix != 0) {
            Scanner scanner = new Scanner(System.in);
            int choix_charge;

            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Charger les données (choix du fichier)");
            System.out.println("2 - Afficher les données");
            System.out.println("3 - Trier les données");
            System.out.println("4 - Filtrer les données");
            System.out.println("5 - Rechercher des données concernant un titre");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi de Charger les données");
                    System.out.println(" ");
                    System.out.println("Quel fichier voulez-vous charger ?");
                    System.out.println("1 - spotify_100.csv");
                    System.out.println("2 - spotify_1000.csv");
                    System.out.println("3 - spotify_10000.csv");
                    System.out.println("4 - spotify_100000.csv");
                    System.out.println("5 - spotify_FULL.csv");

                    choix_charge = scanner.nextInt();

                    switch (choix_charge) {
                        case 1:
                            System.out.println("Chargement du fichier : spotify_100.csv");
                            Chargement("spotify_100.csv");

                            break;
                        case 2:
                            System.out.println("Chargement du fichier : spotify_1000.csv");
                            Chargement("spotify_1000.csv");
                            break;
                        case 3:
                            System.out.println("Chargement du fichier : spotify_10000.csv");
                            Chargement("spotify_10000.csv");
                            break;
                        case 4:
                            System.out.println("Chargement du fichier : spotify_100000.csv");
                            Chargement("spotify_100000.csv");
                            break;
                        case 5:
                            System.out.println("Chargement du fichier : spotify_FULL.csv");
                            Chargement("spotify_FULL.csv");
                            break;
                    }
                    break;
                case 10:
                    SuppressionDUrgenceLente();
                case 2:
                    System.out.println("Vous avez choisi d'afficher les données");
                    Afficher();
                    break;
                case 3:
                    System.out.println("Vous avez choisi de Trier les données");
                    System.out.println(" ");
                    System.out.println("Quel type de tri voulez-vous faire ?");
                    System.out.println("1 - Tri Sélection");
                    System.out.println("2 - Tri Fusion");
                    System.out.println("3 - Tri Java");

                    choix = scanner.nextInt();

                    switch (choix) {
                        case 1:
                            start = System.nanoTime();
                            triSelection();
                            stop = System.nanoTime();
                            Afficher();
                            System.out.println(stop - start + " ms");
                            break;
                        case 2:
                            start = System.nanoTime();
                            triFusion(0, (int) (ListMusique.size() - 1));
                            stop = System.nanoTime();
                            Afficher();
                            System.out.println(stop - start + " ms");
                            break;
                        case 3:
                            System.out.println("Tri Java : ");
                            System.out.println("Quelles données voulez-vous trier ?");
                            System.out.println(" ");
                            System.out.println("1 - Selon l'année");
                            System.out.println("2 - Selon le titre d'une chanson");
                            System.out.println("3 - Selon le titre d'album");
                            System.out.println("4 - Selon un artiste");

                            choix = scanner.nextInt();

                            switch (choix) {
                                case 1:
                                    System.out.println("Tri selon l'année");
                                    ListMusique.sort(Musique.compareAnnee);
                                    System.out.println(ListMusique.toString());
                                    break;
                                case 2:
                                    System.out.println("Tri selon le titre d'une chanson");
                                    ListMusique.sort(Musique.compareChanson);
                                    System.out.println(ListMusique.toString());
                                    break;
                                case 3:
                                    System.out.println("Tri selon le titre d'album");
                                    ListMusique.sort(Musique.compareAlbum);
                                    System.out.println(ListMusique.toString());
                                    break;
                                case 4:
                                    System.out.println("Tri selon le titre un artiste");
                                    ListMusique.sort(Musique.compareArtiste);
                                    System.out.println(ListMusique.toString());
                                    break;
                            }
                            break;
                    }

                    break;
                case 4:
                    System.out.println("Vous avez choisi de Filter les données");
                    System.out.println(" ");
                    System.out.println("Quel type de filtre voulez-vous faire ?");
                    System.out.println("1 - Filtre manuel");
                    System.out.println("2 - Filtre java");

                    choix = scanner.nextInt();

                    switch (choix) {
                        case 1:
                            System.out.println("Entrez l'année que vous voulez filtrer : ");
                            choix = 0;
                            do {
                                choix = scanner.nextInt();
                            } while (choix == 0);
                            filtreManuel(choix);
                            break;
                        case 2:
                            System.out.println("Quelles donnée voulez-vous filtrer ?");
                            System.out.println(" ");
                            System.out.println("1 - Selon l'année");
                            System.out.println("2 - Selon le titre d'une chanson");
                            System.out.println("3 - Selon le titre d'album");
                            System.out.println("4 - Selon un artiste");

                            choix = scanner.nextInt();

                            switch (choix) {
                                case 1:
                                    System.out.println("Entrez l'année que vous voulez filtrer : ");
                                    choix = 0;
                                    do {
                                        choix = scanner.nextInt();
                                    } while (choix == 0);
                                    filtreAnnee(ListMusique, choix);
                                    break;
                                case 2:
                                    System.out.println("Entrez la chanson que vous voulez filtrer : ");
                                    String phrase;
                                    do {
                                        phrase = scanner.nextLine();
                                    } while (phrase.isEmpty());
                                    filtreChanson(ListMusique, phrase);
                                    break;
                                case 3:
                                    System.out.println("Entrez l'album que vous voulez filtrer : ");
                                    do {
                                        phrase = scanner.nextLine();
                                    } while (phrase.isEmpty());
                                    filtreAlbum(ListMusique, phrase);
                                    break;
                                case 4:
                                    System.out.println("Entrez l'artiste que vous voulez filtrer : ");
                                    do {
                                        phrase = scanner.nextLine();
                                    } while (phrase.isEmpty());
                                    filtreArtiste(ListMusique, phrase);
                                    break;
                            }
                            break;
                    }

                    break;
                case 5:
                    System.out.println("Vous avez choisi de Rechercher des données concernant un titre");
                    System.out.println(" ");
                    System.out.println("Quel type de recherche voulez-vous faire ?");
                    System.out.println("1 - Recherche linéaire");
                    System.out.println("2 - Recherche dichotomique");


                    choix = scanner.nextInt();

                    switch(choix) {
                        case 1:
                            System.out.println("Quel titre recherchez-vous ?");
                            String phrase = "";
                            do {
                                phrase = scanner.nextLine();
                            } while (phrase.isEmpty());
                            RechercheLineaire(phrase);
                            break;
                        case 2:
                            phrase = "";
                            do {
                                phrase = scanner.nextLine();
                            } while (phrase.isEmpty());
                            RechercheDichotomique(phrase);
                            break;
                    }
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Erreur : Veuillez saisir un nombre ente 1 et 5");
                    break;
            }
        }
    }


    public static void Chargement(String nom) {
        SuppressionDUrgenceLente();
        try {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'");
            BufferedReader tsvReader = new BufferedReader(new FileReader(nom));
            String row = new String();
            row = tsvReader.readLine(); //row est égal à null si on est en fin de fichier
            titre = row.split(","); // prends toutes les categories meme les pas necessaires

            row = tsvReader.readLine();

            while (row != null) {

                String[] data = row.split(",");

                Musique musique = new Musique(
                        data[0],     // titre_Musique = track_name
                        data[1],     // id_titre = track_id
                        Integer.parseInt(data[3]),    // duree_titre = duration_sec
                        data[4],     // type_album = album_type
                        data[7],     // nom_Album = album_name
                        LocalDateTime.parse(data[8], f).toLocalDate(),     // date_album = release_date
                        data[9],    // nom_Artiste = artist_0
                        Integer.parseInt(data[10]),    // popularite = album_popularity
                        data[5]      // artiste = artists (la liste complète)
                );

                ListMusique.add(musique);
                row = tsvReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void RechercheDichotomique(String phrase){
        boolean est_triee = false;
        int choix = 2;
        int debut = 0;
        int fin = ListMusique.size() - 1;
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour faire une recherche Dichotomique, veuillez vous assurer que la liste est triée par titre de musique");
        System.out.println("1 - La liste est triée");
        System.out.println("0 - La liste n'est pas triée");
        do {
            choix = scanner.nextInt();
        }while(choix== 2);
            if(choix==1){
                est_triee = true;
            }
        choix = 2;
        if (est_triee) {

            while (debut <= fin) {
                m = (debut + fin) / 2;
                String PotentielleMusique = ListMusique.get(m).nom_Musique;
                int resultat = PotentielleMusique.compareTo(phrase);
                if (resultat == 0) {
                    System.out.println("Trouvé à l'index : " + m);
                    System.out.println(ListMusique.get(m));
                    System.out.println("Voulez vous lire le morceau ?");
                    System.out.println("0 - Non");
                    System.out.println("1 - Oui");
                    do {
                        choix = scanner.nextInt();
                    }while(choix== 2);
                    if(choix==1){
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://open.spotify.com/intl-fr/track/"+ListMusique.get(m).id_Musique));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }

                else if (resultat < 0) {
                    debut = m + 1;
                }

                else {
                    fin = m - 1;
                }
            }
        }
    }

    private static void RechercheLineaire(String titre){
        List<Musique> listeFiltree = new ArrayList<>();
        int max = ListMusique.size();

        for (int i = 0; i < max; i++) {
            Musique musique = ListMusique.get(i);
            String mus = musique.nom_Musique;
            if (mus.equals(titre)) listeFiltree.add(musique);
        }
        System.out.println(listeFiltree);
        System.out.println(" ");
    }

    private static void SuppressionDUrgenceLente() {
        int i = 0;

        while (!ListMusique.isEmpty()) {
            ListMusique.remove(0);
            i++;
        }
        System.out.println(i+" lignes supprimées avec succes");
    }

    public static void Afficher() {
        int compteur = 0;
        int step = (ListMusique.size() > 1000) ? 1000 : 1;

        // On s'assure de ne pas dépasser la taille de la liste
        int max = Math.toIntExact(Math.min(ListMusique.size(), ListMusique.size()));
        //System.out.println(Arrays.toString(titre));
        System.out.printf(
                "%-150s %-25s %-15s %-40s %-150s %-30s %-30s %-20s%n",
                titre[0],  // nom_Musique
                titre[1],  // id_Musique
                titre[2],  // duree
                titre[3],  // type_album
                titre[4],  // nom_Album
                titre[5],  // date
                titre[6],  // nom_Artiste
                titre[7]   // popularite
        );
        for (int i = 0; i < max; i += step) {
            //System.out.println(". "+ListMusique.get(i));

            System.out.printf("%-150s %-25s %-15d %-40s %-150s %-30s %-30s %-20d%n",
            ListMusique.get(i).nom_Musique,
            ListMusique.get(i).id_Musique,
            ListMusique.get(i).duree_titre,
            ListMusique.get(i).type_album,
            ListMusique.get(i).nom_Album,
            ListMusique.get(i).date_album,
            ListMusique.get(i).nom_Artiste,
            ListMusique.get(i).popularite);
            compteur++;
        }
        System.out.println(" ");
        System.out.println(compteur + " lignes affichées sur " + ListMusique.size());
    }

    public static void triSelection() {
        Musique temp;
        int min;

        for (int i = 0; i < ListMusique.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < ListMusique.size() - 1; j++)
                if (ListMusique.get(min).popularite > ListMusique.get(j).popularite) {
                    min = j;
                }
            ;
            temp = ListMusique.get(min);
            ListMusique.set(min, ListMusique.get(i));
            ListMusique.set(i, temp);
        }
    }

    public static void triFusion(int g, int d) {
        int m;
        if (g < d) {
            m = (g + d) / 2; //division enti�re
            triFusion(g, m);
            triFusion(m + 1, d);
            fusionner(g, m, d);
        }
    }

    public static void fusionner(int g, int m, int d) {
        Musique[] tab3 = new Musique[d - g + 1];
        int n1 = m, n2 = d, i1 = g, i2 = m + 1, i3 = 0;


        while ((i1 <= n1) && (i2 <= n2)) {
            if (ListMusique.get(i1).popularite < ListMusique.get(i2).popularite) {
                tab3[i3] = ListMusique.get(i1);
                i1++;
            } else {
                tab3[i3] = ListMusique.get(i2);
                i2++;
            }
            i3++;
        }

        while (i1 <= n1) {
            tab3[i3] = ListMusique.get(i1);
            i1++;
            i3++;
        }

        while (i2 <= n2) {
            tab3[i3] = ListMusique.get(i2);
            i2++;
            i3++;
        }

        for (i3 = 0; i3 < tab3.length; i3++) {
            ListMusique.set(i3 + g, tab3[i3]);
        }
    }

    public static void filtreAnnee(List<Musique> listMusique, int date) {
        ListMusique.removeIf(f -> f.date_album.getYear() != date);
        Afficher();
    }

    public static void filtreAlbum(List<Musique> listMusique, String nom) {
        ListMusique.removeIf(f -> !f.nom_Album.contains(nom));
        Afficher();
    }

    public static void filtreChanson(List<Musique> listMusique, String chanson) {
        ListMusique.removeIf(f -> !f.nom_Musique.contains(chanson));
        Afficher();
    }

    public static void filtreArtiste(List<Musique> listMusique, String artiste) {
        ListMusique.removeIf(f -> !f.nom_Artiste.contains(artiste));
        Afficher();
    }

    public static void filtreManuel(int date) {
        List<Musique> listeFiltree = new ArrayList<>();
        int max = ListMusique.size();

        for (int i = 0; i < max; i++) {
            Musique musique = ListMusique.get(i);
            int annee = musique.date_album.getYear();
            if (annee == date) listeFiltree.add(musique);
        }
        System.out.println(listeFiltree);
        System.out.println("");
    }
}

package fr.mareths.dev.lesalphas;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListImage {

    private List<Image> list = new ArrayList<Image>();

    /** Constructeur privé */
    private ListImage()
    {
        construireListe();
    }

    /** Instance unique non préinitialisée */
    private static ListImage INSTANCE = null;

    private static int position = -1;

    /** Point d'accès pour l'instance unique du singleton */
    public static ListImage getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ListImage();
        }
        return INSTANCE;
    }

    private void construireListe() {

        int idDroite, idGauche;
        String fieldName;

        Class cls = R.drawable.class;
        Field fieldlist[] = cls.getDeclaredFields();
        for (Field fldD : fieldlist) {
            fieldName = fldD.getName();
            if (fieldName.startsWith("d_")) {
                try {
                    idDroite = fldD.getInt(null);

                    for (Field fldG : fieldlist) {
                        fieldName = fldG.getName();
                        if (fieldName.startsWith("g_")) {
                            Image image = new Image(idDroite, fldG.getInt(null));
                            list.add(image);
                        }
                    }
                }
                catch (Exception e) {
                    System.out.print(e.getMessage());
                }

            }
        }

        Collections.shuffle(list);
    }

    public Image getNextImage() {

        if (position < list.size()-1) {
            position++;
        }

        return list.get(position);
    }

    public Image getPreviousImage() {

        if (position > 0) {
            position--;
        }

        return list.get(position);
    }

    public void reInit() {
        list.clear();
        position = -1;
        construireListe();
    }
}

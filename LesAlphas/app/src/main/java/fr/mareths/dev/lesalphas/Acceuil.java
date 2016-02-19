package fr.mareths.dev.lesalphas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Acceuil extends AppCompatActivity {


    Button buttonSuivant;
    Button buttonPrecedent;
    Button buttonNew;
    ImageView imageDroite;
    ImageView imageGauche;
    TextView compteur;

    ListImage listImage = ListImage.getInstance();

    int index = 0;
    int longueurListImage = listImage.getLongueurListe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null != savedInstanceState) {
            index = savedInstanceState.getInt("index");
        }

        displayImage(index);

        addListenerOnButton();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", listImage.getPosition());
    }

    public void addListenerOnButton() {

        buttonSuivant = (Button) findViewById(R.id.idSuivant);
        buttonSuivant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                displayImageSuivante();
            }

        });

        buttonPrecedent = (Button) findViewById(R.id.idPrecedent);
        buttonPrecedent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                displayImagePrecedente();
            }

        });

        buttonNew = (Button) findViewById(R.id.idNew);
        buttonNew.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {
                reinitListe();
                return true;
            }

        });

    }

    public void displayImageSuivante() {
        displayImage(listImage.getNextImage());
    }

    public void displayImagePrecedente() {
        displayImage(listImage.getPreviousImage());
    }

    public void displayImage(int index) {
        displayImage(listImage.getImage(index));
    }

    public void reinitListe() {
        listImage.reInit();

        displayImageSuivante();
    }

    public void displayImage(Image image) {
        imageGauche = (ImageView) findViewById(R.id.alphaGauche);
        imageDroite = (ImageView) findViewById(R.id.alphaDroite);


        if (image != null) {
            imageGauche.setImageResource(image.getIdGauche());
            imageDroite.setImageResource(image.getIdDroite());
        }

        displayCompteur();
    }

    public void displayCompteur() {
        compteur = (TextView) findViewById(R.id.idCompteur);

        compteur.setText(new StringBuffer()
                .append(Integer.toString(listImage.getPosition()))
                .append(" / ")
                .append(Integer.toString(longueurListImage)));
    }


}

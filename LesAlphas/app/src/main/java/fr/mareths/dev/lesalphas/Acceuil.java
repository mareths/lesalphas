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

public class Acceuil extends AppCompatActivity {


    Button buttonSuivant;
    Button buttonPrecedent;
    Button buttonNew;
    ImageView imageDroite;
    ImageView imageGauche;

    ListImage listImage = ListImage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayImageSuivante();

        addListenerOnButton();
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
        buttonNew.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                reinitListe();
            }

        });

    }

    public void displayImageSuivante() {
        displayImage(listImage.getNextImage());
    }

    public void displayImagePrecedente() {
        displayImage(listImage.getPreviousImage());
    }

    public void reinitListe() {
        listImage.reInit();

        displayImageSuivante();
    }

    //Test Git

    public void displayImage(Image image) {
        imageGauche = (ImageView) findViewById(R.id.alphaGauche);
        imageDroite = (ImageView) findViewById(R.id.alphaDroite);

        if (image != null) {
            imageGauche.setImageResource(image.getIdGauche());
            imageDroite.setImageResource(image.getIdDroite());
        }

    }


}

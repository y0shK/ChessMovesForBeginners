package com.example.chessmovesforbeginners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // inflate overflowMenu with info_menu.xml
    // https://stackoverflow.com/questions/5180105/creating-menu-in-android
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu, menu);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.android_bg_no_border);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    public void getAppInfo() {
        Intent appInfoIntent = new Intent(this, AppInfo.class);
        startActivity(appInfoIntent);
    }

    // check if info menu is pressed, then move to the appropriate activity
    // https://stackoverflow.com/questions/38887304/what-does-this-method-do-super-oncreateoptionmenu-and-super-onoptionsitemselec
    // switch statement works, even if it looks deprecated
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection - can be for 1 menu item or for multiple menu items
        switch (item.getItemId()) {
            case R.id.info_menu: // if the item selected is the "get info" item
                getAppInfo(); // get the app info by creating a new intent and switching activities
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // create activity to click on each piece's imageView and transition to the info screen

    // https://stackoverflow.com/questions/3412180/how-to-determine-which-button-pressed-on-android/
    public String getTextOfButton(View view){
        Button btn = (Button) findViewById(view.getId());
        String text = btn.getText().toString();
        //System.out.println(text);
        return text.toLowerCase();
    }

    public void getChessPieceInfo(View view) {

        String pieceClicked = getTextOfButton(view);
        Intent pieceIntent;

        if (pieceClicked.equals("pawn")) {
            pieceIntent = new Intent(this, PawnJava.class);
        }
        else if (pieceClicked.equals("knight")) {
            pieceIntent = new Intent(this, KnightJava.class);
        }
        else if (pieceClicked.equals("bishop")) {
            pieceIntent = new Intent(this, BishopJava.class);
        }
        else if (pieceClicked.equals("rook")) {
            pieceIntent = new Intent(this, RookJava.class);
        }
        else if (pieceClicked.equals("queen")) {
            pieceIntent = new Intent(this, QueenJava.class);
        }
        else { // king
            pieceIntent = new Intent(this, KingJava.class);
        }
        startActivity(pieceIntent);

        //Intent pieceIntent = new Intent(this, )
    }

    /*
    public void getPawnInfo(View view) {
        Intent pawnIntent = new Intent(this, PawnJava.class);
        startActivity(pawnIntent);
    }

    public void getKnightInfo(View view) {
        Intent knightIntent = new Intent(this, KnightJava.class);
        startActivity(knightIntent);
    }
    */

}
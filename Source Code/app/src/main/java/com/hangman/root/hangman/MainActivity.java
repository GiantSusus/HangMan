package com.hangman.root.hangman;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends ActionBarActivity {

    /*
    *  TO DO!
    *  App logic:
    *  1. small - capital characters: -> guessright
    *  2. restrict the user input to only one letter: -> android:maxLength="10"
    *  3. modify the function so that we can have spaces after the dashes
    *  Database:
    *  1. Create a word list and load the words randomly to the game
    *  2. connect to mySql database
    *  Web
    *  1. create login function
    * */

    Button button;
    TextView randomWord, missWord;
    EditText editText;
    String guessword, misses;
    char letter;
    StringBuilder status = new StringBuilder();
    Random rand = new Random();
    int guesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i("something", "Content");
        //System.out.println("----------------" + "\n" + "some" + "\n" +"----------------" );

        misses = "";
        guessword = "Songoku";
        guessword = guessword.toUpperCase();

        randomWord  = (TextView) findViewById(R.id.random_word);
        missWord = (TextView) findViewById(R.id.test_word);
        editText = (EditText) findViewById(R.id.edit_text1);
        button = (Button) findViewById(R.id.button1);

        generate_dash();

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Perform action on click
                guessRight(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // guessing
    void guessRight(View v) {

        letter = editText.getText().charAt(0);
        letter = Character.toUpperCase(letter);

        if (alreadyUsed(letter)) return;

        for (int i = 0; i < guessword.length(); i++) {
            if (guessword.charAt(i) == letter) {
                status.setCharAt(i*2, letter);
            }
        }
        randomWord.setText(status + "");
        editText.setText("");

        if (letterNotInWord(letter)) return;

        //Toast.makeText(this, "The length: " + status.length(), Toast.LENGTH_SHORT).show();
        if (guessword.equals(status + ""))
            gameOver(true);
    }

    // generates dashes instead of the word that the user has to get right
    void generate_dash() {

        status.delete(0, status.length());

        for (int i = 0; i < guessword.length(); i++ ) {
            status.append("_ ");
        }
        randomWord.setText(status.toString());
    }

    // checks if the letter input was already used
    boolean alreadyUsed (char letter) {
        // == -1 refers to that it didnt find the letter
        if ((status + misses).indexOf(letter) == -1 && status.indexOf(letter + "") == -1)
            return false;

        editText.setText("");
        Toast.makeText(this, "Letter: " + letter + " is already used!", Toast.LENGTH_SHORT).show();

        return true;
    }

    // checks if the letter input was in the guessword
    boolean letterNotInWord(char letter) {

        if (guessword.indexOf(letter) != -1)
            return false;

        misses += letter + " ";

        // update  misses textView
        missWord.setText(misses);

        editText.setText("");
        // if no more guesses are left, you lost
        return true;
    }

    // we will need a future condition, when it will be game over and someone loses
    void gameOver(Boolean youWon) {
        String message =
           youWon ? "Congrats, you won!" : "This was the word: " + guessword + " You Lost!"; // ? : if yes(?) or :no options

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

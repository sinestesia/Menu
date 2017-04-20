package es.pamp.menu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    private Fragmento1 fragmento1;
    private Fragmento2 fragmento2;
    private Fragmento3 fragmento3;
    private Menu menu;

    private int botonPulsado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.menu1:
                fragmento1 = new Fragmento1();
                transaction.replace(R.id.contenedor, fragmento1);
                transaction.commit();
                botonPulsado=1;
                invalidateOptionsMenu();
                return true;
            case R.id.menu2:
                fragmento2 = new Fragmento2();
                transaction.replace(R.id.contenedor, fragmento2);
                transaction.commit();
                botonPulsado=2;
                invalidateOptionsMenu();
                return true;
            case R.id.menu3:
                fragmento3 = new Fragmento3();
                transaction.replace(R.id.contenedor, fragmento3);
                transaction.commit();
                botonPulsado=3;
                invalidateOptionsMenu();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.menu1).setEnabled(true);
        menu.findItem(R.id.menu2).setEnabled(true);
        menu.findItem(R.id.menu3).setEnabled(true);

        switch (botonPulsado) {
            case 1:
                menu.findItem(R.id.menu1).setEnabled(false);
                break;
            case 2:
                menu.findItem(R.id.menu2).setEnabled(false);
                break;
            case 3:
                menu.findItem(R.id.menu3).setEnabled(false);
                break;
            default:
                break;
        }

        return super.onPrepareOptionsMenu(menu);
    }
}

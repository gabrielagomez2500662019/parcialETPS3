package sv.edu.utec.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import sv.edu.utec.menuopciones.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.menuopciones.clases.CamFragment;
import sv.edu.utec.menuopciones.clases.FavFragment;
import sv.edu.utec.menuopciones.clases.PricipalFragment;
import sv.edu.utec.menuopciones.clases.SearchFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav = findViewById(R.id.btnNav);
        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    seleccionFrag = new PricipalFragment();
                    break;
                case R.id.nav_fav:
                    seleccionFrag = new FavFragment();
                    break;
                case R.id.nav_cam:
                    seleccionFrag = new CamFragment();
                    break;
                case R.id.nav_src:
                    seleccionFrag = new SearchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont,seleccionFrag).commit();
            return true;
        }
    };
}
package sv.edu.utec.menuopciones.clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import sv.edu.utec.menuopciones.Helper.AdminSQLiteOpenHelper;
import sv.edu.utec.menuopciones.R;

public class FavFragment extends Fragment {

    EditText txtNombre,txtApellido,txtTelefono,txtCorreo;
    Button btnUpdates;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_fav,container,false);

        txtNombre=view.findViewById(R.id.edtNombre);
        txtApellido=view.findViewById(R.id.edtApellidos);
        txtTelefono=view.findViewById(R.id.edtTelefono);
        txtCorreo=view.findViewById(R.id.edtCorreo);
        btnUpdates=view.findViewById(R.id.btnUpdate);

        btnUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(),"parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String nombre=txtNombre.getText().toString();
                String apellido=txtApellido.getText().toString();
                String telefono=txtTelefono.getText().toString();
                String correo=txtCorreo.getText().toString();
                ContentValues informacion =new ContentValues();
                informacion.put("nombre",nombre);
                informacion.put("apellidos",apellido);
                informacion.put("telefono",telefono);
                informacion.put("correo",correo);

                int cat=bd.update("contactos",informacion,
                        "correo='"+correo+"'",null);
                bd.close();
                if(cat==1){
                    Toast.makeText(getActivity().getApplicationContext(),"Se modifico el producto",Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"No se modifico el producto",Toast.LENGTH_LONG).show();

                }
            }
        });

        return view;
    }
}

package com.agc.dataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ib.custom.toast.CustomToastView;
import com.omarshehe.forminputkotlin.FormInputText;

import java.util.ArrayList;

import Models.Ciudad;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private FormInputText Id;
    private FormInputText Nombre;
    private FormInputText Poblacion;
    private FormInputText Latitud;
    private FormInputText Longitud;
    private Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Id= findViewById(R.id.IdCiudad);
        Nombre =findViewById(R.id.NombreCiudad);
        Poblacion= findViewById(R.id.PoblacionCiudad);
        Latitud= findViewById(R.id.LatitudCiudad);
        Longitud= findViewById(R.id.LongitudCiudad);
        btnagregar= findViewById(R.id.btnagregarciudad);

        btnagregar.setOnClickListener(this);
        //llamando el metodo del id automatico
        Idautomatico();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btnagregarciudad) {
            int IdCiudad = Integer.parseInt(Id.getValue());
            String NombreCiudad = Nombre.getValue();
            int PoblacionCiudad = Integer.parseInt(Poblacion.getValue());
            double LatitudCiudad = Double.parseDouble(Latitud.getValue());
            double LongitudCiudad = Double.parseDouble(Longitud.getValue());

            //variables de obtencion
            ciudad(IdCiudad,NombreCiudad,PoblacionCiudad,LatitudCiudad,LongitudCiudad);

        }
    }
    public void ciudad(int IdCiudad,String NombreCiudad, int PoblacionCiudad,double LatitudCiudad, double LongitudCiudad){

        if(IdCiudad==0){
            CustomToastView.makeInfoToast(this,"Error al validar el Id",R.layout.custom_toast).show();
            return;
        }
        if (NombreCiudad.equals("")) {
            CustomToastView.makeErrorToast(this, "Error al validar el nombre de la ciudad", R.layout.custom_toast).show();
            return;
        }
        if(PoblacionCiudad==0){
            CustomToastView.makeInfoToast(this,"Error al validar la población",R.layout.custom_toast).show();
            return;
        }
        if(LatitudCiudad==0){
            CustomToastView.makeInfoToast(this,"Error al validar la latitud",R.layout.custom_toast).show();
            return;
        }
        if(LongitudCiudad==0){
            CustomToastView.makeInfoToast(this,"Error al validar la longitud",R.layout.custom_toast).show();
            return;
        }

        //instanciar clase
        Ciudad ciudad= new Ciudad();
        ciudad.setId(IdCiudad);
        ciudad.setNombre(NombreCiudad);
        ciudad.setPoblacion(PoblacionCiudad);
        ciudad.setLatitud(LatitudCiudad);
        ciudad.setLongitud(LongitudCiudad);

        //instanciar la base de datos
        MyDbHelper db=new MyDbHelper(this);
        db.InsertCiudad(db.getWritableDatabase(),ciudad);

        Idautomatico();
        Nombre.setValue("");
        Poblacion.setValue("");
        Latitud.setValue("");
        Longitud.setValue("");


        // lista para guardar los atributos
        ArrayList<Ciudad> ciudades = db.seleccionCiudad(db.getWritableDatabase());
        int i = 1;
        for(Ciudad Seleccion : ciudades){
            System.out.println("Ciudad Id: " + Seleccion.getId() + " Nombre: " + Seleccion.getNombre() +
                    "Población: "+ Seleccion.getPoblacion() + "Latitud: " + Seleccion.getLatitud() +
                    "Longitud: "+ Seleccion.getLongitud());
        }

    }
    public void Idautomatico(){
        MyDbHelper db=new MyDbHelper(this);
        int idauto= db.SiguienteId(db.getWritableDatabase());
        Id.setValue(String.valueOf(idauto));
    }

}
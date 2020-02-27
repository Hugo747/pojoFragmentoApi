package com.proyectoc.pollofracmentopi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.proyectoc.pollofracmentopi.api.Api;
import com.proyectoc.pollofracmentopi.api.RetrofitClient;
import com.proyectoc.pollofracmentopi.model.RespuestaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView pregunta, categoria, dificultad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {


            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {

                categoria.setText(response.body().getResults().get(0).getQuestion());
                pregunta.setText(response.body().getResults().get(0).getQuestion());
                dificultad.setText(response.body().getResults().get(0).getQuestion());

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {


           //     log.e("errores", t.toString());

                Toast.makeText(MainActivity.this, "Algo Fallo", Toast.LENGTH_SHORT).show();

            }


      });


     }


    private void initializeViews(){
        pregunta = findViewById(R.id.pregunta1);
        categoria = findViewById(R.id.categoria);
        dificultad = findViewById(R.id.dificultad);

    }




}

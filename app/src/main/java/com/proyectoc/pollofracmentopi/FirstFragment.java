package com.proyectoc.pollofracmentopi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private TextView pregunta, categoria, dificultad;
private Button button;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public FirstFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_first, container, false);
       // return inflater.inflate(R.layout.fragment_first, container, false);

///////////////////////////////////////
        initializeViews(view);
///////////////////////////////////////
        Log.e ("error","oon_create_View");
///////////////////////////////////////
        pregunta.setText(mParam1);
        categoria.setText(mParam2);


/////////////////////////////////////////////////////////////
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Toast.makeText(getContext(), "Holita", Toast.LENGTH_SHORT).show();
        pasarAlotro();

        shareWithWhatsApp(v);

    }
});

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    ////////////////////////////////////////////////////////////////////
    private void initializeViews(View view){
        pregunta = view.findViewById(R.id.pregunta1);
        categoria = view.findViewById(R.id.categoria);
        dificultad = view.findViewById(R.id.dificultad);

        button =view.findViewById(R.id.buttonInFragment1);

    }



    private void pasarAlotro(){

        SecondFragment secondFragment = SecondFragment.newInstance("","");
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.framelayout,secondFragment,"SECONDFRAGMENT")
                .commit();
    }


    public void shareWithWhatsApp(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "¡Hola! te comparto mi niota obtenida hoy: " +
               pregunta.getText().toString());
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
    }

}

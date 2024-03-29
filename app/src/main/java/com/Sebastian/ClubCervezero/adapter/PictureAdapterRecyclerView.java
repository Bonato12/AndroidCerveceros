package com.Sebastian.ClubCervezero.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.Sebastian.ClubCervezero.MapsActivity;
import com.Sebastian.ClubCervezero.R;
import com.Sebastian.ClubCervezero.model.Picture;
import com.squareup.picasso.Picasso;
import com.Sebastian.ClubCervezero.view.fragments.PictureDetailActivity;


import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, FragmentActivity activity) {

        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;

    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inicializamos la clase ViewHolder para que encuentre todas las vistas

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        PictureViewHolder pictureViewHolder = new PictureViewHolder(view);

        return pictureViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PictureViewHolder holder, int position) {

        // aca trabajamos con la lista de objetos, y esto va a ir cacheando las cards que se van creando

        final Picture picture = pictures.get(position);

        // a traves del objeto holder, obtengo los datos
        // falta setear imagen
        holder.nameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.promocionCard.setText(picture.getPromocion());
        holder.likesCard.setText(picture.getLikesNumber());

        // modificamos el contexto y llamamos a picture para insertar las imagenes

        //Picasso.get().load(picture.getPicture()).into(holder.pictureCard);
        Picasso.with(activity).load(picture.getPicture()).error(R.drawable.ic_home).into(holder.pictureCard);
        // con la version 2.5.2 de picasso se usa with(activity) y no get()
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        // utilizamos el objeto holder, pasa el parametro
        //hacemos clickelable la card
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(activity, PictureDetailActivity.class);
                //activity.startActivity(intent);
                /*
                Intent intent = new Intent(activity, MapsActivity.class);
                intent.putExtra("latitud", picture.getLatitud());
                intent.putExtra("longitud",picture.getLongitud());
                activity.startActivity(intent);

                 */
                Intent intent = new Intent(activity, PictureDetailActivity.class);
                intent.putExtra("titulo", picture.getUserName());
                intent.putExtra("descripcion", picture.getDescripcion());
                intent.putExtra("likes", picture.getLikesNumber());
                intent.putExtra("latitud", picture.getLatitud());
                intent.putExtra("longitud",picture.getLongitud());

                activity.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {

        return pictures.size();

    }


    // esta es la clase inner, que trabaja todos los view de las tarjetas
    // Esta clase  PictureViewHolder trabaja con todos los view de las cardView que la componen
    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView nameCard;
        private TextView timeCard;
        private TextView promocionCard;
        private TextView likesCard;
       // private CheckBox likeCheckCard;


        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            // instanciamos sobre las clases inners

            pictureCard = itemView.findViewById(R.id.pictureCard);
            nameCard = itemView.findViewById(R.id.cardViewName);
            timeCard = itemView.findViewById(R.id.timeCard);
            promocionCard = itemView.findViewById(R.id.promocionCard);
            likesCard = itemView.findViewById(R.id.likesCard);
           // likeCheckCard = itemView.findViewById(R.id.likeCheckCard);


        }

    }
}

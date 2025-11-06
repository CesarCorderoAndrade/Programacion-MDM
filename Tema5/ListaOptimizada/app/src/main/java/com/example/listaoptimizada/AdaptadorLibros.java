package com.example.listaoptimizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdaptadorLibros extends RecyclerView.Adapter<AdaptadorLibros.LibrosViewHolder> {

    private Libros[] listaLibros;
    public AdaptadorLibros(Libros[] listaLibros){
        this.listaLibros = listaLibros;
    }
    private Context context;

    @NonNull
    @Override
    public LibrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.libros_item, parent, false);
        return new LibrosViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosViewHolder holder, int position) {
        holder.BindLibro(this.listaLibros[position]);

    }

    @Override
    public int getItemCount() {
        return this.listaLibros.length;
    }

    public static class LibrosViewHolder extends RecyclerView.ViewHolder{

    public TextView tituloView;
    public ImageView portadaView;
    private Context context;

    public LibrosViewHolder(View view, Context context){

        super(view);
        this.context = context;

        tituloView = view.findViewById(R.id.textView);
        portadaView = view.findViewById(R.id.imageView);
    }

    public void BindLibro(Libros libro){
        tituloView.setText(libro.titulo);
        portadaView.setImageResource(
                context.getResources()
                        .getIdentifier(libro.image,
                                "drawable",
                                "com.example.listas"));
    }
  }
}
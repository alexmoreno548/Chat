package aula8.proyecto;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by xavier on 12/07/16.
 */
public class AdaptadorPreguntas extends RecyclerView.Adapter<AdaptadorPreguntas.AdaptadorViewHolder> {

    private List<Usuario> items;

    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagenUsuario;
        private TextView nombreUsuario;
        private TextView preguntaUsuario;
        private Button botonRespuesta;
        private Button botonExpandir;
        private FragmentManager fm;
        private Context context;

        public AdaptadorViewHolder(View v) {
            super (v);
            imagenUsuario = (ImageView) v.findViewById(R.id.imagenUsuario);
            nombreUsuario = (TextView) v.findViewById(R.id.nombreUsuario);
            preguntaUsuario = (TextView) v.findViewById(R.id.preguntaUsuario);
            preguntaUsuario.setMovementMethod(new ScrollingMovementMethod());
            botonRespuesta = (Button) v.findViewById(R.id.botonRespuesta);
            botonExpandir = (Button) v.findViewById(R.id.expandir);

        }

    }

    public AdaptadorPreguntas(List<Usuario> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pregunta_card,viewGroup,false);
        return new AdaptadorViewHolder(v);
    }



    public void onBindViewHolder(final AdaptadorViewHolder viewHolder, int i) {
        final int imagen = items.get(i).getImagen();
        viewHolder.imagenUsuario.setImageResource(items.get(i).getImagen());
        viewHolder.nombreUsuario.setText(items.get(i).getNombre());
        viewHolder.preguntaUsuario.setText(String.valueOf(items.get(i).getCorreo()));
        viewHolder.botonRespuesta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.botonRespuesta:
                        viewHolder.botonRespuesta.setText("Respondido");
                        viewHolder.botonRespuesta.setBackgroundColor(Color.BLUE);
                    break;

                }
            }
        });
        viewHolder.botonExpandir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.expandir:
                        AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                        View dialog  = LayoutInflater.from(v.getContext()).inflate(R.layout.pregunta_expandida, null);
                        alert.setView(dialog);

                        ImageView imageView = (ImageView)dialog.findViewById(R.id.imagenUsuario);
                        imageView.setImageResource(imagen);
                        TextView textView = (TextView)dialog.findViewById(R.id.nombreUsuario);
                        textView.setText(viewHolder.nombreUsuario.getText().toString());
                        TextView textViewPregunta = (TextView)dialog.findViewById(R.id.preguntaUsuario);
                        textViewPregunta.setText(viewHolder.preguntaUsuario.getText().toString());
                        Button botonCerrar = (Button)dialog.findViewById(R.id.botonCerrar);
                        final AlertDialog alertDialog = alert.create();
                        botonCerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });
                        alertDialog.show();

                    break;
                }
            }
        });

    }
}

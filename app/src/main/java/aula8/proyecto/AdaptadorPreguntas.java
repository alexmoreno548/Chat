package aula8.proyecto;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xavier on 12/07/16.
 */
public class AdaptadorPreguntas extends RecyclerView.Adapter<AdaptadorPreguntas.AdaptadorViewHolder> {

    private List<Usuario> items;

    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textView1;
        private Button botonRespuesta;

        public AdaptadorViewHolder(View v) {
            super (v);
            imageView = (ImageView) v.findViewById(R.id.imagenUsuario);
            textView = (TextView) v.findViewById(R.id.nombreUsuario);
            textView1 = (TextView) v.findViewById(R.id.preguntaUsuario);
            botonRespuesta = (Button) v.findViewById(R.id.botonRespuesta);
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
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pregunta_card,viewGroup,false);
        return new AdaptadorViewHolder(v);
    }


    public void onBindViewHolder(final AdaptadorViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(items.get(i).getImagen());
        viewHolder.textView.setText(items.get(i).getNombre());
        viewHolder.textView1.setText("Correo: "+String.valueOf(items.get(i).getCorreo()));
        viewHolder.botonRespuesta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                switch (v.getId())
                {
                    case R.id.botonRespuesta:
                        viewHolder.botonRespuesta.setText("Respondido");
                    break;
                }
            }
        });

    }
}

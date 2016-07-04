package aula8.proyecto.petanias.pestanias;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by xavier on 30/06/16.
 */
public class FragmentProfesor extends android.support.v4.app.Fragment
{
    private View rootView;
    private Activity activity;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_profesor, container, false);

        return rootView;
    }
}

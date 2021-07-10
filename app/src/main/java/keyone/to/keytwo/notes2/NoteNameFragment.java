package keyone.to.keytwo.notes2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class NoteNameFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_note_name, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout linearLayout) {
        String[] cities = getResources().getStringArray(R.array.names);
        for (int i = 0; i < cities.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(cities[i]);
            textView.setTextSize(30);
            final int FINAL_I = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).currentNote = new Note(FINAL_I);
                    showNoteDescription(((MainActivity) getActivity()).currentNote);
                }
            });
            linearLayout.addView(textView);
        }
    }

    private void showNoteDescription(Note currentNote) {
            showPortNoteDescription(currentNote);
    }

 
    private void showPortNoteDescription(Note currentNote) {
        // Мы полностью перешли на single-activity архитектуру, и теперь все проиходит в MainActivity
        Toast.makeText(getActivity(), " Выбрана заметка " + currentNote.getNoteName(getActivity()) + " \nМы полностью перешли на single-activity архитектуру, и теперь все проиходит в MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
}
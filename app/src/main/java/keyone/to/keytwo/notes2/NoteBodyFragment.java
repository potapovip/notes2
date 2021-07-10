package keyone.to.keytwo.notes2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class NoteBodyFragment extends Fragment {

    public static final String ARG_NOTE = "note";
    private Note note;


    public static NoteBodyFragment newInstance(Note note) {
        NoteBodyFragment fragment = new NoteBodyFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            note = getArguments().getParcelable(ARG_NOTE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_body, container, false);
        TextView textViewBody = view.findViewById(R.id.body_of_note);
        TextView textViewDate = view.findViewById(R.id.date_of_note);
        DatePicker datePicker = view.findViewById(R.id.date_picker);
        textViewDate.setText(note.getNoteName(getContext()));
        textViewBody.setText(note.getNoteBody(getContext()));
        return view;
    }
}
package keyone.to.keytwo.notes2;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {


    //так как у нас все данные заметок(кроме даты) хранятся в массивах, нам нужен будет только индекс заметки
    private int noteIndex;



    public Note(int contentIndex){
        this.noteIndex = contentIndex;
    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public String getNoteName(Context mContext) {
        return mContext.getResources().getStringArray(R.array.names)[noteIndex];
    }

    public String getNoteBody(Context mContext) {
        return mContext.getResources().getStringArray(R.array.text)[noteIndex];
    }





    
    /*  блок сохранения состояния*/
    protected Note(Parcel in) {
        noteIndex = in.readInt();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getNoteIndex());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public  Note[] newArray(int size) {
            return new Note[size];
        }
    };
    /*  блок сохранения состояния*/
}

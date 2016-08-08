package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon implements Parcelable {

    @SerializedName("URL")
    @Expose
    public String uRL;
    @SerializedName("Height")
    @Expose
    public String height;
    @SerializedName("Width")
    @Expose
    public String width;


    protected Icon(Parcel in) {
        uRL = in.readString();
        height = in.readString();
        width = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uRL);
        dest.writeString(height);
        dest.writeString(width);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() {
        @Override
        public Icon createFromParcel(Parcel in) {
            return new Icon(in);
        }

        @Override
        public Icon[] newArray(int size) {
            return new Icon[size];
        }
    };
}

package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maintainer implements Parcelable {

    @SerializedName("github")
    @Expose
    public String github;


    protected Maintainer(Parcel in) {
        github = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(github);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Maintainer> CREATOR = new Parcelable.Creator<Maintainer>() {
        @Override
        public Maintainer createFromParcel(Parcel in) {
            return new Maintainer(in);
        }

        @Override
        public Maintainer[] newArray(int size) {
            return new Maintainer[size];
        }
    };
}
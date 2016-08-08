package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic implements Parcelable {

    @SerializedName("Result")
    @Expose
    public String result;
    @SerializedName("Icon")
    @Expose
    public Icon icon;
    @SerializedName("FirstURL")
    @Expose
    public String firstURL;
    @SerializedName("Text")
    @Expose
    public String text;


    protected RelatedTopic(Parcel in) {
        result = in.readString();
        icon = (Icon) in.readValue(Icon.class.getClassLoader());
        firstURL = in.readString();
        text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeValue(icon);
        dest.writeString(firstURL);
        dest.writeString(text);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<RelatedTopic> CREATOR = new Parcelable.Creator<RelatedTopic>() {
        @Override
        public RelatedTopic createFromParcel(Parcel in) {
            return new RelatedTopic(in);
        }

        @Override
        public RelatedTopic[] newArray(int size) {
            return new RelatedTopic[size];
        }
    };
}
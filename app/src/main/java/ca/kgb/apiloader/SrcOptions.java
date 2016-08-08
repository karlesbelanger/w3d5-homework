package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SrcOptions implements Parcelable {

    @SerializedName("skip_end")
    @Expose
    public String skipEnd;
    @SerializedName("skip_abstract")
    @Expose
    public Integer skipAbstract;
    @SerializedName("skip_qr")
    @Expose
    public String skipQr;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("skip_icon")
    @Expose
    public Integer skipIcon;
    @SerializedName("skip_image_name")
    @Expose
    public Integer skipImageName;
    @SerializedName("directory")
    @Expose
    public String directory;
    @SerializedName("min_abstract_length")
    @Expose
    public String minAbstractLength;
    @SerializedName("skip_abstract_paren")
    @Expose
    public Integer skipAbstractParen;
    @SerializedName("is_wikipedia")
    @Expose
    public Integer isWikipedia;
    @SerializedName("source_skip")
    @Expose
    public String sourceSkip;
    @SerializedName("is_fanon")
    @Expose
    public Integer isFanon;
    @SerializedName("is_mediawiki")
    @Expose
    public Integer isMediawiki;
    @SerializedName("src_info")
    @Expose
    public String srcInfo;


    protected SrcOptions(Parcel in) {
        skipEnd = in.readString();
        skipAbstract = in.readByte() == 0x00 ? null : in.readInt();
        skipQr = in.readString();
        language = in.readString();
        skipIcon = in.readByte() == 0x00 ? null : in.readInt();
        skipImageName = in.readByte() == 0x00 ? null : in.readInt();
        directory = in.readString();
        minAbstractLength = in.readString();
        skipAbstractParen = in.readByte() == 0x00 ? null : in.readInt();
        isWikipedia = in.readByte() == 0x00 ? null : in.readInt();
        sourceSkip = in.readString();
        isFanon = in.readByte() == 0x00 ? null : in.readInt();
        isMediawiki = in.readByte() == 0x00 ? null : in.readInt();
        srcInfo = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(skipEnd);
        if (skipAbstract == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(skipAbstract);
        }
        dest.writeString(skipQr);
        dest.writeString(language);
        if (skipIcon == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(skipIcon);
        }
        if (skipImageName == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(skipImageName);
        }
        dest.writeString(directory);
        dest.writeString(minAbstractLength);
        if (skipAbstractParen == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(skipAbstractParen);
        }
        if (isWikipedia == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isWikipedia);
        }
        dest.writeString(sourceSkip);
        if (isFanon == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isFanon);
        }
        if (isMediawiki == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(isMediawiki);
        }
        dest.writeString(srcInfo);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<SrcOptions> CREATOR = new Parcelable.Creator<SrcOptions>() {
        @Override
        public SrcOptions createFromParcel(Parcel in) {
            return new SrcOptions(in);
        }

        @Override
        public SrcOptions[] newArray(int size) {
            return new SrcOptions[size];
        }
    };
}
package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("DefinitionSource")
    @Expose
    public String definitionSource;
    @SerializedName("Heading")
    @Expose
    public String heading;
    @SerializedName("ImageWidth")
    @Expose
    public Integer imageWidth;
    @SerializedName("RelatedTopics")
    @Expose
    public List<RelatedTopic> relatedTopics = new ArrayList<RelatedTopic>();
    @SerializedName("Entity")
    @Expose
    public String entity;
    @SerializedName("meta")
    @Expose
    public Meta meta;
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("Redirect")
    @Expose
    public String redirect;
    @SerializedName("DefinitionURL")
    @Expose
    public String definitionURL;
    @SerializedName("AbstractURL")
    @Expose
    public String abstractURL;
    @SerializedName("Definition")
    @Expose
    public String definition;
    @SerializedName("AbstractSource")
    @Expose
    public String abstractSource;
    @SerializedName("Infobox")
    @Expose
    public String infobox;
    @SerializedName("Image")
    @Expose
    public String image;
    @SerializedName("ImageIsLogo")
    @Expose
    public Integer imageIsLogo;
    @SerializedName("Abstract")
    @Expose
    public String _abstract;
    @SerializedName("AbstractText")
    @Expose
    public String abstractText;
    @SerializedName("AnswerType")
    @Expose
    public String answerType;
    @SerializedName("ImageHeight")
    @Expose
    public Integer imageHeight;
    @SerializedName("Answer")
    @Expose
    public String answer;
    @SerializedName("Results")
    @Expose
    public List<Object> results = new ArrayList<Object>();


    protected Result(Parcel in) {
        definitionSource = in.readString();
        heading = in.readString();
        imageWidth = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            relatedTopics = new ArrayList<RelatedTopic>();
            in.readList(relatedTopics, RelatedTopic.class.getClassLoader());
        } else {
            relatedTopics = null;
        }
        entity = in.readString();
        meta = (Meta) in.readValue(Meta.class.getClassLoader());
        type = in.readString();
        redirect = in.readString();
        definitionURL = in.readString();
        abstractURL = in.readString();
        definition = in.readString();
        abstractSource = in.readString();
        infobox = in.readString();
        image = in.readString();
        imageIsLogo = in.readByte() == 0x00 ? null : in.readInt();
        _abstract = in.readString();
        abstractText = in.readString();
        answerType = in.readString();
        imageHeight = in.readByte() == 0x00 ? null : in.readInt();
        answer = in.readString();
        if (in.readByte() == 0x01) {
            results = new ArrayList<Object>();
            in.readList(results, Object.class.getClassLoader());
        } else {
            results = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(definitionSource);
        dest.writeString(heading);
        if (imageWidth == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(imageWidth);
        }
        if (relatedTopics == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(relatedTopics);
        }
        dest.writeString(entity);
        dest.writeValue(meta);
        dest.writeString(type);
        dest.writeString(redirect);
        dest.writeString(definitionURL);
        dest.writeString(abstractURL);
        dest.writeString(definition);
        dest.writeString(abstractSource);
        dest.writeString(infobox);
        dest.writeString(image);
        if (imageIsLogo == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(imageIsLogo);
        }
        dest.writeString(_abstract);
        dest.writeString(abstractText);
        dest.writeString(answerType);
        if (imageHeight == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(imageHeight);
        }
        dest.writeString(answer);
        if (results == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(results);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
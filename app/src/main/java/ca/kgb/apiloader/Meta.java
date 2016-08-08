package ca.kgb.apiloader;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable {

    @SerializedName("maintainer")
    @Expose
    public Maintainer maintainer;
    @SerializedName("perl_module")
    @Expose
    public String perlModule;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("production_state")
    @Expose
    public String productionState;
    @SerializedName("dev_date")
    @Expose
    public Object devDate;
    @SerializedName("js_callback_name")
    @Expose
    public String jsCallbackName;
    @SerializedName("signal_from")
    @Expose
    public String signalFrom;
    @SerializedName("live_date")
    @Expose
    public Object liveDate;
    @SerializedName("src_id")
    @Expose
    public Integer srcId;
    @SerializedName("src_options")
    @Expose
    public SrcOptions srcOptions;
    @SerializedName("repo")
    @Expose
    public String repo;
    @SerializedName("developer")
    @Expose
    public List<Developer> developer = new ArrayList<Developer>();
    @SerializedName("tab")
    @Expose
    public String tab;
    @SerializedName("producer")
    @Expose
    public Object producer;
    @SerializedName("unsafe")
    @Expose
    public Integer unsafe;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("dev_milestone")
    @Expose
    public String devMilestone;
    @SerializedName("topic")
    @Expose
    public List<String> topic = new ArrayList<String>();
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("attribution")
    @Expose
    public Object attribution;
    @SerializedName("created_date")
    @Expose
    public Object createdDate;
    @SerializedName("example_query")
    @Expose
    public String exampleQuery;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("is_stackexchange")
    @Expose
    public Object isStackexchange;
    @SerializedName("designer")
    @Expose
    public Object designer;
    @SerializedName("src_domain")
    @Expose
    public String srcDomain;
    @SerializedName("src_name")
    @Expose
    public String srcName;
    @SerializedName("blockgroup")
    @Expose
    public Object blockgroup;
    @SerializedName("src_url")
    @Expose
    public Object srcUrl;


    protected Meta(Parcel in) {
        maintainer = (Maintainer) in.readValue(Maintainer.class.getClassLoader());
        perlModule = in.readString();
        status = in.readString();
        productionState = in.readString();
        devDate = (Object) in.readValue(Object.class.getClassLoader());
        jsCallbackName = in.readString();
        signalFrom = in.readString();
        liveDate = (Object) in.readValue(Object.class.getClassLoader());
        srcId = in.readByte() == 0x00 ? null : in.readInt();
        srcOptions = (SrcOptions) in.readValue(SrcOptions.class.getClassLoader());
        repo = in.readString();
        if (in.readByte() == 0x01) {
            developer = new ArrayList<Developer>();
            in.readList(developer, Developer.class.getClassLoader());
        } else {
            developer = null;
        }
        tab = in.readString();
        producer = (Object) in.readValue(Object.class.getClassLoader());
        unsafe = in.readByte() == 0x00 ? null : in.readInt();
        id = in.readString();
        devMilestone = in.readString();
        if (in.readByte() == 0x01) {
            topic = new ArrayList<String>();
            in.readList(topic, String.class.getClassLoader());
        } else {
            topic = null;
        }
        name = in.readString();
        attribution = (Object) in.readValue(Object.class.getClassLoader());
        createdDate = (Object) in.readValue(Object.class.getClassLoader());
        exampleQuery = in.readString();
        description = in.readString();
        isStackexchange = (Object) in.readValue(Object.class.getClassLoader());
        designer = (Object) in.readValue(Object.class.getClassLoader());
        srcDomain = in.readString();
        srcName = in.readString();
        blockgroup = (Object) in.readValue(Object.class.getClassLoader());
        srcUrl = (Object) in.readValue(Object.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(maintainer);
        dest.writeString(perlModule);
        dest.writeString(status);
        dest.writeString(productionState);
        dest.writeValue(devDate);
        dest.writeString(jsCallbackName);
        dest.writeString(signalFrom);
        dest.writeValue(liveDate);
        if (srcId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(srcId);
        }
        dest.writeValue(srcOptions);
        dest.writeString(repo);
        if (developer == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(developer);
        }
        dest.writeString(tab);
        dest.writeValue(producer);
        if (unsafe == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(unsafe);
        }
        dest.writeString(id);
        dest.writeString(devMilestone);
        if (topic == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(topic);
        }
        dest.writeString(name);
        dest.writeValue(attribution);
        dest.writeValue(createdDate);
        dest.writeString(exampleQuery);
        dest.writeString(description);
        dest.writeValue(isStackexchange);
        dest.writeValue(designer);
        dest.writeString(srcDomain);
        dest.writeString(srcName);
        dest.writeValue(blockgroup);
        dest.writeValue(srcUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Meta> CREATOR = new Parcelable.Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };
}
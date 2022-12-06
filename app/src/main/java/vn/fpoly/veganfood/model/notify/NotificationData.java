package vn.fpoly.veganfood.model.notify;

import java.io.Serializable;

public class NotificationData implements Serializable {

    private String body;
    private String title;
    private Boolean sound;
    private String type;

    public NotificationData(String body, String title, Boolean sound, String type) {
        this.body = body;
        this.title = title;
        this.sound = sound;
        this.type = type;
    }
}

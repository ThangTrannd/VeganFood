package vn.fpoly.veganfood.model.notify;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListNotification {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static class Data {
        @SerializedName("current_page")
        @Expose
        private Integer currentPage;
        @SerializedName("data")
        @Expose
        private List<Notification> data = null;
        @SerializedName("first_page_url")
        @Expose
        private String firstPageUrl;
        @SerializedName("from")
        @Expose
        private Integer from;
        @SerializedName("last_page")
        @Expose
        private Integer lastPage;
        @SerializedName("last_page_url")
        @Expose
        private String lastPageUrl;
        @SerializedName("next_page_url")
        @Expose
        private Object nextPageUrl;
        @SerializedName("path")
        @Expose
        private String path;
        @SerializedName("per_page")
        @Expose
        private Integer perPage;
        @SerializedName("prev_page_url")
        @Expose
        private Object prevPageUrl;
        @SerializedName("to")
        @Expose
        private Integer to;
        @SerializedName("total")
        @Expose
        private Integer total;

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public List<Notification> getData() {
            return data;
        }

        public void setData(List<Notification> data) {
            this.data = data;
        }

        public String getFirstPageUrl() {
            return firstPageUrl;
        }

        public void setFirstPageUrl(String firstPageUrl) {
            this.firstPageUrl = firstPageUrl;
        }

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getLastPage() {
            return lastPage;
        }

        public void setLastPage(Integer lastPage) {
            this.lastPage = lastPage;
        }

        public String getLastPageUrl() {
            return lastPageUrl;
        }

        public void setLastPageUrl(String lastPageUrl) {
            this.lastPageUrl = lastPageUrl;
        }

        public Object getNextPageUrl() {
            return nextPageUrl;
        }

        public void setNextPageUrl(Object nextPageUrl) {
            this.nextPageUrl = nextPageUrl;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Object getPrevPageUrl() {
            return prevPageUrl;
        }

        public void setPrevPageUrl(Object prevPageUrl) {
            this.prevPageUrl = prevPageUrl;
        }

        public Integer getTo() {
            return to;
        }

        public void setTo(Integer to) {
            this.to = to;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public static class Notification implements Parcelable {
            @SerializedName("id")
            @Expose
            private String id;

            @SerializedName("code")
            @Expose
            private String code;

            @SerializedName("title")
            @Expose
            private String title;

            @SerializedName("scope")
            @Expose
            private String scope;

            @SerializedName("content")
            @Expose
            private String content;

            @SerializedName("product_id")
            @Expose
            private String product_id;

            @SerializedName("status")
            @Expose
            private String status;

            @SerializedName("created_at")
            @Expose
            private String created_at;

            @SerializedName("updated_at")
            @Expose
            private String updated_at;

            @SerializedName("time_send")
            @Expose
            private String time_send;

            @SerializedName("user_id")
            @Expose
            private String user_id;

            @SerializedName("created_user")
            @Expose
            private String created_user;

            @SerializedName("user_read")
            @Expose
            private String user_read;

            @SerializedName("bill_id")
            @Expose
            private String orderId;

            @SerializedName("type")
            @Expose
            private String notifycationType;


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getScope() {
                return scope;
            }

            public void setScope(String scope) {
                this.scope = scope;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getTime_send() {
                return time_send;
            }

            public void setTime_send(String time_send) {
                this.time_send = time_send;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCreated_user() {
                return created_user;
            }

            public void setCreated_user(String created_user) {
                this.created_user = created_user;
            }

            public String getUser_read() {
                return user_read;
            }

            public void setUser_read(String user_read) {
                this.user_read = user_read;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getNotifycationType() {
                return notifycationType;
            }

            public void setNotifycationType(String notifycationType) {
                this.notifycationType = notifycationType;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.code);
                dest.writeString(this.title);
                dest.writeString(this.scope);
                dest.writeString(this.content);
                dest.writeString(this.product_id);
                dest.writeString(this.status);
                dest.writeString(this.created_at);
                dest.writeString(this.updated_at);
                dest.writeString(this.time_send);
                dest.writeString(this.user_id);
                dest.writeString(this.created_user);
                dest.writeString(this.user_read);
                dest.writeString(this.orderId);
                dest.writeString(this.notifycationType);
            }

            public Notification() {
            }

            protected Notification(Parcel in) {
                this.id = in.readString();
                this.code = in.readString();
                this.title = in.readString();
                this.scope = in.readString();
                this.content = in.readString();
                this.product_id = in.readString();
                this.status = in.readString();
                this.created_at = in.readString();
                this.updated_at = in.readString();
                this.time_send = in.readString();
                this.user_id = in.readString();
                this.created_user = in.readString();
                this.user_read = in.readString();
                this.orderId = in.readString();
                this.notifycationType = in.readString();
            }

            public static final Creator<Notification> CREATOR = new Creator<Notification>() {
                @Override
                public Notification createFromParcel(Parcel source) {
                    return new Notification(source);
                }

                @Override
                public Notification[] newArray(int size) {
                    return new Notification[size];
                }
            };
        }
    }
}

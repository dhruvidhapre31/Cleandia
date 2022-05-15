package models;

public class PostModel {
    int postImage;
    String userName, time, address, cases;

    public PostModel(int postImage, String userName, String time, String address, String cases) {
        this.postImage = postImage;
        this.userName = userName;
        this.time = time;
        this.address = address;
        this.cases = cases;
    }

    public int getPostImage() {
        return postImage;
    }
    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCases() {
        return cases;
    }
    public void setCases(String cases) {
        this.cases = cases;
    }
}

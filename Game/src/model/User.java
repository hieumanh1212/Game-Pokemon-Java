package model;
public class User 
{
    private String user;
    private String Pass;
    private int score;
    private int time;
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return Pass;
    }
    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }    
    public User(){       
    }
    public User(String user, String Pass, int score, int time) {
        this.user = user;
        this.Pass = Pass;
        this.score = score;
        this.time = time;
    }
    
    
    
}

package modal.updatepost;

import lombok.Data;
import lombok.Getter;

@Data
public class Reactions {
    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    private int dislikes;
    private int likes;

}

package modal.updatepost;

import lombok.Data;
import lombok.Getter;

@Data
public class Reactions {
    private int dislikes;
    private int likes;

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

}

package modal.updatepost;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class UpdatePosts {
    private Reactions reactions;
    private int id;
    private String title;
    private String body;
    private int userId;
    private List<String> tags;

    public void setReactions(Reactions reactions) {
        this.reactions = reactions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}

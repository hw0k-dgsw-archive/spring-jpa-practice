package kr.hs.dgsw.web_0326.protocols;

import kr.hs.dgsw.web_0326.domains.Comment;
import lombok.Data;

@Data
public class CommentUserProtocol extends Comment {

    public CommentUserProtocol(Comment c, String username) {
        super(c);
        this.username = username;
    }

    private String username;
}

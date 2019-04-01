package kr.hs.dgsw.web_0326.services;

import kr.hs.dgsw.web_0326.domains.Comment;
import kr.hs.dgsw.web_0326.protocols.CommentUserProtocol;

import java.util.List;

public interface CommentService {
    List<CommentUserProtocol> listAllComments();
    CommentUserProtocol addComment(Comment comment);
    CommentUserProtocol viewComment(Long id);
    CommentUserProtocol updateComment(Long id, Comment comment);
    boolean deleteComment(Long id);
}

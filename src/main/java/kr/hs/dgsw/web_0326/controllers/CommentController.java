package kr.hs.dgsw.web_0326.controllers;

import kr.hs.dgsw.web_0326.domains.Comment;
import kr.hs.dgsw.web_0326.protocols.CommentUserProtocol;
import kr.hs.dgsw.web_0326.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public List<CommentUserProtocol> list() {
        return this.commentService.listAllComments();
    }

    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment) {
        return this.commentService.addComment(comment);
    }

    @GetMapping("/comment/{id}")
    public CommentUserProtocol viewComment(@PathVariable Long id) {
        return this.commentService.viewComment(id);
    }

    @PutMapping("/comment/{id}")
    public CommentUserProtocol updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return this.commentService.updateComment(id, comment);
    }

    @DeleteMapping("/comment/{id}")
    public boolean deleteComment(@PathVariable Long id) {
        return this.commentService.deleteComment(id);
    }

}

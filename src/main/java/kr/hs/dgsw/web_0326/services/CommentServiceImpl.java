package kr.hs.dgsw.web_0326.services;

import kr.hs.dgsw.web_0326.domains.Comment;
import kr.hs.dgsw.web_0326.domains.User;
import kr.hs.dgsw.web_0326.protocols.CommentUserProtocol;
import kr.hs.dgsw.web_0326.repositories.CommentRepository;
import kr.hs.dgsw.web_0326.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void init() {
        User user1 = new User("abc1", "abc1@dgsw.hs.kr");
        User user2 = new User("abc2", "abc2@dgsw.hs.kr");
        User user3 = new User("abc3", "abc3@dgsw.hs.kr");

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);

        this.commentRepository.save(new Comment(user1.getId(), "안녕"));
        this.commentRepository.save(new Comment(user2.getId(), "안녕?"));
        this.commentRepository.save(new Comment(user3.getId(), "안녕!"));
    }

    private String getUsernameByComment(Comment comment) {
        return this.userRepository.findById(comment.getUserId())
                .map(User::getUsername)
                .orElse(null);
    }

    @Override
    public List<CommentUserProtocol> listAllComments() {
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentUserProtocol> protocolList = new ArrayList<>();

        commentList.forEach(comment ->
            protocolList.add(new CommentUserProtocol(comment, this.getUsernameByComment(comment)))
        );

        return protocolList;
    }

    @Override
    public CommentUserProtocol addComment(Comment comment) {
        Comment savedComment = this.commentRepository.save(comment);
        return new CommentUserProtocol(savedComment, this.getUsernameByComment(savedComment));
    }

    @Override
    public CommentUserProtocol viewComment(Long id) {
        Optional<Comment> target = this.commentRepository.findById(id);
        if (!target.isPresent()) {
            return null;
        }
        Comment comment = target.get();

        return new CommentUserProtocol(comment, this.getUsernameByComment(comment));
    }

    @Override
    public CommentUserProtocol updateComment(Long id, Comment comment) {
        Optional<Comment> target = this.commentRepository.findById(id);
        if (!target.isPresent()) {
            return null;
        }

        Comment updateComment = target.map(this.commentRepository::save).orElse(null);
        return new CommentUserProtocol(updateComment, this.getUsernameByComment(updateComment));
    }

    @Override
    public boolean deleteComment(Long id) {
        Optional<Comment> target = this.commentRepository.findById(id);
        if (!target.isPresent()) {
            return false;
        }

        this.commentRepository.deleteById(id);
        return true;
    }


}

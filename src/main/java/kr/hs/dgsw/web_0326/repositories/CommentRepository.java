package kr.hs.dgsw.web_0326.repositories;

import kr.hs.dgsw.web_0326.domains.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

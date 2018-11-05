package com.codeup.spring.repositories;

import com.codeup.spring.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PostsRepo extends CrudRepository<Post, Long> {
    //select * from posts where title like '%X%' or body like '%Y%';
    List<Post> findAllByTitleContainsOrBodyContains(String str, String str2);
    //HQL
    @Query("from Post where title like %?1% or body like %?1%")
    List<Post> searchByTitleOrBody(String term);

    @Query("from Post where id like ?1")
    void deleteById(long id);
}
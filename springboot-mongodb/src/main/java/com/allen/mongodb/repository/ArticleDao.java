package com.allen.mongodb.repository;

import com.allen.mongodb.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author allen
 * @date 2022/9/15 9:41
 */
public interface ArticleDao extends MongoRepository<Article, Long> {

    /**
     * 根据标题模糊查询
     *
     * @param title 标题
     * @return 满足条件的文章列表
     */
    List<Article> findByTitleLike(String title);
}

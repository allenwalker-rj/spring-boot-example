package com.allen.mongodb.repository;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.allen.mongodb.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Snowflake snowflake;

    @Test
    public void save() {
        // 插入数据
        Article article = Article.builder()
                .id(snowflake.nextId())
                .title(RandomUtil.randomString(10))
                .content(RandomUtil.randomString(50))
                .createTime(DateUtil.date())
                .updateTime(DateUtil.date())
                .thumbUp(RandomUtil.randomLong(0, 1000))
                .visits(RandomUtil.randomLong(0, 1000))
                .build();

        articleDao.save(article);
        log.info("article : {}", article);
    }

    @Test
    public void update1() {
        // 简单的更新
        articleDao.findById(1570235645018902528L).ifPresent(article -> {
            article.setUpdateTime(DateUtil.date());
            article.setTitle(article.getTitle() + "新加一个更新");
            articleDao.save(article);
            log.info("article : {}", article);
        });
    }


    @Test
    public void update2() {
        // 更加细致的更新
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(1570235644641415168L));
        Update update = Update.update("updateTime", DateUtil.date());
        update.inc("thumbUp", 1);
        update.inc("visits", 1);
        mongoTemplate.updateFirst(query, update, "article");
        articleDao.findById(1570235644641415168L).ifPresent(article -> log.info("article : {}", article));
    }

    @Test
    public void page() {
        // 分页查询
        Sort sort = Sort.by("thumbUp", "updateTime").descending();
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        Page<Article> all = articleDao.findAll(pageRequest);
        log.info("totalPages : {}", all.getTotalPages());
        log.info("totalCount : {}", all.getTotalElements());
        log.info("当前页数据 : {}", Arrays.toString(all.getContent().toArray()));
    }

    @Test
    public void findByTitleLike() {
        // 模糊查询
        List<Article> articles = articleDao.findByTitleLike("更新");
        log.info("article : {}", JSONUtil.toJsonStr(articles));
    }

    @Test
    public void delete() {
        // 根据主键删除
        articleDao.deleteById(1L);
    }
}
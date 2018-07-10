package com.zln.cmfz.dao;

import com.zln.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhanglijiao on 2018/7/8.
 */
public interface ArticleDao {

    public int insertArticle(Article article);


    public List<Article> selectArticles(@Param("begin") Integer begin, @Param("end") Integer end);

    public int count();


}

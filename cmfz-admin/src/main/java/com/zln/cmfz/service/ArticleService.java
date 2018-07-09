package com.zln.cmfz.service;

import com.zln.cmfz.entity.Article;

/**
 * Created by zhanglijiao on 2018/7/8.
 */

public interface ArticleService {

    /**
     * 创建文章
     * @param article
     * @return
     */
    public int addArticle(Article article);
}

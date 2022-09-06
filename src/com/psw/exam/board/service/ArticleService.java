package com.psw.exam.board.service;

import com.psw.exam.board.Container;
import com.psw.exam.board.dto.Article;
import com.psw.exam.board.dao.ArticleDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleService {
  private ArticleDao articleDao;

  public ArticleService() {
    articleDao = Container.articleDao;
  }

  public int add(int memberId, String title, String body) {
    return articleDao.add(memberId, title, body);
  }

  public boolean articleExists(int id) {
    return articleDao.articleExists(id);
  }

  public void delete(int id) {
    articleDao.delete(id);
  }

  public Article getArticleById(int id) {
    return articleDao.getArticleById(id);
  }

  public void update(int id, String title, String body) {
    articleDao.update(id, title, body);
  }

  public void increaseHit(int id) {
    articleDao.increaseHit(id);
  }

  public List<Article> getForPrintArticleById(int page, int pageItemCount) {
    int limitFrom = (page - 1) * pageItemCount;
    int limitTake = pageItemCount;

    Map<String, Object> args = new HashMap<>();
    args.put("limitFrom", limitFrom);
    args.put("limitTake", limitTake);
    return articleDao.getArticles(args);
  }
}

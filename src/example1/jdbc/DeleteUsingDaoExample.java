package example1.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.articleDao;
import example.jdbc.utils.Article;


public class DeleteUsingDaoExample {

	public static void main(String[] args) {
		  DaoInterface<Article, Integer> daoRef=new articleDao();
		  daoRef.delete(201);

	}

}

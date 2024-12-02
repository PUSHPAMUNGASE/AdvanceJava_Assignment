package example1.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.articleDao;
import example.jdbc.utils.Article;

import java.sql.Date;

public class CreateUsingDao {

    public static void main(String[] args) {
        // Create an instance of the DAO for Article
        DaoInterface<Article, Integer> daoRef = new articleDao();

        // Create a new Article object
        Article article = new Article(202, "The Last suffer", "Painting", Date.valueOf("1553-01-01"), "Leonardo da Vinci");

        // Use the DAO to persist the Article
        daoRef.create(article);
    }
}

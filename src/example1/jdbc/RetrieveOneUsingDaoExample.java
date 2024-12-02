package example1.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.articleDao;
import example.jdbc.utils.Article;

public class RetrieveOneUsingDaoExample {

    public static void main(String[] args) {
        // Use ArticleDao instead of RestaurantDao
        DaoInterface<Article, Integer> daoRef = new articleDao();
        
        // Retrieve one article by ID
        Article articleObj = daoRef.retrieveOne(201); // Example ID
        
        if (articleObj != null) {
            System.out.println(articleObj);
        } else {
            System.out.println("Article with the given ID does not exist");
        }
    }
}

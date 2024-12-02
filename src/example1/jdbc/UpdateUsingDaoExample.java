package example1.jdbc;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.articleDao;
import example.jdbc.utils.Article;

import java.sql.Date;

public class UpdateUsingDaoExample {

    public static void main(String[] args) {
        // Use ArticleDao instead of RestaurantDao
        DaoInterface<Article, Integer> daoRef = new articleDao();

        // Obtaining an Article on which update is to be performed
        Article article = daoRef.retrieveOne(201); // Example ID
        
        if (article != null) {
            // Changing the name, category, and creator name using setters
            article.setName("The New Mona Lisa");
            article.setCategory("Masterpiece");
            article.setDateCreated(Date.valueOf("2024-01-01")); // Update date
           article.setCreatorName("Modern Curator");
        	


            // Reflecting this changed state back to the database
            daoRef.update(article);
        } else {
            System.out.println("Article with the given ID does not exist");
        }
    }
}

package example1.jdbc;

import java.util.Collection;

import example.jdbc.dao.DaoInterface;
import example.jdbc.dao.articleDao;
import example.jdbc.utils.Article;

public class RetrieveAllUsingDaoExample {

    public static void main(String[] args) {
        // Use ArticleDao instead of RestaurantDao
        DaoInterface<Article, Integer> daoRef = new articleDao();
        
        // Retrieve all articles
        Collection<Article> allAvailableArticles = daoRef.retriveAll();
        
        // Print each article using a for-each loop
        for (Article currentArticle : allAvailableArticles)
            System.out.println(currentArticle);
        
        System.out.println("====================below from toString and forEach==================");
        
        // Print each article using a stream forEach
        allAvailableArticles.stream().forEach(article -> System.out.println(article));
    }
}

package example.jdbc.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import example.jdbc.utils.Article;
import example.jdbc.utils.JdbcUtils;

public class articleDao implements DaoInterface<Article, Integer> {

	@Override
	public Collection<Article> retriveAll() {
		Collection<Article> allArticles=new ArrayList<Article>();
		String sqlQuery="select * from Article_master";
		try(Connection conn = JdbcUtils.getConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sqlQuery);
				){
			while(rs.next()) {
				int ArticleId=rs.getInt(1);
				String ArticleName=rs.getString(2);
				String ArticleCategory=rs.getString(3);
				Date ArticledateCreated = rs.getDate(4);
				String ArticlecreatorName = rs.getString(5);
				
				Article rst=new Article(ArticleId, ArticleName, ArticleCategory, ArticledateCreated, ArticlecreatorName);
				allArticles.add(rst);	
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return allArticles;
	}

	@Override
	public Article retrieveOne(Integer id) {
		Article foundArticle=null;
		String sqlQuery="select * from Article_master where  id=?";
		
		try (
			    Connection conn = JdbcUtils.getConnection();
			    PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
			) {
			    pstmt.setInt(1, id); // Assuming the query uses a parameterized ID
			    ResultSet rs = pstmt.executeQuery();
			    if (rs.next()) {
			        int articleId = rs.getInt(1);                // Article ID
			        String articleName = rs.getString(2);        // Article name
			        String articleCategory = rs.getString(3);    // Article category
			        Date dateCreated = rs.getDate(4);            // Date created
			        String creatorName = rs.getString(5);        // Creator name
			        
			        // Building Article object based on the retrieved values
			        foundArticle = new Article(articleId, articleName, articleCategory, dateCreated, creatorName);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return foundArticle;

		
	}

	@Override
	public void create(Article article) {
	    String sqlQuery = "INSERT INTO Article_master (id, name, category, date_created, creator_name) VALUES (?, ?, ?, ?, ?)";
	    
	    try (
	        Connection conn = JdbcUtils.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
	    ) {
	        pstmt.setInt(1, article.getId());               // Set ID
	        pstmt.setString(2, article.getName());          // Set Name
	        pstmt.setString(3, article.getCategory());      // Set Category
	        pstmt.setDate(4, article.getDateCreated());     // Set Date Created
	        pstmt.setString(5, article.getCreatorName());   // Set Creator Name

	        int rowsInserted = pstmt.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("Article created successfully!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void update(Article modifiedArticle) {
	    // This method receives the modified state of the Article
	    // object and reflects that state into the database.
	    String sqlQuery = "UPDATE Article_master SET name = ?, category = ?, date_created = ?, creator_name = ? WHERE id = ?";

	    try (
	        Connection conn = JdbcUtils.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
	    ) {
	        // Capturing the modified state of the Article object
	        int articleId = modifiedArticle.getId();
	        String articleName = modifiedArticle.getName();
	        String articleCategory = modifiedArticle.getCategory();
	        Date dateCreated = modifiedArticle.getDateCreated();
	        String creatorName = modifiedArticle.getCreatorName();

	        // Setting parameters in the PreparedStatement
	        pstmt.setString(1, articleName);       // Set name (index 1)
	        pstmt.setString(2, articleCategory);   // Set category (index 2)
	        pstmt.setDate(3, dateCreated);         // Set date_created (index 3)
	        pstmt.setString(4, creatorName);       // Set creator_name (index 4)
	        pstmt.setInt(5, articleId);            // Set ID (index 5)

	        // Executing the update query
	        int updateCount = pstmt.executeUpdate();
	        System.out.println(updateCount + " record updated.");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}


	@Override
	public void delete(Integer id) {
	    // SQL query to delete an article based on its ID
	    String sqlQuery = "DELETE FROM Article_master WHERE id = ?";

	    try (
	        Connection conn = JdbcUtils.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
	    ) {
	        // Setting the ID parameter in the PreparedStatement
	        pstmt.setInt(1, id);

	        // Executing the delete query
	        int deleteCount = pstmt.executeUpdate();
	        System.out.println(deleteCount + " record deleted.");
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}

	

}

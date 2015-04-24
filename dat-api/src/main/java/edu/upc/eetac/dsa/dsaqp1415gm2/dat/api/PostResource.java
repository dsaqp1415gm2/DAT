package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;










import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.PostCollection;



@Path("/themeid/threadid/postid")



public class PostResource {
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	private String GET_POSTS_QUERY = "select s.*, u.name from post s, users u where u.username=s.username order by idpost desc limit ?";
	private String GET_POSTS_QUERY_FROM_LAST = "select s.*, u.name from post s, users u where u.username=s.username  order by idpost desc";
	private String GET_POST_BY_ID_QUERY = "select s.*, u.name from post s, users u where u.username=s.username and s.postid=?";
	private String INSERT_POST_QUERY = "insert into post (user_default,content,image_link) values ('Anonymous', ?, ?)";
	private String DELETE_POST_QUERY = "delete from post where postid=?";
	private String UPDATE_POST_QUERY = "update post set content=ifnull(?, content) where postid=?";
	

	

	
	
	@SuppressWarnings("resource")
	@GET
	@Produces(MediaType.DAT_API_POST_COLLECTION)
	public PostCollection getIdposts(@QueryParam("length") int length,
			@QueryParam("before") long before, @QueryParam("after") long after) {
		
		PostCollection posts = new PostCollection();

		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}

		PreparedStatement stmt = null;
		try {
			ResultSet rs = stmt.executeQuery();
			boolean updateFromLast = after > 0;
			stmt = updateFromLast ? conn // condicion ternaria
					.prepareStatement(GET_POSTS_QUERY_FROM_LAST) : conn
					.prepareStatement(GET_POSTS_QUERY);
			while (rs.next()) {
				Post post = new Post();
				post.setIdpost(rs.getInt("idpost"));
				post.setUser_default(rs.getString("user_default"));
				post.setContent	(rs.getString("content"));
				post.setImage_link(rs.getString("image_link"));
				posts.addPost(post);
				
			}
			
		}
		catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	
	return posts;
}}
	
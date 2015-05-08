package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;

@Path("/post")
public class PostResource {
	
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	
	private String GET_POST_BY_ID_QUERY = "select * from post where idthema=?, idhilo=? and idpost=?";
	private String GET_POST_BY_ID = "select s.*,"
			+ "from post s, where u.username=s.username and s.stingid=?";
	
	@GET
	@Path("/{idtema}/{idhilo}/{idpost}")
	@Produces("application/json")
	public Post getpost(@PathParam("idtema") String idtema, @PathParam("idhilo") String idhilo,
			@PathParam("idpost") String idpost) {
		Post post = getPostFromDB(idtema,idhilo,idpost);
		
		return post;
	}
	private Post getPostFromDB(String idtema, String idhilo, String idpost) {
		Post post = new Post();
	 
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
	 
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(GET_POST_BY_ID_QUERY);
			stmt.setInt(1, Integer.valueOf(idtema));
			stmt.setInt(2, Integer.valueOf(idhilo));
			stmt.setInt(3, Integer.valueOf(idpost));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				post.setIdthema(rs.getInt("idtema"));
				post.setIdhilo(rs.getInt("idhilo"));
				post.setIdpost(rs.getInt("idpost"));
				post.setContent(rs.getString("content"));
				
			} else {
				throw new NotFoundException("There's no post with id="
						+ idpost);
			}
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	 
		return post;
	}
}
		
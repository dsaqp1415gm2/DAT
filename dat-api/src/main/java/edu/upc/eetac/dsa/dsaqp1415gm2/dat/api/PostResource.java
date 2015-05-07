package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Thread.PostCollection;

public class PostResource {
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	private String GET_POSTS_QUERY = "select s.*, u.name from post s, users u where u.username=s.username order by idpost desc limit ?";
	private String GET_POSTS_QUERY_FROM_LAST = "select s.*, u.name from post s, users u where u.username=s.username  order by idpost desc";
	private String GET_POST_BY_ID_QUERY = "select s.*, u.name from post s, users u where u.username=s.username and s.postid=?";
	private String INSERT_POST_QUERY = "insert into post (user_default,content,image_link) values ('Anonymous', ?, ?)";
	private String DELETE_POST_QUERY = "delete from post where postid=?";
	private String UPDATE_POST_QUERY = "update post set content=ifnull(?, content) where postid=?";
	

	/*
	@GET
	@Produces(MediaType.DAT_API_THREAD)
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
			boolean updateFromLast = after > 0;
			stmt = updateFromLast ? conn
					.prepareStatement(GET_POSTS_QUERY_FROM_LAST) : conn
					.prepareStatement(GET_POSTS_QUERY);

		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
			if (Idpost!=0) {
				stmt.getIdpost(1, new Timestamp(after));
			} else {
				if (before > 0)
					stmt.setTimestamp(1, new Timestamp(before));
				else
					stmt.setTimestamp(1, null);
				length = (length <= 0) ? 5 : length;
				stmt.setInt(2, length);
			}
			ResultSet rs = stmt.executeQuery();
			boolean first = true;
			long oldestTimestamp = 0;
			while (rs.next()) {
			}
				
				
				
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	 
		return posts;
	}
	
*/
}

/*if (updateFromLast) {
	stmt.setTimestamp(1, new Timestamp(after));
} else {
	if (before > 0)
		stmt.setTimestamp(1, new Timestamp(before));
	else
		stmt.setTimestamp(1, null);
	length = (length <= 0) ? 5 : length;
	stmt.setInt(2, length);
}
ResultSet rs = stmt.executeQuery();
boolean first = true;
long oldestTimestamp = 0;
while (rs.next()) {
	Sting sting = new Sting();
	sting.setStingid(rs.getInt("stingid"));
	sting.setUsername(rs.getString("username"));
	sting.setAuthor(rs.getString("name"));
	sting.setSubject(rs.getString("subject"));
	sting.setLastModified(rs.getTimestamp("last_modified").getTime());
	sting.setCreationTimestamp(rs.getTimestamp("creation_timestamp").getTime()); 
	oldestTimestamp = rs.getTimestamp("creation_timestamp").getTime();
	sting.setLastModified(oldestTimestamp);
	if (first) {
		first = false;
		stings.setNewestTimestamp(sting.getCreationTimestamp());
	}
	stings.addSting(sting);
}
stings.setOldestTimestamp(oldestTimestamp);*/

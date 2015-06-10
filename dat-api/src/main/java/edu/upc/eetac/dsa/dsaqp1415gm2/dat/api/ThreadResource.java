package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Theme;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Threadx;

@Path("/thread")
public class ThreadResource {
private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	
	private String GET_THREAD_BY_IDS_QUERY = "select * from thread where (idtema=? and idthread=?) order by idthread desc";
	private String GET_THREAD_BY_ID_QUERY = "select * from thread where idthread=? order by idthread desc";
	private String GET_THREADS_QUERY = "select * from thread";
	private String INSERT_THREAD_QUERY = "insert into thread (idtema, idthread, subject, content, imagen) values (?, ?, ?, ?, ?)";
	private String INSERT_POST_QUERY = "insert into post (idthema, idhilo, idpost, content, image_link) values (?, ?, ?, ?, ?)";
	private String DELETE_THREAD_QUERY = "delete from thread where idthread=?";
	private String DELETE_POSTS_QUERY = "delete from post where idhilo=?";
	private String UPDATE_THREAD = "update thread SET lastidpost=? WHERE idthread=?";

	@GET
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreads() {
		Theme theme = new Theme();
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
		
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(GET_THREADS_QUERY);
		
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Threadx threadx= new Threadx();
			threadx.setIdtema(rs.getInt("idtema"));
			threadx.setIdthread(rs.getInt("idthread"));
			threadx.setSubject(rs.getString("subject"));
			threadx.setContent(rs.getString("content"));
			theme.addThread(threadx);
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
	 
		return theme;
	}
	//para obtener un post poniendo la id del tema, del thread y del post.
	@GET
	@Path("/{idtema}/{idthread}")
	@Produces("application/json")
	public Threadx getthreadwithIDs(@PathParam("idtema") String idtema, @PathParam("idthread") String idthread) {
		Threadx threadx = getThreadFromDBwithIDs(idtema,idthread);
		
		return threadx;
	}
	//para obtener un post solo poniendo su ID
	@GET
	@Path("/{idthread}")
	@Produces("application/json")
	public Threadx getthread(@PathParam("idthread") String idthread) {
		Threadx threadx = getThreadFromDB(idthread);
		
		return threadx;
	}
	private Threadx getThreadFromDBwithIDs(String idtema, String idthread) {
		Threadx threadx = new Threadx();
	 
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
	 
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(GET_THREAD_BY_IDS_QUERY);
			stmt.setInt(1, Integer.valueOf(idtema));
			stmt.setInt(2, Integer.valueOf(idthread));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				
			} else {
				throw new NotFoundException("There's no thread with id="
						+ idthread);
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
	 
		return threadx;
	}
	private Threadx getThreadFromDB(String idthread) {
		Threadx threadx = new Threadx();
	 
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
	 
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(GET_THREAD_BY_ID_QUERY);
			stmt.setInt(1, Integer.valueOf(idthread));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				
			} else {
				throw new NotFoundException("There's no thread with id="
						+ idthread);
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
	 
		return threadx;
	}
	@POST
	@Consumes(MediaType.DAT_API_THREAD)
	@Produces(MediaType.DAT_API_THREAD)
	public Threadx createThread(Threadx threadx) {
		validateThreadx(threadx);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
		int idthread=0;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		try {
			stmt = conn.prepareStatement(INSERT_THREAD_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, threadx.getIdtema());
			stmt.setInt(2, 0);
			stmt.setString(3, threadx.getSubject());
			stmt.setString(4, threadx.getContent());
			stmt.setString(5, threadx.getImagen());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				idthread = rs.getInt(1);
			} else {
				// Something has failed...
			}
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
		
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
		}
		try {
			stmt2 = conn.prepareStatement(INSERT_POST_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt2.setInt(1, threadx.getIdtema());
			stmt2.setInt(2, idthread);
			stmt2.setInt(3, 0);
			stmt2.setString(4, threadx.getContent());
			stmt2.setString(5, threadx.getImagen());
			stmt2.executeUpdate();
			ResultSet rs2 = stmt2.getGeneratedKeys();
			if (rs2.next()) {
				int idpost=rs2.getInt(2);
				updateThread(Integer.toString(idpost), Integer.toString(idthread));
			} else {
				// Something has failed...
			}
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt2 != null)
					stmt2.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
		return threadx;
	}
	@POST
	@Path("/post")
	@Consumes(MediaType.DAT_API_THREAD)
	@Produces(MediaType.DAT_API_THREAD)
	public Post createPost(Post post) {
		//validatePost(post);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
		int idthread=0;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(INSERT_POST_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, post.getIdthema());
			stmt.setInt(2, post.getIdhilo());
			idthread=post.getIdhilo();
			stmt.setInt(3,0);
			stmt.setString(4, post.getContent());
			stmt.setString(5, post.getImagelink());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int idpost=rs.getInt(3);
				updateThread(Integer.toString(idpost),Integer.toString(idthread));
			} else {
				// Something has failed...
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
	private void validateThreadx(Threadx threadx) {
		if (threadx.getSubject() == null)
			throw new BadRequestException("Subject can't be null.");
		if (threadx.getContent() == null)
			throw new BadRequestException("Content can't be null.");
		if (threadx.getSubject().length() > 100)
			throw new BadRequestException("Subject can't be greater than 100 characters.");
		if (threadx.getContent().length() > 500)
			throw new BadRequestException("Content can't be greater than 500 characters.");
	}
	@DELETE
	@Path("/{idthread}")
	public void deleteThread(@PathParam("idthread") String idthread) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
	 
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(DELETE_POSTS_QUERY);
			stmt.setInt(1, Integer.valueOf(idthread));
	 
			int rows = stmt.executeUpdate();
			if (rows == 0)
				;// Deleting inexistent sting
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
		}
		PreparedStatement stmt2 = null;
		try {
			stmt2 = conn.prepareStatement(DELETE_THREAD_QUERY);
			stmt2.setInt(1, Integer.valueOf(idthread));
	 
			int rows = stmt2.executeUpdate();
			if (rows == 0)
				;// Deleting inexistent sting
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt2 != null)
					stmt2.close();
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	@PUT
	@Consumes(MediaType.DAT_API_THREAD)
	@Produces(MediaType.DAT_API_THREAD)
	public Threadx updateThread(String idpost, String idthread) {
		//validatePost(post);
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(UPDATE_THREAD);
			stmt.setInt(1, Integer.valueOf(idpost));
			stmt.setInt(2, Integer.valueOf(idthread));
			ResultSet rs = stmt.executeQuery();
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
		Threadx threadx = null;
		return threadx;
	}
}
		
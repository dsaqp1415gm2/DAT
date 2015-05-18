package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Theme;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Threadx;
@Path("/Theme")
public class ThemeResource {
	private String GET_POST_BY_IDS_QUERY = "select * from post where (idthema=? and idhilo=?)";
	private String GET_THREADS_QUERY = "select * from thread where idtema=?";
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	@GET
	public Theme getTheme() {
		Theme api = new Theme();
		return api;
	}
	@GET
	@Path("/Tecnologia")
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreadsTecno() {
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
			stmt.setInt(1, Integer.valueOf(1));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Threadx threadx= new Threadx();
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				String temp = rs.getString("imagen");
				threadx.setImagen(temp);

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
	
	@GET
	@Path("/Deportes")
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreadsDeportes() {
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
			stmt.setInt(1, Integer.valueOf(2));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Threadx threadx= new Threadx();
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				threadx.setImagen(rs.getString("imagen"));
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
	@GET
	@Path("/Motor")
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreadsMotor() {
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
			stmt.setInt(1, Integer.valueOf(3));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Threadx threadx= new Threadx();
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				threadx.setImagen(rs.getString("imagen"));
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
	@GET
	@Path("/Videojuegos")
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreadsVideojuegos() {
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
			stmt.setInt(1, Integer.valueOf(4));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Threadx threadx= new Threadx();
				threadx.setIdtema(rs.getInt("idtema"));
				threadx.setIdthread(rs.getInt("idthread"));
				threadx.setSubject(rs.getString("subject"));
				threadx.setContent(rs.getString("content"));
				threadx.setImagen(rs.getString("imagen"));
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
	//para obtener un thread poniendo la id del tema y del thread
	@GET
	@Path("/Tecnologia/{idhilo}")
	@Produces("application/json")
	public Threadx getpostwithIDT(@PathParam("idhilo") String idhilo) {
		Threadx thread = getPostFromDBwithIDs("1",idhilo);
		
		return thread;
	}
	//para obtener un post poniendo la id del tema, del thread y del post.
	@GET
	@Path("/Deportes/{idhilo}")
	@Produces("application/json")
	public Threadx getpostwithIDD(@PathParam("idhilo") String idhilo) {
		Threadx thread = getPostFromDBwithIDs("2",idhilo);
		
		return thread;
	}
	//para obtener un post poniendo la id del tema, del thread y del post.
	@GET
	@Path("/Motor/{idhilo}")
	@Produces("application/json")
	public Threadx getpostwithIDM(@PathParam("idhilo") String idhilo) {
		Threadx thread = getPostFromDBwithIDs("3",idhilo);
		
		return thread;
	}
	//para obtener un post poniendo la id del tema, del thread y del post.
	@GET
	@Path("/Videojuegos/{idhilo}")
	@Produces("application/json")
	public Threadx getpostwithIDV(@PathParam("idhilo") String idhilo) {
		Threadx thread = getPostFromDBwithIDs("4",idhilo);
		
		return thread;
	}
	private Threadx getPostFromDBwithIDs(String idthema, String idhilo) {
	Threadx thread = new Threadx();
	
	Connection conn = null;
	try {
		conn = ds.getConnection();
	} catch (SQLException e) {
		throw new ServerErrorException("Could not connect to the database",
				Response.Status.SERVICE_UNAVAILABLE);
	}
 
	PreparedStatement stmt = null;
	try {
		stmt = conn.prepareStatement(GET_POST_BY_IDS_QUERY);
		stmt.setInt(1, Integer.valueOf(idthema));
		stmt.setInt(2, Integer.valueOf(idhilo));
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Post post = new Post();
			post.setIdthema(rs.getInt("idthema"));
			post.setIdhilo(rs.getInt("idhilo"));
			post.setIdpost(rs.getInt("idpost"));
			post.setContent(rs.getString("content"));
			post.setImagelink(rs.getString("image_link"));
			thread.addPost(post);
		}
	} 
		catch (SQLException e) {
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
 
	return thread;
	}
}

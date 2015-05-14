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
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Theme;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Threadx;
@Path("/Theme")
public class ThemeResource {
	private String GET_POST_BY_IDS_QUERY = "select * from post where (idthema=? and idhilo=? and idpost=?)";
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
	//para obtener un post poniendo la id del tema, del thread y del post.
		@GET
		@Path("/Tecnologia/{idhilo}/{idpost}")
		@Produces("application/json")
		public Post getpostwithIDT(@PathParam("idtema") String idthema, @PathParam("idhilo") String idhilo,
				@PathParam("idpost") String idpost) {
			idthema ="1";
			Post post = getPostFromDBwithIDs(idthema,idhilo,idpost);
			
			return post;
		}
		//para obtener un post poniendo la id del tema, del thread y del post.
		@GET
		@Path("/Deportes/{idhilo}/{idpost}")
		@Produces("application/json")
		public Post getpostwithIDD(@PathParam("idtema") String idthema, @PathParam("idhilo") String idhilo,
				@PathParam("idpost") String idpost) {
			idthema ="2";
			Post post = getPostFromDBwithIDs(idthema,idhilo,idpost);
			
			return post;
		}
		//para obtener un post poniendo la id del tema, del thread y del post.
		@GET
		@Path("/Motor/{idhilo}/{idpost}")
		@Produces("application/json")
		public Post getpostwithIDM(@PathParam("idtema") String idthema, @PathParam("idhilo") String idhilo,
				@PathParam("idpost") String idpost) {
			idthema ="3";
			Post post = getPostFromDBwithIDs(idthema,idhilo,idpost);
			
			return post;
		}
		//para obtener un post poniendo la id del tema, del thread y del post.
		@GET
		@Path("/Videojuegos/{idhilo}/{idpost}")
		@Produces("application/json")
		public Post getpostwithIDV(@PathParam("idtema") String idthema, @PathParam("idhilo") String idhilo,
				@PathParam("idpost") String idpost) {
			idthema ="4";
			Post post = getPostFromDBwithIDs(idthema,idhilo,idpost);
			
			return post;
		}
	private Post getPostFromDBwithIDs(String idthema, String idhilo, String idpost) {
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
			stmt = conn.prepareStatement(GET_POST_BY_IDS_QUERY);
			stmt.setInt(1, Integer.valueOf(idthema));
			stmt.setInt(2, Integer.valueOf(idhilo));
			stmt.setInt(3, Integer.valueOf(idpost));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				post.setIdthema(rs.getInt("idthema"));
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

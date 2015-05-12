package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Theme;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Threadx;
@Path("/Theme")
public class ThemeResource {

private String GET_THREADS_QUERY = "select * from thread where idtema=?";
private DataSource ds = DataSourceSPA.getInstance().getDataSource();

	@GET
	@Path("/Tecnologia")
	@Produces(MediaType.DAT_API_THREAD)
	public Theme getthreadsTecno() {
		Theme theme = new Theme();
		theme.setIdtheme(1);
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
		theme.setIdtheme(2);
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
		theme.setIdtheme(3);
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
		theme.setIdtheme(4);
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
}

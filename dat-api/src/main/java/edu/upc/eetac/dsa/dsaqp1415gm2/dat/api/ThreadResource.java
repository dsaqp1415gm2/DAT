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

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Theme;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Threadx;

@Path("/thread")
public class ThreadResource {
private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	
	private String GET_THREAD_BY_IDS_QUERY = "select * from thread where (idtema=? and idthread=?)";
	private String GET_THREAD_BY_ID_QUERY = "select * from thread where idthread=?";
	private String GET_THREADS_QUERY = "select * from thread";
	
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
}
		
package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.digest.DigestUtils;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.User;


@Path("/users")

public class UserResource {
		private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	 
		private final static String GET_USER_BY_USERNAME_QUERY = "select * from users where username=?";
		//private final static String INSERT_USER_INTO_USERS = "insert into users values(?, MD5(?), ?, ?)";
		//private final static String INSERT_USER_INTO_USER_ROLES = "insert into user_roles values (?, 'registered')";
		
		@Path("/login")
		@POST
		@Produces(MediaType.DAT_API_USER)
		@Consumes(MediaType.DAT_API_USER)
		public User login(User user) {
			if (user.getName() == null || user.getPassword() == null)
				throw new BadRequestException(
						"username and password cannot be null.");
	 
			String pwdDigest = DigestUtils.md5Hex((byte[]) user.getPassword());
			String storedPwd = (String) getUserFromDatabase(user.getName(), true)
					.getPassword();
	 
			user.setLoginSuccessful(pwdDigest.equals(storedPwd));
			user.setPassword(null);
			return user;
		}
		
		private User getUserFromDatabase(String username, boolean password) {
			User user = new User();
			Connection conn = null;
			try {
				conn = ds.getConnection();
			} catch (SQLException e) {
				throw new ServerErrorException("Could not connect to the database",
						Response.Status.SERVICE_UNAVAILABLE);
			}
	 
			PreparedStatement stmt = null;
			try {
				stmt = conn.prepareStatement(GET_USER_BY_USERNAME_QUERY);
				stmt.setString(1, username);
	 
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					user.setName(rs.getString("username"));
					if (password)
						user.setPassword(rs.getString("userpass"));
					user.setName(rs.getString("name"));
				} else
					throw new NotFoundException(username + " not found.");
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
	 
			return user;
		}
		
		@SuppressWarnings("unused")
		private void validateUser(User user) {
			if (user.getName() == null)
				throw new BadRequestException("username cannot be null.");
			if (user.getPassword() == null)
				throw new BadRequestException("password cannot be null.");
		}
		
	}
		
		


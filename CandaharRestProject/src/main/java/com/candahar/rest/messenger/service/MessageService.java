package com.candahar.rest.messenger.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.candahar.rest.messenger.connection.ConnectionPool;
import com.candahar.rest.messenger.model.Message;;

public class MessageService {

    PreparedStatement pstmtObj = null;
    ResultSet rsObj = null;
    Connection connObj = null;
    ConnectionPool jdbcObj = new ConnectionPool();
	
	public List<Message> getAllMessage() throws Exception{
		
		List<Message> list = new ArrayList<>();
		
		try {
			DataSource dataSource = jdbcObj.setUpPool();
			connObj = dataSource.getConnection();

			String query = "SELECT * FROM Message";
			pstmtObj = connObj.prepareStatement(query);
			
            rsObj = pstmtObj.executeQuery();
			
			while(rsObj.next()) {
				Message message = new Message();
				message.setId(rsObj.getInt("Id"));
				message.setMessage(rsObj.getString("Message"));
				message.setCreated(rsObj.getDate("Created"));
				message.setAuthor(rsObj.getString("Author"));
				
				list.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
            try {
                // Closing ResultSet Object
                if(rsObj != null) { rsObj.close(); }

                // Closing PreparedStatement Object
                if(pstmtObj != null) { pstmtObj.close(); }

                // Closing Connection Object
                if(connObj != null) { connObj.close(); }

            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
		
		return list;
	}

	public Message getMessage(int id) throws Exception {
		Message message = new Message();
		try {
			DataSource dataSource = jdbcObj.setUpPool();
			connObj = dataSource.getConnection();

			String query = "SELECT * FROM Message WHERE Id = ?";
			pstmtObj = connObj.prepareStatement(query);
			pstmtObj.setInt(1, id);
            rsObj = pstmtObj.executeQuery();
			
			if(rsObj.next()) {
				
				message.setId(rsObj.getInt("Id"));
				message.setMessage(rsObj.getString("Message"));
				message.setCreated(rsObj.getDate("Created"));
				message.setAuthor(rsObj.getString("Author"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
            try {
                // Closing ResultSet Object
                if(rsObj != null) { rsObj.close(); }

                // Closing PreparedStatement Object
                if(pstmtObj != null) { pstmtObj.close(); }

                // Closing Connection Object
                if(connObj != null) { connObj.close(); }

            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
		return message;
	}

	public Message addMessage(Message message) throws Exception {
		try {
			DataSource dataSource = jdbcObj.setUpPool();
			connObj = dataSource.getConnection();

			String query = "INSERT INTO Message SET Author = ?, Created = now(), Message = ?";
			pstmtObj = connObj.prepareStatement(query);
			pstmtObj.setString(1, message.getAuthor());
//			pstmtObj.setDate(2, new java.sql.Date(message.getCreated().getTime()));
			pstmtObj.setString(2, message.getMessage());
			pstmtObj.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
            try {
                // Closing ResultSet Object
                if(rsObj != null) { rsObj.close(); }

                // Closing PreparedStatement Object
                if(pstmtObj != null) { pstmtObj.close(); }

                // Closing Connection Object
                if(connObj != null) { connObj.close(); }

            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
		return message;
	}

	public Message updateMessage(Message message) throws Exception {

		try {
			DataSource dataSource = jdbcObj.setUpPool();
			connObj = dataSource.getConnection();

			String query = "UPDATE Message SET Message = ? WHERE Id = ?";
			pstmtObj = connObj.prepareStatement(query);
			pstmtObj.setString(1, message.getMessage());
			pstmtObj.setLong(2, message.getId());
            pstmtObj.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
            try {
                // Closing ResultSet Object
                if(rsObj != null) { rsObj.close(); }

                // Closing PreparedStatement Object
                if(pstmtObj != null) { pstmtObj.close(); }

                // Closing Connection Object
                if(connObj != null) { connObj.close(); }

            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
		return message;
	}

	public void deleteMessage(int id) throws Exception {

		try {
			DataSource dataSource = jdbcObj.setUpPool();
			connObj = dataSource.getConnection();

			String query = "DELETE FROM Message WHERE Id = ?";
			pstmtObj = connObj.prepareStatement(query);
			pstmtObj.setInt(1, id);
            pstmtObj.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
            try {
                // Closing ResultSet Object
                if(rsObj != null) { rsObj.close(); }

                // Closing PreparedStatement Object
                if(pstmtObj != null) { pstmtObj.close(); }

                // Closing Connection Object
                if(connObj != null) { connObj.close(); }

            } catch(Exception sqlException) {
                sqlException.printStackTrace();
            }

        }
	}
}

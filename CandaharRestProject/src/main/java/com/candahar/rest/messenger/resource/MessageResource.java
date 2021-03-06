package com.candahar.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.candahar.rest.messenger.model.Message;
import com.candahar.rest.messenger.service.MessageService;;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getAllMessage() throws Exception {
		return messageService.getAllMessage();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") int messageId) throws Exception {
		return messageService.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message) throws Exception {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") int messageId, Message message) throws Exception {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") int messageId) throws Exception {
		messageService.deleteMessage(messageId);
	}
	
}

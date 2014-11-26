package com.bemach.restful.mongo;

import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import com.bemach.mongo.nw.datasvc.Customer;
import com.bemach.mongo.nw.datasvc.NorthwindDataMgr;
import com.mongodb.MongoClient;

@Path("customers")
public class Customers {
	private MongoClient mongoClient;

	@GET
	@Path("{customerId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Customer getCustomerByCustomerId(@PathParam("customerId") String customerId) {
		NorthwindDataMgr dataMgr;
		try {
			dataMgr = getNorthwindDataMgr();
			return dataMgr.getCustomerByCustomerId(customerId);
			
		} catch (UnknownHostException e) {
			e.printStackTrace(); /// need to fix this.
		} finally {
			
		}
		System.out.println("PROBLEM");
		return null;
	}

	private NorthwindDataMgr getNorthwindDataMgr() throws UnknownHostException {
		mongoClient = getMongoClient();	
		NorthwindDataMgr dataMgr = new NorthwindDataMgr();
		dataMgr.setMongoClient(mongoClient);
		return dataMgr;
	}

	private MongoClient getMongoClient() throws UnknownHostException {
		return new MongoClient("localhost", 27017);
	}
}

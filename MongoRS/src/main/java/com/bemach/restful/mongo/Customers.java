package com.bemach.restful.mongo;

import java.net.UnknownHostException;
import java.util.NoSuchElementException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.bemach.mongo.nw.datasvc.Customer;
import com.bemach.mongo.nw.datasvc.NorthwindDataMgr;
import com.mongodb.MongoClient;

/**
 * use curl:
 * 
 * curl -i -H "Accept: application/json" http://localhost:18080/MongoRS/services/customers/EASTC
 * 
 * @author ktran
 *
 */

@Path("customers")
public class Customers {
	private Logger logger = Logger.getLogger(Customer.class);
	private MongoClient mongoClient;

	@GET
	@Path("{customerId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Customer getCustomerByCustomerId(@PathParam("customerId") String customerId) throws Exception {
		logger.info(String.format("Retrieving customer %s", customerId));
		NorthwindDataMgr dataMgr;
		try {
			dataMgr = getNorthwindDataMgr();
			return dataMgr.getCustomerByCustomerId(customerId);
			
		} catch (UnknownHostException e) {
			e.printStackTrace(); /// need to fix this.
		} catch (NoSuchElementException e) {
			logger.error(String.format("Customer %s not found", customerId));
			throw(new Exception (String.format("Customer %s not found", customerId)));
		} finally {
			
		}
		logger.error("getCustomerByCustomerId experiences a problem!");
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

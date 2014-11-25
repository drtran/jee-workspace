package com.bemach.mongo.nw.datasvc;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class NorthwindDataMgr {
	private static final String DB_NAME = "Northwind";
	public static enum COLLECTIONS {CATEGORIES, CUSTOMERS, EMPLOYEE_TERRITORIES, EMPLOYEES, NORTHWIND,
													 ORDER_DETAILS, ORDERS, PRODUCTS, REGIONS, SHIPPERS, 
													 SUPPLIERS, SYSTEM_INDEX, TERRITORIES, USERS};
	public static final Map<COLLECTIONS, String> COLLECTION_MAP = new HashMap<COLLECTIONS, String>();
	static {
		COLLECTION_MAP.put(COLLECTIONS.CATEGORIES, "categories");
		COLLECTION_MAP.put(COLLECTIONS.CUSTOMERS, "customers");
		COLLECTION_MAP.put(COLLECTIONS.EMPLOYEE_TERRITORIES, "employee_territories");
		COLLECTION_MAP.put(COLLECTIONS.EMPLOYEES, "employees");
		COLLECTION_MAP.put(COLLECTIONS.NORTHWIND, "northwind");
		COLLECTION_MAP.put(COLLECTIONS.ORDER_DETAILS, "order_details");
		COLLECTION_MAP.put(COLLECTIONS.ORDERS, "orders");
		COLLECTION_MAP.put(COLLECTIONS.PRODUCTS, "products");
		COLLECTION_MAP.put(COLLECTIONS.REGIONS, "regions");
		COLLECTION_MAP.put(COLLECTIONS.SHIPPERS, "shippers");
		COLLECTION_MAP.put(COLLECTIONS.SUPPLIERS, "suppliers");
		COLLECTION_MAP.put(COLLECTIONS.SYSTEM_INDEX, "system.index");
		COLLECTION_MAP.put(COLLECTIONS.TERRITORIES, "territories");
		COLLECTION_MAP.put(COLLECTIONS.USERS, "users");
	}

	private MongoClient mongoClient;
	
	@Inject
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public Customer getCustomerByCustomerId(String customerId) throws UnknownHostException {
		DB db = mongoClient.getDB(DB_NAME);
		DBCollection customers = db.getCollection(COLLECTION_MAP.get(COLLECTIONS.CUSTOMERS));
		DBObject query = BasicDBObjectBuilder.start().
									   add(Customer.KEYS.CustomerID.toString(), customerId).get();
		DBCursor cursor = customers.find(query);
		DBObject result = cursor.next();
		
		return buildCustomerObject(result);
	}
	
	
	private Customer buildCustomerObject(DBObject result) {
		Customer customer = new Customer(result.get(Customer.KEYS.CustomerID.toString()).toString());
		customer.setAddress(result.get(Customer.KEYS.Address.toString()).toString());
		customer.setCompanyName(result.get(Customer.KEYS.CompanyName.toString()).toString());
		customer.setId(result.get(Customer.KEYS._id.toString()).toString());
		customer.setContactName(result.get(Customer.KEYS.ContactName.toString()).toString());
		customer.setContactTitle(result.get(Customer.KEYS.ContactTitle.toString()).toString());
		customer.setCity(result.get(Customer.KEYS.City.toString()).toString());
		customer.setRegion(result.get(Customer.KEYS.Region.toString()).toString());
		customer.setPostalCode(result.get(Customer.KEYS.PostalCode.toString()).toString());
		customer.setCountry(result.get(Customer.KEYS.Country.toString()).toString());
		customer.setPhone(result.get(Customer.KEYS.Phone.toString()).toString());
		customer.setFax(result.get(Customer.KEYS.Fax.toString()).toString());

		return customer;
	}


}

package com.bemach.mongo.nw.datasvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.mockito.Mockito.*;

import com.bemach.mongo.nw.datasvc.Customer;
import com.bemach.mongo.nw.datasvc.NorthwindDataMgr;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@RunWith(value=Parameterized.class)
public class NorthwindDataMgrWithCustomersTest {
	
	private String customerId;
	private NorthwindDataMgr dataMgr;
	private MongoClient mockMongoClient;
	private DB mockDB;
	private DBCollection mockCustomers;
	private DBCursor mockCursor;
	private DBObject mockResult;
	private static MongoClient mongoClient;
	private static boolean mock;

	/**
	 * Testing Git Plugin.
	 * @param customerId
	 */
	public NorthwindDataMgrWithCustomersTest(Object customerId) {
		this.customerId = (String) customerId;
	}
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
				{"BOTTM"}, 
				{"EASTC"},
				{"DUMON"},
				{"ERNSH"},
				{"BLONP"}
		});
	}
	
	@BeforeClass public static void classSetUp() throws UnknownHostException {
		mock = System.getProperty("NOMOCK") == null || "False".equals(System.getProperty("NOMOCK"));
		if (!mock)
			mongoClient = new MongoClient("localhost", 27017);	
	}
	
	@Before public void setUp() {
		dataMgr = new NorthwindDataMgr();
		mockMongoClient = mock(MongoClient.class);
		mockDB = mock(DB.class);
		mockCustomers = mock(DBCollection.class);
		mockCursor = mock(DBCursor.class);
		mockResult = mock(DBObject.class);
	}
	
	@Test public void shouldCreateANorthwinDataMgrObject() {
		assertNotNull (dataMgr);
	}
	
	@Test public void shouldGetACustomerRecordByCustomerId() throws UnknownHostException {
		if (mock) {
			when(mockMongoClient.getDB(anyString())).thenReturn(mockDB);
			when(mockDB.getCollection(anyString())).thenReturn(mockCustomers);
			when(mockCustomers.find(any(DBObject.class))).thenReturn(mockCursor);
			when(mockCursor.next()).thenReturn(mockResult);
			when(mockResult.get(anyString())).thenReturn(customerId);
			dataMgr.setMongoClient(mockMongoClient);
		} else {
			dataMgr.setMongoClient(mongoClient);
		}
		Customer customer = dataMgr.getCustomerByCustomerId(customerId);
		System.out.println(customer);
		assertEquals(customer.getCustomerId(), customerId);
	}
}

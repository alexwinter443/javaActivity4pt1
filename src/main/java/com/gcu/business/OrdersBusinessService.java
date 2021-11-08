package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gcu.data.OrdersDataAccessInterface;
import com.gcu.data.OrdersDataService;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	@Autowired
	OrdersDataService ordersDAO;
	
	private List<OrderModel> orders;
	
	// uses dependency injection configured in the spring ConfigFile
	// to determine which database (fakeDAO or mysQL, still to be created) will be used
	//@Autowired
	//OrdersDataAccessInterface ordersDAO;	

	@Override
	public void test() {
		System.out.println("The test method of the OrdersBusinessService appears to be working "
				+ "if you can see this test.");
	}
	
	
	@Override
	public void init() {
		System.out.println("Init method in OrdersBusinessService was just called.");
		orders = new ArrayList<OrderModel>();	
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy method of OrdersBusinessService was just called.");	
	}

	@Override
	public List<OrderModel> getOrders() {		
		return ordersDAO.getOrders();
	}
	
	@Override
	public List<OrderModel> searchOrders(String searchTerm) {		
		return ordersDAO.searchOrders(searchTerm);	
	}

	@Override
	public int addOne(OrderModel orderModel) {
		return ordersDAO.addOne(orderModel);
	}

	@Override
	public boolean deleteOne(long l) {
		return ordersDAO.deleteOne(l);
	}

	@Override
	public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
		return ordersDAO.updateOne(idToUpdate, updateOrder);
	}

	@Override
	public OrderModel getOne(int id) {
		return ordersDAO.getById(id);
	}
	
	
}

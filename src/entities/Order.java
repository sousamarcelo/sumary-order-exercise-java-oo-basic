package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enu.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus orderStatus;
	
	private Client client;
	List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderstatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus= orderStatus;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: " + "\n");
		sb.append("Order moment: ");
		sb.append(sdf2.format(getMoment()) + "\n");
		sb.append("Order Status: ");
		sb.append(orderStatus + "\n");
		sb.append("Client: ");
		sb.append(getClient().getName() + " (");
		sb.append(sdf.format(getClient().getBirthDate()));
		sb.append(") - ");
		sb.append(getClient().getEmail() + "\n");
		sb.append("Order Items:" + "\n");
		Double sum = 0.0;
		for(OrderItem i : items) {
			sb.append(i.getProduct().getName());
			sb.append(", $");
			sb.append(String.format("%.2f", i.getProduct().getPrice()) );
			sb.append(", Quantity: ");
			sb.append(i.getQuantity());			
			sb.append(", subtotal: $");
			sb.append(String.format("%.2f", i.subTotal()) + "\n");
			sum += i.subTotal();
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", sum));
		
		return sb.toString();
	}

}

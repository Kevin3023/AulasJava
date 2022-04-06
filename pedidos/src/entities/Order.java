package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Client client;
	private Date moment;
	private OrderStatus status;
	private ArrayList<OrderItem> items = new ArrayList<>();

	public Order() {

	}
	
	public Order(Client client, Date moment, OrderStatus status) {
		this.client = client;
		this.moment = moment;
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ArrayList<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public Double total() {
		Double sum = 0.0;
		
		for (OrderItem i : items) {
			sum += i.SubTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY: \n");
		sb.append("Order Moment: "+ sdf.format(moment) + "\n");
		sb.append("Order status: "+ status + "\n");
		sb.append(client.toString() + "\n");
		sb.append("Order items: \n");
		for (OrderItem i : items) {
			sb.append(i.toString()+ "\n");
		}
		
		sb.append("Total price: $" +total());
		return sb.toString();
	}
	
}

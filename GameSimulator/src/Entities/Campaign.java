package Entities;

import java.util.Date;

public class Campaign {
	private int id;
	private String campaignName;
	private Date started;
	private Date completed;
	private double discount;
	
	public Campaign() {
		super();
	}
	
	public Campaign(int id, String campaignName, Date started, Date completed, double discount) {
		super();
		this.id = id;
		this.campaignName = campaignName;
		this.started = started;
		this.completed = completed;
		this.discount = discount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public Date getStarted() {
		return started;
	}
	public void setStarted(Date started) {
		this.started = started;
	}
	public Date getCompleted() {
		return completed;
	}
	public void setCompleted(Date completed) {
		this.completed = completed;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}

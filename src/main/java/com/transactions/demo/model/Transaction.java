package com.transactions.demo.model;

public class Transaction {
	 private Long id;
	    private String description;
	    private Double count;

	    // Constructors, getters, and setters
	    public Transaction() {}

	    public Transaction(Long id, String description, Double count) {
	        this.id = id;
	        this.description = description;
	        this.count = count;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public Double getCount() {
	        return count;
	    }

	    public void setCount(Double count) {
	        this.count = count;
	    }
}

package com.tsc.paging;

public class Column {
	private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;
    private Search search;
    
    public Column() {
    	
    }

    public Column(String data, String name, Boolean searchable, Boolean orderable, Search search) {
		super();
		this.data = data;
		this.name = name;
		this.searchable = searchable;
		this.orderable = orderable;
		this.search = search;
	}

	public Column(String data) {
        this.data = data;
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSearchable() {
		return searchable;
	}

	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}

	public Boolean getOrderable() {
		return orderable;
	}

	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

}

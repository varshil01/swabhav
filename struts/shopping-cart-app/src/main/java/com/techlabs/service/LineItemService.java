package com.techlabs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.techlabs.model.LineItem;
import com.techlabs.model.Product;

public class LineItemService {
	private List<LineItem> listOfLineItems = new ArrayList<LineItem>();

	public LineItemService() {

	}

	public void addLineItem(LineItem lineitem) {
		listOfLineItems.add(lineitem);
	}

	public List<LineItem> getListOfLineItems() {
		return listOfLineItems;
	}

	public void setListOfLineItems(List<LineItem> listOfLineItems) {
		this.listOfLineItems = listOfLineItems;
	}

	public List<LineItem> getAllLineItem() {
		return listOfLineItems;
	}

	public List<LineItem> deleteLineItemById(List<LineItem> listfromsession,long id) {
		for (LineItem lineitem : listfromsession) {
			if (lineitem.getId() == id) {
				listfromsession.remove(lineitem);
				break;
			}
			
		}
		return listfromsession;
	}

	public boolean checklineitemexist(List<LineItem> listofproductsincart,
			String id) {
		if (listofproductsincart == null) {
			return false;
		}
		for (LineItem lineitem : listofproductsincart) {
			if (lineitem.getProduct_id().equalsIgnoreCase(id)) {
				listOfLineItems.remove(lineitem);
				return true;
			}
		}
		return false;

	}

	public long generateLineItemId() {
		return Math.abs(UUID.randomUUID().getMostSignificantBits());
	}

}
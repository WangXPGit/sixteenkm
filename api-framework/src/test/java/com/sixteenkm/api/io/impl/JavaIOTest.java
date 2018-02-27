/** 
 * JavaIOTest.java Create on 2018年1月19日
 */ 


package com.sixteenkm.api.io.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sixteenkm.api.io.IOFormater;
import com.sixteenkm.api.util.JsonUtil;

/**
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2018年1月19日
 */
public class JavaIOTest {

	@Test
	public void testWrite()
	{
		try {
			String fileName = "/Users/wangxiaoping/Downloads/logs/TD_MATCHID_FOOTBALLID_10.txt";
			
			JavaIO io = new JavaIO();
			TagDataFormater tdf = new TagDataFormater();
			List<Item> items = new ArrayList<Item>();
			tdf.setItems(items);
			Item item1 = new Item();
			item1.setId(1);
			item1.setName("item1");
			items.add(item1);

			Item item2 = new Item();
			item2.setId(1);
			item2.setName("item1");
			items.add(item2);
			io.write(fileName, tdf.format());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testRead()
	{
		try {
			String fileName = "/Users/wangxiaoping/Downloads/logs/TD_MATCHID_FOOTBALLID_10.txt";
			JavaIO io = new JavaIO();
			List<Item> items = io.read(fileName, null, Item.class);
			for (Item i : items) {
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class TagDataFormater implements IOFormater{
		private List<Item> items;

		public List<Item> getItems() {
			return items;
		}

		public void setItems(List<Item> items) {
			this.items = items;
		}

		@Override
		public String format() {
			return JsonUtil.toJson(items);
		}
	}
	
	class Item
	{
		private int id;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}

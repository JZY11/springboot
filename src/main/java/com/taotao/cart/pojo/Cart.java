/**
 * 
 */
package com.taotao.cart.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Cart
 * @Description
 * @Author jzy
 * @Date 2018年8月27日
 */
@Table(name = "tb_cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long userid;
	private long itemid;
	private String itemTitle;
	private String itemImage;
	private Long itemPrice;
	private Integer num;
	private Date created;
	private Date updated;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the userid
	 */
	public long getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(long userid) {
		this.userid = userid;
	}
	/**
	 * @return the itemid
	 */
	public long getItemid() {
		return itemid;
	}
	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	/**
	 * @return the itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}
	/**
	 * @param itemTitle the itemTitle to set
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	/**
	 * @return the itemImage
	 */
	public String getItemImage() {
		return itemImage;
	}
	/**
	 * @param itemImage the itemImage to set
	 */
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	/**
	 * @return the itemPrice
	 */
	public Long getItemPrice() {
		return itemPrice;
	}
	/**
	 * @param itemPrice the itemPrice to set
	 */
	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}
	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	
}

/**
 * 
 */
package com.taotao.cart.bean;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @ClassName Item
 * @Description
 * @Author jzy
 * @Date 2018年8月27日
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

	private long id;
	
	private String title;

    private String sellPoint;

    private Long price;

    private String image;

    private Long cid;

    private Integer status;

    private Long created;
    
    private Long updated;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the sellPoint
	 */
	public String getSellPoint() {
		return sellPoint;
	}

	/**
	 * @param sellPoint the sellPoint to set
	 */
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the cid
	 */
	public Long getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the created
	 */
	public Long getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Long created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Long getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Long updated) {
		this.updated = updated;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", title=" + title + ", sellPoint="
				+ sellPoint + ", price=" + price + ", image=" + image
				+ ", cid=" + cid + ", status=" + status + ", created="
				+ created + ", updated=" + updated + "]";
	}
    
	public String[] getImages(){
		return StringUtils.split(this.getImage(), ",");
	}
}

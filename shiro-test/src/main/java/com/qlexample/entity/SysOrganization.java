package com.qlexample.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * The persistent class for the sys_organization database table.
 * 
 */
@Entity
@Table(name="sys_organization")
@NamedQuery(name="SysOrganization.findAll", query="SELECT s FROM SysOrganization s")
public class SysOrganization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Boolean available;

	private String name;

	@Column(name="parent_id")
	private Long parentId;

	@Column(name="parent_ids")
	private String parentIds;

	private int priority;

	public SysOrganization() {
	}

    
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return this.parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
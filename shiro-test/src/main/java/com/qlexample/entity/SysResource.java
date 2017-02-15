package com.qlexample.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.type.TrueFalseType;


/**
 * The persistent class for the sys_resource database table.
 * 
 */
@Entity
@Table(name="sys_resource")
@NamedQuery(name="SysResource.findAll", query="SELECT s FROM SysResource s")
public class SysResource implements Serializable {
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

	private String permission;

	private int priority;
    
	@Enumerated(EnumType.STRING)
	@Column(length=5,nullable = true)
	private ResourceType type = ResourceType.menu;

	private String url;
	
	
	public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

	public SysResource() {
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

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

    
	
	public ResourceType getType() {
		return type;
	}
    
	
	public void setType(ResourceType type) {
		this.type = type;
	}



	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
    
	public boolean isRootNode() {
		return parentId == 0;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
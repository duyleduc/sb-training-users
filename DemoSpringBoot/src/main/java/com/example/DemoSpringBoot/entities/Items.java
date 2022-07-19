package com.example.DemoSpringBoot.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Items {

    @Id
    @Column
    @NotNull
    @Size(max = 8, message = "The length of itemID must be between 1 and 8 characters.")
    private String itemID;

    @Column
    @NotEmpty(message = "itemName is required")
    @Size(max = 64, message = "The length of itemName must be between 1 and 64 characters.")
    private String itemName;

    @Column
    @NotEmpty(message = "description is required")
    @Size(max = 64, message = "The length of description must be between 1 and 64 characters.")
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "catalogid")
    @NotEmpty(message = "catalogID is required")
    @Size(max = 64, message = "The length of catalogID must be between 1 and 64 characters.")
    private Catalogs catalogID;

    @Column
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catalogs getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(Catalogs catalogID) {
        this.catalogID = catalogID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    public Items() {
    }

    public Items(String itemID,
            String itemName,
            String description,
            Catalogs catalogID,
            Date createdDate) {
        super();
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.catalogID = catalogID;
        this.createdDate = createdDate;
    }

    
}

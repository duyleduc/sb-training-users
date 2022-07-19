package com.example.DemoSpringBoot.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Catalogs {

    @Id
    @Column
    // @NotNull
    // @Size(max = 8, message = "The length of catalogID must be between 1 and 8 characters.")
    private String catalogID;

    @OneToMany(mappedBy = "catalogID", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Items> itemsList;

    @Column
    // @NotEmpty(message = "catalogName is required")
    // @Size(max = 64, message = "The length of catalog Name must be between 1 and 64 characters.")
    private String catalogName;

    @Column
    // @NotEmpty(message = "description is required")
    // @Size(max = 64, message = "The length of description must be between 1 and 64 characters.")
    private String description;

    @Column
    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdDate;

    public String getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(String catalogID) {
        this.catalogID = catalogID;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    /**
     * Constructor
     */
    public Catalogs(){}

    public Catalogs(String catalogID,
            String catalogName,
            String description,
            Date createdDate) {
        super();
        this.catalogID = catalogID;
        this.catalogName = catalogName;
        this.description = description;
        this.createdDate = (createdDate != null) ? new Date(createdDate.getTime()) : new Date();
    }

    public List<Items> getItems() {
        return itemsList;
    }

    public void setItems(List<Items> items) {
        this.itemsList = items;
    }

    // bidirectional Relationship
    public void addItem(Items item) {
        if(this.itemsList == null){
            this.itemsList = new ArrayList<>();
        }
        itemsList.add(item);
        // item.setCatalogID(this);
    }
}

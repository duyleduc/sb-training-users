package com.example.DemoSpringBoot.models.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatalogDTO {
    private String catalogID, catalogName, description;
    private Date createdDate;
    private List<ItemDTO> itemsList;
    
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
        this.createdDate = createdDate;
    }

    public CatalogDTO(){
        
    }
    public List<ItemDTO> getItems() {
        return itemsList;
    }
    public void setItems(List<ItemDTO> itemsList) {
        this.itemsList = itemsList;
    }

    // bidirectional Relationship
    // public void addItem(ItemDTO itemDTO) {
    //     if(this.itemsList == null){
    //         this.itemsList = new ArrayList<>();
    //     }
    //     itemsList.add(itemDTO);
    //     // itemDTO.setCatalogID(this);
    // }
}

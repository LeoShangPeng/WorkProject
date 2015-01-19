package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	 private List<Categorymini> category;                                                 
	 private String category_id;                                                              
	 private String category_picurl;                                                          
	 private String category_name;                                                            
	 private String tiny_name;                                                                
	 private int has_icon;                                                                    
	 private String icon_url;                                                                 
	                                                                                          
	 public List<Categorymini> getCategory() {                                            
	     return category;                                                                     
	 }                                                                                        
	                                                                                          
	 public void setCategory(List<Categorymini> category) {                               
	     this.category = category;                                                            
	 }                                                                                        
	                                                                                          
	 public String getCategory_id() {                                                         
	     return category_id;                                                                  
	 }                                                                                        
	                                                                                          
	 public void setCategory_id(String category_id) {                                         
	     this.category_id = category_id;                                                      
	 }                                                                                        
	                                                                                          
	 public String getCategory_picurl() {                                                     
	     return category_picurl;                                                              
	 }                                                                                        
	                                                                                          
	 public void setCategory_picurl(String category_picurl) {                                 
	     this.category_picurl = category_picurl;                                              
	 }                                                                                        
	                                                                                          
	 public String getCategory_name() {                                                       
	     return category_name;                                                                
	 }                                                                                        
	                                                                                          
	 public void setCategory_name(String category_name) {                                     
	     this.category_name = category_name;                                                  
	 }                                                                                        
	                                                                                          
	 public String getTiny_name() {                                                           
	     return tiny_name;                                                                    
	 }                                                                                        
	                                                                                          
	 public void setTiny_name(String tiny_name) {                                             
	     this.tiny_name = tiny_name;                                                          
	 }                                                                                        
	                                                                                          
	 public int getHas_icon() {                                                               
	     return has_icon;                                                                     
	 }                                                                                        
	                                                                                          
	 public void setHas_icon(int has_icon) {                                                  
	     this.has_icon = has_icon;                                                            
	 }                                                                                        
	                                                                                          
	 public String getIcon_url() {                                                            
	     return icon_url;                                                                     
	 }                                                                                        
	                                                                                          
	 public void setIcon_url(String icon_url) {                                               
	     this.icon_url = icon_url;                                                            
	 }                                                                                        
	                                                                                          
	 @Override                                                                                
	 public String toString() {                                                               
	     return "HomeCategory [category=" + category + ", category_id="                       
	             + category_id + ", category_picurl=" + category_picurl                       
	             + ", category_name=" + category_name + ", tiny_name="                        
	             + tiny_name + ", has_icon=" + has_icon + ", icon_url="                       
	             + icon_url + "]";                                                            
	 }                                                                                        
}

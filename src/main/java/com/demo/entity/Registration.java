package com.demo.entity;
import jakarta.persistence.*;

@Entity
public class Registration {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private long id;
 private String name;
 private String email;
 private String mobile;
 
 
 public void setName(String name) {
	 this.name=name;
 }
 public void setEmail(String email) {
	 this.email=email;
 }
 public void setMobile(String mobile) {
	 this.mobile=mobile;
 }
 
 public long getid() {
	 return id;
 }
 public String getname() {
	 return name;
 }
 public String getemail() {
	 return email;
 }
public String getmobile() {
	return mobile;
}
}
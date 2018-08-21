package com.sunaniya.app.model;

import java.sql.Date;
import java.util.List;

import com.sunaniya.app.model.User.PAYMENTMODE;

public class UserForm {
	 	private Long id;
	    private String firstName;
	    private String lastName;
	    private Long mobileNumber;
	    private String emailId;
	    
	    private String address1;
	    private String address2;
	    private String city;
	    private String state;
	    private String pincode;
	    
	    private List<String> selectedLotteries;
	    
	    private boolean isPaymentDone;
	    private PAYMENTMODE paymentMode;
	    private String lastFourDigits;
	    
	    private Date createdDate;
	    private String createdUser;
		
	    
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(Long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPincode() {
			return pincode;
		}
		public void setPincode(String pincode) {
			this.pincode = pincode;
		}
		public List<String> getSelectedLotteries() {
			return selectedLotteries;
		}
		public void setSelectedLotteries(List<String> selectedLotteries) {
			this.selectedLotteries = selectedLotteries;
		}
		public boolean isPaymentDone() {
			return isPaymentDone;
		}
		public void setPaymentDone(boolean isPaymentDone) {
			this.isPaymentDone = isPaymentDone;
		}
		public PAYMENTMODE getPaymentMode() {
			return paymentMode;
		}
		public void setPaymentMode(PAYMENTMODE paymentMode) {
			this.paymentMode = paymentMode;
		}
		public String getLastFourDigits() {
			return lastFourDigits;
		}
		public void setLastFourDigits(String lastFourDigits) {
			this.lastFourDigits = lastFourDigits;
		}
		public Date getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
		public String getCreatedUser() {
			return createdUser;
		}
		public void setCreatedUser(String createdUser) {
			this.createdUser = createdUser;
		}
	    
	    
	    
}

package com.sunaniya.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "lottery", uniqueConstraints = @UniqueConstraint(columnNames="lotteryNumber"))
public class Lottery {
    private Long id;
    @Column(unique = true)
    private String lotteryNumber;
    private boolean isAllotted;
    private String type;
    private Set<User> users;

    
    public Lottery() {
		// TODO Auto-generated constructor stub
	}

	public Lottery(String lotteryNumber, boolean isAllotted, String type) {
		this.lotteryNumber = lotteryNumber;
		this.isAllotted = isAllotted;
		this.type = type;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLotteryNumber() {
		return lotteryNumber;
	}

	public void setLotteryNumber(String lotteryNumber) {
		this.lotteryNumber = lotteryNumber;
	}

	@Column(columnDefinition="smallint default 0")
	public boolean isAllotted() {
		return isAllotted;
	}

	public void setAllotted(boolean isAllotted) {
		this.isAllotted = isAllotted;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy = "lotteries")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    
}
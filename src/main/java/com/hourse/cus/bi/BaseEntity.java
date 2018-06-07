package com.hourse.cus.bi;

import java.util.List;

public class BaseEntity {
private int userId;
private List<Integer> ids;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public List<Integer> getIds() {
	return ids;
}
public void setIds(List<Integer> ids) {
	this.ids = ids;
}


}

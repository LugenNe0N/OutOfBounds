package model.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskBean implements Serializable{
	private int taskId;
	private String taskName;
	private int CategoryId;
	private Date limitDate;
	private String employeeId;
	private String status;
	private String memo;
	private Date registeredDate;
	private Date updateDate;

	public TaskBean(){

	}

	/**
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId セットする taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName セットする taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return categoryId
	 */
	public int getCategoryId() {
		return CategoryId;
	}

	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	/**
	 * @return limitDate
	 */
	public Date getLimitDate() {
		return limitDate;
	}

	/**
	 * @param limitDate セットする limitDate
	 */
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * @return employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId セットする employeeId
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status セットする status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo セットする memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return registeredDate
	 */
	public Date getRegisteredDate() {
		return registeredDate;
	}

	/**
	 * @param registeredDate セットする registeredDate
	 */
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}

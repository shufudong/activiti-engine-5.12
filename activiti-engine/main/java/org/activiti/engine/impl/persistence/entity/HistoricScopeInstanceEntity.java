/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.engine.impl.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.impl.db.PersistentObject;
import org.activiti.engine.impl.util.ClockUtil;

/**
 * @author Christian Stettler
 */
public abstract class HistoricScopeInstanceEntity implements PersistentObject, Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String id;
  protected String processInstanceId;
  protected String processDefinitionId;
  protected Date startTime;
  protected Date endTime;
  
  protected Long startTimeLong;
  protected Long endTimeLong;
  protected Long durationInMillis;
  protected String deleteReason;
  protected String bussinessRemark;
  protected String bussinessOperation;
  protected String owner;
  protected Date claimTime;
  public void markEnded(String deleteReason,String bussinessop,String bussinessRemark) {
    this.deleteReason = deleteReason;
    this.endTime = ClockUtil.getCurrentTime();
//    if(this.startTime.after(this.endTime))
//    	this.startTime = this.endTime;
    this.endTimeLong = this.endTime.getTime();
    this.durationInMillis = endTime.getTime() - startTime.getTime();
    this.bussinessOperation = bussinessop;
    this.bussinessRemark = bussinessRemark;
  }
  public Date getClaimTime() {
	    return claimTime;
	  }
	  public void setClaimTime(Date claimTime) {
	    this.claimTime = claimTime;
	  }
  public String getOwner() {
	    return owner;
	  }
	  public void setOwner(String owner) {
	    this.owner = owner;
	  }
  // getters and setters //////////////////////////////////////////////////////

  public String getProcessInstanceId() {
    return processInstanceId;
  }
  public String getProcessDefinitionId() {
    return processDefinitionId;
  }
  public Date getStartTime() {
    return startTime;
  }
  public Date getEndTime() {
    return endTime;
  }
  public Long getDurationInMillis() {
    return durationInMillis;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }
  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
  public void setDurationInMillis(Long durationInMillis) {
    this.durationInMillis = durationInMillis;
  }
  public String getDeleteReason() {
    return deleteReason;
  }
  public void setDeleteReason(String deleteReason) {
    this.deleteReason = deleteReason;
  }

	public String getBussinessRemark() {
		return bussinessRemark;
	}
	
	public void setBussinessRemark(String bussinessRemark) {
		this.bussinessRemark = bussinessRemark;
	}
	
	public String getBussinessOperation() {
		return bussinessOperation;
	}
	
	public void setBussinessOperation(String bussinessOperation) {
		this.bussinessOperation = bussinessOperation;
	}
	public Long getStartTimeLong() {
		return startTimeLong;
	}
	public void setStartTimeLong(Long startTimeLong) {
		this.startTimeLong = startTimeLong;
	}
	public Long getEndTimeLong() {
		return endTimeLong;
	}
	public void setEndTimeLong(Long endTimeLong) {
		this.endTimeLong = endTimeLong;
	}



	
}

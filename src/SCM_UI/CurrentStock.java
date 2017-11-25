/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCM_UI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Warren Elliott
 */
@Entity
@Table(name = "CURRENT_STOCK", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "CurrentStock.findAll", query = "SELECT c FROM CurrentStock c")
    , @NamedQuery(name = "CurrentStock.findById", query = "SELECT c FROM CurrentStock c WHERE c.id = :id")
    , @NamedQuery(name = "CurrentStock.findByItem", query = "SELECT c FROM CurrentStock c WHERE c.item = :item")
    , @NamedQuery(name = "CurrentStock.findByStatus", query = "SELECT c FROM CurrentStock c WHERE c.status = :status")
    , @NamedQuery(name = "CurrentStock.findByQuantityRemaining", query = "SELECT c FROM CurrentStock c WHERE c.quantityRemaining = :quantityRemaining")
    , @NamedQuery(name = "CurrentStock.findByArrivalDate", query = "SELECT c FROM CurrentStock c WHERE c.arrivalDate = :arrivalDate")
    , @NamedQuery(name = "CurrentStock.findByCheckedBy", query = "SELECT c FROM CurrentStock c WHERE c.checkedBy = :checkedBy")})
public class CurrentStock implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ITEM")
    private String item;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @Column(name = "QUANTITY REMAINING")
    private String quantityRemaining;
    @Basic(optional = false)
    @Column(name = "ARRIVAL DATE")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    @Column(name = "CHECKED BY")
    private String checkedBy;

    public CurrentStock() {
    }

    public CurrentStock(Integer id) {
        this.id = id;
    }

    public CurrentStock(Integer id, String item, String status, String quantityRemaining, Date arrivalDate) {
        this.id = id;
        this.item = item;
        this.status = status;
        this.quantityRemaining = quantityRemaining;
        this.arrivalDate = arrivalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        String oldItem = this.item;
        this.item = item;
        changeSupport.firePropertyChange("item", oldItem, item);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getQuantityRemaining() {
        return quantityRemaining;
    }

    public void setQuantityRemaining(String quantityRemaining) {
        String oldQuantityRemaining = this.quantityRemaining;
        this.quantityRemaining = quantityRemaining;
        changeSupport.firePropertyChange("quantityRemaining", oldQuantityRemaining, quantityRemaining);
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        Date oldArrivalDate = this.arrivalDate;
        this.arrivalDate = arrivalDate;
        changeSupport.firePropertyChange("arrivalDate", oldArrivalDate, arrivalDate);
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        String oldCheckedBy = this.checkedBy;
        this.checkedBy = checkedBy;
        changeSupport.firePropertyChange("checkedBy", oldCheckedBy, checkedBy);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrentStock)) {
            return false;
        }
        CurrentStock other = (CurrentStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SCM_UI.CurrentStock[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

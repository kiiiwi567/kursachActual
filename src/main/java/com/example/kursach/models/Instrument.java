package com.example.kursach.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instruments")
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idInst;

    @Column
    private String instName;

    @Column
    private Integer idCateg;

    @Column
    private Double instPrice;

    @Column
    private Integer instQuantity;

    @Column
    private String instDescription;

    public Long getIdInst() {
        return this.idInst;
    }

    public String getInstName() {
        return this.instName;
    }

    public Integer getIdCateg() {
        return this.idCateg;
    }

    public Double getInstPrice() {
        return this.instPrice;
    }

    public Integer getInstQuantity() {
        return this.instQuantity;
    }

    public String getInstDescription() {
        return this.instDescription;
    }

    public void setIdInst(Long idInst) {
        this.idInst = idInst;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public void setInstPrice(Double instPrice) {
        this.instPrice = instPrice;
    }

    public void setInstQuantity(Integer instQuantity) {
        this.instQuantity = instQuantity;
    }

    public void setInstDescription(String instDescription) {
        this.instDescription = instDescription;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Instrument)) return false;
        final Instrument other = (Instrument) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$idInst = this.getIdInst();
        final Object other$idInst = other.getIdInst();
        if (this$idInst == null ? other$idInst != null : !this$idInst.equals(other$idInst)) return false;
        final Object this$instName = this.getInstName();
        final Object other$instName = other.getInstName();
        if (this$instName == null ? other$instName != null : !this$instName.equals(other$instName)) return false;
        final Object this$idCateg = this.getIdCateg();
        final Object other$idCateg = other.getIdCateg();
        if (this$idCateg == null ? other$idCateg != null : !this$idCateg.equals(other$idCateg)) return false;
        final Object this$instPrice = this.getInstPrice();
        final Object other$instPrice = other.getInstPrice();
        if (this$instPrice == null ? other$instPrice != null : !this$instPrice.equals(other$instPrice)) return false;
        final Object this$instQuantity = this.getInstQuantity();
        final Object other$instQuantity = other.getInstQuantity();
        if (this$instQuantity == null ? other$instQuantity != null : !this$instQuantity.equals(other$instQuantity))
            return false;
        final Object this$instDescription = this.getInstDescription();
        final Object other$instDescription = other.getInstDescription();
        if (this$instDescription == null ? other$instDescription != null : !this$instDescription.equals(other$instDescription))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Instrument;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idInst = this.getIdInst();
        result = result * PRIME + ($idInst == null ? 43 : $idInst.hashCode());
        final Object $instName = this.getInstName();
        result = result * PRIME + ($instName == null ? 43 : $instName.hashCode());
        final Object $idCateg = this.getIdCateg();
        result = result * PRIME + ($idCateg == null ? 43 : $idCateg.hashCode());
        final Object $instPrice = this.getInstPrice();
        result = result * PRIME + ($instPrice == null ? 43 : $instPrice.hashCode());
        final Object $instQuantity = this.getInstQuantity();
        result = result * PRIME + ($instQuantity == null ? 43 : $instQuantity.hashCode());
        final Object $instDescription = this.getInstDescription();
        result = result * PRIME + ($instDescription == null ? 43 : $instDescription.hashCode());
        return result;
    }

    public String toString() {
        return "Instrument(idInst=" + this.getIdInst() + ", instName=" + this.getInstName() + ", idCateg=" + this.getIdCateg() + ", instPrice=" + this.getInstPrice() + ", instQuantity=" + this.getInstQuantity() + ", instDescription=" + this.getInstDescription() + ")";
    }
}

package app.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by smparadeza on 6/12/15.
 */
@Entity
public class Leaf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "filename")
    private String filename;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "date")
    private String date;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "type")
    private String type;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "author")
    private String author;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "organization")
    private String organization;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "content")
    private String content;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "individual_plant_id")
    private String individualPlantId;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_regnum")
    private String taxonRegnum;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_class")
    private String taxonClass;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_subclass")
    private String taxonSubclass;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_superorder")
    private String taxonSuperorder;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_order")
    private String taxonOrder;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_family")
    private String taxonFamily;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_genus")
    private String taxonGenus;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "taxon_species")
    private String taxon_Species;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "class_id")
    private String classId;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "vernacular_name")
    private String vernacularName;

    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "locality")
    private String locality;


    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "longtitude")
    private String longtitude;


    @Basic(optional = false)
    @NotBlank
    @Size(min = 1, max = 100)
    @Column(name = "latitude")
    private String latitude;

    @Column(name = "is_compound", columnDefinition = "tinyint")
    private Boolean isCompound;

    public Leaf(){

    }


    public Leaf(String filename, String date, String type, String author, String organization, String content, String individualPlantId, String taxonRegnum, String taxonClass, String taxonSubclass, String taxonSuperorder, String taxonOrder, String taxonFamily, String taxonGenus, String taxon_Species, String classId, String vernacularName, String locality, String longtitude, String latitude) {
        this.filename = filename;
        this.date = date;
        this.type = type;
        this.author = author;
        this.organization = organization;
        this.content = content;
        this.individualPlantId = individualPlantId;
        this.taxonRegnum = taxonRegnum;
        this.taxonClass = taxonClass;
        this.taxonSubclass = taxonSubclass;
        this.taxonSuperorder = taxonSuperorder;
        this.taxonOrder = taxonOrder;
        this.taxonFamily = taxonFamily;
        this.taxonGenus = taxonGenus;
        this.taxon_Species = taxon_Species;
        this.classId = classId;
        this.vernacularName = vernacularName;
        this.locality = locality;
        this.longtitude = longtitude;
        this.latitude = latitude;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIndividualPlantId() {
        return individualPlantId;
    }

    public void setIndividualPlantId(String individualPlantId) {
        this.individualPlantId = individualPlantId;
    }

    public String getTaxonRegnum() {
        return taxonRegnum;
    }

    public void setTaxonRegnum(String taxonRegnum) {
        this.taxonRegnum = taxonRegnum;
    }

    public String getTaxonClass() {
        return taxonClass;
    }

    public void setTaxonClass(String taxonClass) {
        this.taxonClass = taxonClass;
    }

    public String getTaxonSubclass() {
        return taxonSubclass;
    }

    public void setTaxonSubclass(String taxonSubclass) {
        this.taxonSubclass = taxonSubclass;
    }

    public String getTaxonSuperorder() {
        return taxonSuperorder;
    }

    public void setTaxonSuperorder(String taxonSuperorder) {
        this.taxonSuperorder = taxonSuperorder;
    }

    public String getTaxonOrder() {
        return taxonOrder;
    }

    public void setTaxonOrder(String taxonOrder) {
        this.taxonOrder = taxonOrder;
    }

    public String getTaxonFamily() {
        return taxonFamily;
    }

    public void setTaxonFamily(String taxonFamily) {
        this.taxonFamily = taxonFamily;
    }

    public String getTaxonGenus() {
        return taxonGenus;
    }

    public void setTaxonGenus(String taxonGenus) {
        this.taxonGenus = taxonGenus;
    }

    public String getTaxon_Species() {
        return taxon_Species;
    }

    public void setTaxon_Species(String taxon_Species) {
        this.taxon_Species = taxon_Species;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getVernacularName() {
        return vernacularName;
    }

    public void setVernacularName(String vernacularName) {
        this.vernacularName = vernacularName;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Boolean getIsCompound() {
        return isCompound;
    }

    public void setIsCompound(Boolean isCompound) {
        this.isCompound = isCompound;
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", organization='" + organization + '\'' +
                ", content='" + content + '\'' +
                ", individualPlantId='" + individualPlantId + '\'' +
                ", taxonRegnum='" + taxonRegnum + '\'' +
                ", taxonClass='" + taxonClass + '\'' +
                ", taxonSubclass='" + taxonSubclass + '\'' +
                ", taxonSuperorder='" + taxonSuperorder + '\'' +
                ", taxonOrder='" + taxonOrder + '\'' +
                ", taxonFamily='" + taxonFamily + '\'' +
                ", taxonGenus='" + taxonGenus + '\'' +
                ", taxon_Species='" + taxon_Species + '\'' +
                ", classId='" + classId + '\'' +
                ", vernacularName='" + vernacularName + '\'' +
                ", locality='" + locality + '\'' +
                ", longtitude='" + longtitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}

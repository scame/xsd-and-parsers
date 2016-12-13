
package jaxb;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ingredients" form="unqualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ingredient" type="{http://www.w3.org/2001/XMLSchema}NCName" maxOccurs="unbounded" minOccurs="2" form="unqualified"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="characteristics" form="unqualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="isFiltered" type="{http://www.w3.org/2001/XMLSchema}boolean" form="unqualified"/>
 *                   &lt;element name="alcPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
 *                   &lt;element name="caloroficValue" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                   &lt;element name="transparency" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
 *                   &lt;element name="bottling" form="unqualified">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="container" maxOccurs="unbounded" form="unqualified">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
 *                                       &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="isAlcoholic" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="manufacturer" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="dark"/>
 *             &lt;enumeration value="light"/>
 *             &lt;enumeration value="live"/>
 *             &lt;enumeration value="lager"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ingredients",
    "characteristics"
})
@XmlRootElement(name = "beer", namespace = "http://scame.com/")
public class Beer {

    @XmlElement(required = true)
    protected Beer.Ingredients ingredients;
    @XmlElement(required = true)
    protected Beer.Characteristics characteristics;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "isAlcoholic", required = true)
    protected boolean isAlcoholic;
    @XmlAttribute(name = "manufacturer", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String manufacturer;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String name;
    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * Gets the value of the ingredients property.
     * 
     * @return
     *     possible object is
     *     {@link Beer.Ingredients }
     *     
     */
    public Beer.Ingredients getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beer.Ingredients }
     *     
     */
    public void setIngredients(Beer.Ingredients value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the characteristics property.
     * 
     * @return
     *     possible object is
     *     {@link Beer.Characteristics }
     *     
     */
    public Beer.Characteristics getCharacteristics() {
        return characteristics;
    }

    /**
     * Sets the value of the characteristics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Beer.Characteristics }
     *     
     */
    public void setCharacteristics(Beer.Characteristics value) {
        this.characteristics = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the isAlcoholic property.
     * 
     */
    public boolean isIsAlcoholic() {
        return isAlcoholic;
    }

    /**
     * Sets the value of the isAlcoholic property.
     * 
     */
    public void setIsAlcoholic(boolean value) {
        this.isAlcoholic = value;
    }

    /**
     * Gets the value of the manufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the value of the manufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturer(String value) {
        this.manufacturer = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="isFiltered" type="{http://www.w3.org/2001/XMLSchema}boolean" form="unqualified"/>
     *         &lt;element name="alcPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
     *         &lt;element name="caloroficValue" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *         &lt;element name="transparency" type="{http://www.w3.org/2001/XMLSchema}string" form="unqualified"/>
     *         &lt;element name="bottling" form="unqualified">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="container" maxOccurs="unbounded" form="unqualified">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
     *                             &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "isFiltered",
        "alcPercentage",
        "caloroficValue",
        "transparency",
        "bottling"
    })
    public static class Characteristics {

        protected boolean isFiltered;
        @XmlElement(required = true)
        protected BigDecimal alcPercentage;
        @XmlElement(required = true)
        protected String caloroficValue;
        @XmlElement(required = true)
        protected String transparency;
        @XmlElement(required = true)
        protected Beer.Characteristics.Bottling bottling;

        /**
         * Gets the value of the isFiltered property.
         * 
         */
        public boolean isIsFiltered() {
            return isFiltered;
        }

        /**
         * Sets the value of the isFiltered property.
         * 
         */
        public void setIsFiltered(boolean value) {
            this.isFiltered = value;
        }

        /**
         * Gets the value of the alcPercentage property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAlcPercentage() {
            return alcPercentage;
        }

        /**
         * Sets the value of the alcPercentage property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAlcPercentage(BigDecimal value) {
            this.alcPercentage = value;
        }

        /**
         * Gets the value of the caloroficValue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCaloroficValue() {
            return caloroficValue;
        }

        /**
         * Sets the value of the caloroficValue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCaloroficValue(String value) {
            this.caloroficValue = value;
        }

        /**
         * Gets the value of the transparency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransparency() {
            return transparency;
        }

        /**
         * Sets the value of the transparency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransparency(String value) {
            this.transparency = value;
        }

        /**
         * Gets the value of the bottling property.
         * 
         * @return
         *     possible object is
         *     {@link Beer.Characteristics.Bottling }
         *     
         */
        public Beer.Characteristics.Bottling getBottling() {
            return bottling;
        }

        /**
         * Sets the value of the bottling property.
         * 
         * @param value
         *     allowed object is
         *     {@link Beer.Characteristics.Bottling }
         *     
         */
        public void setBottling(Beer.Characteristics.Bottling value) {
            this.bottling = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="container" maxOccurs="unbounded" form="unqualified">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
         *                   &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "container"
        })
        public static class Bottling {

            @XmlElement(required = true)
            protected List<Beer.Characteristics.Bottling.Container> container;

            /**
             * Gets the value of the container property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the container property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContainer().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Beer.Characteristics.Bottling.Container }
             * 
             * 
             */
            public List<Beer.Characteristics.Bottling.Container> getContainer() {
                if (container == null) {
                    container = new ArrayList<Beer.Characteristics.Bottling.Container>();
                }
                return this.container;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="material" type="{http://www.w3.org/2001/XMLSchema}NCName" form="unqualified"/>
             *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}decimal" form="unqualified"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "material",
                "capacity"
            })
            public static class Container {

                @XmlElement(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                @XmlSchemaType(name = "NCName")
                protected String material;
                @XmlElement(required = true)
                protected BigDecimal capacity;

                /**
                 * Gets the value of the material property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMaterial() {
                    return material;
                }

                /**
                 * Sets the value of the material property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMaterial(String value) {
                    this.material = value;
                }

                /**
                 * Gets the value of the capacity property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getCapacity() {
                    return capacity;
                }

                /**
                 * Sets the value of the capacity property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setCapacity(BigDecimal value) {
                    this.capacity = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ingredient" type="{http://www.w3.org/2001/XMLSchema}NCName" maxOccurs="unbounded" minOccurs="2" form="unqualified"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ingredient"
    })
    public static class Ingredients {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "NCName")
        protected List<String> ingredient;

        /**
         * Gets the value of the ingredient property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ingredient property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIngredient().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIngredient() {
            if (ingredient == null) {
                ingredient = new ArrayList<String>();
            }
            return this.ingredient;
        }

    }

}

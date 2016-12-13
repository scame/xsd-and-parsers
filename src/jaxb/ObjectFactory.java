
package jaxb;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the scame package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: scame
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Beer }
     * 
     */
    public Beer createBeer() {
        return new Beer();
    }

    /**
     * Create an instance of {@link Beer.Characteristics }
     * 
     */
    public Beer.Characteristics createBeerCharacteristics() {
        return new Beer.Characteristics();
    }

    /**
     * Create an instance of {@link Beer.Characteristics.Bottling }
     * 
     */
    public Beer.Characteristics.Bottling createBeerCharacteristicsBottling() {
        return new Beer.Characteristics.Bottling();
    }

    /**
     * Create an instance of {@link Beer.Ingredients }
     * 
     */
    public Beer.Ingredients createBeerIngredients() {
        return new Beer.Ingredients();
    }

    /**
     * Create an instance of {@link Beer.Characteristics.Bottling.Container }
     * 
     */
    public Beer.Characteristics.Bottling.Container createBeerCharacteristicsBottlingContainer() {
        return new Beer.Characteristics.Bottling.Container();
    }

}


package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Paginacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Paginacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="totalRegistros" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalPaginas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalRegistrosPorPagina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroPagina" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Paginacion", propOrder = {
    "totalRegistros",
    "totalPaginas",
    "totalRegistrosPorPagina",
    "numeroPagina"
})
public class Paginacion {

    protected int totalRegistros;
    protected int totalPaginas;
    protected int totalRegistrosPorPagina;
    protected int numeroPagina;

    /**
     * Obtiene el valor de la propiedad totalRegistros.
     * 
     */
    public int getTotalRegistros() {
        return totalRegistros;
    }

    /**
     * Define el valor de la propiedad totalRegistros.
     * 
     */
    public void setTotalRegistros(int value) {
        this.totalRegistros = value;
    }

    /**
     * Obtiene el valor de la propiedad totalPaginas.
     * 
     */
    public int getTotalPaginas() {
        return totalPaginas;
    }

    /**
     * Define el valor de la propiedad totalPaginas.
     * 
     */
    public void setTotalPaginas(int value) {
        this.totalPaginas = value;
    }

    /**
     * Obtiene el valor de la propiedad totalRegistrosPorPagina.
     * 
     */
    public int getTotalRegistrosPorPagina() {
        return totalRegistrosPorPagina;
    }

    /**
     * Define el valor de la propiedad totalRegistrosPorPagina.
     * 
     */
    public void setTotalRegistrosPorPagina(int value) {
        this.totalRegistrosPorPagina = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPagina.
     * 
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Define el valor de la propiedad numeroPagina.
     * 
     */
    public void setNumeroPagina(int value) {
        this.numeroPagina = value;
    }

}

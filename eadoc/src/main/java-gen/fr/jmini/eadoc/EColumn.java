/**
 */
package fr.jmini.eadoc;

import org.asciidoctor.ast.Column;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EColumn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link fr.jmini.eadoc.EColumn#getStyle <em>Style</em>}</li>
 *   <li>{@link fr.jmini.eadoc.EColumn#getTable <em>Table</em>}</li>
 *   <li>{@link fr.jmini.eadoc.EColumn#getWidth <em>Width</em>}</li>
 *   <li>{@link fr.jmini.eadoc.EColumn#getHAlignment <em>HAlignment</em>}</li>
 *   <li>{@link fr.jmini.eadoc.EColumn#getVAlignment <em>VAlignment</em>}</li>
 * </ul>
 *
 * @see fr.jmini.eadoc.EadocPackage#getEColumn()
 * @model superTypes="fr.jmini.eadoc.EContentNode fr.jmini.eadoc.Column"
 * @generated
 */
public interface EColumn extends EContentNode, Column {
	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see #setStyle(String)
	 * @see fr.jmini.eadoc.EadocPackage#getEColumn_Style()
	 * @model unique="false"
	 * @generated
	 */
	String getStyle();

	/**
	 * Sets the value of the '{@link fr.jmini.eadoc.EColumn#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(String value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link fr.jmini.eadoc.ETable#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(ETable)
	 * @see fr.jmini.eadoc.EadocPackage#getEColumn_Table()
	 * @see fr.jmini.eadoc.ETable#getColumns
	 * @model opposite="columns" transient="false"
	 * @generated
	 */
	ETable getTable();

	/**
	 * Sets the value of the '{@link fr.jmini.eadoc.EColumn#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(ETable value);

	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(int)
	 * @see fr.jmini.eadoc.EadocPackage#getEColumn_Width()
	 * @model unique="false"
	 * @generated
	 */
	int getWidth();

	/**
	 * Sets the value of the '{@link fr.jmini.eadoc.EColumn#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(int value);

	/**
	 * Returns the value of the '<em><b>HAlignment</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.jmini.eadoc.EHorizontalAlignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>HAlignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>HAlignment</em>' attribute.
	 * @see fr.jmini.eadoc.EHorizontalAlignment
	 * @see #setHAlignment(EHorizontalAlignment)
	 * @see fr.jmini.eadoc.EadocPackage#getEColumn_HAlignment()
	 * @model unique="false"
	 * @generated
	 */
	EHorizontalAlignment getHAlignment();

	/**
	 * Sets the value of the '{@link fr.jmini.eadoc.EColumn#getHAlignment <em>HAlignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HAlignment</em>' attribute.
	 * @see fr.jmini.eadoc.EHorizontalAlignment
	 * @see #getHAlignment()
	 * @generated
	 */
	void setHAlignment(EHorizontalAlignment value);

	/**
	 * Returns the value of the '<em><b>VAlignment</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.jmini.eadoc.EVerticalAlignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VAlignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VAlignment</em>' attribute.
	 * @see fr.jmini.eadoc.EVerticalAlignment
	 * @see #setVAlignment(EVerticalAlignment)
	 * @see fr.jmini.eadoc.EadocPackage#getEColumn_VAlignment()
	 * @model unique="false"
	 * @generated
	 */
	EVerticalAlignment getVAlignment();

	/**
	 * Sets the value of the '{@link fr.jmini.eadoc.EColumn#getVAlignment <em>VAlignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VAlignment</em>' attribute.
	 * @see fr.jmini.eadoc.EVerticalAlignment
	 * @see #getVAlignment()
	 * @generated
	 */
	void setVAlignment(EVerticalAlignment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='throw new <%java.lang.UnsupportedOperationException%>(\"Not implemented\");'"
	 * @generated
	 */
	int getColumnNumber();

} // EColumn

package edu.utm.bd.domain;

public class ProductoKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column producto.IdProduco
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	private Integer idproduco;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column producto.Proveedor_id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	private Integer proveedorId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column producto.IdProduco
	 * @return  the value of producto.IdProduco
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public Integer getIdproduco() {
		return idproduco;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column producto.IdProduco
	 * @param idproduco  the value for producto.IdProduco
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public void setIdproduco(Integer idproduco) {
		this.idproduco = idproduco;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column producto.Proveedor_id
	 * @return  the value of producto.Proveedor_id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public Integer getProveedorId() {
		return proveedorId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column producto.Proveedor_id
	 * @param proveedorId  the value for producto.Proveedor_id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}
}
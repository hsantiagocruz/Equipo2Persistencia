package edu.utm.bd.domain;

public class VentaHasProductoKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column venta_has_producto.Venta_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	private String ventaId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column venta_has_producto.Producto_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	private Integer productoId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column venta_has_producto.Venta_Id
	 * @return  the value of venta_has_producto.Venta_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public String getVentaId() {
		return ventaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column venta_has_producto.Venta_Id
	 * @param ventaId  the value for venta_has_producto.Venta_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public void setVentaId(String ventaId) {
		this.ventaId = ventaId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column venta_has_producto.Producto_Id
	 * @return  the value of venta_has_producto.Producto_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public Integer getProductoId() {
		return productoId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column venta_has_producto.Producto_Id
	 * @param productoId  the value for venta_has_producto.Producto_Id
	 * @mbg.generated  Wed Apr 25 18:55:18 CDT 2018
	 */
	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
}
package Modelos;

import Modelos.util.JsfUtil;
import Modelos.util.PaginationHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("pagosController")
@SessionScoped
public class PagosController implements Serializable {

    private Pagos current;
    private DataModel items = null;
    private List<Productos> productos;
    private List<Pagos> pagos;
    private Pagos editarPago;
    
    @EJB
    private Modelos.PagosFacade ejbFacade;
    @EJB
    private Modelos.DetallesPagosFacade ejbFacadeDetalle;

    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PagosController() {
    }

    public void addProdCart(Productos productos) {
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }

        this.productos.add(productos);
    }

    public Pagos getEditarPago() {
        return editarPago;
    }

    public void setEditarPago(Pagos editarPago) {
        this.editarPago = editarPago;
    }

    public Pagos getSelected() {
        if (current == null) {
            current = new Pagos();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PagosFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String crearVenta() {

        //current.setFecha(new Date());
        ejbFacade.create(current);
        DetallesPagos detalle = new DetallesPagos();
        for (Productos producto : productos) {
            detalle.setCantidad(1);
            detalle.setIdPago(current);
            detalle.setIdProducto(producto);
            detalle.setPrecio(producto.getPrecio());
            ejbFacadeDetalle.create(detalle);
        }
        //productos.clear();
            productos = null;
        //this.productos= new ArrayList<>();
        
        return "List";
    }
    public String eliminar(Pagos pagos)
    {
        getFacade().remove(pagos);
        return "List";
    }
    public String editar(Pagos pagos)
    {
        editarPago= pagos;
        
        return "Edit";
    }
    public String guardar()
    {
        getFacade().edit(editarPago);
        return "List";
    }

    public List<Pagos> getPagos() {
       pagos= getFacade().findAll();
        return pagos;
    }

    public void setPagos(List<Pagos> pagos) {
        this.pagos = pagos;
    }

    public DetallesPagosFacade getEjbFacadeDetalle() {
        return ejbFacadeDetalle;
    }

    public void setEjbFacadeDetalle(DetallesPagosFacade ejbFacadeDetalle) {
        this.ejbFacadeDetalle = ejbFacadeDetalle;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }



    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Pagos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Pagos();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            Productos prod = new Productos();
            for (Productos item : this.productos) {
                if (item.getIdProducto() == prod.getIdProducto()) {
                    productos.add(item);
                }
            }

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PagosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Pagos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PagosUpdated"));
            return "List";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Pagos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PagosDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Pagos getPagos(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Pagos.class)
    public static class PagosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PagosController controller = (PagosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pagosController");
            return controller.getPagos(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pagos) {
                Pagos o = (Pagos) object;
                return getStringKey(o.getIdPago());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Pagos.class.getName());
            }
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVO;

/**
 *
 * @author juand
 */
public class RolVO {
    private String rolId, rolTipo;

    public RolVO() {
    }

    public RolVO(String rolId, String rolTipo) {
        this.rolId = rolId;
        this.rolTipo = rolTipo;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(String rolTipo) {
        this.rolTipo = rolTipo;
    }
}
